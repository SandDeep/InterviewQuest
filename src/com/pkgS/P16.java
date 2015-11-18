package com.pkgS;

import java.util.Arrays;
import java.util.Comparator;

public class P16 {

	public static void main(String[] args) {
		int start[] = { 1, 3, 5, 6, 8, 4 };
		int finish[] = { 2, 4, 9, 7, 9, 9 };

		P16 test = new P16();
		test.maxActivities(start, finish);

		test.maxActivityes();
	}

	private void maxActivityes() {
		// TODO sort on finish time
		int start[] = { 1, 3, 0, 5, 8, 5 };
		int finish[] = { 2, 4, 6, 7, 9, 9 };

		int i = 0;
		System.out.println("start=" + start[i] + ", finish=" + finish[i]);

		for (int j = 1; j < finish.length; j++) {
			if (finish[i] <= start[j]) {
				System.out.println("start=" + start[j] + ", finish="
						+ finish[j]);
				i = j;
			}
		}
	}

	private void maxActivities(int[] start, int[] finish) {
		Activity[] activities = new Activity[finish.length];

		for (int i = 0; i < finish.length; i++) {
			activities[i] = new Activity(start[i], finish[i]);
		}

		// Sort on finish time
		Arrays.sort(activities, new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				int finish1 = o1.getFinish();
				int finish2 = o2.getFinish();

				if (finish1 == finish2) {
					return 0;
				}
				return (finish1 > finish2) ? 1 : -1;
			}
		});

		int index = 0;
		System.out.println(activities[index]);

		for (int i = 1; i < activities.length; i++) {
			if (activities[i].getStart() >= activities[index].getFinish()) {
				System.out.println(activities[i]);
				index = i;
			}
		}
	}
}

class Activity {
	int start;
	int finish;

	public Activity(int start, int finish) {
		this.start = start;
		this.finish = finish;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
	}

	@Override
	public String toString() {
		return "Activity [start=" + start + ", finish=" + finish + "]";
	}
}