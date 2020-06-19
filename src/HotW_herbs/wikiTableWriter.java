package HotW_herbs;

import java.io.FileWriter;
import java.io.IOException;

public class wikiTableWriter {

	private FileWriter openedFile;
	private boolean hasHeader;
	private boolean hasCaption;
	private int rows;
	private int columns;
	private String wikiclass;
	
	public wikiTableWriter (String name, int columns, String wikiclass, String caption) {
		try {
			openedFile = new FileWriter(name);
		} catch (IOException e) {
			System.out.println("Couldn't open the file " + name);	
			e.printStackTrace();
		}
		rows=0;
		this.columns=columns;
		hasHeader=false;
		
		try {
			openedFile.append("{|");
		} catch (IOException e) {
			System.out.println("Error writing the start of table.");
			e.printStackTrace();
		}
		
		if (!wikiclass.isEmpty()) {
			try {
				openedFile.append(" class=\"" + wikiclass + "\"");
			} catch (IOException e) {
				System.out.println("Error writing the class of wikitable.");
				e.printStackTrace();
			}
		}
		
		try {
			openedFile.append("\n");
		} catch (IOException e) {
			System.out.println("Error writing wikitable row change");
			e.printStackTrace();
		}
		
		if (caption.isEmpty()) {
			hasCaption=false;
		} else {
			hasCaption=true;
			try {
				openedFile.append("|+" + caption + "\n|-");
			} catch (IOException e) {
				System.out.println("Error writing the caption of wikitable");
				e.printStackTrace();
			}
		}
	}
	
	public void closeFile() {		
		try {
			openedFile.flush();
			openedFile.close();
		} catch (IOException e) {
			System.out.println("Error closing the file");
			e.printStackTrace();
		}
	}
	
}
