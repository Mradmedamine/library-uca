package org.library.uca.service;

import org.library.uca.model.domain.entity.User;

public interface UserService {

	void save(User user);

	User findByUsername(String username);
}
