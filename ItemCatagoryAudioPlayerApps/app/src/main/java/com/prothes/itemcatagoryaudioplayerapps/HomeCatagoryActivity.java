package com.prothes.itemcatagoryaudioplayerapps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeCatagoryActivity extends AppCompatActivity {
    private GridView gridView;
    private NetworkConnectionCheck networkConnectionCheck = new NetworkConnectionCheck();
    private ArrayList< HashMap<String,String> > catagoryList = new ArrayList<>();
    private HashMap<String,String> catagoryMap = new HashMap<>();

    private ArrayList< HashMap<String,String> > songList = new ArrayList<>();
    private HashMap<String,String> songMap = new HashMap<>();

    // Catagory Image Start Here =============================================
    private String catagory_1_img = "https://www.tbsnews.net/sites/default/files/styles/big_3/public/images/2022/04/30/james-photo.jpg";
    private String catagory_2_img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRTSqROaM8eJ46XncxyHKntiHuQWw_OsJpFpA&s";
    private String catagory_3_img = "https://img.wynk.in/unsafe/200x200/filters:no_upscale():strip_exif():format(jpg)/http://s3.ap-south-1.amazonaws.com/discovery-prod-zion/zion/1696452544852-Arijit_Singh.png";
    private String catagory_4_img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsbWXJ_vxv3p89EY-lIPowFNDylQ9bdNpXtg&s";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.home_catagory_activity);

        gridView = findViewById(R.id.gridView);

        theCatagoryItems();

        CatagoryBaseAdapter catagoryBaseAdapter = new CatagoryBaseAdapter();
        gridView.setAdapter(catagoryBaseAdapter);

    }


    // ========================  Catagory Item Data Start Here ====================================
    public void theCatagoryItems(){
        // Catagory No : 1
        catagoryMap = new HashMap<>();
        catagoryMap.put("catagory_img",catagory_1_img);
        catagoryMap.put("catagory_name","James");
        catagoryMap.put("album","album_no_1");
        catagoryList.add(catagoryMap);

        // Catagory No : 2
        catagoryMap = new HashMap<>();
        catagoryMap.put("catagory_img",catagory_2_img);
        catagoryMap.put("catagory_name","Sanu");
        catagoryMap.put("album","album_no_2");
        catagoryList.add(catagoryMap);

        // Catagory No : 3
        catagoryMap = new HashMap<>();
        catagoryMap.put("catagory_img",catagory_3_img);
        catagoryMap.put("catagory_name","Arjit");
        catagoryMap.put("album","album_no_3");
        catagoryList.add(catagoryMap);

        // Catagory No : 3
        catagoryMap = new HashMap<>();
        catagoryMap.put("catagory_img",catagory_4_img);
        catagoryMap.put("catagory_name","Alka");
        catagoryMap.put("album","album_no_4");
        catagoryList.add(catagoryMap);
    }// ========================  Catagory Item Data End Here ====================================


    // ========================  Song Album No 1 Data Start Here ====================================
    public void jamesAlbumSongList(){
        songList.clear();

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_1_img);
        songMap.put("song_title","This is Number 1 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-3s.mp3");
        songList.add(songMap);
        
        songMap = new HashMap<>();
        songMap.put("song_img",catagory_1_img);
        songMap.put("song_title","This is Number 2 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-6s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_1_img);
        songMap.put("song_title","This is Number 3 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-9s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_1_img);
        songMap.put("song_title","This is Number 4 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-6s.mp3");
        songList.add(songMap);

    }// ========================  Song Album No 1 Data End Here ======================================


    // ========================  Song Album No 2 Data Start Here ====================================
    public void sanuAlbumSongList(){
        songList.clear();

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_2_img);
        songMap.put("song_title","This is Number 1 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-12s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_2_img);
        songMap.put("song_title","This is Number 2 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-3s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_2_img);
        songMap.put("song_title","This is Number 3 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-6s.mp3");
        songList.add(songMap);

    }// ========================  Song Album No 2 Data End Here ======================================


    // ========================  Song Album No 3 Data Start Here ====================================
    public void arjitAlbumSongList(){
        songList.clear();

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_3_img);
        songMap.put("song_title","This is Number 1 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-15s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_3_img);
        songMap.put("song_title","This is Number 2 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-3s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_3_img);
        songMap.put("song_title","This is Number 3 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-6s.mp3");
        songList.add(songMap);

    }// ========================  Song Album No 3 Data End Here ======================================


    // ========================  Song Album No 4 Data Start Here ====================================
    public void alkaAlbumSongList(){
        songList.clear();

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_4_img);
        songMap.put("song_title","This is Number 1 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-9s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_4_img);
        songMap.put("song_title","This is Number 2 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-12s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_4_img);
        songMap.put("song_title","This is Number 3 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-15s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_4_img);
        songMap.put("song_title","This is Number 1 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-9s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_4_img);
        songMap.put("song_title","This is Number 2 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-12s.mp3");
        songList.add(songMap);

        songMap = new HashMap<>();
        songMap.put("song_img",catagory_4_img);
        songMap.put("song_title","This is Number 3 song");
        songMap.put("song_des","This Song is the best effective");
        songMap.put("song_url","https://samplelib.com/lib/preview/mp3/sample-15s.mp3");
        songList.add(songMap);

    }// ========================  Song Album No 4 Data End Here ======================================



    // ========================  Custom Adapter Start Here ====================================
    public class CatagoryBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return catagoryList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.grid_items_layout,parent,false);
            }
            CardView gridItemCardView = convertView.findViewById(R.id.gridItemCardView);
            ImageView gridItemImg = convertView.findViewById(R.id.gridItemImg);
            TextView gridItemsCatagory = convertView.findViewById(R.id.gridItemsCatagory);

            HashMap<String,String> hashMap = catagoryList.get(position);
            String getImgUrl = hashMap.get("catagory_img");
            String getCatTitle = hashMap.get("catagory_name");
            String getAlbum = hashMap.get("album");

            gridItemsCatagory.setText(""+getCatTitle);
            Glide.with(HomeCatagoryActivity.this)
                    .load(getImgUrl)
                    .circleCrop()
                    .placeholder(R.drawable.loading_image_placeholder)
                    .into(gridItemImg);


            gridItemCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAlbum != null && getAlbum.contains("album_no_1")){
                        jamesAlbumSongList();
                        SongListActivity.arrayList = songList;
                        startActivity(new Intent(HomeCatagoryActivity.this, SongListActivity.class));
                    }else if (getAlbum != null && getAlbum.contains("album_no_2")) {
                        sanuAlbumSongList();
                        SongListActivity.arrayList = songList;
                        startActivity(new Intent(HomeCatagoryActivity.this, SongListActivity.class));
                    }else if (getAlbum != null && getAlbum.contains("album_no_3")) {
                        arjitAlbumSongList();
                        SongListActivity.arrayList = songList;
                        startActivity(new Intent(HomeCatagoryActivity.this, SongListActivity.class));
                    }else if (getAlbum != null && getAlbum.contains("album_no_4")) {
                        alkaAlbumSongList();
                        SongListActivity.arrayList = songList;
                        startActivity(new Intent(HomeCatagoryActivity.this, SongListActivity.class));
                    }
                }
            });

            return convertView;
        }
    }// ========================  Custom Adapter End Here ====================================


    // ======================================================================================
    // ======================================================================================
    // =================================    End Work    =====================================
    // ======================================================================================
    // ======================================================================================

    // When You Pressed Back Button Then Show a alert dialogue
    @Override
    public void onBackPressed() {
        if (isTaskRoot()){
            AlertDialog alertDialog = new AlertDialog.Builder(HomeCatagoryActivity.this)
                    .setTitle("Warning !!")
                    .setMessage("Do you want to exit this app")
                    .setCancelable(true)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
            alertDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(getColor(R.color.sky));
            alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(getColor(R.color.sky));
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkConnectionCheck,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkConnectionCheck);
        super.onStop();
    }
}