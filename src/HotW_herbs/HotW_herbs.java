package HotW_herbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

public class HotW_herbs {

	public static void main(String[] args) throws IOException {
		HashMap<String, Herb> Herbs = new HashMap<String, Herb>();
		String herbNames[] = {"Vetchling", "Horsetail", "Oxlip", "Southron's Crown", "Dwarfsbeard",
				"Elfspear", "Drakewort", "Bell-O-Dale", "Rock-rose", "Larkspur", "Buckthorn",
				"Dusknettle", "Bonemallow", "Wraithscowl", "Eye-of-Night", "Evengleam", "Mournweed"};
		
		Herb Vetchling = new Herb("Vetchling");
		Herbs.put("Vetchling", Vetchling);
		
		Herb Horsetail = new Herb("Horsetail");
		Herbs.put("Horsetail", Horsetail);
		
		Herb Oxlip = new Herb("Oxlip");
		Herbs.put("Oxlip", Oxlip);
		
		Herb Southron = new Herb("Southron's Crown");
		Herbs.put("Southron's Crown", Southron);
		
		Herb Dwarfsbeard = new Herb("Dwarfsbeard");
		Herbs.put("Dwarfsbeard", Dwarfsbeard);
		
		Herb Elfspear = new Herb("Elfspear");
		Herbs.put("Elfspear", Elfspear);
		
		Herb Drakewort = new Herb("Drakewort");
		Herbs.put("Drakewort", Drakewort);
		
		Herb Bell = new Herb("Bell-O-Dale");
		Herbs.put("Bell-O-Dale", Bell);
		
		Herb Larkspur = new Herb("Larkspur");
		Herbs.put("Larkspur", Larkspur);
		
		Herb Rock = new Herb("Rock-rose");
		Herbs.put("Rock-rose", Rock);
		
		Herb Buckthorn = new Herb("Buckthorn");
		Herbs.put("Buckthorn", Buckthorn);
		
		Herb Wraithscowl = new Herb("Wraithscowl");
		Herbs.put("Wraithscowl", Wraithscowl);
		
		Herb Dusknettle = new Herb("Dusknettle");
		Herbs.put("Dusknettle", Dusknettle);
		
		Herb Bonemallow = new Herb("Bonemallow");
		Herbs.put("Bonemallow", Bonemallow);
		
		Herb Eye = new Herb("Eye-of-Night");
		Herbs.put("Eye-of-Night", Eye);
		
		Herb Evengleam = new Herb("Evengleam");
		Herbs.put("Evengleam", Evengleam);
		
		Herb Mournweed = new Herb("Mournweed");
		Herbs.put("Mournweed", Mournweed);
		
		File file = new File("data.csv");
		BufferedReader csvReader = new BufferedReader(new FileReader(file));
		
		//Read header
		csvReader.readLine();
		
		
		String row;
		
		while ((row = csvReader.readLine()) != null) {
			
			//Needs -1 parameter so split does not stop at first empty spot.
		    String[] data = row.split(",", -1);
		    
		    String name = data[0];
		    
		    int phials[] = new int[7];
		    for (int i = 1; i <data.length; i++) {
		    	if (data[i].length()==0) {
		    		phials[i-1] = 0;
		    	} else {
		    		phials[i-1] = Integer.parseInt(data[i]);
		    	}		    	
		    }
		    
		    Herb temp = Herbs.get(name);
		    try {
		    temp.addPickup(phials[0], phials[1], phials[2], phials[3], phials[4], phials[5], phials[6]);
		    } catch (NullPointerException e) {
		    	System.out.println("Error at " + name);
		    }
		}
		
		csvReader.close();
		
		System.out.println("Starting printing:");
		System.out.println();
		
		int totalPickups = 0;
		
		for (String currentPrintHerb : herbNames) {
			Herb temp = Herbs.get(currentPrintHerb);
			totalPickups += temp.getNumOfPickups();
			
			System.out.println("Herb: " + temp.getName() + " (Pickups: " + temp.getNumOfPickups() + ")");
			System.out.println("Crimson per pickup: " + temp.CrimsonPerPickup());
			System.out.println("Umber per pickup: " + temp.UmberPerPickup());
			System.out.println("Verdant per pickup: " + temp.VerdantPerPickup());
			System.out.println("Amber per pickup: " + temp.AmberPerPickup());
			System.out.println("Sapphire per pickup: " + temp.SapphirePerPickup());
			System.out.println("Violet per pickup: " + temp.VioletPerPickup());
			System.out.println("Golden per pickup: " + temp.GoldenPerPickup());
			System.out.println();
		}
		
		System.out.println("Total number of pickups: " + totalPickups);
		
		lowHerbsPrint(Herbs);
		
		csv_writer Csv_writer = new csv_writer("Output.csv", 9);
		String[] HerbHeader = {"Herb", "Crimson", "Umber", "Verdant", "Amber", "Sapphire", "Violet", "Golden", "Total pickups"};
		
		Csv_writer.writeHeader(HerbHeader);
		
		for (String currentPrintHerb : herbNames) {
			Herb temp = Herbs.get(currentPrintHerb);
			String[] printOut = new String[9];
			printOut[0] = temp.getName();
			printOut[1] = String.valueOf(temp.CrimsonPerPickup());
			printOut[2] = String.valueOf(temp.UmberPerPickup());
			printOut[3] = String.valueOf(temp.VerdantPerPickup());
			printOut[4] = String.valueOf(temp.AmberPerPickup());
			printOut[5] = String.valueOf(temp.SapphirePerPickup());
			printOut[6] = String.valueOf(temp.VioletPerPickup());
			printOut[7] = String.valueOf(temp.GoldenPerPickup());
			printOut[8] = String.valueOf(temp.getNumOfPickups());
			Csv_writer.writeRow(printOut);
		}
		
		Csv_writer.closeFile();
		
		wikiTableWriter WikiTableWriter = new wikiTableWriter("to_wiki.txt", 9, "wikitable", "Phial drop rates");
		WikiTableWriter.writeHeader(HerbHeader);
		
		for (String currentPrintHerb : herbNames) {
			DecimalFormat number_format = new DecimalFormat( "##0.00" );
			Herb temp = Herbs.get(currentPrintHerb);
			String[] printOut = new String[9];
			printOut[0] = temp.getName();
			printOut[1] = String.valueOf(number_format.format(temp.CrimsonPerPickup()*100)) + " %";
			printOut[2] = String.valueOf(number_format.format(temp.UmberPerPickup()*100)) + " %";
			printOut[3] = String.valueOf(number_format.format(temp.VerdantPerPickup()*100)) + " %";
			printOut[4] = String.valueOf(number_format.format(temp.AmberPerPickup()*100)) + " %";
			printOut[5] = String.valueOf(number_format.format(temp.SapphirePerPickup()*100)) + " %";
			printOut[6] = String.valueOf(number_format.format(temp.VioletPerPickup()*100)) + " %";
			printOut[7] = String.valueOf(number_format.format(temp.GoldenPerPickup()*100)) + " %";
			printOut[8] = String.valueOf(temp.getNumOfPickups());
			WikiTableWriter.writeRow(printOut);
		}
		
		WikiTableWriter.closeFile();
	}
	
	private static void lowHerbsPrint(HashMap<String, Herb> Herbs) {
		System.out.println("\nHerbs with under 100 pickups");
		for (Herb temp : Herbs.values()) {
			if (temp.getNumOfPickups() <100) {
				System.out.println(temp.getName() + " (" + temp.getNumOfPickups() + ")");
			}
		}
		
		System.out.println("\nHerbs with under 200 pickups");
		for (Herb temp : Herbs.values()) {
			if (temp.getNumOfPickups() >99 && temp.getNumOfPickups() <200) {
				System.out.println(temp.getName() + " (" + temp.getNumOfPickups() + ")");
			}
		}
	}
	
	

}
