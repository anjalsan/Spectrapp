package com.spectrosmart.NanoScan;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.spectrosmart.NanoScan.RetrofitSupport.Values;

import java.util.ArrayList;

/**
 * Created by anjal 15/01/2016
 */
public class AdapterCSVResult extends RecyclerView.Adapter<AdapterCSVResult.MyViewHolder> {
    private static LayoutInflater inflater = null;
    private Context context;
    private ArrayList<Values> tag = new ArrayList<>();


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tag_item, parent, false);
        return new MyViewHolder(itemView);
    }

    public AdapterCSVResult(Activity context, ArrayList<Values> places) {
        this.context = context;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.tag = places;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (tag.get(position) != null) {
            if (String.valueOf(tag.get(position).getValue()).length() > 6) {
                holder.value.setText(String.valueOf(tag.get(position).getValue()).substring(0, 5) + "% m/m");
            } else {
                holder.value.setText(String.valueOf(tag.get(position).getValue()) + "% m/m");
            }
            holder.name.setText(tag.get(position).getName());

            if (tag.get(position).getName().equals("Composition")) {
                holder.value.setText("Result");
                holder.range.setText("Ideal Ranges");

                holder.value.setTextColor(Color.parseColor("#000000"));
                holder.value.setTextSize(14);

                holder.name.setTextColor(Color.parseColor("#000000"));
                holder.name.setTextSize(14);

                holder.range.setTextColor(Color.parseColor("#000000"));
                holder.range.setTextSize(14);

            } else {
                if (tag.get(position).getName().equals("Fat")){
                    holder.range.setText("1.5 - 26 % m/m");
                } else if (tag.get(position).getName().equals("Protein")){
                    holder.range.setText("above 34 % m/m");
                } else if (tag.get(position).getName().equals("Protien")){
                    holder.range.setText("above 34 % m/m");
                } else if (tag.get(position).getName().equals("Water")){
                    holder.range.setText("0 - 4 % m/m");
                } else if (tag.get(position).getName().equals("Lactose")){
                    holder.range.setText("10 - 25 % m/m");
                } else {
                    holder.range.setText("-");
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return tag.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, value, range;

        public MyViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            value = (TextView) view.findViewById(R.id.value);
            range = (TextView) view.findViewById(R.id.range);
        }
    }
}
