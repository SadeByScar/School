#DML Kontrollfragen

- Wie lautet der Befehl, um Daten zu ändern? <br>
    <i>UPDATE</i>
- Wie lautet der Befehl, um Tabellenstrukturen zu ändern? <br>
    <i>ALTER</i>
- Wie lautet der Befehl, um Daten zu löschen? <br>
    <i>DELETE</i>
- Wie lautet der Befehl, um Datenstrukturen zu löschen? <br>
    <i>DROP</i>
- Wenn man eine zweite Tabelle benötigt, um Datensätze für eine Aktualisierung oder eine Löschvorgang zu selektieren, mit welcher "Technik" kann man diese einbinden? <br>
    <i>Subqueries</i>
- Bei der Verknüpfung von Tabellen und Subqueries sollte man immer den JOIN überprüfen. Worauf? <br>
    <i>OUTER JOINS</i>
- Prägen Sie sich die Reigenfolge von Befehlen ein. Z. B. <br>
UPDATE <i>t</i> SET <i>feld=</i> WHERE.....
    - Neue Tabelle aus alten Daten erstellen.
    - Daten automatisch in bestehende Tabellen einfügen.
    - Daten aktualisieren bei denen Bedingungen sich auf andere Tabellen beziehen.
    - Daten löschen bei denen Bedingungen sicha uf andere Tabellen beziehen.

#DML Aufgaben

## Aufgabe 1

Löschen Sie alle Aufträge, die keine Auftragspositionen haben, da sie keinen Sinn ergeben.

## Lösung 1

```bash
```

## Aufgabe 2

Aufgabe 2:	Alle Artikel, die Auslaufartikel sind und keinen Lagerbestand mehr haben, sollen gelöscht werden. Sichern Sie zuvor alle zu löschenden Artikel und die dazu gehörenden Kundenaufträge einschließlich Positionen. Bedenken Sie, dass die Aufträge auch Positionen mit Artikeln enthalten können, die selber keine Auslaufartikel sind. Diese Positionen sollen natürlich auch gesichert werden. Vergessen Sie zudem die abweichenden Versandadressen nicht! Außerdem müssen sowohl die Lieferantenangebote, wie auch die Bestellpositionen aus den Lieferantenbestellungen aufgrund der referentiellen Integrität berücksichtigt werden. Löschen Sie erst anschließend die Auslaufartikel ohne Lagerbestand mit Ihren zugehörigen Aufträgen und Versandadressen.

## Lösung 2

```bash
```

## Aufgabe 3

Aufgabe 3:	Die Kunden-Auftragsdaten des ersten Betriebsjahres (Jahreszahl des Datums) von Otto&Co. werden für betriebsinterne Zwecke nicht mehr benötigt. Sie sollen daher aus der Datenbank gelöscht werden.

## Lösung 3

```bash
```

## Aufgabe 4

Aufgabe 4:	Vor einer Preiserhöhung, sollen die alten Preise in einer Tabelle gesichert werden. Die Preise in der Tabelle Artikel sollen anschließend um 5% erhöht werden. Kontrollieren Sie, ob die Preise tatsächlich erhöht wurden.

## Lösung 4

```bash
```

## Aufgabe 5

Aufgabe 5:	Alle deutschen Kunden sollen den Artikel „Lakkalikööri“ als Weihnachtsgeschenk erhalten. Die Mitarbeiterin Davolio wird mit dieser Aktion beauftragt und soll den Versand mit Speedy Express vornehmen. Fügen Sie automatisch die Aufträge an die entsprechenden Tabellen an. Frachtkosten werden nicht erhoben.

## Lösung 5

```bash
```

## Aufgabe 6

Aufgabe 6:	Heben Sie die Preise von gut verkauften Artikeln (mehr als 20 Kundenaufträge) um 10% an.

## Lösung 6

```bash
```

## Aufgabe 7

Aufgabe 7:	Kennzeichnen Sie schlecht zu verkaufende Artikel als Auslaufartikel und senken Sie deren Preise um 60%. Als Kriterium soll dienen, ob sie im Jahr 2017 höchstens ein Mal verkauft wurden.

## Lösung 7

```bash
```

## Aufgabe 8

Aufgabe 8:	Verdoppeln Sie den Mindestbestand der Artikel, die im Durchschnitt mehr als 10 Mal pro Jahr an Kunden verkauft wurden.

## Lösung 8

```bash
```