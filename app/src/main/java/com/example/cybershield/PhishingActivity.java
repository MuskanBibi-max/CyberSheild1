
package com.example.cybershield;

import android.os.Bundle;
import android.widget.Button;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class PhishingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phishing);

        Button btnQuiz = findViewById(R.id.btnQuiz);
        Button btnBack = findViewById(R.id.btnPhishingBack);

        btnQuiz.setOnClickListener(v -> {
            new AlertDialog.Builder(PhishingActivity.this)
                    .setTitle("Cyber Safety Quiz")
                    .setMessage(
                            "You receive a message asking for your bank OTP. What should you do?"
                    )
                    .setPositiveButton("Never share it",
                            (dialog, which) ->
                                    new AlertDialog.Builder(PhishingActivity.this)
                                            .setTitle("Correct!")
                                            .setMessage(
                                                    "Never share an OTP. Verify unexpected messages through official channels."
                                            )
                                            .setPositiveButton("OK", null)
                                            .show()
                    )
                    .setNegativeButton("Share it", (dialog, which) ->
                            new AlertDialog.Builder(PhishingActivity.this)
                                    .setTitle("Incorrect")
                                    .setMessage(
                                            "Never share an OTP, even with someone claiming to be from your bank."
                                    )
                                    .setPositiveButton("OK", null)
                                    .show()
                    )
                    .show();
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
