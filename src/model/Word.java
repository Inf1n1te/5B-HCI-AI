package model;

public class Word {
	
	private String word;
	private int maleCount = 0;
	private int femaleCount = 0;
	private float probMale;
	private float probFemale;

	public Word(String word, boolean male) {
		this.word = word;
		if (male) {
			maleCount++;
		} else {
			femaleCount++;
		}
	}
	
	public void incrementMale() {
		maleCount++;
	}
	
	public void incrementFemale() {
		femaleCount++;
	}

	public float getProbMale() {
		return probMale;
	}
	
	public float getProbFemale() {
		return probFemale;
	}
}
