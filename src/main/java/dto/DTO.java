/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Movie;
import java.util.List;

/**
 *
 * @author sinanjasar
 */
public class DTO {

    private String name;
    private int releaseDate;
    private List<String> actors;

    public DTO(Movie r) {
        this.name = r.getName();
        this.releaseDate = r.getReleaseDate();
        this.actors = r.getActors();
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public List<String> getActors() {
        return actors;
    }

}
