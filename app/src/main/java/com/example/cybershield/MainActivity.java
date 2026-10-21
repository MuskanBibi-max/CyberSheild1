
package com.example.cybershield;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnPassword;
    private Button btnPhishing;
    private Button btnTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPassword = findViewById(R.id.btnPassword);
        btnPhishing = findViewById(R.id.btnPhishing);
        btnTips = findViewById(R.id.btnTips);

        btnPassword.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    PasswordActivity.class
            );
            startActivity(intent);
        });


        btnPhishing.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    PhishingActivity.class
            );
            startActivity(intent);
        });



        btnTips.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    TipsActivity.class
            );
            startActivity(intent);
        });

    }
}
