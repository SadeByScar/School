# SQL DML

## Aufgabe 1:	Löschen Sie alle Aufträge, die keine Auftragspositionen haben, da sie keinen Sinn ergeben

Kontrolle: 	6 Datensätze,

```sql
DELETE FROM kdauftrag 
WHERE
    AuftragsNr NOT IN (SELECT 
        Auftrag
    FROM
        kdauftragsposition)
```

## Aufgabe 2:	Alle Artikel, die Auslaufartikel sind und keinen Lagerbestand mehr haben, sollen gelöscht werden

Sichern Sie zuvor alle zu **löschenden Artikel** und die dazu **gehörenden Kundenaufträge** einschließlich **Positionen**. Bedenken Sie, dass die Aufträge auch Positionen mit Artikeln enthalten können, die selber keine Auslaufartikel sind. Diese Positionen sollen natürlich auch gesichert werden. Vergessen Sie zudem die **abweichenden Versandadressen** nicht! Außerdem müssen sowohl die **Lieferantenangebote**, wie auch die **Bestellpositionen** aus den Lieferantenbestellungen aufgrund der referentiellen Integrität berücksichtigt werden. Löschen Sie erst anschließend die **Auslaufartikel ohne Lagerbestand** mit Ihren **zugehörigen Aufträgen und Versandadressen**.

Kontrolle: 	artikelSAV 	4 Datensätze,
	kdAuftragSAV 	83 Datensätze,
	kdAuftragspositionSAV	250 Datensätze (Bei 89 haben Sie nur die  Auftragspositionen
		die zu den zu löschenden Artikeln gehören gesichert, aber nicht
		die zu anderen Artikeln),
	abweichenderVersandSAV 	6 Datensätze

### Speicherquery

#### Artikel

```sql
CREATE TABLE artikelSAV 
SELECT
	*
FROM
    artikel
WHERE
    Auslaufartikel = '1'
```

Ergebnis: 8 Datensätze

#### kdAuftragsposition

```sql
CREATE TABLE kdAuftragspositionSAV
SELECT 
	*
FROM
    (SELECT 
        ArtikelNr
    FROM
        artikel
    WHERE
        Auslaufartikel = '1') AS bla
        INNER JOIN
    kdauftragsposition ON ArtikelNr = kdauftragsposition.Artikel
```

Alternative

```sql
CREATE TABLE kdAuftragspositionSAV
SELECT 
    *
FROM
    kdauftragsposition
WHERE
    Artikel IN (SELECT 
            ArtikelNr
        FROM
            artikel
        WHERE
            Auslaufartikel = '1')
```

Ergebnis: 188 Datensätze

#### kdAuftrag

```sql
CREATE TABLE kdAuftragSAV
SELECT 
    *
FROM
    (SELECT 
        ArtikelNr
    FROM
        artikel
    WHERE
        Auslaufartikel = '1') AS bla
        INNER JOIN
    kdauftragsposition ON ArtikelNr = kdauftragsposition.Artikel
        LEFT JOIN
    kdauftrag ON Auftrag = kdauftrag.AuftragsNr
GROUP BY AuftragsNr
```

Alternative

```sql
CREATE TABLE kdAuftragSAV
SELECT 
    *
FROM
    kdauftrag
WHERE
    AuftragsNr IN (SELECT 
            Auftrag
        FROM
            kdauftragsposition
        WHERE
            Artikel IN (SELECT 
                    ArtikelNr
                FROM
                    artikel
                WHERE
                    Auslaufartikel = '1')
        GROUP BY Auftrag)
```

Ergebnis: 188 Datensätze

#### abweichenderVersand

Alternative

```sql
SELECT 
    *
FROM
    abweichenderversand av
WHERE
    av.AuftragsNr IN (SELECT 
            AuftragsNr
        FROM
            kdauftrag
        WHERE
            AuftragsNr IN (SELECT 
                    Auftrag
                FROM
                    kdauftragsposition
                WHERE
                    Artikel IN (SELECT 
                            ArtikelNr
                        FROM
                            artikel
                        WHERE
                            Auslaufartikel = '1')
                GROUP BY Auftrag))
```

Ergebnis: 10 Datensätze

**WAS SOLL ICH TUN?!**

## Aufgabe 3:	Die Kunden-Auftragsdaten des ersten Betriebsjahres (Jahreszahl des Datums) von Otto&Co. werden für betriebsinterne Zwecke nicht mehr benötigt. Sie sollen daher aus der Datenbank gelöscht werden

Kontrolle: 	alteKdPositionen 	427 mit vorheriger Löschung (513 ohne) Datensätze
	alteAbweichenderVersand	6 mit (10 ohne Löschung) Datensätze
	alteKdAuftrag	168 mit (194 ohne Löschung) Datensätze

```sql
SELECT 
    MIN(YEAR(Auftragsdatum)) AS FirstYear
FROM
    kdauftrag
```

```sql
SELECT 
    AuftragsNr
FROM
    kdauftrag
WHERE
    YEAR(Auftragsdatum) = (SELECT 
            MIN(YEAR(Auftragsdatum)) AS FirstYear
        FROM
            kdauftrag)
```

Ergebnis: 194 Datensätze

```sql
SELECT 
    Auftrag
FROM
    kdauftragsposition
        RIGHT JOIN
    (SELECT 
        AuftragsNr
    FROM
        kdauftrag
    WHERE
        YEAR(Auftragsdatum) = (SELECT 
                MIN(YEAR(Auftragsdatum)) AS FirstYear
            FROM
                kdauftrag)) AS Bla ON Auftrag = Bla.AuftragsNr
```

Ergebnis: 513 Datensätze

```sql
SELECT 
    abweichenderversand.AuftragsNr
FROM
    abweichenderversand
        INNER JOIN
    (SELECT 
        AuftragsNr
    FROM
        kdauftrag
    WHERE
        YEAR(Auftragsdatum) = (SELECT 
                MIN(YEAR(Auftragsdatum)) AS FirstYear
            FROM
                kdauftrag)) AS Bla ON abweichenderversand.AuftragsNr = Bla.AuftragsNr
```

Ergebnis: 10 Datensätze

## Aufgabe 4:	Vor einer Preiserhöhung, sollen die alten Preise in einer Tabelle gesichert werden. Die Preise in der Tabelle Artikel sollen anschließend um 5% erhöht werden. Kontrollieren Sie, ob die Preise tatsächlich erhöht wurden

Kontrolle: 	Sicherung: 77 (73 nach Aufg.2) Datensätze, Artikel 1 Verkaufspreis 18 Euro
	Aktualisierung: 77 Datensätze (73 nach Aufg.2), Artikel 1 Verkaufspreis 18,9 Euro

```sql
CREATE TABLE altePreise SELECT ArtikelNr, Verkaufspreis AS alterVerkaufspreis FROM
    artikel
```

```sql
UPDATE artikel 
SET 
    Verkaufspreis = Verkaufspreis * 1.05
```

```sql
SELECT 
    Verkaufspreis,
    alterVerkaufspreis,
    (Verkaufspreis / alterVerkaufspreis) AS diff
FROM
    artikel
        INNER JOIN
    altePreise ON artikel.ArtikelNr = altePreise.ArtikelNr
	```

## Aufgabe 5:	Alle deutschen Kunden sollen den Artikel „Lakkalikööri“ als Weihnachtsgeschenk erhalten. Die Mitarbeiterin Davolio wird mit dieser Aktion beauftragt und soll den Versand mit Speedy Express vornehmen. Fügen Sie automatisch die Aufträge an die entsprechenden Tabellen an. Frachtkosten werden nicht erhoben

Kontrolle: 	jeweils 11 neue Datensätze in kdAuftrag und kdAuftragspositionen

```sql
 insert into kdauftrag (Kunde, Bearbeiter, Auftragsdatum, Versandfirma, Frachtkosten)
SELECT 
    KdNr, (select PersonalNr from Personal where Nachname = "Davolio") as Bearbeiter,  (select VNr from versandfirma where VFirma ="Speedy Express") as VNr, curdate() as Auftragsdatum,0
FROM
    kunde
WHERE KdLand = "Deutschland" 
Group By kdNr

```

## Aufgabe 6:	Heben Sie die Preise von gut verkauften Artikeln (mehr als 20 Kundenaufträge) um 10% an

Kontrolle: 	27 (46 ohne Löschungen) Datensätze

```sql
UPDATE artikel
        INNER JOIN
    (SELECT 
        ArtikelNr, COUNT(Auftrag) AS AnzahlAufträge
    FROM
        artikel
    INNER JOIN kdauftragsposition ON kdauftragsposition.Artikel = artikel.ArtikelNr
    GROUP BY ArtikelNr) AS sub ON sub.ArtikelNr = artikel.ArtikelNr 
SET 
    Verkaufspreis = Verkaufspreis * 0.1
WHERE
    AnzahlAufträge > 20
```

## Aufgabe 7:	Kennzeichnen Sie schlecht zu verkaufende Artikel als Auslaufartikel und senken Sie deren Preise um 60%. Als Kriterium soll dienen, ob sie im Jahr 2017 höchstens ein Mal verkauft wurden

Kontrolle: 	4 Datensätze (Achtung es gibt zwei Datensätze mit 0 Verkaufszahlen  Artikel 15 und 78 )

```sql
UPDATE artikel 
SET 
    Verkaufspreis = Verkaufspreis * 0.6
        AND Auslaufartikel = 1
WHERE
    ArtikelNr IN (SELECT 
            COUNT(Auftrag) AS AnzahlAufträge
        FROM
            artikel
                LEFT JOIN
            kdauftragsposition ON kdauftragsposition.Artikel = artikel.ArtikelNr
                LEFT JOIN
            kdauftrag ON kdauftrag.AuftragsNr = kdauftragsposition.Auftrag
        WHERE
            YEAR(Auftragsdatum) = '2017'
        GROUP BY ArtikelNr
        HAVING AnzahlAufträge <= 1)
```

## Aufgabe 8:	Verdoppeln Sie den Mindestbestand der Artikel, die im Durchschnitt mehr als 10 Mal pro Jahr an Kunden verkauft wurden

Kontrolle: 	(224 ohne Löschungen) Datensätze im innersten subquery,
	22 im nächsten subquery)
	Als geändert werden nur 21 Datensätze angegeben,
	da in einem Datensatz der Mindestbestand auf 0 steht.
