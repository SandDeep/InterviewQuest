package com.pkgG;

public class Subset {
	int parent = 0;
	int rank = 0;

	public Subset(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Subset [parent=" + parent + ", rank=" + rank + "]";
	}

}
