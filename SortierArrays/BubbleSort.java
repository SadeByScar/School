package SortierArrays;

public class BubbleSort
{
    public BubbleSort(int[] array)
    {
        this.sortASC(array);
    }

    public BubbleSort()
    {
        int[] test = {16, 4, 43, 45, 17, 5, 6};
        this.sortASC(test);
    }

    public int[] sortASC(int[] toSort)
    {
        // Variable wegen Optimierung, wenn nicht getauscht dann nicht mehr gucken
        boolean tausch = true;
        // Von hinten nach vorne wegen Optimierung, Abfrage von tausch wegen Optimierung
        for (int j = toSort.length; j > 0 && tausch; j--)
        {
            // Auf falsch setzten bei jedem neuen Durchlauf
            tausch = false;
            // Von vorne nach hinten
            for (int i = 1; i < j; i++) {
                // Mit Nachbar vergleichen
                if (toSort[i] < toSort[i - 1]) {
                    // tauschen
                    int temp = toSort[i];
                    toSort[i] = toSort[i - 1];
                    toSort[i - 1] = temp;
                    // Wenn getauscht, tausch auf true
                    if (!tausch)
                    {
                        tausch = true;
                    }
                }
            }
        }
        return toSort;
    }
}
