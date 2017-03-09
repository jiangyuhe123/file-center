package com.ajavac.config;

import com.ajavac.constants.Role;
import com.ajavac.dao.LocalAuthRepository;
import com.ajavac.entity.LocalAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Created by wyp0596 on 07/03/2017.
 */
@Component
public class DataInit {

    @Value("${server.port}")
    private String port;

    private static final String adminName = "admin";
    private static final String adminPassword = "admin";

    private final LocalAuthRepository localAuthRepository;

    @Autowired
    public DataInit(LocalAuthRepository localAuthRepository) {
        this.localAuthRepository = localAuthRepository;
    }

    @PostConstruct
    @Transactional
    public void dataInit() {
        LocalAuth localAuth = localAuthRepository.findOne(adminName);
        if (localAuth == null) {
            localAuth = new LocalAuth(adminName, adminPassword, Role.ADMIN);
            localAuthRepository.save(localAuth);
        }
        System.out.println("application run success in : http://localhost:" + port);
    }

}