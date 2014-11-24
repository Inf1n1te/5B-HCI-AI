package model;

public class Word {

	private String word;
	private int maleCount = 0;
	private int femaleCount = 0;
	private double probMale;
	private double probFemale;

	public Word(String word, boolean male) {
		this.word = word;
		if (male) {
			maleCount++;
		} else {
			femaleCount++;
		}
	}

	public void increment(boolean male) {
		if (male) {
			maleCount++;
		} else {
			femaleCount++;
		}
	}

	public String getWord() {
		return word;
	}

	public double getProb(boolean male) {
		if (male) {
			return probMale;
		} else {
			return probFemale;
		}
	}

	public void calculateSmoothProbs(int vocab, int k, int female, int male) {
		if (femaleCount == 0) {
			probFemale = 0;
		} else {
			probFemale = Math.log((femaleCount + k) / (female + k * vocab))
					/ Math.log(2);
		}
		if (femaleCount == 0) {
			probMale = 0;
		} else {
			probMale = Math.log((maleCount + k) / (male + k * vocab))
					/ Math.log(2);
		}
	}
}
