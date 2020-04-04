package com.demo.emp.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private Set<GrantedAuthority> authorities=null;
 
    
	public UserPrincipal(User user) {
        this.user = user;
        setAuthorities(new HashSet<>());
    }


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		/*
		 * authorities = new HashSet<>(); if(user != null) { for(Role userRole:
		 * user.getRoles()) { authorities.add(new
		 * SimpleGrantedAuthority(userRole.getRoleCode())); } }
		 */
		this.authorities = authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
}