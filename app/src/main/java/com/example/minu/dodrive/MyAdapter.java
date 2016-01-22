package com.example.minu.dodrive;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

/**
 * Created by minu on 1/17/2016.
 */

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<MyPojo>pojos;
int a=0;
        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public View view;
            public ViewHolder(View v) {
                super(v);
               view = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<MyPojo>pojos) {
            this.pojos=pojos;
            pojos = pojos;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
           final TextView title=(TextView)holder.view.findViewById(R.id.Title);
           final TextView desc=(TextView)holder.view.findViewById(R.id.desc);
            //ImageView image2=(ImageView)holder.view.findViewById(R.id.imageView);
            title.setText(pojos.get(position).gettitle());
            desc.setText((pojos).get(position).getdesc());
           animate(holder,true);
            //image2.setImageResource((pojos).get(position).getimage());

title.setOnClickListener(new View.OnClickListener(){
    @Override
public void onClick(View view) {
        if (a == 0) {
            title.setTextColor(Color.RED);

            desc.setTextColor(Color.YELLOW);
            a = 1;

        } else if (a == 1) {
            title.setTextColor(Color.BLACK);

            desc.setTextColor(Color.BLACK);
            a = 0;
        }
    }
});

        }

    public static void animate(RecyclerView.ViewHolder holder,boolean goesdown){
        YoYo.with(Techniques.RubberBand).duration(1000).playOn(holder.itemView);
    }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {

            return pojos.size();
        }


}
