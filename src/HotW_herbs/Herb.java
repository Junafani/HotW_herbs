package HotW_herbs;

public class Herb {

	private String name;
	private int numOfPickups;
	private int totalCrimson;
	private int totalUmber;
	private int totalVerdant;
	private int totalAmber;
	private int totalSapphire;
	private int totalViolet;
	private int totalGolden;
	
	public Herb (String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumOfPickups() {
		return numOfPickups;
	}
	
	public void addPickup(int crimson, int umber, int verdant, int amber, int sapphire, int violet, int golden) {
		numOfPickups++;
		totalCrimson += crimson;
		totalUmber += umber;
		totalVerdant += verdant;
		totalAmber += amber;
		totalSapphire += sapphire;
		totalViolet += violet;
		totalGolden += golden;
	}
	
	public double CrimsonPerPickup() {
		return (double)totalCrimson/(double)numOfPickups;
	}
	
	public double UmberPerPickup() {
		return (double)totalUmber/(double)numOfPickups;
	}
	
	public double VerdantPerPickup() {
		return (double)totalVerdant/(double)numOfPickups;
	}
	
	public double AmberPerPickup() {
		return (double)totalAmber/(double)numOfPickups;
	}
	
	public double SapphirePerPickup() {
		return (double)totalSapphire/(double)numOfPickups;
	}
	
	public double VioletPerPickup() {
		return (double)totalViolet/(double)numOfPickups;
	}
	
	public double GoldenPerPickup() {
		return (double)totalGolden/(double)numOfPickups;
	}
}
