#Subquery Aufgaben

##Aufgabe 1

Aufgabe 1:	Wie viele Bestellungen und wie viele Angebote hat jeder Lieferant von dem Otto&Co bestellt hat? Ordnen Sie nach Lieferanten

##Lösung 1
```bash
SELECT LNR, LFirma, Angebotsanzahl, Bestellanzahl  
FROM `lieferant` 
INNER JOIN 
(
    SELECT Lieferant AS ALieferant, COUNT(Artikel) AS Angebotsanzahl
    FROM `liefangebot`
    GROUP BY Lieferant
) AS queryAngebot 
ON queryAngebot.ALieferant = lieferant.LNr
INNER JOIN
(
    SELECT Lieferant AS BLieferant, Count(Bestellnr) AS Bestellanzahl
    FROM `liefbestellung`
    GROUP BY Lieferant
) AS queryBestellung
ON queryBestellung.BLieferant = lieferant.LNr
GROUP BY LNR;
```

##Aufgabe 2

Aufgabe 2:	Welche Lieferanten liefern je Artikel zum kleinsten Preis? D.h. Von welchem Lieferanten bekomme ich Artikel 1 zum kleinsten Preis? Von welchem Artikel 2, usw.?

##Lösung 2

```bash
SELECT Lieferant, LFirma, Artikel, Angebotspreis, MINKosten
FROM `liefangebot`
INNER JOIN
(
    SELECT MIN(Angebotspreis) AS MINKosten, Artikel AS MINArtikel
    FROM `liefangebot`
    GROUP BY MINArtikel
) AS queryLiefangebot
ON queryLiefangebot.MINArtikel = liefangebot.Artikel
INNER JOIN lieferant 
ON lieferant.LNr = liefangebot.Lieferant
WHERE Angebotspreis = MINKosten
ORDER BY Artikel
```

##Aufgabe 3
Berücksichtigen Sie in Aufgabe 2 noch die Rabatte, die uns verschiedene Lieferanten gewähren. Die Lieferantenrabatte stehen als Prozentwerte in der Tabelle Lieferant.

##Lösung 3

```bash
SELECT Lieferant, LFirma, Artikel, Angebotspreis, MINKosten
FROM `liefangebot`
INNER JOIN
(
    SELECT MIN(Angebotspreis * (1 - lieferant.Lieferantenrabatt)) AS MINKosten, Artikel AS MINArtikel
    FROM `liefangebot`
    INNER JOIN lieferant
    ON liefangebot.Lieferant = lieferant.LNr
    GROUP BY MINArtikel
) AS queryLiefangebot
ON queryLiefangebot.MINArtikel = liefangebot.Artikel
INNER JOIN lieferant 
ON lieferant.LNr = liefangebot.Lieferant
WHERE (Angebotspreis * (1 - lieferant.Lieferantenrabatt)) = MINKosten
ORDER BY Artikel
```

##Aufgabe 4

Wie hoch ist für jede Warengruppe der Durchschnitt der durchschnittlichen Auftragsmengen der Artikel?

##Lösung 4

```bash
SELECT WGNr, GruppenName, AVG(queryArtikel.AVGArtikel) AS AVGWarengruppe
FROM `warengruppe`
INNER JOIN
(
  SELECT AVG(kdauftragsposition.Anzahl) AS AVGArtikel, Warengruppe
  FROM `artikel`
  INNER JOIN `kdauftragsposition`
  ON kdauftragsposition.Artikel = artikel.ArtikelNr
  GROUP BY ArtikelNr
) AS queryArtikel
ON queryArtikel.Warengruppe = warengruppe.WGNr
GROUP BY WGNr
```

##Aufgabe 5

Ermitteln Sie alle Kunden, die nie an eine abweichende Versandadresse haben liefern lassen.

##Lösung 5

```bash
SELECT KdNr, KdVorname, KdNachname
FROM `kunde`
WHERE KdNr NOT IN
(
  SELECT Kunde
  FROM `kdauftrag`
  WHERE AuftragsNr IN
  (
    SELECT AuftragsNr
    From abweichenderversand
  )
)
```

##Aufgabe 6

Welche Kunden haben nicht im Monat Mai 2016 bestellt? 

##Lösung 6

```bash
SELECT KdNr, KdVorname, KdNachname
FROM `kunde`
WHERE KdNr NOT IN
(
  SELECT Kunde
  FROM `kdauftrag`
  WHERE Auftragsdatum BETWEEN "2016-05-01" AND "2016-05-31"
)
```

##Aufgabe 7

Welche Mitarbeiter sind älter als der Durchschnitt? Zeigen Sie für diese Mitarbeiter das aktuelle Alter an. Vorsicht: Alter ist in SQL ein Schlüsselwort!

##Lösung 7

```bash
SELECT PersonalNr, Nachname, Vorname, (CURRENT_DATE - Geburtsdatum) AS MitarbeiterAlter
FROM `personal`
WHERE (CURRENT_DATE - Geburtsdatum) > 
(
  SELECT AVG(CURRENT_DATE - Geburtsdatum) 
  FROM `personal`
)
GROUP BY PersonalNr
```

##Aufgabe 8

Welche Artikel wurden nicht von deutschen Kunden bestellt?

##Lösung 8

```bash
SELECT ArtikelNr, Artikelname
FROM `artikel`
WHERE ArtikelNr NOT IN
(
  SELECT Artikel
  FROM `kdauftragsposition`
  WHERE Auftrag IN 
  (
    SELECT AuftragsNr
    FROM `kdauftrag`
    WHERE Kunde IN 
    (
      SELECT KdNr
      FROM `kunde`
      WHERE KdLand = "Deutschland"
    )
  )
)
GROUP BY ArtikelNr
```

##Aufgabe 9

Viel mehr noch als einzelne Rechnungsbeträge interessiert die Chefin, der durchschnittliche Auftragswert (keine Frachtkosten, aber Artikelrabatte) für jeden Kunden, der bei Otto&Co bestellt hat. Lassen Sie sich nur die 5 besten Kunden anzeigen. 

##Lösung 9

```bash

```

##Aufgabe 10

Welche Länder der Kunden wurden nie von der Versandfirma Speedy Express beliefert?

##Lösung 10

```bash
SELECT KdLand
FROM `kunde`
WHERE KdNr NOT IN 
(
  SELECT Kunde
  FROM `kdauftrag`
  WHERE Versandfirma = 1
)
GROUP BY KdLand
```