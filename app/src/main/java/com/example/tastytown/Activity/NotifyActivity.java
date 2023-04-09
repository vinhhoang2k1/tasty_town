package com.example.tastytown.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastytown.Adaptor.NotifyAdapter;
import com.example.tastytown.Model.Notify;
import com.example.tastytown.R;

import java.util.ArrayList;

public class NotifyActivity extends AppCompatActivity {
    RecyclerView listViewNotifies;

    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        renderNotifies();
    }

    public void renderNotifies() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        listViewNotifies = findViewById(R.id.notifi_list);
        listViewNotifies.setLayoutManager(linearLayoutManager);
        ArrayList<Notify> notifies = new ArrayList<>();
        notifies.add(new Notify("Anh Tuan 0", "14:00", "Your order is received!", "notifi_thumbnail"));
        notifies.add(new Notify("Anh Tuan 1", "13:30", "Your order is received!", "notifi_thumbnail"));
        notifies.add(new Notify("Anh Tuan 2", "9:00", "Your order is received!", "notifi_thumbnail"));
        adapter = new NotifyAdapter(notifies);
        listViewNotifies.setAdapter(adapter);
    }
}