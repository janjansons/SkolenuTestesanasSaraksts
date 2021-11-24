package com.example.skolenutestesanassaraksts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;



public class ListViewAdapter extends BaseAdapter {
    ArrayList<StudentModal> arrayList;
    Context context;

    public ListViewAdapter(Context context, ArrayList<StudentModal> arrayList){
       this.arrayList = arrayList;
        this.context = context;


    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
   // private static final String TAG = "DateActivity";
   // private TextView mDisplayDate;
    //private DatePickerDialog.OnDateSetListener mDateSetListener;


    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_row, null);

            TextView number = convertView.findViewById(R.id.number);
            //number.setText(position + 1 + ".");

            TextView name = convertView.findViewById(R.id.name);
            number.setText(StudentModal.getStudentName());

            TextView mDisplayDate = (TextView)convertView.findViewById(R.id.date);
            ImageView remove = convertView.findViewById(R.id.remove);

            StudentModal studentModal = arrayList.get(position);

            number.setText(String.valueOf(StudentModal.getId()) +1 + ".");

            //name.setText(StudentModal.getStudentName());

            //mDisplayDate.setText(StudentModal.get);


           // remove.setOnClickListener(new View.OnClickListener() {
                //@Override
                //public void onClick(View view) {
               // MainActivity.removeItem(position);
               // }
           // });



        return convertView;
    }




}


