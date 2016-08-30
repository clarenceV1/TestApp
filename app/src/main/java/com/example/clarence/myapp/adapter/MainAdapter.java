package com.example.clarence.myapp.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.clarence.myapp.R;
import com.example.clarence.myapp.databinding.ActivityMainItemBinding;
import com.example.clarence.myapp.entity.NavigatData;

import java.util.List;

/**
 * Created by clarence on 16/5/30.
 */
public class MainAdapter extends BaseAdapter {
    List<NavigatData> data;
    Context context;

    public MainAdapter(Context context, List<NavigatData> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public NavigatData getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_main_item, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.bind(data.get(position).getTitle());
        return convertView;
    }

    public static class Holder {
        private ActivityMainItemBinding mBinding;

        public Holder(View itemView) {
            mBinding = DataBindingUtil.bind(itemView);
        }

        public void bind(@NonNull String name) {
            mBinding.tvTitle.setText(name);
        }
    }
}
