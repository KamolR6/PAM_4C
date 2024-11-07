package com.example.myapplication.ui.z1;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.snackbar.Snackbar;

public class zadanie1 extends Fragment {

    private Zadanie1ViewModel mViewModel;

    public static zadanie1 newInstance() {
        return new zadanie1();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zadanie1, container, false);

        // Find the TextView in the inflated layout
        TextView textID1 = view.findViewById(R.id.ID1);
        EditText editID2 = view.findViewById(R.id.ID2);
        Button buttonID3 = view.findViewById(R.id.ID3);
        CheckBox checkBoxID5 = view.findViewById(R.id.ID5);
//        if(checkBoxID5.isChecked()){
//            textID1.setText("Jo cie chwyca");
//        }

        buttonID3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editID2.getText() == null || editID2.getText().toString().equals("")){
                    if(checkBoxID5.isChecked()) {
                        Toast ID4 = Toast.makeText(
                                requireContext(), "NIE WPISANO TEKSTU", Toast.LENGTH_SHORT);
                        ID4.show();
                    }else{
                        Snackbar ID4 = Snackbar.make(view, "NIE WPISANO TEKSTU", Snackbar.LENGTH_LONG);
                        ID4.show();
                    }
                    }else{
                if(checkBoxID5.isChecked()){
                    Toast ID4 = Toast.makeText(requireContext(), editID2.getText(), Toast.LENGTH_SHORT);
                    ID4.show();

                }else{
                Snackbar snickers = Snackbar.make(view, editID2.getText(), Snackbar.LENGTH_LONG);
                snickers.show();
            }}}
        });

        // Return the inflated view
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Zadanie1ViewModel.class);
        // TODO: Use the ViewModel
    }

}