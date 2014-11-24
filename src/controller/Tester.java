package controller;

import tokenization.Token;
import model.Words;

public class Tester {
	
	private double probabilityMale = 0;
	private double probabilityFemale = 0;

	public Tester(String sentence, Words words) {
		String[] token = Token.tokenize(sentence);
		for (int i = 0; i < token.length; i++) {
			probabilityMale += words.getProb(token[i], true);
			probabilityFemale += words.getProb(token[i], false);
		}
	}
	
	public double getProbability(boolean male) {
		if (male) {
			return probabilityMale;
		} else { 
			return probabilityFemale;
		}
	}
	
	public String getGender() {
		if (probabilityFemale > probabilityMale) {
			return "Female";
		} else if (probabilityFemale < probabilityMale) {
			return "Male";
		} else {
			return "Equal";
		}
	}

}
