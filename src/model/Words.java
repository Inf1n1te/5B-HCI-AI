package model;

import java.util.ArrayList;

public class Words {

	private int maleCount = 0;
	private int femaleCount = 0;
	private ArrayList<Word> words;

	public Words() {
		words = new ArrayList<Word>();
	}

	public void addWord(String word, boolean male) {
		if (male) {
			maleCount++;
		} else {
			femaleCount++;
		}
		boolean contains = false;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getWord().equals(word)) {
				words.get(i).increment(male);
				contains = true;
				break;
			}
		}
		if (contains == false) {
			words.add(new Word(word, male));
		}
	}
	
	public void calculateProbs() {
		for (int i = 0; i < words.size(); i++) {
			words.get(i).calculateSmoothProbs(0, 0, femaleCount, maleCount);
		}
	}
	
	public void calculateSmoothProbs(int k) {
		for (int i = 0; i < words.size(); i++) {
			words.get(i).calculateSmoothProbs(words.size(), k, femaleCount, maleCount);
		}
	}

}
