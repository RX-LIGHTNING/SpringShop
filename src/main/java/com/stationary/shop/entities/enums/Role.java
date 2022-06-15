package com.stationary.shop.entities.enums;

public enum Role {
    USER("Casual role"),
    ADMIN("Role, that gives access to users list");

    final String description;

    public String getDescription() {
        return description;
    }

    Role(String description) {
        this.description = description;
    }
}
