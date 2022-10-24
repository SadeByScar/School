package src.mitarbeiter;
/**
 * 
 * @author goertz
 *
 */

import java.util.Comparator;

/**
 * 
 * @class Mitarbeiter
 * speichert die Eigenschaften eines Mitarbeiters und stellt Mitarbeiter-Funktionalität zur Verfügung
 */
public abstract class Mitarbeiter implements Comparable<Mitarbeiter>
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

  @Override
  public int compareTo(Mitarbeiter o)
  {
    return o.getName().compareTo(this.getName());
  }

  public static class MitarbeiterComperator implements Comparator<Mitarbeiter>
  {
    @Override
    public int compare(Mitarbeiter o1, Mitarbeiter o2) {
      int temp = 0;
      if (o1.einkommen() < o2.einkommen())
      {
        temp = -1;
      }
      else if (o1.einkommen() > o2.einkommen())
      {
        temp = 1;
      }
      return temp;
    }
  }
}
