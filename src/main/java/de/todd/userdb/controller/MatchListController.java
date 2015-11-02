/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.controller.MatchEditController.Mode;
import de.todd.userdb.model.Match;
import de.todd.userdb.util.Events.Deleted;

/**
 * @author Christian
 *
 */
@SessionScoped
@Named
public class MatchListController implements Serializable {

	private static final long serialVersionUID = 7461147659066034550L;

	private Match matchToDelete;

	@Inject
	private MatchEditController matchEditController;

	@Inject
	@Deleted
	private Event<Match> matchDeleteEventSrc;

	public String doAddMatch() {
		matchEditController.setMatchToEdit(Mode.ADD);
		return Pages.MATCH_EDIT;
	}

	// public String doEditTeam(Group group) {
	// groupEditController.setGroupToEdit(Mode.EDIT, group);
	// return Pages.GROUP_EDIT;
	// }

	public String doListMatch() {
		return Pages.MATCH_LIST;
	}

	public void doDeleteMatch(Match match) {
		this.matchToDelete = match;
	}

	public void doCommitDeleteMatch() {
		this.matchDeleteEventSrc.fire(matchToDelete);
	}
}
