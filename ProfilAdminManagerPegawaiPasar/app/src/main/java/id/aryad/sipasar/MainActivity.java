package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView nama, alamat, jabatan, status ;
    private Button buttonedit, buttonlogout;
    private ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = (TextView) findViewById(R.id.nama);
        alamat = (TextView) findViewById(R.id.alamat);
        jabatan = (TextView) findViewById(R.id.jabatan);
        status = (TextView) findViewById(R.id.status);

        buttonedit = (Button) findViewById(R.id.buttonedit);
        buttonlogout = (Button) findViewById(R.id.buttonlogout);

        gambar = (ImageView) findViewById(R.id.gambar);

        Intent getdata = getIntent();
        int getdata_id_pegawai =  getdata.getIntExtra("id_pegawai", 0);
        String getdata_username =  getdata.getStringExtra("username");
        String getdata_password =  getdata.getStringExtra("password");
        String getdata_role =  getdata.getStringExtra("role");
        int getdata_status =  getdata.getIntExtra("status", 0);
        String getdata_nama =  getdata.getStringExtra("nama");
        String getdata_alamat =  getdata.getStringExtra("alamat");
        int getdata_foto =  getdata.getIntExtra("foto", 0);

        nama.setText(getdata_nama);
        alamat.setText(getdata_alamat);
        jabatan.setText(getdata_role);
        status.setText("Aktif");
        gambar.setImageResource(getdata_foto);

        buttonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Edit = new Intent(MainActivity.this, EditProfilActivity.class);
                Edit.putExtra("nama", getdata_nama);
                Edit.putExtra("alamat", getdata_alamat);
                Edit.putExtra("password", getdata_password);
                Edit.putExtra("foto", getdata_foto);
                startActivity((Edit));
            }
        });

        buttonlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Logout = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(Logout);
            }
        });
    }

}