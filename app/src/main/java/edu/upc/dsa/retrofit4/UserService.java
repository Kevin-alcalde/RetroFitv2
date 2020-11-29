package edu.upc.dsa.retrofit4;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {

    @GET("users/")  /*Esto lo podemos ver en la misma url, de momento tenemos: http://api.larntech.net/users/ */
    Call<List<UserResponse>> getAllusers();


}
