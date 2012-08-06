package org.jboss.tools.example.richfaces.movielibrary.beans;

import java.io.Serializable;
//import java.sql.DriverManager;
import java.util.List;

// import javax.annotation.PostConstruct;
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
		
		/*try {
			DriverManager.getConnection("jdbc:mysql://localhost:3306/mlibrary");
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }*/ 
		
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
