package com.example.viewpagerapp;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface NoteServices {
    @GET("/all")
    Call<List<Note>> getAllNote();
    @GET("/all")
    Call<Note> getNote();
}
