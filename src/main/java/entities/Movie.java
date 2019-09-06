/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author sinanjasar
 */
@Entity
@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int releaseDate;
    private String name;
    private List<String> actors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie() {
    }

    public Movie(int releaseDate, String name, List<String> actors) {
        this.releaseDate = releaseDate;
        this.name = name;
        this.actors = actors;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public String getName() {
        return name;
    }

    public List<String> getActors() {
        return actors;
    }

}
