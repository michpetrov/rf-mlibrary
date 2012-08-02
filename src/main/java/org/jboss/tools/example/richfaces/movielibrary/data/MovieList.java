package org.jboss.tools.example.richfaces.movielibrary.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jboss.tools.example.richfaces.movielibrary.data.Movie;

public class MovieList {

	private Map<Long, Movie> movies = new TreeMap<Long, Movie>();
	
	public MovieList() {		
	}
	
	public List<Movie> getMovies() {
		return new ArrayList<Movie>(movies.values());
	}
	
	public void addMovie(Movie movie) {
		movies.put(movie.getId(), movie);
	}
	
	public Movie getMovieById(long id) {
		return movies.get(id);
	}
	
	public long getNewId() {
		return Collections.max(movies.keySet()) + 1;
	}
	
	public void deleteMovieById(long id) {
		movies.remove(id);
	}
}
