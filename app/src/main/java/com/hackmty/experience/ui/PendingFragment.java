package com.hackmty.experience.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hackmty.experience.R;
import com.hackmty.experience.controller.api.User;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class PendingFragment extends Fragment {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    UserAdapter adapter;
    ArrayList<User> users;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View contentview = inflater.inflate(R.layout.fragment_pending, container, false);
        ButterKnife.bind(this, contentview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        users = new ArrayList<>();

        users.add(new User("Jonathan Velázquez", R.drawable.jony));
        users.add(new User("Abner Abbey", R.drawable.abner));
        users.add(new User("Aldo Avalos", R.drawable.aldo));

        adapter = new UserAdapter(getContext(), users);
        recyclerView.setAdapter(adapter);

        return contentview;
    }

}
