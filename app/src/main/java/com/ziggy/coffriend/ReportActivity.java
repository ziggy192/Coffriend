package com.ziggy.coffriend;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        getSupportActionBar().setTitle("Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner reportType = findViewById(R.id.spinnerReport);
        final Spinner reportPerson = findViewById(R.id.personReport);

        List<String> listType = new ArrayList<>();
        listType.add("Event");
        listType.add("Host");
        listType.add("Person");

        List<String> listPerson = new ArrayList<>();
        listPerson.add("John Doe");
        listPerson.add("Jane Doe");
        listPerson.add("Jackson Martinez");
        listPerson.add("Martin");

        ArrayAdapter adapterType = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listType);
        ArrayAdapter adapterPerson = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listPerson);

        reportType.setAdapter(adapterType);
        reportPerson.setAdapter(adapterPerson);

        reportType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 2){
                    reportPerson.setVisibility(View.VISIBLE);
                } else {
                    reportPerson.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void clickReport(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("");
        builder.setMessage("We received your report. We will check it soon!");
        builder.setNegativeButton("FINISH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
