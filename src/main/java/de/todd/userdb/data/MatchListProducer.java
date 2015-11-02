package de.todd.userdb.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.Match;
import de.todd.userdb.services.MatchService;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Deleted;
import de.todd.userdb.util.Events.Updated;

@RequestScoped
@Named
public class MatchListProducer {

	@Inject
	private MatchService matchService;

	private List<Match> matchList;

	@PostConstruct
	public void init() {
		matchList = matchService.getAllMatches();
	}

	public List<Match> getMatch() {
		return matchList;
	}

	public void onMatchAdded(@Observes @Added Match match) {
		matchService.addMatch(match);
		init();
	}

	public void onMatchDeleted(@Observes @Deleted Match match) {
		matchService.deleteMatch(match);
		init();
	}

	public void onTeamUpdated(@Observes @Updated Match match) {
		matchService.updateMatch(match);
		init();
	}

}
