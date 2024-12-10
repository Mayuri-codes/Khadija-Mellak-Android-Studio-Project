package com.example.taskup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    TextView tvLogin;
    TextView tvPassword;
    EditText etLogin;
    EditText etPassword;
    String login;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        loginButton=findViewById(R.id.loginButton);

        etLogin=findViewById(R.id.username);
        etPassword=findViewById(R.id.password);



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login= etLogin.getText().toString();
                if (login.isEmpty() || etPassword.length() == 0){
                    Toast.makeText(MainActivity.this,"Empty Input !",Toast.LENGTH_SHORT).show();
                }

                else if (!etPassword.getText().toString().equals("1234")) {
                    Toast.makeText(MainActivity.this,"Incorrect Password! Retry", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(MainActivity.this, "Hello "+login+" !",Toast.LENGTH_SHORT).show();
                    intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // Not necessary, but can help in some cases
                    startActivity(intent);

                }
            }
        });
    }
}