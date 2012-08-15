package org.jboss.tools.example.richfaces.movielibrary.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.jboss.tools.example.richfaces.movielibrary.data.Movie;
import org.jboss.tools.example.richfaces.movielibrary.data.Report;
import org.jboss.tools.example.richfaces.movielibrary.util.MovieOperations;

@ManagedBean
@ViewScoped
public class MovieBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private MovieOperations mo;

    private Movie movie;
    private Movie newMovie;
    private Report newReport;

    private int op = 1;

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    // @Produces
    // @Named
    public Movie getNewMovie() {
        return newMovie;
    }

    public Report getNewReport() {
        return newReport;
    }

    // used on the page
    public void editMovie() {
        this.newMovie = movie;
        this.op = 2;
    }

    public void deleteMovie() {
        mo.deleteMovie(movie); // delete from db

        movie = null; // delete from view
    }

    // used for persistence
    public void createMovie() {
        mo.createMovie(newMovie);
        reset();
    }

    public void updateMovie() {
        mo.updateMovie(newMovie);
        reset();
    }

    public void addReport() {
        // newReport.setMovieId(movie.getId());
        movie.addReport(newReport);
        mo.updateMovie(movie);

        newReport = new Report();
    }

    @PostConstruct
    public void initNewMovie() {
        newMovie = new Movie();
        newReport = new Report();
    }

    public void reset() {
        op = 1;
        newMovie = new Movie();
    }
}
