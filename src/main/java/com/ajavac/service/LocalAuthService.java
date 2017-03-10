package com.ajavac.service;

import com.ajavac.dto.LocalAuthInfo;

/**
 * Created by wyp0596 on 05/03/2017.
 */
public interface LocalAuthService {

    boolean isUsernameExists(String username);

    LocalAuthInfo insert(LocalAuthInfo localAuthInfo);

    LocalAuthInfo update(LocalAuthInfo localAuthInfo);

    void delete(long localAuthId);

    LocalAuthInfo login(LocalAuthInfo localAuthInfo);

}
