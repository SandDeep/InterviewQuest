package com.pkgG;

public enum GraphState {
	UNDISCOVERED(0), DISCOVERED(1), PROCESSED(2);

	int state = 0;

	private GraphState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

}
