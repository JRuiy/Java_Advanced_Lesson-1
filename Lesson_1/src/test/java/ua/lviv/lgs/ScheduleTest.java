package ua.lviv.lgs;

import java.util.Set;
import java.util.TreeSet;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {
	
	private Schedule schedule;

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
		schedule = new Schedule();
	}
	
	@After
	public void afterTest() {
		schedule = null;
	}
	
	@Test
	public void addSeanceTest() {
		schedule.addSeance(new Seance(new Movie("Marvel", new Time(1, 50)),new Time(10, 0), new Time(0, 0)));
		Set<Seance> realSeances = schedule.getSeances();
		Set<Seance> expectedSeances = new TreeSet<Seance>();
		expectedSeances.add(new Seance(new Movie("Marvel", new Time(1, 50)),new Time(10, 0), new Time(0, 0)));
		
		Assert.assertEquals(expectedSeances, realSeances);
	}
	
	@Test
	public void removeSeanceTest() {
		Set<Seance> realSeances = schedule.getSeances();
		realSeances.add(new Seance(new Movie("Marvel", new Time(1, 50)),new Time(10, 0), new Time(0, 0)));
		schedule.removeSeance(new Seance(new Movie("Marvel", new Time(1, 50)),new Time(10, 0), new Time(0, 0)));
		Set<Seance> expectedSeances = new TreeSet<Seance>();
		Assert.assertEquals(expectedSeances, realSeances);
	}
	
}
