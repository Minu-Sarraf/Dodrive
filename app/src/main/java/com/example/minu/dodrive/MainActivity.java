package com.example.minu.dodrive;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.logging.Handler;

import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;

public class MainActivity extends ActionBarActivity {
    int count=0;
   ArrayList<MyPojo>pojos=new ArrayList<MyPojo>();
int j=1;
    private RecyclerView mRecyclerView;
   private Button button;
    private RecyclerView.Adapter mAdapter;
    private SwipeRefreshLayout mswipe;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("tab", "toolbar");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.e("tab", "tolerate ");
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mswipe = (SwipeRefreshLayout)findViewById(R.id.swipe);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);



        mswipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        mswipe.setColorSchemeResources(android.R.color.holo_blue_dark, android.R.color.holo_red_dark, android.R.color.holo_green_light, android.R.color.holo_purple);
        mswipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mswipe.setRefreshing(true);
                Log.d("Swipe", "Refreshing Number");



                run123();
            }
        });

        for(int i=0; i<50;i++){
            pojos.add(new MyPojo("Title" +i,"Date:2016-01-" +j));
            j++;
        }
       mAdapter = new MyAdapter(pojos);
       mRecyclerView.setAdapter(mAdapter);
    }

    public void run123() {
        pojos.add(new MyPojo("Title1223","Date:2016-01-58" ));
        mAdapter = new MyAdapter(pojos);
        mRecyclerView.setAdapter(mAdapter);
        Toast.makeText(getBaseContext(),"swipe",
                Toast.LENGTH_SHORT).show();
        mswipe.setRefreshing(false);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id){

            case R.id.action_settings:

                // handle settings
                break;

            case R.id.action_listview:

                // Setup the LinearLayoutManager
                initListDisplay();
                break;


            case R.id.action_gridview:
                    if(count==0) {
                        // Setup the GridLayoutManager

                        initGridDisplay();
                    }else if(count==1){
                    initListDisplay();
                }
                break;

        }

        return super.onOptionsItemSelected(item);
    }
        //noinspection SimplifiableIfStatement
     /*  if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
        private void initListDisplay(){



            mLayoutManager = new LinearLayoutManager(this);
           // mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

            mRecyclerView.setLayoutManager(mLayoutManager);
            count=0;

        }

    // Display the Grid
    private void initGridDisplay(){
         mLayoutManager = new GridLayoutManager(this, 3);

        mRecyclerView.setLayoutManager(mLayoutManager);
        count=1;

    }
}
