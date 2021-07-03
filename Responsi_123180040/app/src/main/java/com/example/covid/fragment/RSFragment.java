package com.example.covid.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covid.R;
import com.example.covid.adapter.RSAdapter;
import com.example.covid.model.rs.DataItem;
import com.example.covid.service.CovidListener;
import com.example.covid.service.CovidService;

import java.util.List;


public class RSFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_r_s, container, false);
    }

    RecyclerView rvRS;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvRS = view.findViewById(R.id.rv_rs);
        new CovidService().getRS(covidListener);
    }

    CovidListener<List<DataItem>> covidListener = new CovidListener<List<DataItem>>() {
        @Override
        public void onSuccess(List<DataItem> items) {
            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvRS.setLayoutManager(linearLayoutManager);
            RSAdapter rvAdapter = new RSAdapter(items);
            rvRS.setAdapter(rvAdapter);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("Errornya : ", msg);
        }
    };

}