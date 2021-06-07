package com.example.test.registration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Registration extends AppCompatActivity {
    private TextInputLayout userRegEmail;
    private TextInputLayout userRegName;
    private TextInputLayout userRegPassword;
    private Button userRegButton;
    private RadioGroup radioGroup;
    private TextView userLoginText;
    private ProgressBar userProgress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        this.setTitle("Registration");

        userRegEmail = findViewById(R.id.user_register_email);
        userRegName = findViewById(R.id.user_register_name);
        userRegPassword = findViewById(R.id.user_register_password);
        radioGroup = findViewById(R.id.user_register_radio_group);
        userRegButton = findViewById(R.id.user_resister_button);
        userLoginText = findViewById(R.id.user_login_text);
        userProgress = findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();

        userRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticate();
            }
        });

        userLoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this, LogInActivity.class));
            }
        });

    }

    public void authenticate() {
        String email = userRegEmail.getEditText().getText().toString().trim();
        String name = userRegName.getEditText().getText().toString().trim();
        String password = userRegPassword.getEditText().getText().toString().trim();

        if (email.isEmpty()) {
            userRegEmail.setError("Field can't be empty");
            userRegEmail.requestFocus();
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            userRegEmail.setError("Please provide correct email");
            userRegEmail.requestFocus();
            return;
        } else {
            userRegEmail.setErrorEnabled(false);
        }
        if (name.isEmpty()) {
            userRegName.setError("Field can't be empty");
            userRegName.requestFocus();
            return;
        } else if (name.length() < 8) {
            userRegName.setError("Length too short!");
            userRegName.requestFocus();
            return;
        } else {
            userRegName.setErrorEnabled(false);
        }
        if (password.isEmpty()) {
            userRegPassword.setError("Field can't be empty");
            userRegPassword.requestFocus();
            return;
        } else if (password.length() <= 6) {
            userRegPassword.setError("Length should be 6");
            userRegPassword.requestFocus();
            return;
        } else {
            userRegPassword.setErrorEnabled(false);
        }
        userProgress.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                userProgress.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(Registration.this, "Successful", Toast.LENGTH_SHORT).show();
                } else if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                    Toast.makeText(Registration.this, "Error because " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registration.this, "Register Failed..!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}