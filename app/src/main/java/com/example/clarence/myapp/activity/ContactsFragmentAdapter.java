package com.example.clarence.myapp.activity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clarence.libwidget.pinnedsection.PinnedSectionListAdapter;
import com.example.clarence.myapp.R;

import java.util.List;

/**
 * Created by clarence on 16/8/30.
 */
public class ContactsFragmentAdapter extends BaseAdapter implements PinnedSectionListAdapter {
    List<ContactsItem> data;
    Context context;

    private static final int[] COLORS = new int[]{
            R.color.green_light, R.color.orange_light,
            R.color.blue_light, R.color.red_light};

    public ContactsFragmentAdapter(Context context, List<ContactsItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public ContactsItem getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (null == convertView) {
            convertView = View.inflate(context, R.layout.contacts_fragment_item, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        ContactsItem item = getItem(position);
        if (item != null && item.userInfoDO != null) {
            holder.tvName.setText(item.userInfoDO.getName());
        }
        holder.tvName.setTextColor(Color.DKGRAY);
        holder.tvTelephone.setTextColor(Color.DKGRAY);
        if (item.type == ContactsItem.SECTION) {
            holder.view.setBackgroundColor(parent.getResources().getColor(COLORS[item.sectionPosition % COLORS.length]));
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).type;
    }

    public boolean isItemViewTypePinned(int viewType) {
        return viewType == ContactsItem.SECTION;
    }

    class Holder {
        TextView tvName;
        TextView tvTelephone;
        View view;

        public Holder(View v) {
            view = v;
            tvName = (TextView) v.findViewById(R.id.tvName);
            tvTelephone = (TextView) v.findViewById(R.id.tvTelephone);
        }
    }
}
