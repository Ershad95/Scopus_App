package scopus.raoufi.ershad.scopus;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import scopus.raoufi.ershad.scopus.Model.Model;

public class Compare extends AppCompatActivity {
    private AlertDialog progressDialog = null;
    LinearLayout parent_c1;
    LinearLayout parent_c2;
    LinearLayout parent;
    TextView txtC1;
    TextView txtC2;
    TextView txtCountry1;
    TextView txtCountry2;
    ImageView imgCountry1;
    ImageView imgCountry2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        getSupportActionBar().hide();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.progress_dialog, null);
        builder.setView(view);
        builder.setCancelable(true);
        progressDialog = builder.create();
        progressDialog.getWindow().getAttributes().windowAnimations = R.style.ProgressDialog;

        final Spinner spinner1 = (Spinner) findViewById(R.id.country1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.country2);

        parent_c1 = (LinearLayout) findViewById(R.id.parent_country1);
        parent_c2 = (LinearLayout) findViewById(R.id.parent_country2);
        parent = (LinearLayout) findViewById(R.id.parent);

        imgCountry1 = (ImageView) findViewById(R.id.imgCountry1);
        imgCountry2 = (ImageView) findViewById(R.id.imgCountry2);


        txtC1 = (TextView) findViewById(R.id.txtC1);
        txtC2 = (TextView) findViewById(R.id.txtC2);

        txtCountry1 = (TextView) findViewById(R.id.txtCountry1);
        txtCountry2 = (TextView) findViewById(R.id.txtCountry2);

        Button Compare = (Button) findViewById(R.id.btnCompare);

        Compare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String c1 = String.valueOf(spinner1.getSelectedItem());
                String c2 = String.valueOf(spinner2.getSelectedItem());

                GetData(c1, c2);
            }
        });


        ImageView imageView = (ImageView)findViewById(R.id.imgBack);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });
    }

    public void GetData(final String c1, final String c2) {
        progressDialog.show();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                final String URL = "http://api.elsevier.com/content/search/scopus";
                try {
                    HttpUrl url = HttpUrl.parse(URL);
                    HttpUrl.Builder urlBuilder = url.newBuilder();
                    urlBuilder.setQueryParameter("query", "AFFILCOUNTRY(" + c1 + ")");
                    urlBuilder.setQueryParameter("apiKey", "a1e36891226b10bb028be191604f3f3a");
                    OkHttpClient.Builder b = new OkHttpClient.Builder();

                    b.connectTimeout(30, TimeUnit.SECONDS);
                    b.writeTimeout(30, TimeUnit.SECONDS);
                    b.readTimeout(30, TimeUnit.SECONDS);

                    OkHttpClient client = b.build();

                    Request.Builder requestBuilder = new Request.Builder();
                    requestBuilder.url(urlBuilder.build());
                    Call call = client.newCall(requestBuilder.build());
                    Response response = null;
                    try {
                        response = call.execute();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    String s1 = null;
                    String s2 = null;
                    try {
                        s1 = response.body().string();
                        urlBuilder.setQueryParameter("query", "AFFILCOUNTRY(" + c2 + ")");
                        urlBuilder.setQueryParameter("apiKey", "a1e36891226b10bb028be191604f3f3a");
                        b = new OkHttpClient.Builder();

                        b.connectTimeout(30, TimeUnit.SECONDS);
                        b.writeTimeout(30, TimeUnit.SECONDS);
                        b.readTimeout(30, TimeUnit.SECONDS);

                        client = b.build();

                        requestBuilder = new Request.Builder();
                        requestBuilder.url(urlBuilder.build());
                        call = client.newCall(requestBuilder.build());
                        response = call.execute();
                        s2 = response.body().string();
                    } catch (final IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    ObjectMapper mapper = new ObjectMapper();
                    Model model;
                    String result = "";
                    String result2 = "";
                    try {
                        model = mapper.readValue(s1, Model.class);
                        result = model.getSearchResults().getOpensearchTotalResults();
                        model = mapper.readValue(s2, Model.class);
                        result2 = model.getSearchResults().getOpensearchTotalResults();
                    } catch (final IOException e) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    final String finalResult = result;
                    final String finalResult2 = result2;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressDialog.dismiss();
                            progressDialog.hide();
                            txtCountry1.setText(c1);
                            txtCountry2.setText(c2);

                            parent.setVisibility(View.VISIBLE);
                            if (Integer.valueOf(finalResult) > Integer.valueOf(finalResult2)) {
                                parent_c1.setBackgroundResource(R.drawable.back_green);
                                parent_c2.setBackgroundResource(R.drawable.back_red);
                            } else if (Integer.valueOf(finalResult) < Integer.valueOf(finalResult2)) {
                                parent_c2.setBackgroundResource(R.drawable.back_green);
                                parent_c1.setBackgroundResource(R.drawable.back_red);

                            }
                                if (c1.equals("Iran")) {
                                    imgCountry1.setImageResource(R.drawable.iran);
                                } else if (c1.equals("Spain")) {
                                    imgCountry1.setImageResource(R.drawable.spain);

                                } else if (c1.equals("Sweden")) {
                                    imgCountry1.setImageResource(R.drawable.sweden);

                                } else if (c1.equals("Germany")) {
                                    imgCountry1.setImageResource(R.drawable.germany);
                                } else if (c1.equals("Canada")) {
                                    imgCountry1.setImageResource(R.drawable.ca);
                                } else if (c1.equals("Russia")) {
                                    imgCountry1.setImageResource(R.drawable.ru);

                                }

                                if (c2.equals("Iran")) {
                                    imgCountry2.setImageResource(R.drawable.iran);
                                } else if (c2.equals("Spain")) {
                                    imgCountry2.setImageResource(R.drawable.spain);

                                } else if (c2.equals("Sweden")) {
                                    imgCountry2.setImageResource(R.drawable.sweden);

                                } else if (c2.equals("Germany")) {
                                    imgCountry2.setImageResource(R.drawable.germany);
                                } else if (c2.equals("Canada")) {
                                    imgCountry2.setImageResource(R.drawable.ca);
                                } else if (c2.equals("Russia")) {
                                    imgCountry2.setImageResource(R.drawable.ru);

                                }
                            DecimalFormat df = new DecimalFormat("###,###,###");
                            txtC1.setText(df.format(Integer.parseInt(String.valueOf(finalResult))));
                            txtC2.setText(df.format(Integer.parseInt(String.valueOf(finalResult2))));
                            }



                    });

                } catch (final Exception ex) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        });
        thread.start();
    }
}
