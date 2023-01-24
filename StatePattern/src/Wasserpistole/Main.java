package Wasserpistole;

import Wasserpistole.*;
import Wasserpistole.Wasserpistole.Wasserpistole;

public class Main {

    public static void main(String[] args)
    {
        Wasserpistole peter = new Wasserpistole(0);
        peter.fuellen(500);
        for (int i = 0; i < 9; i++)
        {
            peter.schiessen();
            System.out.println(peter.getFuellstand());
        }
        peter.fuellen(100);
        peter.schiessen();
        peter.fuellen(100);
        for (int i = 0; i < 3; i++)
        {
            peter.schiessen();
            System.out.println(peter.getFuellstand());
        }
        peter.fuellen(600);
        for (int i = 0; i < 9; i++)
        {
            peter.schiessen();
            System.out.println(peter.getFuellstand());
        }
        peter.schiessen();
        peter.schiessen();
    }
}
