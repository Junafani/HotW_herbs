package HotW_herbs;

import java.io.FileWriter;
import java.io.IOException;

public class csv_writer {
	
	private FileWriter openedFile;
	boolean hasHeader;
	int rows;
	int columns;
	
	public csv_writer (String name, int columns) {
		try {
			openedFile = new FileWriter(name);
		} catch (IOException e) {
			System.out.println("Couldn't open the file " + name);	
			e.printStackTrace();
		}
		rows=0;
		this.columns=columns;
		hasHeader=false;
	}
	
	public void writeHeader(String[] header) {
		for (int i=0; i<columns; i++) {
			try {
				openedFile.append(header[i]);
				openedFile.append(",");
			} catch (IOException e) {
				System.out.println("Error writing header column: " + i + " with data \"" + header[i] + "\"");
				e.printStackTrace();
			}
		}
		
		try {
			openedFile.append(header[columns-1]);
			openedFile.append("\n");
		} catch(IOException e) {
			System.out.println("Error writing last header column: " + columns + " with data \"" + header[columns] + "\"");
			e.printStackTrace();
		}
		hasHeader=true;
	}
	
	public void writeRow(String[] rowOfData) {
		for (int i=0; i<columns-1; i++) {
			try {
				openedFile.append(rowOfData[i]);
				openedFile.append(",");
			} catch (IOException e) {
				System.out.println("Error writing row: " + rows + "  column: " + i + " with data \"" + rowOfData[i] + "\"");
				e.printStackTrace();
			}
		}
		
		try {
			openedFile.append(rowOfData[columns-1]);
			openedFile.append("\n");
		} catch(IOException e) {
			System.out.println("Error writing last row column: " + columns + " with data \"" + rowOfData[columns] + "\"");
			e.printStackTrace();
		}
		
		rows++;
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
