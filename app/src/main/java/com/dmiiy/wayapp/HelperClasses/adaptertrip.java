package com.dmiiy.wayapp.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.dmiiy.wayapp.R;

import java.util.ArrayList;

public class adaptertrip extends RecyclerView.Adapter<adaptertrip.PhoneViewHold>  {

    ArrayList<triphelper> phoneLaocations;
    final private ListItemClickListener mOnClickListener;

    public adaptertrip(ArrayList<triphelper> phoneLaocations, ListItemClickListener listener) {
        this.phoneLaocations = phoneLaocations;
        mOnClickListener = listener;
    }

    @NonNull

    @Override
    public PhoneViewHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercard, parent, false);
        return new PhoneViewHold(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHold holder, int position) {


        triphelper triphelper = phoneLaocations.get(position);
        holder.image.setImageResource(triphelper.getImage());
        holder.title.setText(triphelper.getTitle());
    }

    @Override
    public int getItemCount() {
        return phoneLaocations.size();

    }

    public interface ListItemClickListener {
        void onphoneListClick(int clickedItemIndex);
    }

    public class PhoneViewHold extends RecyclerView.ViewHolder implements View.OnClickListener {


        ImageView image;
        TextView title;

        RelativeLayout relativeLayout;


        public PhoneViewHold(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks

            image = itemView.findViewById(R.id.phone_image);
            title = itemView.findViewById(R.id.phone_title);
            //mark = itemView.findViewById(R.id.imagemark);
            //relativeLayout = itemView.findViewById(R.id.background_color);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onphoneListClick(clickedPosition);
        }
    }

}
