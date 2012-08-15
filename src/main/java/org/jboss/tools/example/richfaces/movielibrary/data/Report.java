package org.jboss.tools.example.richfaces.movielibrary.data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
@Table(name = "reports")
public class Report {

    @NotNull
    @Column(name = "id")
    private int reportId;

    /*
     * @NotNull
     *
     * @Column(name="movie_id") private int movieId;
     */

    @NotNull
    private int rating;

    @Size(max = 200)
    private String review;

    public Report() {

    }

    public int getId() {
        return reportId;
    }

    public void setId(int id) {
        this.reportId = id;
    }

    /*
     * public int getMovieId() { return movieId; }
     *
     * public void setMovieId(int movieId) { this.movieId = movieId; }
     */

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
