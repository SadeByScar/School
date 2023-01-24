package Aufgabe3;

public class QuickSortRun implements Runnable
{
    private int[] array;
    private int leftmostIndex;
    private int rightmostIndex;
    private QuickSort sort;

    public QuickSortRun(int[] array, int leftmostIndex, int rightmostIndex)
    {
        this.array = array;
        this.leftmostIndex = leftmostIndex;
        this.rightmostIndex = rightmostIndex;
        sort = new QuickSort();

    }

    @Override
    public void run() {
        sort.quicksort(array, leftmostIndex, rightmostIndex);
        //System.out.println(this);
    }
}
