package testArea;

import java.io.PrintStream;

public class Movie {

	private String title;
	private int duration_in_minutes;
	private String category;
	private String review;

	/*public Movie() {
		this(String "unset", int 0 , String "unset" );
	}*/

	public Movie(String title, int duration, String category) {
		this.title = title;
		this.duration_in_minutes = duration;
		this.category = category;
	}

	public String getMovieSummary() {
		return  "title: " + this.title + "\nduration: " + this.getDuration_in_minutes() + "\ncategory: " + this.category + "\nreview: " + this.review;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDuration_in_minutes() {
		return Integer.toString(duration_in_minutes);
	}

	public void setDuration_in_minutes(int duration_in_minutes) {
		this.duration_in_minutes = duration_in_minutes;
	}
}
