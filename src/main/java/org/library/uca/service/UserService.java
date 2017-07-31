package org.library.uca.service;

import org.library.uca.domain.entity.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
