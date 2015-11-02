package de.todd.userdb.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.Result;
import de.todd.userdb.services.ResultService;

@RequestScoped
@Named
public class ResultListProducer {

	@Inject
	private ResultService resultService;

	private List<Result> resultList;

	@PostConstruct
	public void init() {
		resultList = resultService.getAllResults();
	}

	public List<Result> getResult() {
		// for (Result result : resultList) {
		// System.out.println("ResultListProducer.getResult: "
		// + result.getMatch().getTeam1().getName() + " - "
		// + result.getMatch().getTeam2().getName());
		// }
		return resultList;
	}

}
