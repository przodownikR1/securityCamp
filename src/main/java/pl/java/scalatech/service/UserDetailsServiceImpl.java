package pl.java.scalatech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pl.java.scalatech.domain.User;
import pl.java.scalatech.repository.UserRepository;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService  {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		User user = userRepository.findByLogin(login).orElseThrow(()->new UsernameNotFoundException("user not exists"));



        UserDetails userDetails = null;
		/*System.out.println("userDetails   :::::::::"+userDetails.getUsername());

		System.out.println("userDetails   :::::::::"+userDetails.getPassword());

		System.out.println("userDetails   :::::::::"+userDetails.getAuthorities());


		System.out.println("UserDetailsServiceImpl : loadUserByUsername() -end");*/
		return userDetails;
	}

}