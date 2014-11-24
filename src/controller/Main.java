package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tokenization.Token;
import tokenization.Trainer;
import model.Words;

public class Main {

	private static float k = 1;
	private static Words words = new Words();
	public static File[] files;

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter value for k:\n");
		try {
			k = Float.parseFloat(br.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Training
		new Trainer(words);
		
		words.calculateSmoothProbs(k);
		
		files = new File("/media/inf1n1te/Data/Documents 2/Linux Workspace/5B-HCI-AI/blogtest").listFiles();
		top();
		
		while (true) {
			try {
				System.out
						.println(new Tester(br.readLine(), words).getGender());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void top() throws FileNotFoundException, IOException{
		System.out.println("Starting");
		int correct = 0;
		for (int i = 0; i < files.length; i++){
	        if (files[i].isFile()){ //this line weeds out other directories/folders
	        	String[] s = pullAll(files[i]);
	        	boolean gender = gender(files[i]);
	        	if (new Tester(s, words).isCorrect(gender)) {
	        		correct++;
	        	}
	        }
	    }
		System.out.println("Done");
		System.out.println(correct);
	}
	
	private static String[] pullAll(File f) throws FileNotFoundException, IOException{
		String everything = "";
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

	public static boolean gender(File file){
		String s = file.getName();
		if(s.startsWith("M")){
			return true;
		} else {
			return false;
		}
	}
}