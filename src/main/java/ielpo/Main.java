package ielpo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class Main {

	public static void main(String... args){
		Rename rename = new Rename();
		String directory = "";
		String findPattern = "";
		String replaceWith ="";
		Boolean proceed = false;
		
		System.out.println("Start: " + new Date());
		
		if(args.length > 2
				&& !"".equalsIgnoreCase(args[0])
				&& !"".equalsIgnoreCase(args[1])
				&& !"".equalsIgnoreCase(args[2])){

			
			directory = args[0];
			findPattern = args[1];
			replaceWith = args[2];
			
			if(args.length > 3)
				if("y".equalsIgnoreCase(args[3]))
					proceed = true;
			
		} else {
			try{
				System.out.println("Insert working dir");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
				String i1,i2,i3;
					
				if((i1=br.readLine())!=null)
					directory = i1;
				
				System.out.println("Insert characters to find");
				br = new BufferedReader(new InputStreamReader(System.in));
					
				if((i2=br.readLine())!=null)
					findPattern = i2;
				
				System.out.println("Insert new characters to replace");
				br = new BufferedReader(new InputStreamReader(System.in));
					
				if((i3=br.readLine())!=null)
					replaceWith = i3;
					
			}catch(IOException io){
				io.printStackTrace();
			}	
		}
		
		rename.doExecute(directory, findPattern, replaceWith, proceed);
	}
}
