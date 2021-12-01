package mitarbeiter;
public class MainMitarbeitertst
{
	public static void main(String[] args) {
		Mitarbeiter ab = new Mitarbeiter(11, "Rudolf");
		ab.setId(12);
		ab.getId();
		ab.setName("Sander");
		System.out.println(ab.toString());
	}
}
