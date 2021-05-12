package ua.lviv.lgs;

public class Time {

	int hour;
	int min;

	public Time(int hour, int min) {
		super();
		if (min < 0) {
			System.out.println("Такого значення не існує");
			min = 0;
		} else if (min > 60) {
			System.out.println("Такого значення не існує");
			min = 0;
		} else {
			this.min = min;
		}
		if (hour < 0) {
			System.out.println("Такого значення не існує");
			hour = 0;
		} else if (hour > 24) {
			System.out.println("Такого значення не існує");
			hour = 0;
		} else {
			this.hour = hour;
		}

	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		if (min < 0) {
			System.out.println("Такого значення не існує");
			min = 0;
		} else if (min > 60) {
			System.out.println("Такого значення не існує");
			min = 0;
		} else {
			this.min = min;
		}
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour < 0) {
			System.out.println("Такого значення не існує");
			hour = 0;
		} else if (hour > 24) {
			System.out.println("Такого значення не існує");
			hour = 0;
		} else {
			this.hour = hour;
		}
	}

	@Override
	public String toString() {
		return hour+ ":" + min;
	}


}
