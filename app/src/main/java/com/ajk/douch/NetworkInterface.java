package com.ajk.douch;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ahnju on 2016-09-24.
 */
public interface NetworkInterface {

    //register
    @POST("/auth/register")
    @FormUrlEncoded
    Call<Usr> userRegister(@Field("num") String num, @Field("pw") String pw, @Field("name") String name);

    //login
    @POST("/auth/login")
    @FormUrlEncoded
    Call<Usr> userLogin(@Field("num") String num, @Field("pw") String pw);

    //groupGet
    @POST("/group/getgroup")
    @FormUrlEncoded
    Call<ArrayList<Group>> groupGet(@Field("gapi")String gapi);

    //groupRegister
    @POST("/gorup/regiGroup")
    @FormUrlEncoded
    Call<ArrayList<Group>> groupRegister(@Field("id")String groupId, @Field("name")String groupName, @Field("admin")String groupAdmin, @Field("member")String[] groupMem);

    //todoRegister
    @POST("/todo/regiTodo")
    @FormUrlEncoded
    Call<ArrayList<Group>> todoRegister(@Field("id")String todoId, @Field("name")String todoName, @Field("admin")String todoAdmin,@Field("start")String startTime, @Field("end")String endTime ,@Field("member")String[] todoMem);


}
