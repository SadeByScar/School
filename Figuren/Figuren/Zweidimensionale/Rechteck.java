package Figuren.Figuren.Zweidimensionale;
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
public class Rechteck extends ZweidimensionaleFigur {
	
	private double laenge;
	private double breite;

	public Rechteck(double laenge, double breite)
	{
		this.breite = breite;
		this.laenge = laenge;
	}

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