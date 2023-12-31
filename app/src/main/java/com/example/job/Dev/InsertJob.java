package com.example.job.Dev;
import com.example.job.Modele.Job;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.job.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class InsertJob extends AppCompatActivity {

    EditText title, description, field, location, budget;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        field = findViewById(R.id.field);
        location = findViewById(R.id.location);
        budget = findViewById(R.id.budget);

        submit = findViewById(R.id.createJob);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Write a message to the database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("job");

                //get id of user to create jobId
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("userPref", Context.MODE_PRIVATE);

                String UserId= sharedPreferences.getString("userId", "");


                Job Job = new Job(description.getText().toString(),  field.getText().toString(), budget.getText().toString(), title.getText().toString(),location.getText().toString()
             ,UserId );

               myRef.child(UserId+"_"+time()).setValue(Job);

                    Toast.makeText(InsertJob.this, "Job created", Toast.LENGTH_SHORT).show();

                Intent in=new Intent(InsertJob.this,Menu.class);
                startActivity(in);



            }
        });


    }

    private String time()
    {

        return String.valueOf((new Date().getTime()));
    }

}