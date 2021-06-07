package com.example.test.registration;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;

public class PasswordReset extends AppCompatActivity {
    private TextInputLayout emailResetET;
    private Button resetButton;
    private FirebaseAuth resetAuth;
    private ProgressBar resetProgress;
    private TextView restText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_reset);
        this.setTitle("Password Reset");

        emailResetET = findViewById(R.id.reset_password_edit_text);
        resetButton = findViewById(R.id.reset_button);
        resetProgress = findViewById(R.id.reset_progress);
        restText = findViewById(R.id.text_view);
        resetAuth = FirebaseAuth.getInstance();

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });

    }

    public void resetPassword() {
        String email = emailResetET.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            emailResetET.setError("Enter your registered email");
            emailResetET.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailResetET.setError("Provide Correct email");
            emailResetET.requestFocus();
            return;
        } else {
            emailResetET.setErrorEnabled(false);
        }
        resetProgress.setVisibility(View.VISIBLE);
        resetAuth.sendPasswordResetEmail(email).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                resetProgress.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(PasswordReset.this, "Sent your password Successfully", Toast.LENGTH_SHORT).show();
                    restText.setText(getResources().getString(R.string.reset_text_string));
                } else if (task.getException() instanceof FirebaseAuthEmailException) {
                    Toast.makeText(PasswordReset.this, "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(PasswordReset.this, "Not Registered Account", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}