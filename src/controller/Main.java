package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import tokenization.Trainer;
import model.Words;

public class Main {

	private static float k = 1;
	private static Words words = new Words();

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

}