package edu.upc.dsa.retrofit4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements UsersAdapter.ClickedItem {

    Toolbar toolbar;
    RecyclerView recyclerView;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);/*Estamos diciendo que es el toolbar del dibujo*/
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        usersAdapter = new UsersAdapter(this::ClickedUser);
        getAllUsers();






    }

    public void getAllUsers(){
        Call<List<UserResponse>> userlist = ApiClient.getUserService().getAllusers();
        userlist.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if(response.isSuccessful()){
                    List<UserResponse> userResponses = response.body();
                    usersAdapter.setData(userResponses);
                    recyclerView.setAdapter(usersAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
            }
        });

    }

    @Override
    public void ClickedUser(UserResponse userResponse) {
        Log.e("clickeduser",userResponse.toString());

    }
}