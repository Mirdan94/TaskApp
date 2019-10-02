package com.taskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    EditText editTitle, editDesc;
    private String hint = "Fill in";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        editTitle = findViewById(R.id.editTitle);
        editDesc = findViewById(R.id.editDesc);
        textView = findViewById(R.id.error_textView);
    }

    public void onClick(View view) throws EmptyException {
        try {
        if(editTitle.getText().toString().isEmpty() || editDesc.getText().toString().isEmpty()){
            throw new EmptyException();
        } else {
            String title = editTitle.getText().toString().trim();
            String desc = editDesc.getText().toString().trim();
            Task task = new Task(title, desc);
            Intent intent = new Intent();
            intent.putExtra("task", task);
            setResult(RESULT_OK, intent);
            finish();
        }
        } catch (EmptyException e){
            editTitle.setHint("Fill in");
            editDesc.setHint("Fill in");
        }
    }
}
