package com.example.covid.service;

import com.example.covid.model.kasus.KasusResponse;
import com.example.covid.model.rs.RSResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidAPI {
    String URL_BASE = "https://covid19-public.digitalservice.id/api/v1/";

    @GET("rekapitulasi_v2/jabar/harian")
    Call<KasusResponse> getKasus();

    @GET("sebaran_v2/jabar/faskes")
    Call<RSResponse> getRS();
}
