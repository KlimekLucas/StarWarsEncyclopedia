package com.example.rottan.starwarsencyclopedia.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rottan.starwarsencyclopedia.R;

import java.util.ArrayList;

public class SWAdapter extends RecyclerView.Adapter<SWAdapter.SWViewHolder> {

    private ArrayList<ExampleItem> exampleList;

    public static class SWViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView1;
        public TextView textView2;

        public SWViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }

    public SWAdapter(ArrayList<ExampleItem> exampleItems) {
        this.exampleList = exampleItems;

    }


    @NonNull
    @Override
    public SWViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        SWViewHolder swViewHolder = new SWViewHolder(view);
        return swViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SWViewHolder holder, int i) {
        ExampleItem currentItem = exampleList.get(i);

        holder.imageView.setImageResource(currentItem.getImageResource());
        holder.textView1.setText(currentItem.getText1());
        holder.textView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }

}
