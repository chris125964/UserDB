package de.todd.userdb.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import de.todd.userdb.model.Group;
import de.todd.userdb.services.GroupService;
import de.todd.userdb.util.Events.Added;
import de.todd.userdb.util.Events.Deleted;
import de.todd.userdb.util.Events.Updated;

@RequestScoped
@Named
public class GroupListProducer {

	@Inject
	private GroupService groupService;

	private List<Group> groupList;

	@PostConstruct
	public void init() {
		groupList = groupService.getAllGroups();
	}

	public List<Group> getGroup() {
		return groupList;
	}

	public void onGroupAdded(@Observes @Added Group group) {
		System.out.println("onGroupAdded.found " + group.getLetter());
		groupService.addGroup(group);
		init();
	}

	public void onGroupDeleted(@Observes @Deleted Group group) {
		groupService.deleteGroup(group);
		init();
	}

	public void onTeamUpdated(@Observes @Updated Group group) {
		groupService.updateGroup(group);
		init();
	}
}
