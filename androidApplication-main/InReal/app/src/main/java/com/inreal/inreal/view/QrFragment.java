package com.inreal.inreal.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.inreal.inreal.Listener;
import com.inreal.inreal.R;

public class QrFragment extends Fragment {
    Listener listener;

    public QrFragment(Listener listener) {this.listener = listener;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_qr, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button buttonScan = getView().findViewById(R.id.qr_button_for_scan);
        buttonScan.setOnClickListener(v -> listener.onClickForScan());
    }
}