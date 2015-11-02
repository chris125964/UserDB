package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named
public class ResultEditController implements Serializable {

	private static final long serialVersionUID = -86205355396751789L;

	public String doSave() {
		return Pages.USER_LIST;
	}

}
