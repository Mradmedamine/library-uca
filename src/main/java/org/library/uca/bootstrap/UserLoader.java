package org.library.uca.bootstrap;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.library.uca.model.domain.entity.Role;
import org.library.uca.model.domain.entity.User;
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

	private static final String USER_ROLE = "USER_ROLE";
	private static final String ADMIN_ROLE = "ADMIN_ROLE";

	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserRepository userRepository;
	private RoleRepository roleRepository;

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

		Role userRole = new Role();
		userRole.setName(USER_ROLE);
		userRole = roleRepository.save(userRole);
		log.info("Saved Role :" + USER_ROLE + " id: " + userRole.getId());
		
		Role adminRole = new Role();
		adminRole.setName(ADMIN_ROLE);
		adminRole = roleRepository.save(adminRole);
		log.info("Saved Role :" + ADMIN_ROLE + " id: " + adminRole.getId());
		
		User user = new User();
		user.setUsername("editorial");
		user.setPassword(bCryptPasswordEncoder.encode("editorial"));
		user.setPasswordConfirm("editorial");
		user.setRoles(Collections.singleton(userRole));
		user = userRepository.save(user);

		log.info("Saved User - id: " + user.getId());

		userRole.setUsers(Collections.singleton(user));
		roleRepository.save(userRole);

	}
}
