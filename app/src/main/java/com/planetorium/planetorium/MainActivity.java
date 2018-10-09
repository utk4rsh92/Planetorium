package com.planetorium.planetorium;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity

{
    public static final String DESCRIPTION = "desc";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Model> modelList;
    private RequestQueue requestQueue;
    private PlanetAdapter planetAdapter;
    private ProgressDialog progressDialog;
    TextView tvTitlePlanet;
    private boolean isConnected = false;
    private NetworkChangeReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
      //  recyclerView.setHasFixedSize(true);
       // layoutManager = new LinearLayoutManager(this);
      //  requestWindowFeature(Window.
        //FEATURE_NO_TITLE);
        //  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        //     WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        requestQueue = Volley.newRequestQueue(this);
        tvTitlePlanet = (TextView)findViewById(R.id.tv_planetorium) ;
        Typeface qwe = Typeface.createFromAsset(getAssets(),"fonts/Mayan.ttf");
        tvTitlePlanet.setTypeface(qwe);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCanceledOnTouchOutside(false);
      //

        modelList = new ArrayList<>();
        checkInternetConenction();

    }


    private void checkInternetConenction() {
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();
        registerReceiver(receiver, filter);

    }


    public class NetworkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, final Intent intent) {

          //  Log.v(LOG_TAG, "Receieved notification about network status");
            //isNetworkAvailable(context);

            isNetworkAvailable(context);
        }

  /**  private void checkInternetConenction() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
           // changeTextStatus(true);
            progressDialog.show();
            jsonParse();
        } else {
         //   changeTextStatus(false);
            setContentView(R.layout.activity_disconnect);
            progressDialog.dismiss();
          //  Toast.makeText(getApplicationContext(),""+networkInfo,Toast.LENGTH_SHORT).show();



            Snackbar.make(findViewById(android.R.id.content), "Internet disconnected..!", Snackbar.LENGTH_LONG)
                  //  .setAction("Submit", mOnClickListener)
                    .setActionTextColor(Color.RED)
                    .show();
        }


    }
**/



      private boolean isNetworkAvailable(Context context) {
          ConnectivityManager connectivity = (ConnectivityManager)
                  context.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null) {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null) {
                  for (int i = 0; i < info.length; i++) {
                      if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                          if(!isConnected){
                              progressDialog.show();
                              jsonParse();
                              //Log.v(LOG_TAG, "Now you are connected to Internet!");
                            //  networkStatus.setText("Now you are connected to Internet!");
                              isConnected = true;
                              //do your processing here ---
                              //if you need to post any data to the server or get status
                              //update from the server
                          }
                          return true;
                      }
                  }
              }
              else{
                  setContentView(R.layout.activity_disconnect);
                  progressDialog.dismiss();
              }
          }

         // Log.v(LOG_TAG, "You are not connected to Internet!");
        //  networkStatus.setText("You are not connected to Internet!");
          isConnected = false;
          return false;
      }

  }


        private void jsonParse() {
        //new api on 9 October 2018
        String url = "https://api.myjson.com/bins/11p1yk";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("planets");
                            for (int i=0;i<jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Model modeldata = new Model(jsonObject.getString("name"), jsonObject.getString("details"), jsonObject.getString("description"),
                                        jsonObject.getString("imageurl"),jsonObject.getString("fact1"),jsonObject.getString("fact2"),jsonObject.getString("fact3"),
                                        jsonObject.getString("fact4"),jsonObject.getString("fact5"),jsonObject.getString("fact6"),jsonObject.getString("fact7"));
                                modelList.add(modeldata);
                            }
                            progressDialog.dismiss();
                            PlanetAdapter planetAdapter = new PlanetAdapter(modelList, getApplicationContext());
                            recyclerView.setAdapter(planetAdapter);
                        //    planetAdapter.setOnItemClickListener(MainActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue.add(request);

    }

}
