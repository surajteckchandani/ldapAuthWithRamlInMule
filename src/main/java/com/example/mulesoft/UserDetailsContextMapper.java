package com.example.mulesoft;

import java.util.Collection;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.ldap.userdetails.InetOrgPerson;
import org.springframework.security.ldap.userdetails.InetOrgPersonContextMapper;

public class UserDetailsContextMapper extends InetOrgPersonContextMapper {
	
	
	public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        InetOrgPerson.Essence p = new InetOrgPerson.Essence(ctx);
        p.setUsername(username);
        p.setAuthorities(authorities);
        p.setDisplayName(ctx.getStringAttribute("givenName"));
        return p.createUserDetails();
    }

}