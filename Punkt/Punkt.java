package Punkt
/**
 * 
 * @author goertz
 *
 */

/**
 * 
 * @class Punkt
 * speichert die Eigenschaften eines Punkt und stellt Punkt-Funktionalität zur Verfügung
 */
public class Punkt {
	
	private double x;
	private double y;
	
	/**
	 * 
	 * @param cord 
	 * 
	 */
	public void setX(double cord)
	{
		this.x = cord;
	}
	
	public double getX()
	{
		return this.x;
	}
	
	/**
	 * 
	 * @param cord 
	 * 
	 */
	public void setY(double cord)
	{
		this.y = cord;
	}
	
	public double getY()
	{
		return this.y;
	}
	
	/**
	 * 
	 * @param plusX
	 * @param plusY
	 * 
	 */
	public void verschiebe(double plusX, double plusY)
	{
		this.x = this.x + plusX;
		this.y = this.y + plusY;
	}
}