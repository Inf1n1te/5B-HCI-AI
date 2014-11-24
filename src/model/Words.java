package model;

import java.util.ArrayList;

public class Words {

	private int maleCount = 0;
	private int femaleCount = 0;
	private ArrayList<Word> words;
	private float k;

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
		k = 0;
	}

	public void calculateSmoothProbs(float k) {
		for (int i = 0; i < words.size(); i++) {
			words.get(i).calculateSmoothProbs(words.size(), k, femaleCount,
					maleCount);
		}
		this.k = k;
	}

	public double getProb(String word, boolean male) {
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).getWord().equals(word)
					&& words.get(i).getProb(male) != 0) {
				return words.get(i).getProb(male);
			}
		}
		int N;
		if (male) {
			N = maleCount;
		} else {
			N = femaleCount;
		}
		return Math.log(k / (N + k * words.size()));
	}
}
