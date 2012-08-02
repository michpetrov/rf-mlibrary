package org.jboss.tools.example.richfaces.movielibrary.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jboss.tools.example.richfaces.movielibrary.data.Movie;
import org.jboss.tools.example.richfaces.movielibrary.data.MovieList;

@ManagedBean
@SessionScoped
public class LibraryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private MovieList movieList;
	
	private long selectedMovieId;
	
	private int op = 1;
	private Movie newMovie;
	private int newRating;
	private String newReview;
	
	@PostConstruct
	public void postConstruct() {
		movieList = new MovieList();
		
		//long id, String name, int year, String director, String genre, String description
		Movie m1 = new Movie(1, "Matrix", 1999, "Lana & Andy Wachowski", "Sci-fi", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.");
		m1.addReview("Very good movie.");
		m1.addRating(5);
		m1.addRating(4);
		
		Movie m2 = new Movie(2, "Alien", 1979, "Ridley Scott", "Sci-fi/Horror", "A mining ship, investigating a suspected SOS, lands on a distant planet. The crew discovers some strange creatures and investigates.");
		m2.addReview("Incredible");
		m2.addReview("Obsolutely fantastic");
		m2.addRating(5);
		
		Movie m3 = new Movie(3, "Back to the Future", 1985, "Robert Zemeckis", "Sci-fi", "In 1985, Doc Brown invents time travel; in 1955, Marty McFly accidentally prevents his parents from meeting, putting his own existence at stake.");
		m3.addReview("Excellent");
		m3.addRating(5);
		
		Movie m4 = new Movie(4, "Star Wars", 1977, "George Lucas", "Sci-fi", "Luke Skywalker, a spirited farm boy, joins rebel forces to save Princess Leia from the evil Darth Vader, and the galaxy from the Empire's planet-destroying Death Star.");
		m4.addRating(4);
		
		movieList.addMovie(m1);
		movieList.addMovie(m2);
		movieList.addMovie(m3);
		movieList.addMovie(m4);
		
		//selectedMovieId = 1L;
		
		newMovie = new Movie();
	}
	
	public List<Movie> getMovies() {
		return movieList.getMovies();
	}
	
	public void setSelectedMovieId(long id) {
		this.selectedMovieId = id;
	}
	
	public long getSelectedMovieId() {
		return selectedMovieId;
	}

	public void doNothing() {
		return;
	}
	
	public void reset() {
		newMovie = new Movie();
		op = 1;
	}
	
	public void addNewMovie() {
		if (op == 1) {
			newMovie.setId(getNewId());
			movieList.addMovie(newMovie);
		}
		
		else {
			op = 1;
		}
		
		newMovie = new Movie();
	}
	
	public void setNewRating(int newRating) {
		this.newRating = newRating;
	}
	
	public int getNewRating() {
		return newRating;
	}
	
	public void setNewReview(String newReview) {
		this.newReview = newReview;
	}
	
	public String getNewReview() {
		return newReview;
	}
	
	public void setOp(int op) {
		this.op = op;
	}
	
	public int getOp() {
		return op;
	}
	
	public Movie getNewMovie() {
		return newMovie;
	}
	
	public void setNewMovie(Movie newMovie) {
		this.newMovie = newMovie;
	}
	
	public long getNewId() {
		return movieList.getNewId();
	}
	
	public void deleteMovie() {
		if (selectedMovieId != 0) {
			movieList.deleteMovieById(selectedMovieId);
		}
	}
}
