# Schleifen in Java

## for-Schleife

### Definition

Eine for-Schleife ist eine z�hlergesteuerte Schleife, deren Wiederholungsanzahl schon vor Beginn feststeht.
Der Ablauf wird �ber eine Z�hlervariable gesteuert, welche am Anfang initialisiert wird und eine gewisse Grenze nicht �berschreitet.
Solange die Grenze nicht �berschritten wird, wird der Anweisungsblock ausgef�hrt.

### Syntax:

```java

for(Initialisierung; Zielwert; Schrittweite)
{
	//Anweisung
}

```

### Vorteile

* Hat einen eingebauten Z�hler
* Bei einem continue wird der Z�hler weiter ver�ndert (so wie man es angegeben hat).

### Nachteile

* Man muss aufpassen wie man die Initialisierung in Bezug auf den Zielwert macht, damit man nicht zu oft oder zu wenig durch die Schleife l�uft
* Anzahl an Durchl�ufen sollte vorher feststehen

### Beispiel

```java

array a = {1, 2, 3, 4, 5};
for (int i = 0; i<a.length(); i++)
{
	System.out.println(a[i]);
}

```

## while-Schleife

### Definition

Die while-Schleife ist eine kopfgestuerte Schleife mit einer boolschen Abbruchbedingung.
Der Anweisungsblock wird nach der �berpr�fung der Abbruchbedingung ausgef�hrt und das nur solange die Bedingung true ist.

### Syntax:

```java

while(Bedingung)
{
	//Anweisung
}


```

### Vorteile

* Man kann die while-Schleife verwenden, wenn es eine bestimmte Anzahl von Iterationen gibt.

### Nachteile

* Es kann schnell zu einer Endlosschleife kommen, wenn die Abbruchbedingung nie erreicht wird.

### Beispiel

```java

int i = 0;
while(i < 5)
{
	System.out.println(i);
	i++;
}

```

## do-while-Schleife

### Definition

Bei einer do-while-Schleife wird der Anweisungsblock vor der �berpr�fung der Bedingung ausgef�hrt.
So wird der Code in der Anweisung mindestens einmal durchlaufen.
Die do-while-Schleife ist eine fu�gesteuerte Schleife.

### Syntax:

```java

do
{
	//Anweisung
}
while(Bedingung);

```

### Vorteile

* Der Anweisungsblock wird auf jeden fall einmal durchlaufen.

### Nachteile

* Bei fehlender �nderung der Z�hlervariable kann es schnell zu Endlosschleifen kommen.

### Beispiel

```java

boolean var=false
do
{
	System.out.println("Nur ein mal");
}
while(var);

```