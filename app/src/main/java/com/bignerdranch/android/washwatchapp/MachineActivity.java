package com.bignerdranch.android.washwatchapp;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Akasha on 5/9/17.
 */

public class MachineActivity extends AppCompatActivity implements WashDialogFragment.WashDialogListener {

    String diaTitle = "SELECT SOMETHING";
    WashInProgress washInProgress;
    String machineNum = WashDialogFragment.machineNumberSelection;
    String washCycle =  WashDialogFragment.washCycleSelection;
    String tenantPhone = WashDialogFragment.tenantPhoneNumber;

    private static final String DIALOG_TITLE = "SELECT SOMETHING";

    @BindView(R.id.selectMachine) Button selectMachine;
    @BindView(R.id.machineOneClock) TextView machOneClock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine);

        ButterKnife.bind(this);

        selectMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDialog();
            }
        });

        washInProgress = new WashInProgress(machineNum, washCycle, tenantPhone);
    }


    void showDialog() {
        FragmentManager manager = getSupportFragmentManager();
        DialogFragment newFragment = new WashDialogFragment();
        newFragment.show(manager, DIALOG_TITLE);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // User touched the dialog's positive button
        Log.i("FragmentAlertDialog", "Positive click!");
        Toast.makeText(getApplicationContext(), WashDialogFragment.machineNumberSelection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // User touched the dialog's negative button
        Log.i("FragmentAlertDialog", "Negative click!");
        Toast.makeText(getApplicationContext(), "Transaction Cancelled", Toast.LENGTH_SHORT).show();

    }





}
