# Schleifen in Java

## for-Schleife

###Definition

Eine for-Schleife ist eine zählergesteuerte Schleife, deren Wiederholungsanzahl schon vor Beginn feststeht.
Der Ablauf wird über eine Zählervariable gesteuert, welche am Anfang initialisiert wird und eine gewisse Grenze nicht überschreitet.
Solange die Grenze nicht überschritten wird, wird der Anweisungsblock ausgeführt.

###Syntax:

```java

for(Initialisierung; Zielwert; Schrittweite)
{
	//Anweisung
}

```

###Vorteile

* Hat einen eingebauten Zähler
* Bei einem continue wird der Zähler weiter verändert (so wie man es angegeben hat).

###Nachteile

* Man muss aufpassen wie man die Initialisierung in Bezug auf den Zielwert macht, damit man nicht zu oft oder zu wenig durch die Schleife läuft
* Anzahl an Durchläufen sollte vorher feststehen

###Beispiel

```java

array a = {1, 2, 3, 4, 5};
for (int i = 0; i<a.length(); i++)
{
	System.out.println(a[i]);
}

```