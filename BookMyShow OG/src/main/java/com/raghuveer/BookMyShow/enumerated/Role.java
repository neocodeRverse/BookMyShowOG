package com.raghuveer.BookMyShow.enumerated;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Role {

    ADMIN(
        Set.of(
            Permission.ADMIN_CREATE,
            Permission.ADMIN_DELETE,
            Permission.ADMIN_READ,
            Permission.ADMIN_UPDATE,
            
            Permission.TOWNER_CREATE,
            Permission.TOWNER_DELETE,
            Permission.TOWNER_READ,
            Permission.TOWNER_UPDATE,
            
            Permission.CUSTOMER_CREATE,
            Permission.CUSTOMER_DELETE,
            Permission.CUSTOMER_READ,
            Permission.CUSTOMER_UPDATE
        )
    ),

    TOWNER(
        Set.of(
            Permission.TOWNER_CREATE,
            Permission.TOWNER_DELETE,
            Permission.TOWNER_READ,
            Permission.TOWNER_UPDATE
        )
    ),

    CUSTOMER(
        Set.of(
            Permission.CUSTOMER_CREATE,
            Permission.CUSTOMER_DELETE,
            Permission.CUSTOMER_READ,
            Permission.CUSTOMER_UPDATE
        )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                            .stream()
                            .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                            .collect(Collectors.toList());
        
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
