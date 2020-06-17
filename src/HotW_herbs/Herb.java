package HotW_herbs;

public class Herb {

	private String name;
	private int numOfPickups;
	private int totalCrimson;
	private int[] crimsonPickups;
	private int totalUmber;
	private int[] umberPickups;
	private int totalVerdant;
	private int[] verdantPickups;
	private int totalAmber;
	private int[] amberPickups;
	private int totalSapphire;
	private int[] sapphirePickups;
	private int totalViolet;
	private int[] violetPickups;
	private int totalGolden;
	private int[] goldenPickups;
	
	public Herb (String name) {
		this.name = name;
		crimsonPickups = new int[5];
		umberPickups = new int[5];
		verdantPickups = new int[5];
		amberPickups = new int[5];
		sapphirePickups = new int[5];
		violetPickups = new int[5];
		goldenPickups = new int[5];
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumOfPickups() {
		return numOfPickups;
	}
	
	public void addPickup(int crimson, int umber, int verdant, int amber, int sapphire, int violet, int golden) {
		numOfPickups++;
		if (crimson>0) {
			totalCrimson += crimson;
			crimsonPickups[crimson-1]++;
		}
		
		if (umber>0) {
			totalUmber += umber;
			umberPickups[umber-1]++;
		}
		
		if (verdant>0) {
			totalVerdant += verdant;
			verdantPickups[verdant-1]++;
		}
		
		if (amber>0) {
			totalAmber += amber;
			amberPickups[amber-1]++;
		}
		
		if (sapphire>0) {
			totalSapphire += sapphire;
			sapphirePickups[sapphire-1]++;
		}
		
		if (violet>0) {
			totalViolet += violet;
			violetPickups[violet-1]++;
		}
		
		if (golden>0) {
			totalGolden += golden;
			goldenPickups[golden-1]++;
		}
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
