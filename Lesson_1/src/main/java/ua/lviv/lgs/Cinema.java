package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {

	TreeMap<Days, Schedule> schedules = new TreeMap<Days, Schedule>();
	ArrayList<Movie> moviesLibrary = new ArrayList<Movie>();
	Time open;
	Time close;

	public Cinema(TreeMap<Days, Schedule> schedules, ArrayList<Movie> moviesLibrary, Time open, Time close) {
		super();
		this.schedules = schedules;
		this.moviesLibrary = moviesLibrary;
		this.open = open;
		this.close = close;
	}

	
	
	public ArrayList<Movie> getMoviesLibrary() {
		return moviesLibrary;
	}

	public TreeMap<Days, Schedule> getSchedules() {
		return schedules;
	}



	@Override
	public String toString() {
		return "Cinema [schedules=" + schedules + ", moviesLibrary=" + moviesLibrary + ", open=" + open + ", close="
				+ close + "]";
	}

	public void addMovie(String name, int hour, int min) {
		moviesLibrary.add(new Movie(name, new Time(hour, min)));
	}

	public void addSeance(Seance seance, String days) {
		Days[] daysEnum = Days.values();
		boolean flag = false;

		if (schedules.isEmpty()) {
			for (Days days2 : daysEnum) {
				if (days2.toString().equalsIgnoreCase(days)) {
					if (this.open.getHour() <= seance.getStartTime().getHour()
							& this.open.getMin() <= seance.getStartTime().getMin()
							& this.close.getHour() >= seance.getEndTime().getHour()
							& this.close.getMin() <= seance.getEndTime().getMin()) {
						schedules.put(days2, new Schedule());
						flag = true;
					}
				}
			}
			if (!flag) {
				System.out
						.println("Такого дня тижня не існує або вибрані не робочі години кінотеатра! Спробуйте ще раз");
			}
		}

		boolean flag2 = true;

		if (!schedules.isEmpty()) {
			for (Entry<Days, Schedule> entry : schedules.entrySet()) {
				if (entry.getKey().toString().equalsIgnoreCase(days)) {
					if (this.open.getHour() <= seance.getStartTime().getHour()
							& this.open.getMin() <= seance.getStartTime().getMin()
							& this.close.getHour() >= seance.getEndTime().getHour()
							& this.close.getMin() <= seance.getEndTime().getMin()) {
						entry.getValue().addSeance(seance);
						flag2 = false;
					}
				}
			}
		}

		if (flag2) {
			for (Days days2 : daysEnum) {
				if (days2.toString().equalsIgnoreCase(days)) {
					schedules.put(days2, new Schedule());
					flag = true;
				}
			}
			if (!flag) {
				System.out.println("Такого дня тижня не існує! Спробуйте ще раз");
			}
			for (Entry<Days, Schedule> entry : schedules.entrySet()) {
				if (entry.getKey().toString().equalsIgnoreCase(days)) {
					if (this.open.getHour() <= seance.getStartTime().getHour()
							& this.open.getMin() <= seance.getStartTime().getMin()
							& this.close.getHour() >= seance.getEndTime().getHour()
							& this.close.getMin() <= seance.getEndTime().getMin()) {
						entry.getValue().addSeance(seance);
					}
				}
			}
		}
	}

	public void removeMovie(String title) {

		boolean flag = false;
		for (int i = 0; i < moviesLibrary.size(); i++) {
			if (moviesLibrary.get(i).getTitle().equalsIgnoreCase(title)) {
				flag = true;
				moviesLibrary.remove(moviesLibrary.get(i));
			}
		}
		if (!flag) {
			System.out.println(
					"Такого фільму в фільмотеці не існує або вибрані не робочі години кінотеатра! Спробуйте ще раз");
		}
	}

	public void removeSeanse(Seance seance, String days) {
		Days[] daysEnum = Days.values();
		boolean flag = false;
		for (Days days2 : daysEnum) {
			if (days2.toString().equalsIgnoreCase(days)) {
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("Такого дня тижня не існує! Спробуйте ще раз");
		}
		if (flag) {
			for (Entry<Days, Schedule> entry : schedules.entrySet()) {
				if (entry.getKey().toString().equalsIgnoreCase(days)) {
					entry.getValue().removeSeance(seance);
					;
				}
			}
		}

	}

}
