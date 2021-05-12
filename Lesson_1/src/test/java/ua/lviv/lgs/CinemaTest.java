package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {

	private Cinema cinema;
	
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
		
		protected void failed(Throwable e, org.junit.runner.Description description) {
			System.out.println("FAILED--> " + description.getMethodName());
		};
		protected void succeeded(org.junit.runner.Description description) {
			System.out.println("SUCCEED--> " + description.getMethodName());
		};	
	};
	
	@Before
	public void beforeTest() {
		cinema = new Cinema(new TreeMap<Days, Schedule>(), new ArrayList<Movie>(), new Time(10, 0), new Time(22, 0));
	}
	
	@After
	public void afterTest() {
		cinema = null;
	}
	
	@Test
	public void addMovieTest() {
		ArrayList<Movie> realArray = cinema.getMoviesLibrary();
		cinema.addMovie("Mara", 1, 1);
		ArrayList<Movie> expectedArray = new ArrayList<Movie>();
		expectedArray.add(new Movie("Mara", new Time(1, 1)));
		Assert.assertEquals(expectedArray.toString(), realArray.toString());
	}
	
	@Test
	public void addSeanceTest() {
		TreeMap<Days, Schedule> realTreeMap = cinema.getSchedules();
		cinema.addSeance(new Seance(new Movie("Mara", new Time(1, 30)), new Time(11, 0), new Time(0, 0)), "monday");
		cinema.addSeance(new Seance(new Movie("Mara", new Time(1, 30)), new Time(12, 0), new Time(0, 0)), "sunday");
		TreeMap<Days, Schedule> expectedTreeMap = new TreeMap<Days, Schedule>();
		expectedTreeMap.put(Days.MONDAY, new Schedule());
		expectedTreeMap.get(Days.MONDAY).seances.add(new Seance(new Movie("Mara", new Time(1, 30)), new Time(11, 0), new Time(0, 0)));
		expectedTreeMap.put(Days.SUNDAY, new Schedule());
		expectedTreeMap.get(Days.SUNDAY).seances.add(new Seance(new Movie("Mara", new Time(1, 30)), new Time(12, 0), new Time(0, 0)));
		Assert.assertEquals(expectedTreeMap.toString(), realTreeMap.toString());
	}
	
	@Test
	public void removeMovieTest() {
		ArrayList<Movie> realArray = cinema.getMoviesLibrary();
		cinema.addMovie("Mara", 1, 1);
		cinema.removeMovie("Mara");
		ArrayList<Movie> expectedArray = new ArrayList<Movie>();
		Assert.assertEquals(expectedArray.toString(), realArray.toString());
	}
	
	@Test
	public void removeSeanceTest() {
		TreeMap<Days, Schedule> realTree = cinema.getSchedules();
		cinema.addSeance(new Seance(new Movie("Mara", new Time(1, 30)), new Time(11, 0), new Time(0, 0)), "monday");
		cinema.removeSeanse(new Seance(new Movie("Mara", new Time(1, 30)), new Time(11, 0), new Time(0, 0)), "monday");
		TreeMap<Days, Schedule> expectedTree = new TreeMap<Days, Schedule>();
		expectedTree.put(Days.MONDAY, new Schedule());
		Assert.assertEquals(expectedTree.toString(), realTree.toString());
	}
	
}
