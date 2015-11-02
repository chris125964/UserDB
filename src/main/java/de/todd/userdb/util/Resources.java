package de.todd.userdb.util;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;

public class Resources {

	@Produces
	public Logger produceLog() {
		System.out.println("produce a Logger ...");
		return Logger.getLogger("Logger");
	}

	@Produces
	@RequestScoped
	public FacesContext produceFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	@Produces
	@RequestScoped
	HttpServletRequest produceRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}

	@Produces
	@PersistenceContext
	private EntityManager em;
}
