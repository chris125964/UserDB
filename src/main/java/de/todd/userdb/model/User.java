package de.todd.userdb.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NamedQueries({
	@NamedQuery(name = User.findAll, query = "SELECT us FROM User us"),
	@NamedQuery(name = User.findByEmail, query = "SELECT us FROM User us WHERE us.email = :email")
})
@Entity
public class User {

	public static final String findAll = "User.findAll";
	public static final String findByEmail = "User.findByEmail";
	@NotNull
	private String vorname;
	@NotNull
	private String nachname;
	@Id
	@Pattern(regexp = ".+@.+", message = "Bitte eine gültige e-mail angeben!")
	private String email;
	@NotNull
	private String passwort;

	public User() {
		super();
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getVorname() {
		return this.vorname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getPasswort() {
		return this.passwort;
	}

}
