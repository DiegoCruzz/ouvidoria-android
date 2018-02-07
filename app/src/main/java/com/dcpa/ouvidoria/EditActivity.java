package com.dcpa.ouvidoria;

/**
 * Created by mayelli on 06/02/2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText assunto;
    private EditText texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        assunto = (EditText) findViewById(R.id.assunto);
        texto = (EditText) findViewById(R.id.msg);

        Intent intent = getIntent();
        assunto.setText(intent.getStringExtra("assunto"));
        texto.setText(intent.getStringExtra("texto"));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.enviar) {
            Intent intent = new Intent();
            intent.putExtra("assunto", assunto.getText().toString());
            intent.putExtra("texto", texto.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}