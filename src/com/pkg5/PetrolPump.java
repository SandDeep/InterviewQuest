package com.pkg5;

public class PetrolPump {

	public static void main(String[] args) {
		Pump[] pumps = { new Pump(4, 6), new Pump(6, 5), new Pump(7, 3), new Pump(4, 5) };

		int start = findStart(pumps, pumps.length);

		if (start == -1)
			System.out.println("No solution");
		else
			System.out.println("Starting Point : " + start);
	}

	private static int findStart(Pump[] pumps, int n) {

		int start = 0;
		int end = 1;
		int curr_petrol = pumps[start].petrol - pumps[start].distance;

		while (end != start || curr_petrol < 0) {
			while (curr_petrol < 0 && start != end) {
				curr_petrol -= pumps[start].petrol - pumps[start].distance;
				start = (start + 1) % n;

				if (start == 0)
					return -1;
			}

			curr_petrol += pumps[end].petrol - pumps[end].distance;

			end = (end + 1) % n;
		}

		return start;
	}
}

class Pump {
	int petrol;
	int distance;

	public Pump(int petrol, int distance) {
		this.petrol = petrol;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Pump [petrol=" + petrol + ", distance=" + distance + "]";
	}

}