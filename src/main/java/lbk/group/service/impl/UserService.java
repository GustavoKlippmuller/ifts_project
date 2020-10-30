package lbk.group.service.impl;

import java.util.ArrayList; //OK
import java.util.HashSet; //OK
import java.util.List; //OK
import java.util.Set; //OK

import org.springframework.beans.factory.annotation.Autowired; //OK
import org.springframework.beans.factory.annotation.Qualifier; //OK
import org.springframework.security.core.GrantedAuthority; //OK
import org.springframework.security.core.authority.SimpleGrantedAuthority; //OK
import org.springframework.security.core.userdetails.User; //OK
import org.springframework.security.core.userdetails.UserDetails; //OK
import org.springframework.security.core.userdetails.UserDetailsService; //OK
import org.springframework.security.core.userdetails.UsernameNotFoundException; //OK
import org.springframework.stereotype.Service; //OK

import lbk.group.entity.UserRole; //OK
import lbk.group.repository.UserRepository; //OK

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		lbk.group.entity.User user = userRepository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}
	
	public String getFullName(String username) {
		lbk.group.entity.User user = userRepository.findByUsername(username);
		return user.getLast_name() + ", " + user.getFirst_name();
		
	}

	private User buildUser(lbk.group.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
}
