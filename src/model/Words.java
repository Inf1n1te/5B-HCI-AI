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
		for (int i = 0; i < words.size(); i++) {
			
		}
	}

}
