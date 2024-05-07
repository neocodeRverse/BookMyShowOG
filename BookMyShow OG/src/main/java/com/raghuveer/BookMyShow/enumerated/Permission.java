package com.raghuveer.BookMyShow.enumerated;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    ADMIN_UPDATE("admin:update"),
    
    TOWNER_READ("towner:read"),
    TOWNER_CREATE("towner:create"),
    TOWNER_DELETE("towner:delete"),
    TOWNER_UPDATE("towner:update"),
    
    CUSTOMER_READ("customer:read"),
    CUSTOMER_CREATE("customer:create"),
    CUSTOMER_DELETE("customer:delete"),
    CUSTOMER_UPDATE("customer:update");

    @Getter
    private final String permission;

}