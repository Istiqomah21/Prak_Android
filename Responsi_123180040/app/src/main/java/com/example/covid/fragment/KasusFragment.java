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
import com.example.covid.adapter.KasusAdapter;
import com.example.covid.model.kasus.ContentItem;
import com.example.covid.service.CovidListener;
import com.example.covid.service.CovidService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class KasusFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasus, container, false);
    }

    RecyclerView rvKasus;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvKasus = view.findViewById(R.id.rv_kasus);
        new CovidService().getKasus(covidListener);
    }

    CovidListener<List<ContentItem>> covidListener = new CovidListener<List<ContentItem>>() {
        @Override
        public void onSuccess(List<ContentItem> items) {

            Collections.reverse(items);

            final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rvKasus.setLayoutManager((linearLayoutManager));
            KasusAdapter rvAdapter = new KasusAdapter(items);
            rvKasus.setAdapter(rvAdapter);
        }

        @Override
        public void onFailed(String msg) {
            Log.d("Errornya... ", msg);
        }
    };

}