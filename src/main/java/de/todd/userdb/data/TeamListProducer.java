package de.todd.userdb.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.Team;
import de.todd.userdb.services.TeamService;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Deleted;
import de.todd.userdb.util.Events.Updated;

@RequestScoped
@Named
public class TeamListProducer {

	@Inject
	private TeamService teamService;

	private List<Team> teamList;

	@PostConstruct
	public void init() {
		teamList = teamService.getAllTeams();
	}

	public List<Team> getTeam() {
		return teamList;
	}

	public void onTeamAdded(@Observes @Added Team team) {
		teamService.addTeam(team);
		init();
	}

	public void onTeamDeleted(@Observes @Deleted Team team) {
		teamService.deleteTeam(team);
		init();
	}

	public void onTeamUpdated(@Observes @Updated Team team) {
		teamService.updateTeam(team);
		init();
	}
}
