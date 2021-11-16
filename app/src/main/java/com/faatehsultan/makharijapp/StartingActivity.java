package com.faatehsultan.makharijapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);


        findViewById(R.id.btnStartApp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent actIntent = new Intent(StartingActivity.this, MainActivity.class);
                startActivity(actIntent);
            }
        });


        findViewById(R.id.btnGithubRepo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent repoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.github_repo_url)));
                if (repoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(repoIntent);
                }
            }
        });
    }
}