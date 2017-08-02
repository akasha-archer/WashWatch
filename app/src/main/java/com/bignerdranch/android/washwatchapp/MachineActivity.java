package com.bignerdranch.android.washwatchapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Akasha on 5/9/17.
 */

public class MachineActivity extends AppCompatActivity implements WashDialogFragment.WashDialogListener {

    private String diaTitle = "SELECT SOMETHING";
    private static final String DIALOG_TITLE = "SELECT SOMETHING";

    private WashInProgress washInProgress;
    private String machineNum = "";
    private String washCycle = "";
    private String tenantPhone = "";

    @BindView(R.id.selectMachine)
    Button selectMachine;

    @BindView(R.id.machineOneClock)
    TextView machOneClock;
    @BindView(R.id.machine1)
    ImageView machOneEmpty;
    @BindView(R.id.machine1full)
    ImageView machOneFull;

    @BindView(R.id.machineTwoClock)
    TextView machTwoClock;
    @BindView(R.id.machine2)
    ImageView machTwoEmpty;
    @BindView(R.id.machine2full)
    ImageView machTwoFull;

    @BindView(R.id.machineThreeClock)
    TextView machThreeClock;
    @BindView(R.id.machine3)
    ImageView machThreeEmpty;
    @BindView(R.id.machine3full)
    ImageView machThreeFull;

    @BindView(R.id.machineFourClock)
    TextView machFourClock;
    @BindView(R.id.machine4)
    ImageView machFourEmpty;
    @BindView(R.id.machine4full)
    ImageView machFourFull;

    @BindView(R.id.machineFiveClock)
    TextView machFiveClock;
    @BindView(R.id.machine5)
    ImageView machFiveEmpty;
    @BindView(R.id.machine5full)
    ImageView machFiveFull;

    @BindView(R.id.machineSixClock)
    TextView machSixClock;
    @BindView(R.id.machine6)
    ImageView machSixEmpty;
    @BindView(R.id.machine6full)
    ImageView machSixFull;

    @BindView(R.id.machineSevenClock)
    TextView machSevenClock;
    @BindView(R.id.machine7)
    ImageView machSevenEmpty;
    @BindView(R.id.machine7full)
    ImageView machSevenFull;

    @BindView(R.id.machineEightClock)
    TextView machEightClock;
    @BindView(R.id.machine8)
    ImageView machEightEmpty;
    @BindView(R.id.machine8full)
    ImageView machEightFull;

    @BindView(R.id.machineNineClock)
    TextView machNineClock;
    @BindView(R.id.machine9)
    ImageView machNineEmpty;
    @BindView(R.id.machine9full)
    ImageView machNineFull;

    @BindView(R.id.machineTenClock)
    TextView machTenClock;
    @BindView(R.id.machine10)
    ImageView machTenEmpty;
    @BindView(R.id.machine10full)
    ImageView machTenFull;


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
        //   washInProgress = new WashInProgress(machineNum, washCycle, tenantPhone);

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

        updateMachineStatus();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // User touched the dialog's negative button
        Log.i("FragmentAlertDialog", "Negative click!");
        Toast.makeText(getApplicationContext(), "Transaction Cancelled", Toast.LENGTH_SHORT).show();
    }

    private void updateMachineStatus() {

        machineNum = WashDialogFragment.machineNumberSelection;
        washCycle = WashDialogFragment.washCycleSelection;
        tenantPhone = WashDialogFragment.tenantPhoneNumber;

        Toast.makeText(getApplicationContext(), "Machine num: " + machineNum, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Wash Cycle " + washCycle, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Phone: " + tenantPhone, Toast.LENGTH_SHORT).show();

        switch (machineNum) {
            case "1":
                machOneEmpty.setVisibility(View.INVISIBLE);
                machOneFull.setVisibility(View.VISIBLE);
                machOneClock.setText("wash");
                break;

            case "2":
                machTwoEmpty.setVisibility(View.INVISIBLE);
                machTwoFull.setVisibility(View.VISIBLE);
                machTwoClock.setText("wash");
                break;

            case "3":
                machThreeEmpty.setVisibility(View.INVISIBLE);
                machThreeFull.setVisibility(View.VISIBLE);
                machThreeClock.setText("wash");
                break;

            case "4":
                machFourEmpty.setVisibility(View.INVISIBLE);
                machFourFull.setVisibility(View.VISIBLE);
                machFourClock.setText("wash");
                break;

            case "5":
                machFiveEmpty.setVisibility(View.INVISIBLE);
                machFiveFull.setVisibility(View.VISIBLE);
                machFiveClock.setText("wash");
                break;

            case "6":
                machSixEmpty.setVisibility(View.INVISIBLE);
                machSixFull.setVisibility(View.VISIBLE);
                machSixClock.setText("wash");
                break;

            case "7":
                machSevenEmpty.setVisibility(View.INVISIBLE);
                machSevenFull.setVisibility(View.VISIBLE);
                machSevenClock.setText("wash");
                break;

            case "8":
                machEightEmpty.setVisibility(View.INVISIBLE);
                machEightFull.setVisibility(View.VISIBLE);
                machEightClock.setText("wash");
                break;

            case "9":
                machNineEmpty.setVisibility(View.INVISIBLE);
                machNineFull.setVisibility(View.VISIBLE);
                machNineClock.setText("wash");
                break;

            case "10":
                machTenEmpty.setVisibility(View.INVISIBLE);
                machTenFull.setVisibility(View.VISIBLE);
                machTenClock.setText("wash");
                break;

        }

    }


//    public void setRegularTimer() {
//        CountDownTimer regularCycleTimer = new CountDownTimer(2100000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }
//
//
//    }



}


//  Intent washIntent = getIntent();
//  machineNum = washIntent.getStringExtra(WashDialogFragment.MACHINE_NUMBER);
//  washCycle = washIntent.getStringExtra(WashDialogFragment.WASH_CYCLE_KEY);
//  tenantPhone = washIntent.getStringExtra(WashDialogFragment.TENANT_PHONE);