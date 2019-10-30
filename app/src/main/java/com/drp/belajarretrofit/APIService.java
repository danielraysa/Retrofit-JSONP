package com.drp.belajarretrofit;
import com.drp.belajarretrofit.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId);
    @GET("/posts")
    //Wrap the response in a Call object with the type of the expected result//
    Call<List<Post>> getAllPosts();
}
