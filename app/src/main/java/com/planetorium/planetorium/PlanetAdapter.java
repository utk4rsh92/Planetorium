package com.planetorium.planetorium;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder>{
private List<Model> modelList;
Context context;
    private int lastPosition = -1;

public PlanetAdapter(List<Model>modelList,Context context){
    this.modelList = modelList;
    this.context = context;
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planet_data,parent,false);
    return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
    holder.tvName.setText(modelList.get(position).getName());
    holder.tvDetails.setText(modelList.get(position).getDetails());
   holder.tvDescription.setText(modelList.get(position).getDescription());
        final String description = modelList.get(position).getDescription();
        final String img = modelList.get(position).getImageurl();
        Picasso.get()
                .load(img)
                .into(holder.ivPlanets);
 setAnimation(holder.itemView,position);
 final String fact1 = modelList.get(position).getFact1();
 final String fact2 = modelList.get(position).getFact2();
 final String fact3 = modelList.get(position).getFact3();
 final String fact4 = modelList.get(position).getFact4();
        final String fact5 = modelList.get(position).getFact5();
        final String fact6 = modelList.get(position).getFact6();
        final String fact7 = modelList.get(position).getFact7();


        /// });
 holder.linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra("image",img);
        intent.putExtra("desc",description);
        intent.putExtra("fact1",fact1);
        intent.putExtra("fact2",fact2);
        intent.putExtra("fact3",fact3);
        intent.putExtra("fact4",fact4);
        intent.putExtra("fact5",fact5);
        intent.putExtra("fact6",fact6);
        intent.putExtra("fact7",fact7);
        context.startActivity(intent);
     }
  });

    //Animation animation = AnimationUtils.loadAnimation(context,R.anim.slide_in_left);
     // holder.itemView.startAnimation(animation);
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
    public View view;
    TextView tvName, tvDetails, tvDescription;
    ImageView ivPlanets;
    LinearLayout linearLayout;
        public MyViewHolder(View itemView) {
            super(itemView);
            view  = itemView;
            linearLayout = (LinearLayout)itemView.findViewById(R.id.linear);
            tvName = (TextView)itemView.findViewById(R.id.tvTitle);
            tvDetails = (TextView)itemView.findViewById(R.id.tvdetails);
            tvDescription = (TextView)itemView.findViewById(R.id.tv_description);
            ivPlanets = (ImageView)itemView.findViewById(R.id.ivImage);

        }
    }
}
