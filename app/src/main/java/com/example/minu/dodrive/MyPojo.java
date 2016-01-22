package com.example.minu.dodrive;

/**
 * Created by minu on 1/17/2016.
 */
public class MyPojo{
    String title;
    String desc;
    //int image;

    public MyPojo(String title,String desc){
        this.title=title;
        this.desc=desc;
      //  this.image=image;
    }
    public String gettitle(){
        return title;
    }
    public String getdesc(){
        return desc;
    }
   /* public int getimage(){
        return image;
    }*/

}
