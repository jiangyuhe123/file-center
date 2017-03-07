package com.ajavac.controller.api;

import com.ajavac.dto.LocalAuthInfo;
import com.ajavac.service.LocalAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wyp0596 on 06/03/2017.
 */
@RestController
@RequestMapping("auth/local")
public class LocalAuthController {

    @Autowired
    private LocalAuthService localAuthService;

    @PostMapping
    public LocalAuthInfo insert(@RequestBody LocalAuthInfo localAuthInfo){
        return localAuthService.insert(localAuthInfo);
    }

}
