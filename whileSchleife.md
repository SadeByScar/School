# Schleifen in Java

## while-Schleife

### Definition

Die while-Schleife ist eine kopfgestuerte Schleife mit einer boolschen Abbruchbedingung.
Der Anweisungsblock wird nach der Überprüfung der Abbruchbedingung ausgeführt und das nur solange die Bedingung true ist.

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