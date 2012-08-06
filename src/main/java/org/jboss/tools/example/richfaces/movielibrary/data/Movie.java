package org.jboss.tools.example.richfaces.movielibrary.data;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="movies")
public class Movie {
	
	@Id
	// even though we use AUTO_INCREMENT in the db, GenerationType.AUTO will not work
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 5, max = 40)
	private String name;
	
	@NotNull
	@Digits(integer = 4, fraction = 0)
	@Min(value = 1900)
	private int year;
	
	@NotNull
	@Size(min = 4, max = 40)
	private String director;
	
	@NotNull
	private String genre;

	@Size(max = 200)
	private String description;
	
	@ElementCollection(fetch=FetchType.EAGER, targetClass=Report.class)
	@CollectionTable(name="reports", joinColumns=@JoinColumn(name="movie_id"))
	private List<Report> reports;

	public Movie() {
	}

	public Movie(int id, String name, int year, String director, String genre, String description) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public List<Report> getReports() {
		return reports;
	}

	public void setReports(List<Report> reports) {
		this.reports = reports;
	}

	public double getRating() {
		//getReports(); // hack to load the reports?
		if (reports == null) {
			return 0;
		}
		
		if (reports.isEmpty()) {
			return 0;
		}
		
		double total = 0;
		
		for(Report r : reports) {
			total+= r.getRating();
		}
		
		return (double) (total / reports.size());
	}
	
	public void addReport(Report r) {
		reports.add(r);
	}
}
