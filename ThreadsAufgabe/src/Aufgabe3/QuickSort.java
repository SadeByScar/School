package Aufgabe3;

public class QuickSort
{
/*    public void sort(int[] array, int leftmostIndex, int rightmostIndex)
    {
        if (leftmostIndex < rightmostIndex)
        {
            int pivotIndex = partition(array, leftmostIndex, rightmostIndex);
            QuickSortRun runnerR = new QuickSortRun(array, pivotIndex + 1, rightmostIndex);
            QuickSortRun runnerL = new QuickSortRun(array, leftmostIndex, pivotIndex - 1);

            Thread threadR = new Thread(runnerR);
            Thread threadL = new Thread(runnerL);
            threadR.start();
            threadL.start();
        }
    }

    private int partition(int[] array, int leftmostIndex, int rightmostIndex)
    {
        int pivot = array[rightmostIndex];
        int storeIndex = leftmostIndex - 1;
        for (int i = leftmostIndex; i < rightmostIndex; i++)
        {
            if (array[i] <= pivot)
            {
                storeIndex++;

                int temp = array[storeIndex];
                array[storeIndex] = array[i];
                array[i] = temp;
            }
        }

        int temp = array[storeIndex + 1];
        array[storeIndex + 1] = array[rightmostIndex];
        array[rightmostIndex] = temp;

        return storeIndex + 1;
    }*/

    public static void quicksort( int [] zahlenFeld, int links, int rechts){

        //3-Median Strategie
        int mitte = (rechts + links)/2;
        if( zahlenFeld[links] < zahlenFeld[mitte] && zahlenFeld[mitte] < zahlenFeld[rechts]){
            swap(zahlenFeld, rechts, mitte);
        }else if( zahlenFeld[mitte] < zahlenFeld[links] && zahlenFeld[links] < zahlenFeld[rechts]){
            swap(zahlenFeld, rechts, links);
        }

        int pivot = zahlenFeld[rechts]; // Nur damit der Code lesbarer wird
        //Durchl�ufe
        int i = links, j = rechts-1;
        while( i <= j ){
            //Suche linke Tauschposition
            while( i<rechts && zahlenFeld[i] <= pivot)
                i++;
            //Suche rechte Tauschposition
            while( j >= links && zahlenFeld[j] >= pivot)
                j--;
            //Wenn Durchlauf noch nicht beendet
            if( i < j ){
                swap( zahlenFeld, i, j);
            }
        }
        //Setze Pivotelement in die Mitte (endg�ltige Position)
        swap(zahlenFeld, rechts, i);

        // Rekursive Aufrufe:

        int newRechts = i-1, newLinks = i+1;

        //System.out.println("Aufruf linke Teilfolge: "+"links: "+ links + " newRechts: " + newRechts);

        if( links < newRechts){
            QuickSortRun runnerL = new QuickSortRun( zahlenFeld, links, newRechts);
            Thread threadL = new Thread(runnerL);
            threadL.start();
        }
        //System.out.println("Aufruf rechte Teilfolge: "+"newLinks: " +newLinks+ " rechts: " + rechts);
        if( newLinks < rechts){
            QuickSortRun runnerR = new QuickSortRun( zahlenFeld, newLinks, rechts);
            Thread threadR = new Thread(runnerR);
            threadR.start();
        }
    }

    public static void swap(int [] zahlenFeld, int i, int j){
        int temp = zahlenFeld[i];
        zahlenFeld[i] = zahlenFeld[j];
        zahlenFeld[j] = temp;
    }
}
