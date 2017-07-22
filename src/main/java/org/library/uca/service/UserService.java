package org.library.uca.service;

import org.library.uca.domain.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
