package id.aryad.sipasar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditProfilActivity extends AppCompatActivity {

    private EditText editnama, editalamat, editpassword;
    private Button buttonupdate, buttonbatal;
    private ImageView editgambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);

        editnama = (EditText) findViewById(R.id.editnama);
        editalamat = (EditText) findViewById(R.id.editalamat);
        editpassword = (EditText) findViewById(R.id.editpassword);

        buttonupdate = (Button) findViewById(R.id.buttonupdate);
        buttonbatal = (Button) findViewById(R.id.buttonbatal);

        editgambar = (ImageView) findViewById(R.id.editgambar);

        Intent getdata = getIntent();
        String editdata_password =  getdata.getStringExtra("password");
        String editdata_nama =  getdata.getStringExtra("nama");
        String editdata_alamat =  getdata.getStringExtra("alamat");
        int editdata_foto =  getdata.getIntExtra("foto", 0);

        editnama.setText(editdata_nama);
        editalamat.setText(editdata_alamat);
        editpassword.setText(editdata_password);
        editgambar.setImageResource(editdata_foto);
    }
}