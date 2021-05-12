package ua.lviv.lgs;

public class Seance  implements Comparable<Seance>{

	Movie movie;
	Time startTime;
	Time endTime;
	public Seance(Movie movie, Time startTime, Time endTime) {
		super();
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = endTime;
		this.endTime.hour = this.startTime.getHour()+this.movie.duration.getHour();
		this.endTime.min = this.startTime.getMin()+this.movie.getDuration().getMin();
		if (this.endTime.min>=60) {
			this.endTime.hour++;
			this.endTime.min-=60;
		}
	}
	
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return  movie + ", Сеанс починається " + startTime + ", Сеанс закінчується " + endTime;
	}

	@Override
	public int compareTo(Seance o) {
		if (this.movie.title.compareTo(o.movie.getTitle())>0) {
			return 1;
		}else if(this.movie.title.compareTo(o.movie.getTitle())<0) {
			return -1;
		}
		return 0;
	}
	

	
}
