package Aufgabe2;

public class Main
{
    public static void main(String[] args)
    {
        Konto konto1 = new Konto("Konto1",100);
        Konto konto2 = new Konto("Konto2",100);
        AbbuchCommand abbuchCommand1 = new AbbuchCommand(konto1, 10);
        AbbuchCommand abbuchCommand2 = new AbbuchCommand(konto2, 10);
        for(int i = 0; i<10 ; i++) {
            Thread thread1 = new Thread(abbuchCommand1);
            Thread thread2 = new Thread(abbuchCommand2);
            thread1.start();
            thread2.start();
        }

/*        Konto konto3 = new Konto("Konto3", 100);

        for(int i = 0; i<10 ; i++) {
            AbbuchCommand abbuchCommand3 = new AbbuchCommand(konto3, 10);
            AbbuchCommand abbuchCommand4 = new AbbuchCommand(konto3, 10);
            Thread thread3 = new Thread(abbuchCommand3);
            Thread thread4 = new Thread(abbuchCommand4);
            thread3.start();
            thread4.start();
        }*/

   /*     Konto konto4 = new Konto("Konto4", 100);
        for(int i = 0; i<10 ; i++) {
            Thread thread3 = new AbbuchThread(konto4, 10);
            Thread thread4 = new AbbuchThread(konto4, 10);
            thread3.start();
            thread4.start();
        }*/
    }
}
