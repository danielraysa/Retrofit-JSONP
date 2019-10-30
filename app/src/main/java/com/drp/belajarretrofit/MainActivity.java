package com.drp.belajarretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView konten;
    PostAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APIService service = RetrofitClient.getRetrofitInstance().create(APIService.class);

        Call<List<Post>> call = service.getAllPosts();

        //Execute the request asynchronously//

        call.enqueue(new Callback<List<Post>>() {

            @Override
            //Handle a successful response//
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                loadDataList(response.body());
            }

            @Override
            //Handle execution failures//
            public void onFailure(Call<List<Post>> call, Throwable throwable) {

                //If the request fails, then display the following toast//
                Toast.makeText(MainActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Display the retrieved data as a list//
    private void loadDataList(List<Post> usersList) {

        //Get a reference to the RecyclerView//
        konten = findViewById(R.id.myRecyclerView);
        myAdapter = new PostAdapter(usersList);

        //Use a LinearLayoutManager with default vertical orientation//
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        konten.setLayoutManager(layoutManager);

        //Set the Adapter to the RecyclerView//
        konten.setAdapter(myAdapter);
    }


}
