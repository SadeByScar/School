public class Main
{
    public static void main(String[] args)
    {
        CounterCommand counter = new CounterCommand();
        Thread imple = new Thread(counter);
        DatumsCommand datum = new DatumsCommand();
        datum.start();
        imple.start();
    }
}
