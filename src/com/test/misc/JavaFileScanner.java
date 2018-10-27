package com.test.misc;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class JavaFileScanner {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "C:/PCI_SALESORDER_BOT/INBOUND/3PCIOutbound850.edi";//"C:/F/scan/textfile.txt";
		
		Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        
        //read file line by line
        //scanner.useDelimiter(System.getProperty("line.separator"));
        scanner.useDelimiter("~");
        
        while(scanner.hasNext()){
            //System.out.println("Lines: "+scanner.next());
        	parseEDILine(scanner.next());
        }
        scanner.close();
	}

	private static void parseEDILine(String line) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(line);
		 scanner.useDelimiter("\\s*\\*\\s*");
		 while(scanner.hasNext()){
	            //parse line to get Emp Object
	           
	            System.out.print(scanner.next() + "	");
	      }
	      scanner.close();
		System.out.println();
	}

}
