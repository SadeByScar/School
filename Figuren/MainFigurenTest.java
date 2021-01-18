package Figuren

public class MainFigurenTest {

	public static void main(String[] args) {
		Kreis kreis = new Kreis();
		Rechteck rechteck = new Rechteck();
		
		kreis.setRadius(3);
		rechteck.setBreite(2.50);
		rechteck.setLaenge(4);
		System.out.println("Der Umfang des Rechtecks beträgt " + rechteck.umfang());
		System.out.println("Die Fläche des Kreises beträgt " + kreis.flaeche());
	}
}