package com.example.qliniue.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.qliniue.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MedicalRecordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicalRecordFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USERNAME_ARG = "username";
    private static final String PASSWORD_ARG = "password";

    // TODO: Rename and change types of parameters
    private String username_lg;
    private String password_lg;


    public MedicalRecordFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param username Parameter 1.
     * @param password Parameter 2.
     * @return A new instance of fragment MedicalRecordFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicalRecordFragment newInstance(String username, String password) {
        MedicalRecordFragment fragment = new MedicalRecordFragment();
        Bundle args = new Bundle();
        args.putString(USERNAME_ARG, username);
        args.putString(PASSWORD_ARG, password);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            username_lg = getArguments().getString(USERNAME_ARG);
            password_lg = getArguments().getString(PASSWORD_ARG);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_medical_record, container, false);
        TextView otp3 = view.findViewById(R.id.otp3);
        otp3.setText(username_lg + password_lg);
        return view;
    }

}
