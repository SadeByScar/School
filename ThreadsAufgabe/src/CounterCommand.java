public class CounterCommand implements Runnable
{
    public CounterCommand()
    {}

    @Override
    public void run() {
        int i = 0;
        while (true)
        {
            System.out.println(i);
            i++;
        }
    }
}
