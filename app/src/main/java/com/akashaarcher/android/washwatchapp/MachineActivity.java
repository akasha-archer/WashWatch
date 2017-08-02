package com.akashaarcher.android.washwatchapp;

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
        tenantPhone = WashDialogFragment.tenantPhoneNumber;

        Toast.makeText(getApplicationContext(), "Machine num: " + machineNum, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Wash Cycle " + washCycle, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "Phone: " + tenantPhone, Toast.LENGTH_SHORT).show();

        switch (machineNum) {
            case "1":
                startMachine(machOneEmpty, machOneFull, machOneClock);
                startWashTimer(machOneClock);
                break;

            case "2":
                startMachine(machTwoEmpty, machTwoFull, machTwoClock);
                startWashTimer(machTwoClock);
                break;

            case "3":
                startMachine(machThreeEmpty, machThreeFull, machThreeClock);
                startWashTimer(machThreeClock);
                break;

            case "4":
                startMachine(machFourEmpty, machFourFull, machFourClock);
                startWashTimer(machFourClock);
                break;

            case "5":
                startMachine(machFiveEmpty, machFiveFull, machFiveClock);
                startWashTimer(machFiveClock);
                break;

            case "6":
                startMachine(machSixEmpty, machSixFull, machSixClock);
                startWashTimer(machSixClock);
                break;

            case "7":
                startMachine(machSevenEmpty, machSevenFull, machSevenClock);
                startWashTimer(machSevenClock);
                break;

            case "8":
                startMachine(machEightEmpty, machEightFull, machEightClock);
                startWashTimer(machEightClock);
                break;

            case "9":
                startMachine(machNineEmpty, machNineFull, machNineClock);
                startWashTimer(machNineClock);
                break;

            case "10":
                startMachine(machTenEmpty, machTenFull, machTenClock);
                startWashTimer(machTenClock);
                break;
        }
    }


    private void startWashTimer(TextView timerTextView) {
        washCycle = WashDialogFragment.washCycleSelection;

        if (washCycle.equals("Regular Cycle")) {
            setRegularTimer(timerTextView);
        } else {
            setSuperTimer(timerTextView);
        }
    }

    private void startMachine(ImageView machineEmpty, ImageView machineFull, TextView machineClock) {
        machineEmpty.setVisibility(View.INVISIBLE);
        machineFull.setVisibility(View.VISIBLE);
        machineClock.setText("wash");
    }


    private void setRegularTimer(final TextView textView) {
        CountDownTimer regularCycleTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(millisUntilFinished / 1000 + " MIN");
            }

            @Override
            public void onFinish() {
                textView.setText("DONE");
            }
        }.start();
    }

    private void setSuperTimer(final TextView textView) {
        CountDownTimer regularCycleTimer = new CountDownTimer(80000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText(millisUntilFinished / 1000 + " MIN");
            }

            @Override
            public void onFinish() {
                textView.setText("DONE");
            }
        }.start();
    }

}
