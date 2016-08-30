package com.example.clarence.myapp.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.entity.User;
import com.example.clarence.myapp.databinding.ActivityDataBindingItemBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rufi on 6/5/15.
 */
public class DataBindingAdapter extends RecyclerView.Adapter<DataBindingAdapter.UserHolder> {
    private static final int USER_COUNT = 10;

    @NonNull
    private List<User> mUsers;

    public DataBindingAdapter() {
        mUsers = new ArrayList<>(10);
        for (int i = 0; i < USER_COUNT; i++) {
            User user = new User("first_name_" + i, "last_name_" + i, "age");
            mUsers.add(user);
        }
    }

    public static class UserHolder extends RecyclerView.ViewHolder {
        private ActivityDataBindingItemBinding mBinding;

        public UserHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }

        public void bind(@NonNull User user) {
            mBinding.setUser(user);
        }
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_data_binding_item, viewGroup, false);
        return new UserHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }
}

