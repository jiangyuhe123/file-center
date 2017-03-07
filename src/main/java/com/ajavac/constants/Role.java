package com.ajavac.constants;

/**
 * Created by wyp0596 on 06/03/2017.
 */
public enum Role {
    ADMIN(0),
    USER(1)
    ;

    private int type;

    Role(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static Role typeOf(int type) {
        for (Role role : values()) {
            if (role.getType() == type) {
                return role;
            }
        }
        return null;
    }

}
