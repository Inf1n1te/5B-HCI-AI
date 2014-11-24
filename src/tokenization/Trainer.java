package tokenization;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import model.Words;

public class Trainer {

public boolean gender; //true = male, false = female	
public String everything;	
public static Token T;
public static Trainer T1;
public static File file;
public File[] files;
private Words words;

	public Trainer(Words words) throws FileNotFoundException, IOException {
	    this.words = words;
		files = new File("/media/inf1n1te/Data/Documents 2/Linux Workspace/5B-HCI-AI/blogtrain").listFiles();
	    top();
	    
	    //pullAll(file);
	}

	public void top() throws FileNotFoundException, IOException{
		System.out.println("Starting");
		for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){ //this line weeds out other directories/folders
	        	String[] s = pullAll(files[i]);
	        	gender(files[i]);
	        	
	        	for(int j=0; j < s.length;j++){
	        		words.addWord(s[j], gender);
	        	}
	        }
	    }
		System.out.println("Done");
	}
	
	
	public String[] pullAll(File f) throws FileNotFoundException, IOException{
		try(BufferedReader br = new BufferedReader(new FileReader(f))) {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        everything = sb.toString();
	    }
		
		
		return Token.tokenize(everything);
	}
	
	public void gender(File file){
		String s = file.getName();
		if(s.startsWith("M")){
			gender = true;
		} else {
			gender = false;
		}
	}

}

