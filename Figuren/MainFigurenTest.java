import Figuren.*;

public class MainFigurenTest {

	public static void main(String[] args) {
		Kreis kreis = new Kreis(12);
		Rechteck rechteck = new Rechteck(1, 2);
		Dreieck dreieck = new Dreieck(2, 2, 2);
		Polygon polygon = new Polygon(2, 3);
		
		kreis.setRadius(3);
		rechteck.setBreite(2.50);
		rechteck.setLaenge(4);
		System.out.println("Der Umfang des Rechtecks beträgt " + rechteck.umfang());
		System.out.println("Die Fläche des Kreises beträgt " + kreis.flaeche());
		System.out.println("Die Fläche des Dreiecks beträgt " + dreieck.flaeche());
		System.out.println("Die Fläche des Polygons mit " + polygon.getEcken() + " Ecken beträgt " + polygon.flaeche());
	}
}