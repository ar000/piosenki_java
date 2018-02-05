package piosenki;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
 
public class Plik {

	public Plik(){
		
	}
	public static List<String> readFile(String path){
		List<String> lines = new ArrayList<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null){
				lines.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public static void createShareFile(String name){
		File fil = new File(Dane.path+"\\"+name+Const.EXTNEW);
		try {
			fil.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<String> ss = new ArrayList<String>();
		ss.add("<<<>>>");
		writeFile(ss, Dane.path+"\\"+name+Const.EXTNEW);
	}
	
	public static void  writeFile(List<String> lines, String path){
		PrintWriter writer;
		try {
			writer = new PrintWriter(path);
			writer.print(lines.get(0));
			for(int y = 1; y < lines.size(); y++){
				 writer.println();
				 writer.print(lines.get(y));
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	
	
public static boolean checkExportBase(String name){
		File fil = new File(Dane.path+"\\"+name+Const.EXTNEW);
		if(!fil.exists()){
			try {
				fil.createNewFile();
				List<String> ss = new ArrayList<String>();
				ss.add("<<<>>>");
				writeFile(ss, Dane.path+"\\"+name+Const.EXTNEW);
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return true;
			}
		}else{
			return true;
		}
		
	}
	public static void checkFolder(String path){
		File dir = new File(path);
		if(!dir.exists())  dir.mkdir();
	}
	
}
