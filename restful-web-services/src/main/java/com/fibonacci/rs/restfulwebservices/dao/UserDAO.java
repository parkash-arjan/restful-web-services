package com.fibonacci.rs.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fibonacci.rs.restfulwebservices.bean.User;

@Repository
public class UserDAO {

	private static List<User> users = new ArrayList<>();
	private static int userCount = 103;
	static {
		users.add(new User(101L, "User 1", new Date()));
		users.add(new User(102L, "User 2", new Date()));
		users.add(new User(103L, "User 3", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(Long.valueOf(++userCount));
		}
		users.add(user);
		return user;
	}

	public User findOne(Long id) {

		for (User user : users) {
			if (user.getId().longValue() == id.longValue()) {
				return user;
			}
		}

		return null;
	}

	public User deleteById(Long id) {
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			User user = itr.next();

			if (user.getId().longValue() == id.longValue()) {
				itr.remove();
				return user;
			}
		}
		return null;
	}
}
