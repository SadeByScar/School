package Aufgabe3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Main
{
    public static void main(String[] args) throws IOException {
        int anzahl;
        int zahlenFeld[];
        BufferedReader eingabeTool = new BufferedReader(new InputStreamReader( System.in));
        System.out.print("Wie viele Zahlen erzeugen?");
        anzahl = Integer.parseInt(eingabeTool.readLine());
        zahlenFeld= new int[anzahl];
        feldFuellen(zahlenFeld);
        ausgabeFeld(zahlenFeld);
        QuickSort quickSort = new QuickSort();
        quickSort.quicksort(zahlenFeld, 0, zahlenFeld.length-1);
        ausgabeFeld(zahlenFeld);
    }

    public static void feldFuellen(int[]zahlenFeld){
        Random zahlenMaschine = new Random();
        //Feld mit Zufallszahlen fuellen
        for(int i = 0; i < zahlenFeld.length; i++)
            zahlenFeld[i] = zahlenMaschine.nextInt(1000);
    }
    public static void ausgabeFeld(int[]zahlenFeld){
        for(int i = 0; i < zahlenFeld.length; i++)
            System.out.print(zahlenFeld[i] + " ");
        System.out.println();
    }
}
