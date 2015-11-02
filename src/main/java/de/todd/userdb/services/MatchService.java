package de.todd.userdb.services;

import java.util.List;

import de.todd.userdb.model.Match;

public interface MatchService {

	List<Match> getAllMatches();

	void addMatch(Match match);

	void deleteMatch(Match match);

	void updateMatch(Match match);

}
