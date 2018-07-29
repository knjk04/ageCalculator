package com.example.karan.agecalculator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by karan on 28/06/18
 */
class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ConversionViewHolder> {

    private Context mContext;
    List<ConvertedVal> convertedVals;

    RecyclerViewAdapter(Context context, List<ConvertedVal> convertedVals) {
        mContext = context;
        this.convertedVals = convertedVals;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ConversionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.activity_calculated_age, null);
        return new ConversionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ConversionViewHolder conversionViewHolder, int i) {
//        conversionViewHolder.conversion.setText(convertedVals.get(i).strCalculatedValue + " " +
//                                                convertedVals.get(i).strUnit);

        ConvertedVal convertedVal = convertedVals.get(i);

        conversionViewHolder.conversion.setText(convertedVal.getStrCalculatedValue() + " " +
                                                convertedVal.getStrUnit());
    }

    @Override
    public int getItemCount() {
        return convertedVals.size();
    }

    public static class ConversionViewHolder extends RecyclerView.ViewHolder {
        TextView conversion;

        ConversionViewHolder(View itemView) {
            super(itemView);
            conversion = itemView.findViewById(R.id.secondsTextViewCard);
        }
    }
}
