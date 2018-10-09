package com.planetorium.planetorium;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder>{
private List<Model> modelList;
Context context;


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
        String img = modelList.get(position).getImageurl();
        Picasso.get()
                .load(img)
                .into(holder.ivPlanets);


        /// });
 holder.linearLayout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context,DetailActivity.class);
        intent.putExtra("desc",description);
        context.startActivity(intent);
     }
  });

    //Animation animation = AnimationUtils.loadAnimation(context,R.anim.slide_in_left);
     // holder.itemView.startAnimation(animation);
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
