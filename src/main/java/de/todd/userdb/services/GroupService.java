package de.todd.userdb.services;

import java.util.List;

import de.todd.userdb.model.Group;

public interface GroupService {

	List<Group> getAllGroups();

	void addGroup(Group group);

	void deleteGroup(Group group);

	void updateGroup(Group group);

}
