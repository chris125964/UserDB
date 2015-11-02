package de.todd.userdb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({ @NamedQuery(name = Group.findAll, query = "SELECT g FROM Gruppe g") })
@Entity(name = "Gruppe")
public class Group {

	public static final String findAll = "Gruppe.findAll";
	private char letter;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Team> teams;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	public Group() {
		super();
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
		return this.letter;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

}
