package de.todd.userdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Match.findAll, query = "SELECT m FROM Match m") })
@Entity
public class Match {

	public static final String findAll = "Match.findAll";
	@ManyToOne
	private Team team1;
	@ManyToOne
	private Team team2;
	@GeneratedValue
	@Id
	private Long id;

	public Match() {
		super();
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam1() {
		return this.team1;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Team getTeam2() {
		return this.team2;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

}
