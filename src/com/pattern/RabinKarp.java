package com.pattern;

public class RabinKarp {

	int d = 256;

	public static void main(String[] args) {
		char[] txt = "GEEKS FOR GEEKS".toCharArray();
		char[] pat = "GEEK".toCharArray();

		// prime number
		int q = 101;
		RabinKarp rabinKarp = new RabinKarp();
		rabinKarp.search(txt, pat, q);
	}

	/**
	 * <p>
	 * <code>hash( txt[s+1 .. s+m] ) = d ( hash( txt[s .. s+m-1]) – txt[s]*h ) + txt[s + m] ) mod q</code>
	 * </p>
	 * <p>
	 * <code>hash( txt[s .. s+m-1] ) : Hash value at shift s</code>
	 * </p>
	 * <p>
	 * <code>hash( txt[s+1 .. s+m] ) : Hash value at next shift (or shift s+1)</code>
	 * </p>
	 * <p>
	 * <code>d: Number of characters in the alphabet</code>
	 * </p>
	 * <p>
	 * <code>q: A prime number</code> <code>h: d^(m-1)</code>
	 * </p>
	 */
	public void search(char[] txt, char[] pat, int q) {
		int h = 1;
		int M = pat.length;
		int N = txt.length;
		int t = 0;
		int p = 0;

		for (int i = 0; i < M - 1; i++) {
			h = (h * d) % q;
		}

		for (int i = 0; i < M; i++) {
			p = (d * p + txt[i]) % q;
			t = (d * t + pat[i]) % q;
		}

		for (int i = 0; i <= N - M; i++) {
			if (p == t) {
				int j;
				for (j = 0; j < M; j++) {
					if (txt[i + j] != pat[j]) {
						break;
					}
				}
				if (j == M) {
					System.out.println("Pattern Found : " + i);
				}
			}
			if (i < N - M) {
				t = (d * (t - txt[i] * h) + txt[i + M]) % q;

				if (t < 0) {
					t += q;
				}
			}
		}
	}
}
