package com.ajavac.controller.api;

import com.ajavac.dto.LocalAuthInfo;
import com.ajavac.service.LocalAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wyp0596 on 06/03/2017.
 */
@RestController
@RequestMapping("api/auth/local")
public class LocalAuthController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LocalAuthService localAuthService;

    @PostMapping
    public LocalAuthInfo insert(@Validated @RequestBody LocalAuthInfo localAuthInfo) {
        logger.debug(localAuthInfo.toString());
        return localAuthService.insert(localAuthInfo);
    }

}
