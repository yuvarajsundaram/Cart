package com.mariadb.mariadbdemo.Config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class KeyCloakRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

	@SuppressWarnings("unchecked")
	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> realmAccess = (Map<String,Object>) jwt.getClaims().get("realm_access");
		if(realmAccess ==null || realmAccess.isEmpty()) {
			return new ArrayList<>();
		}
		Collection<GrantedAuthority> returnValue = ((List<String>) realmAccess.get("roles")).stream().map(rolename -> "ROLE_"+rolename).
		map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return returnValue;
	}

}
