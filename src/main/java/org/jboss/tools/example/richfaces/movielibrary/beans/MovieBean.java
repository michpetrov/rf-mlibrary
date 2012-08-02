package org.jboss.tools.example.richfaces.movielibrary.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.jboss.tools.example.richfaces.movielibrary.data.Movie;

@ManagedBean
@ViewScoped
public class MovieBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Movie movie;
	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
}
