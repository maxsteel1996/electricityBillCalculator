package com.monitorelectricitybill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.monitorelectricitybill.model.Data;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    FloatingActionButton fab_btn;
    private RecyclerView recyclerView;
    List<Data> list=new ArrayList<>();
    private Button calculateButton;
    private EditText costPerUnit;
    private EditText calculateForDays;
    private TextView showTotalAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.home_toolbar);
        calculateButton=findViewById(R.id.btn_calculate);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Electricity App");
        fab_btn=findViewById(R.id.floatingActionButton);
        recyclerView=findViewById(R.id.recv);
        costPerUnit=findViewById(R.id.price_per_unit);
        calculateForDays=findViewById(R.id.edt_for_days);
        showTotalAmount=findViewById(R.id.total_amount);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new Recycler_View_Adapter(list,this));
        recyclerView.setLayoutManager(layoutManager);
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_Dialog();
            }
        });
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mCostPerUnit=costPerUnit.getText().toString().trim();
                if(TextUtils.isEmpty(mCostPerUnit)){
                    costPerUnit.setError("Please enter cost");
                    return;
                }
                String mCalculateForDays=calculateForDays.getText().toString().trim();
                if(TextUtils.isEmpty(mCalculateForDays)){
                    calculateForDays.setError("Please enter days");
                    return;
                }
                showTotalAmount.setText(String.valueOf(Integer.parseInt(mCostPerUnit)*Integer.parseInt(mCalculateForDays)*calculatePowerForOneDay()));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void custom_Dialog(){
        AlertDialog.Builder myDialog=new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
        View myView=inflater.inflate(R.layout.input_data,null);
        final AlertDialog dialog=myDialog.create();
        dialog.setView(myView);


        // Create the instance of ArrayAdapter
        // having the list of courses
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Constats.devicesMap.keySet().toArray());

        // set simple layout resource file
        // for each item of spinner
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);

        // Set the ArrayAdapter (ad) data on the
        // Spinner which binds data to spinner
        final Spinner type=myView.findViewById(R.id.edt_type);
        type.setAdapter(ad);

        final EditText uses=myView.findViewById(R.id.edt_uses);
        final EditText perDay=myView.findViewById(R.id.per_day);
        final EditText note=myView.findViewById(R.id.edt_note);
        final EditText power=myView.findViewById(R.id.edt_power);
        Button btn=myView.findViewById(R.id.btm_save);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mType=type.getSelectedItem().toString();
                String mUses=uses.getText().toString().trim();
                String mNote=note.getText().toString().trim();
                String mPower=power.getText().toString().trim();
                String mPerDay=perDay.getText().toString().trim();

                Double dPower=0d;
                int dayUser=0;
                int mHour=0,mMinute=0;

                if(TextUtils.isEmpty(mUses)){
                    uses.setError("Required");
                    return;
                }
                if(TextUtils.isEmpty(mPerDay)){
                    perDay.setError("Required");
                    return;
                }
                if(TextUtils.isEmpty(mPower)){
                    power.setError("Required");
                    return;
                }


                try {
                    if (mUses.contains(":")) {
                        String[] usesData = mUses.split(":");
                        mHour = Integer.parseInt(usesData[0]);
                        mMinute = Integer.parseInt(usesData[1]);
                    }else{
                    mHour = Integer.parseInt(mUses);}
                }catch (Exception e){
                    uses.setError(e.getMessage());
                    return;
                }

                try {
                    dPower = Double.parseDouble(mPower);
                }catch (Exception e){
                    power.setError(e.getMessage());
                    return;
                }
                try {
                    dayUser=Integer.parseInt(mPerDay);
                }catch (Exception e){
                    power.setError(e.getMessage());
                    return;
                }
            //String name, String description, double power, int usesHour, int usesMinutes
                Data data=new Data(mType,mNote,dPower,mHour,mMinute,Constats.devicesMap.get(mType),dayUser);
                list.add(data);
                recyclerView.refreshDrawableState();
                dialog.dismiss();
            }
        });
        dialog.show();
    }


    public double calculatePowerForOneDay(){
        double totalPower=0.0;

        for(Data d:list){
            double hour=d.getUsesHour()+(d.getUsesMinutes()/60);
            totalPower+=(hour*d.getPower());
        }
        return totalPower/1000;
    }



}