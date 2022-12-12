package main;

import src.abteilung.Abteilung;
import src.mitarbeiter.*;
import src.*;

public class MainMitarbeitertst
{
	public static void main(String[] args) {

		Manager ab = new Manager(5003, "Erna", 500, 1);
		Abteilung abteilung = new Abteilung("abteilung", ab);
		//System.out.println(ab.toString());
		Malocher mal = new Malocher(3001, "Rudi", 450.00);
		abteilung.add(mal);
		Manager asdf = new Manager(5002, "Fred", 500, 1);
		Abteilung unterabteilung = new Abteilung("UNterabteilung", asdf);
		Malocher nope = new Malocher(3002, "BOB", 450.00);
		unterabteilung.add(nope);
		abteilung.add(unterabteilung);
		System.out.println(abteilung.toString());

	}
}
