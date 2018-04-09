package ielpo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Rename {
	
	private enum Actions {
		NO_ACTION, 
	    NEW_NAME
	}

	private static Map<Actions, Integer> renameFilesFromPattern(File[] files, File dir, String findPattern, String replaceWith, boolean rename){

		Map<Actions, Integer> actions = new HashMap<Actions, Integer>();
		actions.put(Actions.NO_ACTION, 0);
		actions.put(Actions.NEW_NAME, 0);
				
		EmptyUtils.emptyIfNull(Arrays.asList(files)).stream().filter(cur -> cur.isFile()).forEach(f -> {

			String fileName = f.getName();
			String newFileName = fileName.replaceAll(findPattern, replaceWith);
			if(fileName.equals(newFileName)){
				/* PATTERN NOT FOUND - NO ACTION */
				if(!rename)
					System.out.println("No action: " + dir + File.separator + newFileName);
				
				actions.put(Actions.NO_ACTION, actions.get(Actions.NO_ACTION).intValue() + 1);
				
			}else{
				/* NEW NAME */
				if(rename){
					f.renameTo(new File(dir + File.separator + newFileName));
				}else{
					System.out.println("New name: " + dir+ File.separator + newFileName);
				}
				actions.put(Actions.NEW_NAME, actions.get(Actions.NEW_NAME).intValue() + 1);
			}
		
		});

		return actions;
	}

	
	public void doExecute(String directory, String findPattern, String replaceWith, boolean proceed){
		
		File dir = new File(directory);
		if(dir.isDirectory()){
			File[] files = dir.listFiles();
			
			String[] nomiFiles = dir.list();			

			System.out.println("Preview");
			System.out.println("-------");
		
			Map<Actions, Integer> res = renameFilesFromPattern(files, dir, findPattern, replaceWith, false);
			System.out.println("# Files: " + nomiFiles.length);	
			System.out.println("# No action files: " + res.get(Actions.NO_ACTION));
			System.out.println("# New name files: " + res.get(Actions.NEW_NAME));
			System.out.println("-------");

			if(!proceed){
				System.out.println("Do you want to continue? [y/n]");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					
				String i1;
					
				try {
					if((i1=br.readLine())!=null){
						if("y".equalsIgnoreCase(i1)){
							res = renameFilesFromPattern(files, dir, findPattern, replaceWith, true);
							System.out.println("# No action files: " + res.get(Actions.NO_ACTION));
							System.out.println("# New name files: " + res.get(Actions.NEW_NAME));
							
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
				System.out.println("# No action files: " + res.get(Actions.NO_ACTION));
				System.out.println("# New name files: " + res.get(Actions.NEW_NAME));
			}
			
		} else {
			System.out.println(dir + " is not a valid directory");
		}

		System.out.println("End: " + new Date());
	
	}

}