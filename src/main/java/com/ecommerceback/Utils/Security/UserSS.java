package com.ecommerceback.Utils.Security;


import com.ecommerceback.Model.User.AuthenticatorModel;
import com.ecommerceback.Model.User.Enum.TypeUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserSS implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }
    public static UserSS build(AuthenticatorModel user) {
        List<GrantedAuthority> authorities = user.getUser().getTypeUser().stream()
                .map(role -> new SimpleGrantedAuthority(role.getDescription()))
                .collect(Collectors.toList());

        return new UserSS(
                user.getUser().getId_user(),
                user.getUser().getEmail(),
                user.getPassword(),
                authorities);
    }
    public UserSS(Long id, String email, String password,Collection<? extends GrantedAuthority> authorities) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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

    public boolean hasRole(TypeUser profile) {
        return getAuthorities().contains(new SimpleGrantedAuthority(profile.getDescription()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSS userSS = (UserSS) o;
        return Objects.equals(id, userSS.id) && Objects.equals(email, userSS.email) && Objects.equals(password, userSS.password) && Objects.equals(authorities, userSS.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, authorities);
    }
}