package com.akashaarcher.android.washwatchapp;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Queue;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Akasha on 5/11/17.
 */

public class WashDialogFragment extends DialogFragment {

    @BindView(R.id.machine_number_spinner)
    Spinner machineNumber;
    @BindView(R.id.cycle_spinner)
    Spinner washCycleSpinner;
    @BindView(R.id.tenant_phone)
    EditText tenantNumber;

    public static String machineNumberSelection = "";
    public static String washCycleSelection = "";
    public static String tenantPhoneNumber = "";

    public static String MACHINE_NUMBER = "Machine Number";
    public static String WASH_CYCLE_KEY = "Wash Cycle";
    public static String TENANT_PHONE = "Tenant Phone";

    public Queue<WashInProgress> tenantsToText;


    public WashDialogFragment() {
    }

    public static WashDialogFragment newInstance(String title) {
        WashDialogFragment washDialogFragment = new WashDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        washDialogFragment.setArguments(args);
        return washDialogFragment;
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_wash_dialog, null);
        ButterKnife.bind(this, v);

        // Spinner for machine number
        ArrayAdapter<CharSequence> machineNumberAdapter = ArrayAdapter.createFromResource(v.getContext(),
                R.array.machine_numbers, android.R.layout.simple_spinner_item);
        machineNumberAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        machineNumber.setAdapter(machineNumberAdapter);

        machineNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                machineNumberSelection = machineNumber.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "Please select a machine number to continue", Toast.LENGTH_SHORT).show();
            }
        });

        // Spinner for wash cycle
        ArrayAdapter<CharSequence> washCycleAdapter = ArrayAdapter.createFromResource(v.getContext(),
                R.array.wash_cycles, android.R.layout.simple_spinner_item);
        washCycleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        washCycleSpinner.setAdapter(washCycleAdapter);

        washCycleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                washCycleSelection = washCycleSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "Please select a wash cycle to continue", Toast.LENGTH_SHORT).show();
            }
        });


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Please Select Your Wash Cycle and Enter Your Phone Number Below")
                .setPositiveButton(android.R.string.ok, null)
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        mListener.onDialogPositiveClick(WashDialogFragment.this);
//                        if (machineNumberSelection.equals("Select Machine Number")) {
//                            Toast.makeText(getActivity(), "Please select your machine number to continue", Toast.LENGTH_SHORT).show();
//                        }
//                        if (washCycleSelection.equals("Select Wash Cycle")) {
//                            Toast.makeText(getActivity(), "Please select your wash cycle to continue", Toast.LENGTH_SHORT).show();
//                        }

                        tenantPhoneNumber = tenantNumber.getText().toString();

                    }
                })
                // negative button
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mListener.onDialogNegativeClick(WashDialogFragment.this);
                    }
                })
                .create();
    }


//    private WashInProgress addNewWash(){
//        WashInProgress wash = new WashInProgress()
//
//    }

    public interface WashDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    WashDialogListener mListener;


    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (WashDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }

}
