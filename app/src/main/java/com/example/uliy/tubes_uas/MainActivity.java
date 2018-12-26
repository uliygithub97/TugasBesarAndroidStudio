package com.example.uliy.tubes_uas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataHelper dbHelper;
    EditText edtEmail, edtPassword;
    Button buttonLogin, buttonregis;
    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonregis = findViewById(R.id.buttonregis);
        dbHelper = new DataHelper(this);
        sessionManagement = new SessionManagement(this);

        // Handle Click Event
        if(sessionManagement.isLoggedIn()) {
            goToActivity();
        }
        //Untuk Cek Username Passsword
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CekLogin()){
                    if (cekValidasi()) {
                        Toast.makeText(getApplicationContext(),"Benar",Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Home.class);
                        sessionManagement.createLoginSession(edtEmail.getText().toString(),edtPassword.getText().toString());

                        startActivity(i);
                        finish();
                    }
                }

                else{
                    Toast.makeText(getApplicationContext(),"Anda belum terdaftar",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //menuju class register
        buttonregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Register.class);
                startActivity(i);
                finish();
            }
        });
    }


    public boolean CekLogin(){
        SessionManagement sessionManagement = new SessionManagement(this);
        //mengambil emai password yg sudah terdaftar di database
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user WHERE username ='"+edtEmail.getText().toString()+"' and password='"+edtPassword.getText().toString()+"'", null);

        //sessionManagement.tampilkan(username.getText().toString(), cursor.getString(1).toString(), cursor.getString(2).toString(), password.getText().toString());
        sessionManagement.createLoginSession(edtEmail.getText().toString(),edtPassword.getText().toString());

        if(cursor.getCount()>0) return true;
        else return false;
    }

    //cek validasi untuk mengisikan username password
    private boolean cekValidasi()
    {
        if (edtEmail.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Username harus diisi", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if (edtPassword.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Password harus diisi", Toast.LENGTH_SHORT).show();
            return false;
        }

        else
        {
            return true;
        }
    }
    //Login setelah berhasil registrasi menuju class Home
    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(),
                Home.class);
        startActivity(mIntent);
    }


}

