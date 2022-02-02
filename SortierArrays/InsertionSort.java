package SortierArrays;

public class InsertionSort
{
    public InsertionSort(int[] array)
    {
        this.sortASC(array);
    }

    public InsertionSort()
    {
        int[] test = {16, 4, 43, 45, 17, 5, 6};
        this.sortASC(test);
    }

    public int[] sortASC(int[] toSort)
    {
        // Von vorne nach hinten, bei 1 angefangen weil i-1 verwendet wird   
        for(int i = 1; i < toSort.length; i++)
        {
            // Vergleichen mit dem davor    
            if (toSort[i] < toSort[i-1])
            {
                // in temp speichern und den anderen Wert schon umtauschen
                int temp = toSort[i];
                toSort[i] = toSort[i-1];
                // j vor der Schleife damit man es nachher verwenden kann
                int j;
                // j = i-1 um nach voren zu gucken was noch getauscht werden muss, von hinten nach vorne
                // achte auf den vergleich in der for-Schleife denn nur dann muss getauscht werden
                for (j = i-1; j > 0 && toSort[j-1] > temp; j--)
                {
                    // Alles was getauscht werden muss tauschen
                    toSort[j] = toSort[j-1];
                }
                // wenn vorbei dann temp an der richtigen Stelle einfügen
                toSort[j] = temp;
            }
        }
        return toSort;
    }
}
