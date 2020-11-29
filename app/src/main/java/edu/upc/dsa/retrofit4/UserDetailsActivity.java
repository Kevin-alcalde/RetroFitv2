package edu.upc.dsa.retrofit4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetailsActivity extends AppCompatActivity {
    TextView username,email,joined;
    UserResponse userResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);


        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        joined = findViewById(R.id.joined);
        Intent intent = getIntent();
        if(intent.getExtras() != null)
            userResponse = (UserResponse) intent.getSerializableExtra("data");

        String usernamedata = userResponse.getUsername();
        String emaildata = userResponse.getEmail();
        String joineddata = userResponse.getDate_joined();

        username.setText(usernamedata);
        email.setText(emaildata);
        joined.setText(joineddata);












    }
}