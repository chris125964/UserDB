/**
 * 
 */
package de.todd.userdb.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.Group;
import de.todd.userdb.model.Team;
import de.todd.userdb.services.TeamService;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Updated;

@SessionScoped
@Named
public class GroupEditController implements Serializable {

	private static final long serialVersionUID = 7368078056202996615L;

	@Inject
	private TeamService teamService;

	@Inject
	@Added
	private Event<Group> groupAddEventSrc;

	@Inject
	@Updated
	private Event<Group> groupUpdatedEventSrc;

	public enum Mode {
		EDIT, ADD
	};

	private Group group;
	private Mode mode;
	private Long teamId1;
	private Long teamId2;
	private Long teamId3;
	private Long teamId4;

	public Long getTeamId1() {
		return teamId1;
	}

	public void setTeamId1(Long teamId) {
		this.teamId1 = teamId;
	}

	public Long getTeamId2() {
		return teamId2;
	}

	public void setTeamId2(Long teamId2) {
		this.teamId2 = teamId2;
	}

	public Long getTeamId3() {
		return teamId3;
	}

	public void setTeamId3(Long teamId3) {
		this.teamId3 = teamId3;
	}

	public Long getTeamId4() {
		return teamId4;
	}

	public void setTeamId4(Long teamId4) {
		this.teamId4 = teamId4;
	}

	public Mode getMode() {
		return mode;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroupToEdit(Mode mode) {
		this.setGroupToEdit(mode, new Group());
	}

	public void setGroupToEdit(Mode mode, Group group) {
		this.group = group;
		this.mode = mode;

	}

	public String doSave() {
		if (this.getMode() == Mode.ADD) {
			System.out.println("fire ADD " + group.getLetter());
			groupAddEventSrc.fire(group);
		} else {
			System.out.println("GroupEditController.doSave(...) "
					+ group.getLetter());
			Team team1 = teamService.findTeamById(this.getTeamId1());
			team1.setNr(1);
			team1.setGruppe(group);
			Team team2 = teamService.findTeamById(this.getTeamId2());
			team2.setNr(2);
			team2.setGruppe(group);
			Team team3 = teamService.findTeamById(this.getTeamId3());
			team3.setNr(3);
			team3.setGruppe(group);
			Team team4 = teamService.findTeamById(this.getTeamId4());
			team4.setNr(4);
			team4.setGruppe(group);
			List<Team> teams = new ArrayList<Team>();
			teams.add(team1);
			teams.add(team2);
			teams.add(team3);
			teams.add(team4);
			group.setTeams(teams);
			groupUpdatedEventSrc.fire(group);
		}
		return Pages.TEAM_LIST;
	}

	public String doCancel() {
		return Pages.USER_LIST;
	}

	public String getTitle() {
		return this.getMode() == Mode.EDIT ? "Gruppe editieren"
				: "Neuen Gruppe anlegen";
	}
}
