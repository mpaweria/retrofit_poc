package com.example.retrofit_poc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofit_poc.model.ResponseModel;
import com.example.retrofit_poc.view.UserAdapter;
import com.example.retrofit_poc.viewmodel.UserViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ResponseModel> userModelList;
    private UserAdapter adapter;
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new UserAdapter(this, userModelList);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        viewModel.getUsersListObserver().observe(this, new Observer<List<ResponseModel>>() {
            @Override
            public void onChanged(List<ResponseModel> responseModels) {
                if(responseModels != null){
                    userModelList = responseModels;
                    adapter.setUserList(responseModels);
                }
            }
        });
        viewModel.makeApiCall();
    }
}