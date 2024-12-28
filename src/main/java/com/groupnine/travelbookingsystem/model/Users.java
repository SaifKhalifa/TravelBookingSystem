package com.groupnine.travelbookingsystem.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue
    int user_id;


    @Column(name = "user_name")
    String user_name;


    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
