package org.jboss.tools.example.richfaces.movielibrary.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.example.richfaces.movielibrary.data.Movie;

@ManagedBean
@SessionScoped
public class LibraryBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager em;

    private long selectedMovieId;

    private List<Movie> movies;

    public LibraryBean() {
    }

    public List<Movie> getMovies() {
        movies = em.createQuery("select m from Movie m", Movie.class).getResultList();
        return movies;
    }

    public void setSelectedMovieId(long id) {
        this.selectedMovieId = id;
    }

    @Produces
    public long getSelectedMovieId() {
        return selectedMovieId;
    }

    public void doNothing() {
        return;
    }
}
