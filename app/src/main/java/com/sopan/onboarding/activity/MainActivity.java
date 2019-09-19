package com.sopan.onboarding.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sopan.onboarding.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnGradient, btnImage, btnSolid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGradient = findViewById(R.id.btnGradient);
        btnImage = findViewById(R.id.btnImage);
        btnSolid = findViewById(R.id.btnSolid);

        btnGradient.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnSolid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnGradient:
                Intent gradientIntent = new Intent(this, GradientBackgroundActivity.class);
                startActivity(gradientIntent);
                break;

            case R.id.btnImage:
                Intent imageIntent = new Intent(this, ImageBackgroundActivity.class);
                startActivity(imageIntent);
                break;

            case R.id.btnSolid:
                Intent solidIntent = new Intent(this, SolidBackgroundActivity.class);
                startActivity(solidIntent);
                break;

            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
