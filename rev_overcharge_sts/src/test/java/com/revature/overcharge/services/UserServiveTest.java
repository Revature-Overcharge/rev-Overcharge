package com.revature.overcharge.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.revature.overcharge.repositories.UserRepo;

@SpringBootTest(classes = com.revature.overcharge.application.RevOverchargeStsApplication.class)
@Transactional
public class UserServiveTest {

	@Autowired
	UserService us;

	@MockBean
	UserRepo ur;

	@Test
	public void addUserTest() {

		Assertions.assertEquals(0, 0);

	}

	@Test
	public void getUserTest() {
		Assertions.assertEquals(0, 0);

	}

	@Test
	public void updateUserTest() {
		Assertions.assertEquals(0, 0);
	}

	@Test
	public void deleteUserTest() {
		Assertions.assertEquals(0, 0);

	}

}
