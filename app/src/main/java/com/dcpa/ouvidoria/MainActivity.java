package com.dcpa.ouvidoria;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText idUsuario;
    EditText assunto;
    EditText msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idUsuario = findViewById(R.id.user_id);
        assunto = findViewById(R.id.assunto);
        msg = findViewById(R.id.msg);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        ListView listview = (ListView) findViewById(R.id.lista);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.enviar) {

        } else if (id == R.id.requisicao) {
            final Context context = this;
            RequestQueue queue = Volley.newRequestQueue(context);
            String url = "https://ouvidoriacorporativa.herokuapp.com/mensagens";
            JSONObject req= new JSONObject();
            try {
                req.put("data",new Date());
                req.put("assunto", assunto.getText().toString());
                req.put("texto",msg.getText().toString());
                req.put("UsuarioId", Integer.valueOf(idUsuario.getText().toString()));
            }catch (JSONException e){
                Log.e("ouvidoria-android", e.getMessage());
            }



            JsonObjectRequest jsObjRequest = new JsonObjectRequest
                    (Request.Method.POST, url, req, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d("ouvidoria-android", response.toString());

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(context, "Deu erro!", Toast.LENGTH_LONG).show();
                            Log.e("ouvidoria-android", error.getMessage());



                        }
                    });

            queue.add(jsObjRequest);



        }
        return super.onOptionsItemSelected(item);
    }

}
