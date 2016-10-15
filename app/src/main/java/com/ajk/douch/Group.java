package com.ajk.douch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahnju on 2016-10-06.
 */
public class Group {
    public String name, apikey;
    public ArrayList<String> member;
    public Group(String name, String apikey, ArrayList<String> member){
        this.name = name;
        this.apikey = apikey;
        this.member = member;
    }


}
