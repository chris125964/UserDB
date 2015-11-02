package de.todd.userdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@NamedQueries({ @NamedQuery(name = Result.findAll, query = "SELECT r FROM Result r") })
@Entity
public class Result {

	public static final String findAll = "Result.findAll";
	@ManyToOne
	private User user;
	@ManyToOne
	private Match match;
	private int goals1;
	private int goals2;
	@GeneratedValue
	@Id
	private Long id;
	@Transient
	boolean editable;

	public Result() {
		super();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return this.user;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public Match getMatch() {
		return this.match;
	}

	public void setGoals1(int goals1) {
		this.goals1 = goals1;
	}

	public int getGoals1() {
		return this.goals1;
	}

	public void setGoals2(int goals2) {
		this.goals2 = goals2;
	}

	public int getGoals2() {
		return this.goals2;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String editAction(Result result) {
		result.setEditable(true);
		return null;
	}

}
