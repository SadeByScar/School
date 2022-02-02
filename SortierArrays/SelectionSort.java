package SortierArrays;

public class SelectionSort
{
    public SelectionSort(int[] array)
    {
        this.sortASC(array);
    }

    public SelectionSort()
    {
        int[] test = {16, 4, 43, 45, 17, 5, 6};
        this.sortASC(test);
    }

    public int[] sortASC(int[] toSort)
    {
        // Von vorne nach hinten
        for (int i = 0; i < toSort.length; i++)
        {
            // Index merken
            int minindex = i;
            // j vorher damit man nachher darauf zugreifen kann
            for (int j = i+1; j < toSort.length; j++)
            {
                // Checken ob minindex wirklich das kleinste Element ist
                if (toSort[j] < toSort[minindex])
                {
                    // Falls nicht minindex umsetzten          
                    minindex = j;
                }
            }
            // tauschen
            int temp = toSort[i];
            toSort[i] = toSort[minindex]; 
            toSort[minindex] = temp;
        }
        return toSort;
    }
}
