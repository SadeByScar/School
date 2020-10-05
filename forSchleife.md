# Schleifen in Java

## for-Schleife

###Definition

Eine for-Schleife ist eine z�hlergesteuerte Schleife, deren Wiederholungsanzahl schon vor Beginn feststeht.
Der Ablauf wird �ber eine Z�hlervariable gesteuert, welche am Anfang initialisiert wird und eine gewisse Grenze nicht �berschreitet.
Solange die Grenze nicht �berschritten wird, wird der Anweisungsblock ausgef�hrt.

###Syntax:

```java

for(Initialisierung; Zielwert; Schrittweite)
{
	//Anweisung
}

```

###Vorteile

* Hat einen eingebauten Z�hler
* Bei einem continue wird der Z�hler weiter ver�ndert (so wie man es angegeben hat).

###Nachteile

* Man muss aufpassen wie man die Initialisierung in Bezug auf den Zielwert macht, damit man nicht zu oft oder zu wenig durch die Schleife l�uft
* Anzahl an Durchl�ufen sollte vorher feststehen

###Beispiel

```java

array a = {1, 2, 3, 4, 5};
for (int i = 0; i<a.length(); i++)
{
	System.out.println(a[i]);
}

```