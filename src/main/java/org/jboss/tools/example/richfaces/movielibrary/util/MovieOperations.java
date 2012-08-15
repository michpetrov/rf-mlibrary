package org.jboss.tools.example.richfaces.movielibrary.util;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jboss.tools.example.richfaces.movielibrary.data.Movie;

@Stateless
public class MovieOperations {

    @Inject
    private EntityManager em;

    public void createMovie(Movie movie) {
        em.persist(movie);
        // em.flush();
    }

    public void updateMovie(Movie movie) {
        em.merge(movie);
        em.flush();
    }

    public void deleteMovie(Movie movie) {
        /*
         * sometimes* the engine thinks movie is detached and cannot remove it * = after it was created this will force it to
         * find the attached version
         */
        Movie m = em.getReference(Movie.class, movie.getId());
        em.remove(m);
        // em.remove(movie);
    }
}
