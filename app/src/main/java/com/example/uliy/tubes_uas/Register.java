package com.example.uliy.tubes_uas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    Button  btnSignUp;
    DataHelper dbHelper;
    EditText edit_Email, edit_Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnSignUp = (Button) findViewById(R.id.buttonreg);
        dbHelper = new DataHelper(this);
        edit_Email = (EditText) findViewById(R.id.editEmail);
        edit_Password = (EditText)findViewById(R.id.editPassword);

        //input email password database
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (cekValidasi()) {
                if (isValidEmail(edit_Email.getText().toString().trim())){
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into user(username, password) values('" + edit_Email.getText().toString() + "','" + edit_Password.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(i);
                    finish();

                }
                else{
                    edit_Email.setError("Email tidak valid");
                }

            }
            //}
        });

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getApplicationContext(), Login.class);
//                startActivity(i);
//            }
//        });

    }

//    private boolean cekValidasi()
//    {
//        else if (edt_username.getText().toString().equals(""))
//        {
//            Toast.makeText(getApplicationContext(), "Username harus diisi", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        else if (edt_password.getText().toString().equals(""))
//        {
//            Toast.makeText(getApplicationContext(), "Password harus diisi", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        else
//        {
//            return true;
//        }
//    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
