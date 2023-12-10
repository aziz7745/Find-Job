package com.example.job.Dev;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.job.Modele.User;
import com.example.job.R;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Profile extends AppCompatActivity {

    ImageView profile_image;
    ImageView img2;

    TextView profile_email, profile_name, profile_type, profile_facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("userPref", Context.MODE_PRIVATE);
        String userId = sharedPreferences.getString("userId", "");
        profile_email = findViewById(R.id.profile_email);
        profile_name = findViewById(R.id.profile_username);
        profile_type = findViewById(R.id.profile_type);
        profile_facebook = findViewById(R.id.profile_facebook);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("/users").child(userId);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name = snapshot.child("username").getValue().toString();
                String type = snapshot.child("type").getValue().toString();
                String email = snapshot.child("email").getValue().toString();

                profile_email.setText(email);
                profile_type.setText(type);
                profile_name.setText(name);
                profile_facebook.setText("facebook.com/"+name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });









    }

}