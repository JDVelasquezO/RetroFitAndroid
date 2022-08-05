package com.example.frontintermedias;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.HashMap;

public class Assignment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        final EditText dpiText = findViewById(R.id.textDPIAssignment);
        final EditText codeText = findViewById(R.id.textCodeCourse);
        Button btnAssignment = findViewById(R.id.buttonAssign);

        btnAssignment.setOnClickListener(view -> {
            int dpi = Integer.parseInt(dpiText.getText().toString().trim());
            int course = Integer.parseInt(codeText.getText().toString().trim());

            HashMap<String, Object> object = new HashMap<>();
            object.put("dpi_user", dpi);
            object.put("code_course", course);

            sendPost(object);
        });
    }

    public void sendPost(HashMap<String, Object> assignment) {
        RetrofitClient.getInstance().getMyApi().postAssignment(assignment).enqueue(new Callback<Assign>() {
            @Override
            public void onResponse(Call<Assign> call, Response<Assign> response) {
                assert response.body() != null;
                Toast.makeText(getApplicationContext(), "Post desde api " + response.body().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Assign> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "No fue posible", Toast.LENGTH_LONG).show();
            }
        });
    }
}