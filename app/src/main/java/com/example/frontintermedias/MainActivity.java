package com.example.frontintermedias;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnLogin, btnCourses;
    ListView superListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // addListenerOnButton();

        superListView = findViewById(R.id.superListView);
        getSuperHeroes();
    }

    private void getSuperHeroes() {
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getUsers();
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results res = response.body();
                System.out.println(res);
                List<User> users = res.getUsers();
                String[] nameUsers = new String[users.size()];

                for ( int i = 0; i < users.size(); i++ ) {
                    nameUsers[i] = users.get(i).getName();
                }

                superListView.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, nameUsers));
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }
        });
    }

//    public void addListenerOnButton() {
//        final Context context = this;
//
//        btnLogin = findViewById(R.id.button2);
//        btnLogin.setOnClickListener(view -> {
//            Intent intent = new Intent(context, Login.class);
//            startActivity(intent);
//        });
//
//        btnCourses = findViewById(R.id.button3);
//        btnCourses.setOnClickListener(view -> {
//            Intent intent = new Intent(context, ViewCourses.class);
//            startActivity(intent);
//        });
//    }
}