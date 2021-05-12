package ua.lviv.lgs;
import java.util.Set;
import java.util.TreeSet;

public class Schedule {

	Set<Seance> seances = new TreeSet<Seance>();

	public Set<Seance> getSeances() {
		return seances;
	}

	public void setSeances(Set<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public String toString() {
		return  seances + "";
	}
	
	public void addSeance(Seance seance) {
		seances.add(seance);
	}
	
	public void removeSeance(Seance seance) {
		seances.remove(seance);
	}
}
