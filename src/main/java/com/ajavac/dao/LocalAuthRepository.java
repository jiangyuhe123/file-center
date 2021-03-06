package com.ajavac.dao;

import com.ajavac.entity.LocalAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wyp0596 on 05/03/2017.
 */
@Repository
public interface LocalAuthRepository extends JpaRepository<LocalAuth,Long> {

    LocalAuth findByUsername(String username);

    long countByUsername(String username);
}
