package ielpo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * 
 * @author Alberto Ielpo
 * @version 1.0_20161211_1559
 * @category Utility
 * Rename Multiple Files
 *
 */
public class Main {
	
	/**
	 * 
	 * @param files
	 * @param dir
	 * @param findPattern
	 * @param replaceWith
	 * @param rename
	 * @return
	 */
	private static Integer[] renameFilesFromPattern(File[] files, File dir, String findPattern, String replaceWith, boolean rename){

		Integer noAction = 0, newName = 0;
		
		for(File f: files){
			if(f.isFile()){
				String fileName = f.getName();
				String newFileName = fileName.replaceAll(findPattern, replaceWith);
				if(fileName.equals(newFileName)){
					/* 
					 * PATTERN NOT FOUND
					 * NO ACTION
					 */
					
					if(rename){
						//NO ACTION
					}else{
						System.out.println("No action: " + dir + File.separator + newFileName);
					}
					noAction++;
					
				}else{
					//NEW NAME
					if(rename){
						f.renameTo(new File(dir + File.separator + newFileName));
					}else{
						System.out.println("New name: " + dir+ File.separator + newFileName);
					}
					newName++;
				}
			}
		}
		
		return new Integer[]{noAction, newName};
	
	}

	/**
	 * 
	 * @param args
	 * * args[0] = directory
	 * * args[1] = find pattern (ex. GOPR)
	 * * args[2] = replace with -> new name (ex. Como)
	 * * usage> java -jar RenameMultipleFiles /home/tito/Tmp GOPR Como => GOPR1234 will be Como1234
	 */
	public static void main(String[] args) {
	
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
			
			if(args.length > 3){
				if("y".equalsIgnoreCase(args[3])){
					proceed = true;
				}
			}
			
		}else{
			try{
				System.out.println("Insert working dir");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
				String i1,i2,i3;
					
				if((i1=br.readLine())!=null){
					directory = i1;
				}
				
				System.out.println("Insert characters to find");
				br = new BufferedReader(new InputStreamReader(System.in));
					
				if((i2=br.readLine())!=null){
					findPattern = i2;
				}
				
				System.out.println("Insert new characters to replace");
				br = new BufferedReader(new InputStreamReader(System.in));
					
				if((i3=br.readLine())!=null){
					replaceWith = i3;
				}
					
			}catch(IOException io){
				io.printStackTrace();
			}	
		}
		
		File dir = new File(directory);
		if(dir.isDirectory()){
			File[] files = dir.listFiles();
			
			String[] nomiFiles = dir.list();			

			System.out.println("Preview");
			System.out.println("-------");
		
			Integer[] res = renameFilesFromPattern(files, dir, findPattern, replaceWith, false);
			System.out.println("# Files: " + nomiFiles.length);	
			System.out.println("# No action files: " + res[0]);
			System.out.println("# New name files: " + res[1]);
			System.out.println("-------");

			if(!proceed){
				System.out.println("Do you want to continue? [y/n]");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
				String i1;
					
				try {
					if((i1=br.readLine())!=null){
						if("y".equalsIgnoreCase(i1)){
							res = renameFilesFromPattern(files, dir, findPattern, replaceWith, true);
							System.out.println("No action files: " + res[0]);
							System.out.println("New name files: " + res[1]);
							
						}else{
							System.out.println("Operation cancelled");
						}
						
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
	
			} else {
				res = renameFilesFromPattern(files, dir, findPattern, replaceWith, true);
				System.out.println("# Files: " + nomiFiles.length);	
				System.out.println("# No action files: " + res[0]);
				System.out.println("# New name files: " + res[1]);
			}
			
		}else{
			System.out.println(dir + " is not a valid directory");

		}

		System.out.println("End: " + new Date());
	}
}