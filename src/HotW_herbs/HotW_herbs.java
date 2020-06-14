package HotW_herbs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class HotW_herbs {

	public static void main(String[] args) throws IOException {
		HashMap<String, Herb> Herbs = new HashMap<String, Herb>();
		
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
		
		for (Herb temp : Herbs.values()) {
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
		
		System.out.println("lol test");
		csv_writer Csv_writer = new csv_writer("Test.csv", 8);
		String[] HerbHeader = {"Herb", "Crimson", "Umber", "Verdant", "Amber", "Sapphire", "Violet", "Golden"};
		
		Csv_writer.writeHeader(HerbHeader);
		
		for (Herb temp : Herbs.values()) {
			totalPickups += temp.getNumOfPickups();
			
			String[] printOut = new String[8];
			printOut[0] = temp.getName();
			printOut[1] = String.valueOf(temp.CrimsonPerPickup());
			printOut[2] = String.valueOf(temp.UmberPerPickup());
			printOut[3] = String.valueOf(temp.VerdantPerPickup());
			printOut[4] = String.valueOf(temp.AmberPerPickup());
			printOut[5] = String.valueOf(temp.SapphirePerPickup());
			printOut[6] = String.valueOf(temp.VioletPerPickup());
			printOut[7] = String.valueOf(temp.GoldenPerPickup());
			Csv_writer.writeRow(printOut);
		}
		
		Csv_writer.closeFile();
	}

}
