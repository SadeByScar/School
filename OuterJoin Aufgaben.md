#Outer Join Aufgaben

##Aufgabe 1

Zeigen Sie alle Kunden mit ihren Brutto-Warenumsätzen, welche auch die Artikel-Rabatte berücksichtigen.

##Lösung 1

```bash
SELECT kunde.KdVorname, kunde.KdNachname, ifnull(SUM((artikel.Verkaufspreis)*1-artikel.Rabatt), 0) AS "Brutto-Warenwert"
FROM artikel
JOIN kdauftragsposition 
ON kdauftragsposition.Artikel = artikel.ArtikelNr
JOIN kdauftrag 
ON kdauftrag.AuftragsNr = kdauftragsposition.Auftrag
RIGHT JOIN kunde 
ON kunde.KdNr = kdauftrag.Kunde
GROUP BY kunde.KdNr;
```

##Aufgabe 2

Modifizieren Sie die Aufgabe 1 des letzten Arbeitsblattes: Wie viele Bestellungen und wie viele Angebote hat jeder Lieferant? Ordnen Sie nach Lieferanten

##Lösung 2

```bash
SELECT LNR, LFirma, Angebotsanzahl, ifnull(Bestellanzahl, 0) AS Bestellanzahl  
FROM `lieferant` 
INNER JOIN 
(
    SELECT Lieferant AS ALieferant, COUNT(Artikel) AS Angebotsanzahl
    FROM `liefangebot`
    GROUP BY Lieferant
) AS queryAngebot 
ON queryAngebot.ALieferant = lieferant.LNr
LEFT JOIN
(
    SELECT Lieferant AS BLieferant, Count(Bestellnr) AS Bestellanzahl
    FROM `liefbestellung`
    GROUP BY Lieferant
) AS queryBestellung
ON queryBestellung.BLieferant = lieferant.LNr
GROUP BY LNR;
```

##Aufgabe 3

Wie viele Kundenaufträge hat jeder Mitarbeiter betreut?

##Lösung 3

```bash
SELECT personal.Nachname, personal.Vorname, COUNT(kdauftrag.Bearbeiter)
FROM  kdauftrag
RIGHT JOIN personal ON personal.PersonalNr = kdauftrag.Bearbeiter
GROUP BY personal.PersonalNr;
```

##Aufgabe 4

Wie hoch ist der durchschnittliche Bestellwert (Lieferanten) und wie hoch ist der durch-schnittliche Auftragswert (Kunden) für jeden Artikel? Es soll auf volle Cent gerundet werden. 

##Lösung 4

```bash
SELECT artikel.Artikelname, ROUND(AVG(liefbestellposition.Einkaufspreis*liefbestellposition.BestellteAnzahl), 2) AS "Durchschnittlicher Bestellwert", ifnull(ROUND(AVG(kdauftragsposition.Anzahl*artikel.Verkaufspreis), 2), 0.00) AS "Durschnittlicher Auftragswert"
FROM liefbestellposition
JOIN liefbestellung ON liefbestellung.Bestellnr = liefbestellposition.Bestellung
JOIN lieferant ON lieferant.LNr = liefbestellung.Lieferant
JOIN artikel ON artikel.ArtikelNr = liefbestellposition.Artikel
LEFT JOIN kdauftragsposition ON kdauftragsposition.Artikel = artikel.ArtikelNr
GROUP BY artikel.ArtikelNr;
```

##Aufgabe 5

Suchen Sie alle Artikel mit der Häufigkeit der Verkäufe an Kunden und der verkauften Men-ge. Lassen Sie nur Artikel anzeigen, welche in maximal 5 Aufträgen verkauft wurden.

##Lösung 5

```bash
SELECT artikel.Artikelname, COUNT(kdauftragsposition.Auftrag) AS Verkäufe, ifnull(SUM(kdauftragsposition.Anzahl), 0) AS Menge
FROM kdauftragsposition
RIGHT JOIN artikel ON artikel.ArtikelNr = kdauftragsposition.Artikel
GROUP BY artikel.ArtikelNr
HAVING Verkäufe <= 5;
```

##Aufgabe 6

Suchen Sie alle nicht deutschen Lieferanten, mit der Summe der Bestellungen. Es sollen nur Lieferanten angezeigt werden von denen weniger als 5000 Euro bestellt wurde. Dazu gehö-ren auch diejenigen, von denen noch nie bestellt wurde.

##Lösung 6

```bash
SELECT lieferant.LFirma, ifnull(SUM(liefbestellposition.Einkaufspreis*liefbestellposition.BestellteAnzahl), 0) AS Summe, lieferant.LLand
FROM lieferant
LEFT JOIN liefbestellung ON lieferant.LNr = liefbestellung.Lieferant
LEFT JOIN liefbestellposition ON liefbestellung.Bestellnr = liefbestellposition.Bestellung
GROUP BY lieferant.LNr
HAVING Summe <= 5000 AND lieferant.LLand != "Deutschland";
```

##Aufgabe 7

Die Inventur hat stattgefunden: Der festgestellte Lagerbestand soll mit den Eingängen und Ausgängen verglichen werden. Lassen Sie sich nur die anzeigen, bei denen es Abweichun-gen gibt. 

##Lösung 7

```bash
SELECT ArtikelNr, Artikelname, Lagerbestand, ifnull((Bestellung - Lieferung), 0) AS Sollbestand
FROM artikel
LEFT JOIN 
(
  SELECT ifnull(SUM(BestellteAnzahl), 0) AS Bestellung, Artikel AS Art
  FROM liefbestellposition
  WHERE LieferungErhalten = 1
  GROUP BY Artikel
) AS queryLiefbestellposition
ON artikel.ArtikelNr = queryLiefbestellposition.Art
LEFT JOIN 
(
  SELECT ifnull(SUM(Anzahl), 0) AS Lieferung, Artikel AS Arti
  FROM kdauftragsposition
  GROUP BY Artikel
) AS queryKdauftragsposition
ON artikel.ArtikelNr = queryKdauftragsposition.Arti
HAVING Lagerbestand != Sollbestand
```

##Aufgabe 8

Von welchen Lieferanten wurde an den letzten drei Terminen nicht bestellt?
(LIMIT wird von MySQL noch nicht in subqueries der WHERE-Klausel unterstützt)
Ein OUTER JOIN kann zur Lösung beitragen, muss es aber nicht.

##Lösung 8

```bash
SELECT LNr, LFirma
FROM lieferant
RIGHT JOIN 
(
  SELECT Lieferant, Bestelldatum
  FROM liefbestellung
  ORDER BY Bestelldatum DESC
  LIMIT 3
) AS queryLiefbestellung
ON lieferant.LNr = queryLiefbestellung.Lieferant
WHERE LNr != Lieferant
```