package com.example.minu.dodrive;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.widget.RecyclerView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;


/**
 * Created by minu on 1/20/2016.
 */
public class AnimationUtilis {
    public static void scaleXY(RecyclerView.ViewHolder holder) {
        holder.itemView.setScaleX(0);
        holder.itemView.setScaleY(0);

        PropertyValuesHolder propx = PropertyValuesHolder.ofFloat("scaleX", 1);
        PropertyValuesHolder propy = PropertyValuesHolder.ofFloat("scaleY", 1);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(holder.itemView, propx, propy);


        animator.setDuration(800);
        animator.start();
    }

    public static void scaleX(RecyclerView.ViewHolder holder) {
        holder.itemView.setScaleX(0);

        PropertyValuesHolder propx = PropertyValuesHolder.ofFloat("scaleX", 1);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(holder.itemView, propx);


        animator.setDuration(800);
        animator.start();
    }

    public static void scaleY(RecyclerView.ViewHolder holder) {
        holder.itemView.setScaleY(0);

        PropertyValuesHolder propy = PropertyValuesHolder.ofFloat("scaleY", 1);

        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(holder.itemView, propy);

        animator.setDuration(800);
        animator.start();
    }
    public static void animate(RecyclerView.ViewHolder holder,boolean goesdown){
        YoYo.with(Techniques.RubberBand).duration(1000).playOn(holder.itemView);
    }
}


