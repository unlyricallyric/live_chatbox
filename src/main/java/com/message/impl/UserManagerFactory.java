package com.message.impl;

import com.message.dao.UserManager;

import java.util.LinkedHashMap;

public class UserManagerFactory {

    public UserManager getInstance(String group_db){

        if(group_db.equals("group1")){
            return new Group1();
        }else if(group_db.equals("group2")){
            return new Group2();
        }else if(group_db.equals("group3")){
            return new Group3();
        }else{
            return new UserGroups();
        }

    }

    public static void main(String args[]){
        UserManagerFactory uf = new UserManagerFactory();
        UserManager obj = uf.getInstance("group1");
        LinkedHashMap<Integer, String> group = obj.getGroups();

        System.out.println(group);
    }

}
