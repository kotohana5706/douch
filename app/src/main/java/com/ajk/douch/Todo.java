package com.ajk.douch;

import java.util.ArrayList;

/**
 * Created by ahnju on 2016-10-06.
 */
public class Todo {
    public String todoId, todoName, todoAdmin, todoStart, todoEnd;
    public ArrayList<String> todoMem;
    public Todo(String todoId, String todoName, String todoAdmin, String todoStart, String todoEnd, ArrayList<String> todoMem){
        this.todoId = todoId;
        this.todoName = todoName;
        this.todoAdmin = todoAdmin;
        this.todoStart = todoStart;
        this.todoEnd = todoEnd;
        this.todoMem = todoMem;
    }
}
