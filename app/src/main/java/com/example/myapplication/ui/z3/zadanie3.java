package com.example.myapplication.ui.z3;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

import com.example.myapplication.R;

public class zadanie3 extends Fragment {
    private ArrayList<String> listToView;
    private Zadanie3ViewModel mViewModel;
    private EditText editTextText;
    private ListView listView;
    private Button addButton;

    public static zadanie3 newInstance() {
        return new zadanie3();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zadanie3, container, false);  // Make sure this matches your layout file

        // Initialize your views using findViewById
        editTextText = view.findViewById(R.id.editTextText);
        listView = view.findViewById(R.id.listView);
        addButton = view.findViewById(R.id.addButton);

        listToView = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_list_item, R.id.item_text, listToView) {
            @NonNull
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(getContext());
                    convertView = inflater.inflate(R.layout.custom_list_item, parent, false);
                }

                TextView text = convertView.findViewById(R.id.item_text);
                Button remove = convertView.findViewById(R.id.remove_button);

                text.setText(getItem(position));
                remove.setOnClickListener(v -> {
                    listToView.remove(position);
                    notifyDataSetChanged();
                });

                return convertView;
            }
        };

        // Attach the adapter to the ListView
        listView.setAdapter(adapter);

        // Set the listener for the addButton
        addButton.setOnClickListener(v -> {
            String item = editTextText.getText().toString();
            if (!item.isEmpty()) {
                listToView.add(item);
                adapter.notifyDataSetChanged();
                editTextText.setText("");  // Clear the text after adding
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(Zadanie3ViewModel.class);
        // TODO: Use the ViewModel if needed
    }
}
