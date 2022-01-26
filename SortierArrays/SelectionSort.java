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
        
        for (int i = 0; i < toSort.length; i++)
        {
            int minindex = 0;
            int j;
            for (j = i+1; j < toSort.length; j++)
            {
                if (toSort[j] < toSort[minindex])
                {
                    minindex = j;
                }
            }
            int temp = toSort[i];
            toSort[i] = toSort[minindex]; 
            toSort[j] = temp;
        }
        return toSort;
    }
}
