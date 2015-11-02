import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class PersonFormular implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name = null;
	private Integer einkommen = null;

	public void setName(String name) {
		this.name = name;
	}

	public void setEinkommen(Integer einkommen) {
		this.einkommen = einkommen;
	}

	public String getName() {
		return name;
	}

	public Integer getEinkommen() {
		return einkommen;
	}

	public String speichern() {
		if (einkommen == 101) {
			FacesContext.getCurrentInstance().addMessage("das_einkommen",
					new FacesMessage("101 ist ausnahmsweise nicht erlaubt"));
			return null;
		} else {
			System.out.println("Speichere " + name + ", " + einkommen);
			return "gespeichert";
		}
	}

	public String abbrechen() {
		return "abgebrochen";
	}
}