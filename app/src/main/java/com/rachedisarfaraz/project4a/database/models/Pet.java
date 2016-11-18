package com.rachedisarfaraz.project4a.database.models;

import java.util.Date;

/**
 * Created by zakariarachedi on 17/11/2016.
 */

public class Pet {
    private long id;
    private String name;
    private String birthDate;

    public Pet(long id, String name, String birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
