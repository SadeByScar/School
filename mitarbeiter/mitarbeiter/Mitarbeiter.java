package mitarbeiter;
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
public abstract class Mitarbeiter
{
  private int id;
  private String name;
  
  public Mitarbeiter(int id, String name)
  {
    setId(id);
    setName(name);
  }

  public Mitarbeiter(Mitarbeiter original)
  {
    this.setId(original.getId());
    this.setName(original.getName());
  }
  
  /**
   * 
   * @param id 
   * 
   */
  protected void setId(int id) throws IllegalArgumentException
  {
    if(id > 999 && id < 10000)
    {
      this.id = id;
    }
    else
    {
      throw new IllegalArgumentException("Invalide ID");
    }
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
    String rueckgabe = "Der Mitarbeiter mit der ID " + this.id + " heißt " + this.name + ".";
    return rueckgabe;
  }

  public abstract double einkommen();


}
