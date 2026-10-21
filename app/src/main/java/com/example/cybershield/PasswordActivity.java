
package com.example.cybershield;

import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordActivity extends AppCompatActivity {

    private EditText etPassword;
    private TextView tvStrength;
    private Button btnShowHide;
    private boolean passwordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        etPassword = findViewById(R.id.etPassword);
        tvStrength = findViewById(R.id.tvStrength);
        btnShowHide = findViewById(R.id.btnShowHide);
        Button btnCheckStrength =
                findViewById(R.id.btnCheckStrength);
        Button btnBack = findViewById(R.id.btnBack);

        btnShowHide.setOnClickListener(v -> {
            passwordVisible = !passwordVisible;

            if (passwordVisible) {
                etPassword.setInputType(
                        InputType.TYPE_CLASS_TEXT
                );
                btnShowHide.setText("Hide Password");
            } else {
                etPassword.setInputType(
                        InputType.TYPE_CLASS_TEXT
                                | InputType.TYPE_TEXT_VARIATION_PASSWORD
                );
                btnShowHide.setText("Show Password");
            }

            etPassword.setSelection(
                    etPassword.getText().length()
            );
        });

        btnCheckStrength.setOnClickListener(v -> {
            String password = etPassword.getText().toString();

            if (password.isEmpty()) {
                tvStrength.setText(
                        "Please enter a password first."
                );
                return;
            }

            int score = 0;

            if (password.length() >= 8) score++;
            if (password.length() >= 12) score++;
            if (password.matches(".*[A-Z].*")) score++;
            if (password.matches(".*[a-z].*")) score++;
            if (password.matches(".*[0-9].*")) score++;
            if (password.matches(".*[^a-zA-Z0-9].*")) score++;

            String result;

            if (password.length() < 8) {
                result = "Weak password\n"
                        + "Use at least 8 characters; "
                        + "a longer password is better.";
            } else if (score <= 3) {
                result = "Moderate password\n"
                        + "Try a longer, unique passphrase "
                        + "with varied characters.";
            } else {
                result = "Good password structure\n"
                        + "Use a unique password that you "
                        + "do not reuse on other accounts.";
            }

            tvStrength.setText(result);
        });

        btnBack.setOnClickListener(v -> finish());
    }
}
