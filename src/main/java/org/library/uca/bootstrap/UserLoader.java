package org.library.uca.bootstrap;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.library.uca.domain.Role;
import org.library.uca.domain.User;
import org.library.uca.repository.RoleRepository;
import org.library.uca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserLoader implements ApplicationListener<ContextRefreshedEvent> {

	private static Logger log = Logger.getLogger(UserLoader.class);

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setRoleRepository(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Autowired
	public void setBCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Role role = new Role();
		role.setName("user_role");
		role = roleRepository.save(role);
		log.info("Saved Role : user_role  id: " + role.getId());

		User user = new User();
		user.setUsername("uca");
		user.setPassword(bCryptPasswordEncoder.encode("uca"));
		user.setPasswordConfirm("uca");
		user.setRoles(Collections.singleton(role));
		user = userRepository.save(user);

		log.info("Saved User - id: " + user.getId());

		role.setUsers(Collections.singleton(user));
		roleRepository.save(role);

		log.info("Saved Role : user_role  id: " + role.getId());
	}
}
