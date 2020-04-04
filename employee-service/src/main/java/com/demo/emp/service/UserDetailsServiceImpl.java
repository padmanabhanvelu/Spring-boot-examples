package com.demo.emp.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.emp.domain.User;
import com.demo.emp.domain.UserPrincipal;
import com.demo.emp.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User applicationUser = userRepo.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        System.out.println(applicationUser.toString());
		return new UserPrincipal(applicationUser);
    }
}