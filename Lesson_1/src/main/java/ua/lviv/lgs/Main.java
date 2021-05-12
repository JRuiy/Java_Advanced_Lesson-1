package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {

	static void menuForAdminOrUser() {
		System.out.println("Введіть 1 якщо ви адміністратор");
		System.out.println("Введіть 2 якщо ви відвідувач");
		Scanner sc = new Scanner(System.in);
		while (true) {
			switch (sc.next()) {
			case "1": {
				System.out.println("Якщо ви адміністратор, то введіть логін");
				sc = new Scanner(System.in);
				String login = sc.next();
				if (login.equalsIgnoreCase("Admin")) {
					System.out.println("Привіт, адміністрот, гарного вам дня");
					menuForAdmin();
				} else {
					System.out.println("Неправильний логін");
				}
				break;
			}
			case "2": {
				System.out.println("Добрий день відвідувач!!!");
				menuForUser();
				break;
			}
			}
		}
		
	}

	static void menuForAdmin() {
		System.out.println("Введіть 1 для того, щоб додати фільм в фільмотеку");
		System.out.println("Введіть 2 для того, щоб перевірити всю фільмотеку");
		System.out.println("Введіть 3 для того, щоб додати сеанс");
		System.out.println("Введіть 4 для того, щоб видалити сеанс");
		System.out.println("Введіть 5 для того, щоб видалити фільм з фільмотеки");
		
		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema(new TreeMap<Days, Schedule>(), new ArrayList<Movie>(), new Time(10, 0), new Time(22, 0));

		while (true) {
			switch (sc.next()) {
			case "1": {
				sc = new Scanner(System.in);
				System.out.println("Введіть назву фільма");
				String title = sc.next();
				System.out.println("Введіть кількість годин, скільки буде йти фільм");
				int hour = sc.nextInt();
				System.out.println("Введіть кількість хвилин, скільки буде йти фільм");
				int min = sc.nextInt();
				cinema.addMovie(title, hour, min);
				break;
			}
			case "2": {
				for (Movie cin : cinema.moviesLibrary) {
					System.out.println(cin);
				}
				break;
			}
			case "3":{
				sc = new Scanner(System.in);
				System.out.println("Введіть день тижня в який хочете додати сеанс");
				String daysOfWeek = sc.next();
				System.out.println("Введіть назву фільма");
				String movieName = sc.next();
				System.out.println("Введіть кількість годин, скільки буде йти фільм");
				int movieHour = sc.nextInt();
				System.out.println("Введіть кількість хвилин, скільки буде йти фільм");
				int movieMin = sc.nextInt();
				System.out.println("Введіть о котрій годині буде починатися сеанс");
				int seanceHour = sc.nextInt();
				System.out.println("Введіть о котрій хвилині буде починатися сеанс");
				int seanceMin = sc.nextInt();
				cinema.addSeance(new Seance(new Movie(movieName, new Time(movieHour, movieMin)), new Time(seanceHour, seanceMin), new Time(0, 0)), daysOfWeek);
				break;
			}
			case "4": {
				sc = new Scanner(System.in);
				System.out.println("Введіть день тижня з якого хочете видалити сеанс");
				String daysOfWeek = sc.next();
				System.out.println("Введіть назву фільму в сеансі");
				String movieName = sc.next();
				System.out.println("Введіть кількість годин, скільки йде фільм");
				int movieHour = sc.nextInt();
				System.out.println("Введіть кількість хвилин, скільки йде фільм");
				int movieMin = sc.nextInt();
				System.out.println("Введіть о котрій годині починатється сеанс");
				int seanceHour = sc.nextInt();
				System.out.println("Введіть о котрій хвилині починатється сеанс");
				int seanceMin = sc.nextInt();
				cinema.addSeance(new Seance(new Movie(movieName, new Time(movieHour, movieMin)), new Time(seanceHour, seanceMin), new Time(0, 0)), daysOfWeek);
				break;
			}
			case "5": {
				sc = new Scanner(System.in);
				System.out.println("Введіть назву фільма, якого хочете видалити з фільмотеки");
				String title = sc.next();
				cinema.removeMovie(null);
			}
			}
		}
	}

	static void menuForUser() {
		System.out.println("Введіть 1 для того, щоб подивитися всю фільмотеку");
		System.out.println("Введіть 2 для того, щоб переглянути всі сеанси");
		
		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema(new TreeMap<Days, Schedule>(), new ArrayList<Movie>(), new Time(10, 0), new Time(22, 0));
		
		while (true) {
			switch (sc.next()) {
			case "1": {
				for (Movie cin : cinema.moviesLibrary) {
					System.out.println(cin);
				}
				break;
			}
			case "2": {
				for(Entry<Days, Schedule> entry : cinema.schedules.entrySet()) {
					System.out.println(entry);
				}
				break;
			}
			}
		}
		
		
	}

	public static void main(String[] args) {
		menuForAdminOrUser();

	}

}
