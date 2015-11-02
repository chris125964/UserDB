package de.todd.userdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = Team.findAll, query = "SELECT t FROM Team t") })
@Entity
public class Team {

	public static final String findAll = "Team.findAll";
	private String name;
	@ManyToOne
	private Group gruppe;
	private int nr;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	public Team() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setGruppe(Group gruppe) {
		this.gruppe = gruppe;
	}

	public Group getGruppe() {
		return this.gruppe;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public int getNr() {
		return this.nr;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

}
