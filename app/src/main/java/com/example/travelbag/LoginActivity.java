package com.example.travelbag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText email, password, code;
    TextView status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        code = findViewById(R.id.et_code);
        status = findViewById(R.id.login_info);
    }

    public static boolean isValidEmail(CharSequence email){
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    public static boolean isValidCode(CharSequence email){
        return (Patterns.PHONE.matcher(email).matches());
    }

    public void Login(View view) {
        String emailStr = email.getText().toString().trim();
        String passStr = password.getText().toString().trim();
        if(!isValidEmail(emailStr)){
            status.setText("Email yang anda masukan salah");
        }else if(emailStr.equals("") || TextUtils.isEmpty(emailStr)){
            status.setText("Email tidak boleh kosong");
        }else if(passStr.equals("") || TextUtils.isEmpty(passStr)){
            status.setText("Password tidak boleh kosong");
        }else if(code.getText().length() < 4){
            status.setText("Kode yang dimasukan kurang dari 4 digit");
        }else if(!isValidCode(code.getText().toString().trim())){
            status.setText("Kode yang dimasukan tidak valid");
        }else if(TextUtils.isEmpty(code.getText().toString().trim())){
            status.setText("Kode login harus dimasukan dengan angka");
        }else{
            if(isValidEmail(emailStr) && !TextUtils.isEmpty(passStr) && isValidCode(code.getText().toString().trim())){
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        }
    }
}
