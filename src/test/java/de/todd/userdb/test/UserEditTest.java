package de.todd.userdb.test;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.todd.userdb.controller.UserEditController;
import de.todd.userdb.controller.UserEditController.Mode;
import de.todd.userdb.model.User;

@RunWith(Arquillian.class)
public class UserEditTest {

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(WebArchive.class, "test.war")
				.addClasses(User.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	UserEditController userEditController;

	@Test
	public void testAddUser() throws Exception {
		Assert.assertNotNull(userEditController);
		userEditController.setUserToEdit(Mode.ADD);
		User user = userEditController.getUser();
		Assert.assertNotNull(user);
		user.setVorname("Christian");
		user.setNachname("Todd");
		userEditController.doSave();
	}
}
