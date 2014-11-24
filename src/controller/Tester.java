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
	
	public Tester(String[] sentence, Words words) {
		String[] token = sentence;
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
	
	public boolean getGender() {
		if (probabilityFemale > probabilityMale) {
			return false;
		} else  {
			return true;
		}
	}
	
	public boolean isCorrect(boolean male) {
		return getGender() == male;
	}

}
