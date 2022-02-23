package Figuren;
/**
 * 
 * @author goertz
 *
 */

/**
 * 
 * @class Kreis
 * speichert die Eigenschaften eines Kreises und stellt Kreis-Funktionalität zur Verfügung
 */


public class Kreis extends ZweidimensionaleFigur {
	
	private double radius;

	public Kreis(double radius)
	{
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	/**
	 * 
	 * @param radius 
	 *  Der Radius muss größer als 0 sein
	 */
	public void setRadius(double radius)
	{
		if (radius <= 0)
		{
			System.out.println("Der Radius des Kreises muss positiv sein und kann nicht 0 oder kleiner sein.");
		}
		else 
		{
			this.radius = radius;
		}
	}
	
	public double umfang()
	{
		double umfang = 2 * this.radius  * Math.PI;
		return umfang;
	}
	
	public double flaeche()
	{
		double flaeche = Math.PI * this.radius * this.radius;
		return flaeche;
	}
}