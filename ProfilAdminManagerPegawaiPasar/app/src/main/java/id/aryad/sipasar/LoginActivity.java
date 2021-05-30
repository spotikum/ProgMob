package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText inputusername, inputPassword ;
    private Button btnLogin;
    private String i_username, i_password;
    private ArrayList <ModelArrayList>IniArrayList;
    private Boolean Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputusername = (EditText) findViewById(R.id.inputusername);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        IniArrayList = new ArrayList<>();

        IniArrayList.add(new ModelArrayList(1, "aryaadmin", "pass123", "admin", 1, "spot", "Jln. Kenangan Indah No.1", R.drawable.profile));
        IniArrayList.add(new ModelArrayList(2, "aryamanager", "pass123", "manager", 1, "mocha", "Jln. Kenangan Mantan No.2", R.drawable.profile));
        IniArrayList.add(new ModelArrayList(3, "aryapegawai", "pass123", "pegawai", 1, "arya", "Jln. Kenangan Mantan No.7", R.drawable.profile));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i_username = inputusername.getText().toString();
                i_password = inputPassword.getText().toString();

                if(i_username.equals("") || i_password.equals("")){
                    Toast.makeText(getApplicationContext(), "hgaksjfbkajshta", Toast.LENGTH_LONG).show();
                }else {
                    for (ModelArrayList login:IniArrayList){
                        if (login.username.equals(i_username)){
                            if (login.password.equals(i_password)){
                                if (login.status==1){
                                    Intent IntenLogin = new Intent(LoginActivity.this, MainActivity.class);
                                    IntenLogin.putExtra("id_pegawai", login.id_pegawai);
                                    IntenLogin.putExtra("username", login.username);
                                    IntenLogin.putExtra("password", login.password);
                                    IntenLogin.putExtra("role", login.role);
                                    IntenLogin.putExtra("status", login.status);
                                    IntenLogin.putExtra("nama", login.nama);
                                    IntenLogin.putExtra("alamat", login.alamat);
                                    IntenLogin.putExtra("foto", login.foto);
                                    startActivity(IntenLogin);
                                    Toast.makeText(getApplicationContext(), "Welcome " +login.nama, Toast.LENGTH_SHORT).show();
                                    break;
                                }else{
                                    Toast.makeText(getApplicationContext(), "Akun tidak aktif", Toast.LENGTH_LONG).show();
                                    break;
                                }
                            }else {
                                Status=false;
                                Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_LONG).show();
                                break;
                            }
                        }else {
                            Status = true;
                        }
                    }if (Status == true){
                        Toast.makeText(getApplicationContext(), "Akun tidak ditemukan", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


    }
}