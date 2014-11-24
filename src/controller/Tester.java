package controller;

import model.Words;

public class Tester {
	
	private double probabilityMale = 0;
	private double probabilityFemale = 0;

	public Tester(String sentence, Words words) {
		// Tokenize
		String[] test = new String[10];
		for (int i = 0; i < test.length; i++) {
			probabilityMale += words.getProb(test[i], true);
			probabilityFemale += words.getProb(test[i], false);
		}
	}
	
	public double getProbability(boolean male) {
		if (male) {
			return probabilityMale;
		} else { 
			return probabilityFemale;
		}
	}

}
