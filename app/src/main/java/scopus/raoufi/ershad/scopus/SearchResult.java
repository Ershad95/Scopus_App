package scopus.raoufi.ershad.scopus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
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
import scopus.raoufi.ershad.scopus.Model.Entry;
import scopus.raoufi.ershad.scopus.Model.Model;

public class SearchResult extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Entry> entries;
    private AlertDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        getSupportActionBar().hide();
        recyclerView = (RecyclerView) findViewById(R.id.result);
        Intent _getData = getIntent();

        String _q = _getData.getStringExtra("query");
        ImageView imgBack = (ImageView)findViewById(R.id.imgBack);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SearchResult.this,Search.class));
                finish();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.progress_dialog, null);
        builder.setView(view);
        builder.setCancelable(true);
        progressDialog = builder.create();
        progressDialog.getWindow().getAttributes().windowAnimations = R.style.ProgressDialog;


        if (!_q.isEmpty()) {
            try {
                GetData(_q);
            } catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

    }

    public void GetData(final String q) {
        progressDialog.show();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                final String URL = "http://api.elsevier.com/content/search/scopus";
                try {
                    HttpUrl url = HttpUrl.parse(URL);

                    HttpUrl.Builder urlBuilder = url.newBuilder();
                    urlBuilder.setQueryParameter("query", q);
                    urlBuilder.setQueryParameter("apiKey", "a1e36891226b10bb028be191604f3f3a");

                    OkHttpClient.Builder b = new OkHttpClient.Builder();
                    b.connectTimeout(30, TimeUnit.SECONDS);
                    b.writeTimeout(30, TimeUnit.SECONDS);
                    b.readTimeout(30, TimeUnit.SECONDS);
                    OkHttpClient client = b.build();

                    Request.Builder requestBuilder = new Request.Builder();
                    requestBuilder.url(urlBuilder.build());


                    Call call = client.newCall(requestBuilder.build());
                    Response response = call.execute();

                    String s = null;
                    try {
                        s = response.body().string();
                    } catch (final IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                                progressDialog.hide();
                            }
                        });
                    }
                    ObjectMapper mapper = new ObjectMapper();
                    Model model = null;
                    try {
                        model = mapper.readValue(s, Model.class);
                    } catch (final IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                                progressDialog.dismiss();
                                progressDialog.hide();
                            }
                        });
                    }
                    assert model != null;

                    if (model.getSearchResults().getEntry().size() != 0) {
                        entries = new ArrayList<>();
                        for (int i = 0; i < model.getSearchResults().getEntry().size(); i++) {
                            entries.add(model.getSearchResults().getEntry().get(i));
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressDialog.dismiss();
                                progressDialog.hide();
                                //Choose Size And Layout For RecycleView
                                recyclerView.setHasFixedSize(true);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));//show Item in One Column
                                //pass Data To Recycler View
                                recyclerView.setAdapter(new SearchResult_Adapter(entries, getApplicationContext()));


                            }
                        });

                    } else {
                        Toast.makeText(SearchResult.this, "0 Result !!!", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();
                        progressDialog.hide();
                    }

                } catch (final Exception ex) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                            progressDialog.dismiss();
                            progressDialog.hide();
                        }
                    });

                }
            }
        });
        thread.start();
    }
}
