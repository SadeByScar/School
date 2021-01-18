package Figuren
/**
 * 
 * @author goertz
 *
 */

/**
 * 
 * @class Rechteck
 * speichert die Eigenschaften eines Rechtecks und stellt Rechteck-Funktionalität zur Verfügung
 */
public class Rechteck {
	
	private double laenge;
	private double breite;
	
	public double getLaenge()
	{
		return this.laenge;
	}
	
	/**
	 * 
	 * @param laenge 
	 *  Die Länge muss größer als 0 sein
	 */
	public void setLaenge(double laenge)
	{
		if (laenge <= 0)
		{
			System.out.println("Die Länge muss größer als 0 sein.");
		}
		else
		{
			this.laenge = laenge;
		}
	}
	
	public double getBreite()
	{
		return this.breite;
	}
	
	
	/**
	 * 
	 * @param breite 
	 *  Die Breite muss größer als 0 sein
	 */
	public void setBreite(double breite)
	{
		if (breite <= 0)
		{
			System.out.println("Die Breite muss größer als 0 sein.");
		}
		else
		{
			this.breite = breite;
		}
	}
	
	public double umfang()
	{
		double umfang = (2 * this.laenge) + (2 * this.breite);
		return umfang;
	}
	
	public double flaeche()
	{
		double flaeche = this.laenge * this.breite;
		return flaeche;
	}
	
}