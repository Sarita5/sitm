package com.example.sitm;

import android.graphics.Color;
import android.media.Rating;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Review extends Fragment {
    EditText e1, e2, e3;
    Button btn;
    RatingBar rtr;
    ConnectionManager cm;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.review, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cm = new ConnectionManager();
        e1 = (EditText) view.findViewById(R.id.rname);
        e2 = (EditText) view.findViewById(R.id.reemail);
        e3 = (EditText) view.findViewById(R.id.rreview);
        rtr = (RatingBar) view.findViewById(R.id.rb);
        btn = (Button) view.findViewById(R.id.btnreview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = e1.getText().toString();
                String email = e2.getText().toString();
                String feedback = e3.getText().toString();
                if (e1.getText().toString().equals("")) {
                    e1.setHintTextColor(Color.RED);
                    e1.requestFocus();
                    Toast.makeText(getContext(), "enter your name", Toast.LENGTH_SHORT).show();
                } else if (e2.getText().toString().equals("")) {
                    e2.setHintTextColor(Color.RED);
                    e2.requestFocus();
                    Toast.makeText(getContext(), "enter your email", Toast.LENGTH_SHORT).show();
                } else if (e3.getText().toString().equals("")) {
                    e3.setHintTextColor(Color.RED);
                    e3.requestFocus();
                    Toast.makeText(getContext(), "enter your review", Toast.LENGTH_SHORT).show();
                } else {
                    float r = rtr.getRating();
                    String command = "insert into rev values('" + e1.getText() + "','" + e2.getText() + "','" + e3.getText() + "','" + r + "')";
                    boolean x = cm.ExecuteNonQuery(command);
                    if (x == true) {
                        Toast.makeText(getContext(), "Thanks for review", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}