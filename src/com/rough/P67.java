package com.rough;

/**
 * http://www.geeksforgeeks.org/how-to-design-a-tiny-url-or-url-shortener/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P67 {

	public static void main(String[] args) {
		P67 test = new P67();
		int n = 1705;

		String url = test.shortURL(n);
		System.out.println("Short URL : " + url);

		long id = test.shortURLtoID(url);
		System.out.println("ID : " + id);
	}

	private long shortURLtoID(String shortUrl) {
		long id = 0;

		char[] url = shortUrl.toCharArray();

		for (int i = 0; i < url.length; i++) {
			if (url[i] >= 'a' && url[i] <= 'z') {
				id = id * 62 + url[i] - 'a';
			}
			if (url[i] >= 'A' && url[i] <= 'Z') {
				id = id * 62 + url[i] - 'A' + 26;
			}
			if (url[i] >= '0' && url[i] <= '9') {
				id = id * 62 + url[i] - '0' + 26;
			}
		}
		return id;
	}

	private String shortURL(int n) {
		String shortUrl = "";

		char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
				.toCharArray();
		int size = map.length;

		while (!(n < 1)) {
			shortUrl += map[n % size];
			n = n / size;
		}

		return reverse(shortUrl.toCharArray());
	}

	private String reverse(char[] cs) {

		/*
		 * long i = 0; long j = cs.length - 1;
		 */
		/*
		 * while (i != j) { swap(cs, i++, j--); }
		 */
		for (int i = 0, j = cs.length - 1; i <= cs.length / 2; i++, j--) {
			swap(cs, i++, j--);
		}
		return new String(cs);
	}

	public void swap(char[] arr, int mIndex, int nIndex) {
		char temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}
}
