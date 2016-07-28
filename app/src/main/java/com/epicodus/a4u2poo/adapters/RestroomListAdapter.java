package com.epicodus.a4u2poo.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epicodus.a4u2poo.DetailActivity;
import com.epicodus.a4u2poo.Models.Restroom;
import com.epicodus.a4u2poo.R;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RestroomListAdapter extends RecyclerView.Adapter<RestroomListAdapter.RestroomViewHolder> {
    private ArrayList<Restroom> mRestrooms = new ArrayList<>();
    private Context mContext;

    public RestroomListAdapter(Context context, ArrayList<Restroom> restrooms) {
        mContext = context;
        mRestrooms = restrooms;
    }

    @Override
    public RestroomListAdapter.RestroomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.restroom_list, parent, false);
        RestroomViewHolder viewHolder = new RestroomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RestroomListAdapter.RestroomViewHolder holder, int position) {
        holder.bindRestroom(mRestrooms.get(position));
    }

    @Override
    public int getItemCount() {
        return mRestrooms.size();
    }

    public class RestroomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.pooImageView) ImageView mPooImageView;
        @Bind(R.id.tName) TextView mName;
        @Bind(R.id.tStreet) TextView mStreet;
        private Context mContext;

        public RestroomViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindRestroom(Restroom restroom) {
            mName.setText(restroom.getName());
            mStreet.setText(restroom.getStreet());
        }

        @Override
        public void onClick(View view) {
            Log.d("click listener", "working!");
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, DetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restrooms", Parcels.wrap(mRestrooms));
            mContext.startActivity(intent);

        }
    }
}

