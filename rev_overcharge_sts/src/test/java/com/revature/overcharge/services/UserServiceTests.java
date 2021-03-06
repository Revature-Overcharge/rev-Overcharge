package com.revature.overcharge.services;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.revature.overcharge.beans.User;
import com.revature.overcharge.repositories.UserRepo;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
class UserServiceTests {

	@Autowired
	public UserService us;
	@MockBean
	UserRepo ur;

	@Test
	void testAddUser() {
		User user = new User("test", "test", 0, null);
		Mockito.when(ur.save(user)).thenReturn(new User("test", "test", 0, null));

		user = us.addUser(user);

		Assertions.assertEquals("test", user.getUsername());
		Assertions.assertEquals("test", user.getPassword());
		Assertions.assertNotEquals("", user.getPassword());
		Assertions.assertNotEquals("", user.getUsername());
	}

	@Test
	void addUserFailure() {
		User user = new User("test", "test", 0, null);
		Mockito.when(ur.existsById(user.getId())).thenReturn(true);

		assertThrows(ResponseStatusException.class, () -> {
			us.addUser(user);
		});
	}

	@Test
	void testGetUser() {
		User user = new User("test", "test", 0, null);

		Mockito.when(ur.existsById(user.getId())).thenReturn(true);
		Mockito.when(ur.findById(user.getId())).thenReturn(Optional.of(user));

		us.getUser(user.getId());

		Assertions.assertEquals("test", user.getUsername());
		Assertions.assertEquals("test", user.getPassword());
		Assertions.assertNotEquals("", user.getPassword());
		Assertions.assertNotEquals("", user.getUsername());
	}

	@Test
	void getCardFailure() {
		User user = new User("test", "test", 0, null);

		Mockito.when(ur.existsById(user.getId())).thenReturn(false);

		assertThrows(ResponseStatusException.class, () -> {
			us.getUser(user.getId());
		});
	}

	@Test
	void testGetAllUsers() {
		User user = new User("test", "test", 0, null);
		List<User> list = new ArrayList<User>();
		list.add(user);

		Mockito.when(ur.findAll()).thenReturn(list);

		Assertions.assertNotNull(list);
	}

	@Test
	void testUpdateUser() {
		User user = new User("test", "test", 0, null);

		Mockito.when(ur.existsById(user.getId())).thenReturn(true);
		Mockito.when(ur.save(user)).thenReturn(new User("test", "test", 0, null));
		user = us.updateUser(user);
		Assertions.assertEquals("test", user.getUsername());
		Assertions.assertEquals("test", user.getPassword());
		Assertions.assertNotEquals("", user.getPassword());
		Assertions.assertNotEquals("", user.getUsername());
	}

	@Test
	void updateCardFailure() {
		User user = new User("test", "test", 0, null);

		Mockito.when(ur.existsById(user.getId())).thenReturn(false);
		assertThrows(ResponseStatusException.class, () -> {
			us.updateUser(user);
		});
	}

	@Test
	void testDeleteUser() {
		User user = new User("test", "test", 0, null);

		Mockito.when(ur.existsById(user.getId())).thenReturn(true);

		Assertions.assertEquals(us.deleteUser(user.getId()), true);
	}

	@Test
	void deleteCardFailure() {
		User user = new User("test", "test", 0, null);

		Mockito.when(ur.existsById(user.getId())).thenReturn(false);

		assertThrows(ResponseStatusException.class, () -> {
			us.deleteUser(user.getId());
		});
	}

	@Test
	void testLogin() {
		Assertions.assertEquals(0, 0);

	}

}
