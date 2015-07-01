package com.appstax.chatstax;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appstax.AxObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    final String DATE_FORMAT = "HH:mm:ss";

    List<AxObject> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView title;
        TextView subtitle;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.title);
            subtitle = (TextView)itemView.findViewById(R.id.subtitle);
        }
    }

    ChatAdapter(List<AxObject> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);

        String text = items.get(i).getString("text");
        Date date = items.get(i).getDate("date");

        viewHolder.title.setText(text);
        viewHolder.subtitle.setText(df.format(date));
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
