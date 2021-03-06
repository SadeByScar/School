package mitarbeiter
/**
 * 
 * @author goertz
 *
 */

/**
 * 
 * @class Mitarbeiter
 * speichert die Eigenschaften eines Mitarbeiters und stellt Mitarbeiter-Funktionalität zur Verfügung
 */
public class Mitarbeiter {

	private int id;
	private String name;
	
	/**
	 * 
	 * @param id 
	 * 
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * 
	 * @param name 
	 * 
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String toString()
	{
		String rueckgabe = "Der Mitarbeiter mit der ID " + this.id + " heißt " + this.name;
		return rueckgabe;
	}

}