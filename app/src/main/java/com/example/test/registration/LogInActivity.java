package com.example.test.registration;

import android.content.Intent;
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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class LogInActivity extends AppCompatActivity {
    private TextInputLayout loginEmail;
    private TextInputLayout loginPassword;
    private TextView loginTextView, resetPassword;
    private ProgressBar loginProgressbar;
    private Button loginButton;
    private FirebaseAuth loginAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Login Form");

        loginEmail = findViewById(R.id.user_login_email);
        loginPassword = findViewById(R.id.user_login_password);
        loginTextView = findViewById(R.id.register_now);
        loginProgressbar = findViewById(R.id.user_login_progressbar);
        loginButton = findViewById(R.id.user_login_button);
        resetPassword = findViewById(R.id.reset_password_intent);

        loginAuth = FirebaseAuth.getInstance();

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this, Registration.class));
            }
        });

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogInActivity.this, PasswordReset.class));
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLogin();
            }
        });
    }

    public void userLogin() {
        String email = Objects.requireNonNull(loginEmail.getEditText()).getText().toString().trim();
        String password = Objects.requireNonNull(loginPassword.getEditText()).getText().toString().trim();
        if (email.isEmpty()) {
            loginEmail.setError("Field can't be empty");
            loginEmail.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            loginEmail.setError("Please provide correct email");
            loginEmail.requestFocus();
            return;
        } else {
            loginEmail.setErrorEnabled(false);
        }
        if (password.isEmpty()) {
            loginPassword.setError("Field can't be empty");
            loginPassword.requestFocus();
            return;
        } else if (password.length() <= 6) {
            loginPassword.setError("Length should be 6");
            loginPassword.requestFocus();
            return;
        } else {
            loginPassword.setErrorEnabled(false);
        }
        loginProgressbar.setVisibility(View.VISIBLE);
        loginAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                loginProgressbar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    //startActivity(new Intent(LogInActivity.this, ItemView.class));
                    //Toast.makeText(MainActivity.this, "Successfully Login", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LogInActivity.this, "Failed Login..!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}