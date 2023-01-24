# Schleifen in Java

## do-while-Schleife

### Definition

Bei einer do-while-Schleife wird der Anweisungsblock vor der Überprüfung der Bedingung ausgeführt.
So wird der Code in der Anweisung mindestens einmal durchlaufen.
Die do-while-Schleife ist eine fußgesteuerte Schleife.

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

* Bei fehlender Änderung der Zählervariable kann es schnell zu Endlosschleifen kommen.

### Beispiel

```java

boolean var=false
do
{
	System.out.println("Nur ein mal");
}
while(var);

```