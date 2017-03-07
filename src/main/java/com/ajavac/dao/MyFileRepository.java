package com.ajavac.dao;

import com.ajavac.entity.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wyp0596 on 07/03/2017.
 */
@Repository
public interface MyFileRepository extends JpaRepository<MyFile,Long> {

}
