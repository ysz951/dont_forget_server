package com.dont.forget.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.dont.forget.model.Role;
import com.dont.forget.model.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserPrincipal implements UserDetails {
    private Long id;

    private String username;

    @JsonIgnore
    private String password;


    private Role role;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(Long id, String username, String password, Role role, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.role = role;
    }

    public static UserPrincipal create(Users user) {
//        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
//                new SimpleGrantedAuthority(role.getName().name())
//        ).collect(Collectors.toList());
        List<GrantedAuthority> authorities = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority(user.getRole().name())));
        return new UserPrincipal(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getRole(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }


    public Role getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String getUsername() {
        return username;
    }

}
