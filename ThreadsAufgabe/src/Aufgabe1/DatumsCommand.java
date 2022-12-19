package Aufgabe1;

import java.time.ZonedDateTime;

public class DatumsCommand extends Thread
{
    public DatumsCommand()
    {
        super();
    }
    @Override
    public void run()
    {
        while (true)
        {
            System.out.println(ZonedDateTime.now());
        }
    }
}
