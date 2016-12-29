package com.example.ravi.customlistviewwithcheckbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
     ListView listView;
    ArrayAdapter<String> stringArrayAdapter;
    ArrayList<String> stringArrayList;
    public static final String Root_url ="http://api.androidhive.info";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stringArrayList=new ArrayList<>();
        listView= (ListView) findViewById(R.id.list);

         stringArrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,stringArrayList);
        listView.setAdapter(stringArrayAdapter);
        insertUser();
    }

    private void insertUser() {


        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(Root_url).build();

        DetailsAPI api = adapter.create(DetailsAPI.class);
             api.mymeth(new Callback<JsonArray>() {
                 @Override
                 public void success(JsonArray jsonElements, Response response) {

                     for (int i = 0; i < jsonElements.size(); i++) {

                         JsonObject jsonObject= jsonElements.get(i).getAsJsonObject();
                                      String title= jsonObject.get("title").getAsString();

                                       stringArrayList.add(title);


                     }



                 }

                 @Override
                 public void failure(RetrofitError error) {

                     Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                 }
             });

    }
}
