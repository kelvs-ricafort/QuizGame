package com.newtechieblog.wordpress.views.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {
    EditText editTextEmail;
    Button btnContinue;
    ProgressBar progressBarForgotPass;
    FirebaseAuth auth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextEmail = findViewById(R.id.editTextEmailForgot);
        btnContinue = findViewById(R.id.btnContinue);
        progressBarForgotPass = findViewById(R.id.progressBarForgotPass);

        progressBarForgotPass.setVisibility(View.INVISIBLE);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = editTextEmail.getText().toString();
                reset_password(userEmail);
            }
        });
    }

    public void reset_password(String userEmail) {
        progressBarForgotPass.setVisibility(View.VISIBLE);

        auth.sendPasswordResetEmail(userEmail).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(ForgotPasswordActivity.this, "We have sent a Reset Password Email to your Email Address", Toast.LENGTH_LONG).show();
                    btnContinue.setClickable(false);
                    progressBarForgotPass.setVisibility(View.INVISIBLE);
                    finish();
                } else {
                    Toast.makeText(ForgotPasswordActivity.this, "Sorry there is a problem, please try again later", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}