package Wetterdienst;

import java.util.concurrent.TimeUnit;

public class wetterdienstTest
{
    public static void main(String[] args)
    {
        Wetterdaten wd = new Wetterdaten(30, 40, 50);
        WetterPrognose wp = new WetterPrognose(wd);
        WetterdatenGUI wdGUI = new WetterdatenGUI(wd);
        WetterPrognoseGUI wpGUI = new WetterPrognoseGUI(wp);
        while (true)
        {
/*            wd.setTemperatur(Math.random()*30);
            wd.setLuftdruck(Math.random()*100);
            wd.setLuftfeuchte(Math.random()*30);*/
            wd.setWetterdaten(Math.random()*30, Math.random()*100, Math.random()*30);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e)
            {
                System.out.println("Fehler beim Sleep");
            }
        }
    }
}
