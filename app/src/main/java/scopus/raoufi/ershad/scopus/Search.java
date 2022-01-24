package scopus.raoufi.ershad.scopus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import scopus.raoufi.ershad.scopus.Model.Model;

public class Search extends AppCompatActivity {
    String query = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().hide();


        ImageView imageView = (ImageView) findViewById(R.id.imgBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });

        final EditText edtName = (EditText) findViewById(R.id.edtCreator);
        final EditText edtDate = (EditText) findViewById(R.id.edtDate);
        final EditText edtCity = (EditText) findViewById(R.id.edtCity);
        final EditText edtCountry = (EditText) findViewById(R.id.edtCountry);
        final EditText edtPage = (EditText) findViewById(R.id.edtPage);
        final EditText edtKey = (EditText) findViewById(R.id.edtKey);
        ImageView img = (ImageView) findViewById(R.id.imgAccept);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query = "";
                if (edtCountry.getText().length() > 0) {
//            edtName.setText(edtName.getText().replaceAll(" ", "%20"));
                    query += "AFFILCOUNTRY(" + edtCountry.getText() + ")";
                }

                if (edtKey.getText().length() > 0) {
//            edtKey.setText(edtKey.getText().replace(" ", "%20"));
                    query += "KEY(" + edtKey.getText() + ")";
                }

                if (edtName.getText().length() > 0) {
//            edtName.setText(edtName.replaceAll(" ", "%20"));
                    query += "AUTHOR-NAME(" + edtName.getText() + ")";
                }
                if (edtCity.getText().length() > 0) {
//            edtCity.setText(edtCity.getText().replaceAll(" ", "%20"));
                    query += "AFFILCITY(" + edtCity.getText() + ")";
                }
                if (edtPage.getText().length() > 0) {
                    query += "PAGES(" + edtPage.getText() + ")";
                }
                if (edtDate.getText().length() > 0) {
                    query += "AFFILORG(" + edtDate.getText() + ")";
                }
                if (query.length() > 3) {
                    Intent intent = new Intent(Search.this, SearchResult.class);
                    query =  query.replaceAll(" ","%20");
                    intent.putExtra("query", query);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), query, Toast.LENGTH_LONG).show();
                } else {
                    ShowError(Search.this);
                }
            }
        });

    }
    public static void ShowError(Context ctx){
        Toast t = new Toast(ctx);
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        View v2 = inflater.inflate(R.layout.error,null);
        t.setView(v2);
        t.setGravity(Gravity.CENTER, 0, 0);
        t.setDuration(Toast.LENGTH_SHORT);
        t.show();
    }
}
