package com.chiragawale.hungrypeople.Home.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.chiragawale.hungrypeople.Home.Item;
import com.chiragawale.hungrypeople.R;
import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class FoldingCellListAdapter extends ArrayAdapter<Item> {

    private HashSet<Integer> unfoldedIndexes = new HashSet<>();
    private View.OnClickListener defaultRequestBtnClickListener;
    private Context mContext;
    private List<Item> mObjects;

    public FoldingCellListAdapter(Context context, List<Item> objects){
        super(context,0,objects);
        this.mContext=context;
        this.mObjects=objects;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // get item for selected view
        Item item = getItem(position);
        // if cell is exists - reuse it, if not - create the new one from resource
        FoldingCell cell = (FoldingCell) convertView;
        ViewHolder viewHolder;
        if (cell == null) {
            viewHolder = new ViewHolder();
            LayoutInflater vi = LayoutInflater.from(getContext());
            cell = (FoldingCell) vi.inflate(R.layout.cell, parent, false);
            // binding view parts to view holder
            viewHolder.name = cell.findViewById(R.id.title_name);
            viewHolder.address = cell.findViewById(R.id.title_address);
            viewHolder.hours = cell.findViewById(R.id.title_hours);
            viewHolder.category = cell.findViewById(R.id.title_category);
            viewHolder.contentRequestBtn = cell.findViewById(R.id.content_request_btn);
            cell.setTag(viewHolder);
        } else {
            // for existing cell set valid valid state(without animation)
            if (unfoldedIndexes.contains(position)) {
                cell.unfold(true);
            } else {
                cell.fold(true);
            }
            viewHolder = (ViewHolder) cell.getTag();
        }

        if (null == item)
            return cell;

        // bind data from selected element to view through view holder
        viewHolder.name.setText(item.getName());
        viewHolder.address.setText(item.getAddress());
        viewHolder.hours.setText(item.getHours());
        viewHolder.category.setText(item.getCategory());

        // set custom btn handler for list item from that item
        if (item.getRequestBtnClickListener() != null) {
            viewHolder.contentRequestBtn.setOnClickListener(item.getRequestBtnClickListener());
        } else {
            // (optionally) add "default" handler if no handler found in item
            viewHolder.contentRequestBtn.setOnClickListener(defaultRequestBtnClickListener);
        }

        return cell;
    }

    // simple methods for register cell state changes
    public void registerToggle(int position) {
        if (unfoldedIndexes.contains(position))
            registerFold(position);
        else
            registerUnfold(position);
    }

    public void registerFold(int position) {
        unfoldedIndexes.remove(position);
    }

    public void registerUnfold(int position) {
        unfoldedIndexes.add(position);
    }

    public View.OnClickListener getDefaultRequestBtnClickListener() {
        return defaultRequestBtnClickListener;
    }

    public void setDefaultRequestBtnClickListener(View.OnClickListener defaultRequestBtnClickListener) {
        this.defaultRequestBtnClickListener = defaultRequestBtnClickListener;
    }

    // View lookup cache
    private static class ViewHolder {
        TextView name;
        TextView contentRequestBtn;
        TextView address;
        TextView category;
        TextView hours;

    }
}
