package Aufgabe1;

public class Main
{
    public static void main(String[] args)
    {
        CounterCommand counterCommand = new CounterCommand();
        Thread counter = new Thread(counterCommand);
        DatumsCommand datum = new DatumsCommand();
        counter.start();
        datum.start();
    }
}
