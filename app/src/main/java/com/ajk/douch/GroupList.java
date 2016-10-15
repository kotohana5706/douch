package com.ajk.douch;

import java.util.ArrayList;

/**
 * Created by ahnju on 2016-10-15.
 */
public class GroupList {

    public String name, apikey;
    public ArrayList<String> member;
    public GroupList(String name, String apikey, ArrayList<String> member){
        this.name = name;
        this.apikey = apikey;
        this.member = member;
    }

}
