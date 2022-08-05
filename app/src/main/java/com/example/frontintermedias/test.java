package com.example.frontintermedias;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        final EditText dpiText = findViewById(R.id.textDpi);
        final EditText nameText = findViewById(R.id.texName);
        final EditText emailText = findViewById(R.id.textEmail);
        final EditText passText = findViewById(R.id.textPass);
        final EditText phoneText = findViewById(R.id.textPhone);
        TextView msgFinal = findViewById(R.id.tv_response);

        Button btnRegister = findViewById(R.id.button2);

        btnRegister.setOnClickListener(view -> {
            int dpi = Integer.parseInt(dpiText.getText().toString().trim());
            String name = nameText.getText().toString().trim();
            String email = emailText.getText().toString().trim();
            String phone = phoneText.getText().toString().trim();
            String pass = passText.getText().toString().trim();

            if ( !TextUtils.isEmpty(name)) {
                // User user = new User(dpi, name, email, phone, pass);
                HashMap<String, Object> object = new HashMap<>();

                object.put("dpi", dpi);
                object.put("name_user", name);
                object.put("phone", phone);
                object.put("email", email);
                object.put("pass", pass);

                sendPost(object);
            }
        });
    }

    public void sendPost(HashMap<String, Object> user) {
        RetrofitClient.getInstance().getMyApi().postUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NotNull Call<User> call, @NotNull Response<User> response) {
                // showResponse(response.body().toString());
                System.out.println("Hola");
                Toast.makeText(getApplicationContext(), "Post desde api " + response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(@NotNull Call<User> call, @NotNull Throwable t) {
                Toast.makeText(getApplicationContext(), "No fue posible", Toast.LENGTH_LONG).show();
            }
        });
    }

//    public void showResponse(String res) {
//        if (msgFinal.getVisibility() == View.GONE) {
//            msgFinal.setVisibility(View.VISIBLE);
//        }
//        msgFinal.setText(res);
//    }
}