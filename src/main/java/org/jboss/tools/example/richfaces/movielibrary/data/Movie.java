package org.jboss.tools.example.richfaces.movielibrary.data;

import java.util.ArrayList;
import java.util.List;

public class Movie {

	private long id;
	private String name;
	private int year;
	private String director;
	private String genre;
	private String description;

	private int newRating;
	private String newReview;

	private List<Integer> ratings = new ArrayList<Integer>();
	private List<String> reviews = new ArrayList<String>();
	
	public Movie() {
	}

	public Movie(long id, String name, int year, String director, String genre, String description) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.director = director;
		this.genre = genre;
		this.description = description;		
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRating() {
		if (ratings.isEmpty()) {
			return 0.0;
		}

		double total = 0.0;
		for (Integer i : ratings) {
			total += i;
		}
		
		return total / ratings.size();
	}

	public List<String> getReviews() {
		return reviews;
	}

	public void setNewRating(int newRating) {
		this.newRating = newRating;
	}

	public int getNewRating() {
		return newRating;
	}

	public void addRating(int rating) {
		if (rating < 1) {
			return; // no rating given
		}

		int newRating = rating <= 5 ? rating : 5;
		ratings.add(newRating);
	}

	public void rate() {
		addRating(newRating);
		newRating = 0;
	}

	public void addReview(String review) {
		reviews.add(review);
	}

	public void setNewReview(String newReview) {
		this.newReview = newReview;
	}

	public String getNewReview() {
		return newReview;
	}

	public void addReview() {
		if (newReview.isEmpty()) {
			return;
		}
		addReview(newReview);
		newReview = "";
	}
}
