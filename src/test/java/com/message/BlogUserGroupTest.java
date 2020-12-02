package com.message;

import com.message.controller.UserController;
import com.message.dao.UserManager;
import com.message.impl.UserManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class BlogUserGroupTest {

    //Verify if groups are valid from database
    @Test
    void validateUserGroupExist(){

        Boolean testing_result = true;
        int issue_id = 0;
        String issue_group = "";

        ArrayList<String> groups = new ArrayList<>();
        groups.add("admin");
        groups.add("concordia");
        groups.add("encs");
        groups.add("comp");
        groups.add("soen");

        UserController uc = new UserController();

        LinkedHashMap<Integer, String> db_groups = uc.getAllUserGroups();

        for(int key : db_groups.keySet()){
            if(!groups.contains(db_groups.get(key))){
                issue_id = key;
                issue_group = db_groups.get(key);
                testing_result = false;
            }
        }

        Assertions.assertTrue(testing_result, " There is an issue with user(id: " + issue_id + ") having group as: " + issue_group);

    }

    //validate counts of predefined Singleton user groups
    @Test
    void validateUserGroupCount() {
        LinkedHashMap<Integer, String> groups = new LinkedHashMap<>();

        UserManagerFactory uf = new UserManagerFactory();

        UserManager obj = uf.getInstance("group1");

        groups = obj.getGroups();

        Assertions.assertTrue(groups.size() == 5, "There should only have 5 pre-defined groups");
    }
}
