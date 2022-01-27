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
        for(int i = 1; i < toSort.length; i++)
        {
            if (toSort[i] < toSort[i-1])
            {
                int temp = toSort[i];
                toSort[i] = toSort[i-1];
                int j;
                for (j = i-1; j > 0 && toSort[j-1] > temp; j--)
                {
                    toSort[j] = toSort[j-1];
                }
                toSort[j] = temp;
            }
        }
        return toSort;
    }
}
