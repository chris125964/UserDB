package de.todd.userdb.services;

import java.util.List;

import de.todd.userdb.model.Team;

public interface TeamService {

	List<Team> getAllTeams();

	Team findTeamById(Long id);

	void addTeam(Team team);

	void deleteTeam(Team team);

	void updateTeam(Team team);

}
