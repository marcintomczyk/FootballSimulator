package com.tomczyk.football.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * <p>
 * A League represents a list of teams.
 * </p>
 * 
 * @author Marcin Tomczyk
 */

@Entity
public class League {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String name;
	
	/**
	 * <p>
	 * The list of teams.
	 * </p>
	 *
	 * <p>
	 * For the time being EAGER, and PERSIST is ok
	 * </p>
	 * 
	 */
	@OneToMany(mappedBy = "league", cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	private List<Team> teams;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        League league = (League) o;

        if (id != null ? !id.equals(league.id) : league.id != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
	
}
