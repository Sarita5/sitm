package com.example.sitm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ShareUs extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "http://www.sagar.ac.in");
        intent.putExtra(Intent.EXTRA_SUBJECT, "http://www.sagar.ac.in\n");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, "share from my MT Link"));
        return inflater.inflate(R.layout.shareus, container, false);
    }
}