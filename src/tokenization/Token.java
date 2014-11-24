package tokenization;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Token {

// str
	
private InputStream input;
private String s;
private String tokenized;
private String[] token;
private String[] tokenizedArray;
private String everything;
private static File file;
	
	
	public Token(File path) throws FileNotFoundException, IOException {
		getInput(path);
		getInputConsole();
	}
	
	public void getInputConsole() throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Enter String\n");
	        String s = br.readLine();
	        tokenize(s);
	}
	
	
	public void getInput(File f) throws FileNotFoundException, IOException{
		
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
		
		
		tokenize(everything);
	}

	public String[] tokenize(String c){
		String[] tokenized = c.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
		//String[] tokenized = c.split(" ").toLowerCase();
		System.out.println(Arrays.toString(tokenized));
		return tokenized;
		
	}
		
	public static void main(String[] args) throws FileNotFoundException, IOException{
		file = new File("C:/Universiteit/M-train5.txt");
		new Token(file);
	}
	
}
