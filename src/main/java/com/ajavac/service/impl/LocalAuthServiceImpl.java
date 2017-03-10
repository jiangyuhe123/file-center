package com.ajavac.service.impl;

import com.ajavac.dao.LocalAuthRepository;
import com.ajavac.dto.LocalAuthInfo;
import com.ajavac.entity.LocalAuth;
import com.ajavac.exception.IdNotFoundException;
import com.ajavac.exception.LoginException;
import com.ajavac.exception.UsernameExistException;
import com.ajavac.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


/**
 * Created by wyp0596 on 05/03/2017.
 */
@Service
public class LocalAuthServiceImpl implements LocalAuthService {

    @Autowired
    private LocalAuthRepository localAuthRepository;

    @Override
    public boolean isUsernameExists(String username) {
        long count = localAuthRepository.countByUsername(username);
        return count != 0L;
    }

    @Override
    @Transactional
    public LocalAuthInfo insert(LocalAuthInfo localAuthInfo) {
        String username = localAuthInfo.getUsername();
        if (isUsernameExists(username)) {
            throw new UsernameExistException();
        }
        LocalAuth localAuth = new LocalAuth(localAuthInfo);
        localAuthRepository.save(localAuth);
        return new LocalAuthInfo(localAuth);
    }

    @Override
    @Transactional
    public LocalAuthInfo update(LocalAuthInfo localAuthInfo) {
        String username = localAuthInfo.getUsername();
        LocalAuth localAuth = localAuthRepository.findByUsername(username);
        if (localAuth == null) {
            throw new IdNotFoundException();
        }
        localAuth.setPassword(localAuthInfo.getPassword());
        localAuthRepository.save(localAuth);
        return new LocalAuthInfo(localAuth);
    }

    @Override
    @Transactional
    public void delete(long localAuthId) {
        if (!localAuthRepository.exists(localAuthId)) {
            throw new IdNotFoundException();
        }
        localAuthRepository.delete(localAuthId);
    }

    @Override
    public LocalAuthInfo login(LocalAuthInfo localAuthInfo) {
        String username = localAuthInfo.getUsername();
        LocalAuth localAuth = localAuthRepository.findByUsername(username);
        if (localAuth == null) {
            throw new LoginException();
        }
        String password = localAuth.getPassword();
        String loginPassword = localAuthInfo.getPassword();
        if (Objects.equals(password, loginPassword)) {
            return new LocalAuthInfo(localAuth);
        }
        throw new LoginException();
    }
}
