package com.symb.task.todo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createTodo extends AppCompatActivity {

    EditText task_desc;
    Button btn;
    SQLiteHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);

        btn = findViewById(R.id.save);
        task_desc = findViewById(R.id.ed1);
        db = new SQLiteHelper(this);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String task_desc_string = task_desc.getText().toString();

                if(TextUtils.isEmpty(task_desc_string)){
                    Toast.makeText(createTodo.this, "Please Enter task", Toast.LENGTH_LONG).show();
                }
                else{

                    db.addData(task_desc_string);

                    finish();
                    Intent i2 = new Intent(createTodo.this, TodoList.class);
                    startActivity(i2);
                }
            }
        });


    }

    public void onBackPressed()
    {
        //do whatever you want the 'Back' button to do
        //as an example the 'Back' button is set to start a new Activity named 'NewActivity'
        this.startActivity(new Intent(createTodo.this,MainActivity.class));

        return;
    }
}
