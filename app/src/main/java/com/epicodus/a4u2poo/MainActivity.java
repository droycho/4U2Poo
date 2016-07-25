package com.epicodus.a4u2poo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.loginButton) Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        SearchButton from MainPage
        if (view == mSearchButton) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);
        }
//        LoginButton from Mainpage
        if (view == mLoginButton) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}

