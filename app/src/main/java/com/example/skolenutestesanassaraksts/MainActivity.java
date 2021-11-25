package com.example.skolenutestesanassaraksts;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<StudentModal> arrayList;
    ListViewAdapter listViewAdapter;
    //ArrayList<String> dates;

    //ListViewAdapter adapter;

    EditText input;
    ImageView enter;
    DBHandler dbHandler;
    //DBHandler myDB;
    //ArrayList<StudentModal> studentModalArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input = findViewById(R.id.input);
        enter = findViewById(R.id.add);
        listView = (ListView)findViewById(R.id.listview);
        dbHandler = new DBHandler(this);
        arrayList = new ArrayList<>();
        loadDataInListView();
        enterStudent();


    }

    private void loadDataInListView() {
        arrayList = dbHandler.readStudents();
        listViewAdapter = new ListViewAdapter(this,arrayList);
        listView.setAdapter(listViewAdapter);

    }


    private  void enterStudent() {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if (text == null || text.length() == 0) {
                    Toast.makeText(MainActivity.this, "Ievadiet Vārdu!", Toast.LENGTH_LONG).show();
                } else {
                    dbHandler.addNewStudent(text);
                    input.setText("");
                    Toast.makeText(MainActivity.this, "Pievienots: " + text, Toast.LENGTH_LONG).show();
                    listViewAdapter.notifyDataSetChanged();
                }

            }
        });

        }


}