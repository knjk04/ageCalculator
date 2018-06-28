package com.example.karan.agecalculator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

/**
 * Created by karan on 28/06/18
 */
class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ConversionViewHolder> {

    public static class ConversionViewHolder extends RecyclerView.ViewHolder {
        TextView conversion;

        ConversionViewHolder(View itemView) {
            super(itemView);
            conversion = itemView.findViewById(R.id.secondsTextViewCard);
        }
    }

    List<ConvertedVal> convertedVals;

    RecyclerViewAdapter(List<ConvertedVal> convertedVals) {
        this.convertedVals = convertedVals;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ConversionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_calculated_age, viewGroup, false);
        ConversionViewHolder conversionViewHolder = new ConversionViewHolder(v);
        return conversionViewHolder;
    }

    @Override
    public void onBindViewHolder(ConversionViewHolder conversionViewHolder, int i) {
        conversionViewHolder.conversion.setText(convertedVals.get(i).strCalculatedValue + " " +
                                                convertedVals.get(i).strUnit);
    }

    @Override
    public int getItemCount() {
        return convertedVals.size();
    }
}
