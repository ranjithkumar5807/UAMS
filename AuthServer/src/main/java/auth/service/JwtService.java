package auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface JwtService {
	public UserDetails loadUserByUsername(String username);
}
