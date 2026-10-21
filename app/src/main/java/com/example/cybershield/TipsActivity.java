
package com.example.cybershield;

import android.os.Bundle;
import android.widget.Button;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        Button btnPassword = findViewById(R.id.btnTipPassword);
        Button btn2FA = findViewById(R.id.btnTip2FA);
        Button btnWifi = findViewById(R.id.btnTipWifi);
        Button btnUpdates = findViewById(R.id.btnTipUpdates);
        Button btnPrivacy = findViewById(R.id.btnTipPrivacy);
        Button btnBack = findViewById(R.id.btnTipsBack);

        showTip(btnPassword, "Strong Passwords",
                "Use long, unique passwords or passphrases for each account. A password manager can help you store them securely.");

        showTip(btn2FA, "Two-Factor Authentication",
                "Enable two-factor authentication wherever possible. An authenticator app or security key adds protection beyond your password.");

        showTip(btnWifi, "Public Wi-Fi Safety",
                "Avoid sensitive activities on untrusted networks. Check website addresses, use HTTPS, and avoid unexpected connection prompts.");

        showTip(btnUpdates, "Software Updates",
                "Install operating system, browser and app updates promptly. Updates often fix security vulnerabilities.");

        showTip(btnPrivacy, "Protect Your Privacy",
                "Review app permissions and privacy settings. Share less personal information publicly and verify unexpected requests.");

        btnBack.setOnClickListener(v -> finish());
    }

    private void showTip(Button button, String title, String message) {
        button.setOnClickListener(v ->
                new AlertDialog.Builder(TipsActivity.this)
                        .setTitle(title)
                        .setMessage(message)
                        .setPositiveButton("Got it", null)
                        .show()
        );
    }
}
