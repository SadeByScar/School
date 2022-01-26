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
        boolean tausch = true;
        for (int j = toSort.length; j > 0 && tausch; j--)
        {
            tausch = false;
            for (int i = 1; i < j; i++) {
                if (toSort[i] < toSort[i - 1]) {
                    int temp = toSort[i];
                    toSort[i] = toSort[i - 1];
                    toSort[i - 1] = temp;
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
