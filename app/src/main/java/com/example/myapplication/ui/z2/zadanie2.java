package com.example.myapplication.ui.z2;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class zadanie2 extends Fragment {

    int iterator = 0;
    String path = "R.id.photo";
    private String imagePrefix = "photo";
    private Zadanie2ViewModel mViewModel;

    private String[] loremTexts = {
            "Toniz ze night.",
            "Syndrome's down but photo's up B-).",
            "Czym jest przyjazn gdy pod blokiem stoi nowe lambo.",
            "Skradles me serce i rower.",
            "Afera granatnikowa nie byla moja wina.",
            "Cos zimno w tej wannie.",
            "What's up guys! It's Quandale Dingle here! (RUUEHEHEHEHEHEEHE) I have been arrested for multiple crimes (AHHHHHHHHHHHHH) including: Battery on a police officer (WHAT)," +
            " Grand theft, Declaring war on Italy, and public indecency (RUHEHEHEEHEHEHEHEHEHEHE X2 speed). I will be escaping prison on, MARCH 28TH! After that.... I WILL TAKE OVER THE WORLD\n"
    };


    public static zadanie2 newInstance() {
        return new zadanie2();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zadanie2, container, false);

        ImageView imV = view.findViewById(R.id.imageView2);
        Button Back = view.findViewById(R.id.button3);
        Button Forward = view.findViewById(R.id.button4);
        TextView t = view.findViewById(R.id.textView2);

        imV.setImageResource(R.drawable.photo1);
        t.setText(loremTexts[iterator]);
        Back.setEnabled(false);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iterator == 0 ){
                    Back.setEnabled(false);
                }else{
                    Back.setEnabled(true);
                    Forward.setEnabled(true);
                    iterator--;
                    String imageName = imagePrefix + (iterator + 1); // "photo1", "photo2", etc.
                    int resId = getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());

                        imV.setImageResource(resId);

                    t.setText(loremTexts[iterator]);

                }

            }
        });
        Forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(iterator == 6 ){
                    Forward.setEnabled(false);
                }else{
                    Forward.setEnabled(true);
                    Back.setEnabled(true);
                    iterator++;
                    String imageName = imagePrefix + (iterator + 1); // "photo1", "photo2", etc.
                    int resId = getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
                    imV.setImageResource(resId);

                    t.setText(loremTexts[iterator]);
                }
            }
        });




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Zadanie2ViewModel.class);
        // TODO: Use the ViewModel
    }

}