package com.ajavac.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by wyp0596 on 07/03/2017.
 */
@Entity
public class MyFile {

    @Id
    @GeneratedValue
    private long myFileId;

    private String name;

    private int size;

    private String type;

    private String path;

    private String md5;

    private Timestamp time;

    public MyFile() {
    }

    public MyFile(String name, int size, String type, String path, String md5) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.path = path;
        this.md5 = md5;
        this.time = new Timestamp(System.currentTimeMillis());
    }

    public long getMyFileId() {
        return myFileId;
    }

    public void setMyFileId(long myFileId) {
        this.myFileId = myFileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
