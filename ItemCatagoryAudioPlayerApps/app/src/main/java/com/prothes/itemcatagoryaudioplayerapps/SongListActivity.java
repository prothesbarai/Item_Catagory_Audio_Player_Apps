package com.prothes.itemcatagoryaudioplayerapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class SongListActivity extends AppCompatActivity {
    private ListView listView;
    private NetworkConnectionCheck networkConnectionCheck = new NetworkConnectionCheck();
    private LottieAnimationView musicAnimationView;
    private HashMap<String,String> hashMap = new HashMap<>();
    public static ArrayList< HashMap<String,String> > arrayList = new ArrayList<>();
    private MediaPlayer mediaPlayer;
    private boolean isplaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(getColor(R.color.sky));
        this.getWindow().setNavigationBarColor(getColor(R.color.sky));
        setContentView(R.layout.song_list_activity);

        listView = findViewById(R.id.listView);
        musicAnimationView = findViewById(R.id.musicAnimationView);

        SongBaseAdapter songBaseAdapter = new SongBaseAdapter();
        listView.setAdapter(songBaseAdapter);

    }

    public class SongBaseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
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
                convertView = layoutInflater.inflate(R.layout.list_items_layout,parent,false);
            }
            RoundedImageView listItemIconView = convertView.findViewById(R.id.listItemIconView);
            ImageView listItemImgView = convertView.findViewById(R.id.listItemImgView);
            TextView listItemsTitle = convertView.findViewById(R.id.listItemsTitle);
            TextView listItemsDes = convertView.findViewById(R.id.listItemsDes);

            hashMap = arrayList.get(position);
            String get_img = hashMap.get("song_img");
            String get_title = hashMap.get("song_title");
            String get_des = hashMap.get("song_des");
            String get_song = hashMap.get("song_url");

            listItemsTitle.setText(""+get_title);
            listItemsDes.setText(""+get_des);
            Glide.with(SongListActivity.this)
                    .load(get_img)
                    .placeholder(R.drawable.loading_image_placeholder)
                    .circleCrop()
                    .into(listItemImgView);


            listItemIconView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (CommonNetwork.isNetworkAvailable(SongListActivity.this)){

                        if (listItemIconView.getTag() != null && listItemIconView.getTag().toString().contains("NOT_PLAYING")){

                            if (mediaPlayer != null) mediaPlayer.release();

                            mediaPlayer = new MediaPlayer();
                            try {
                                mediaPlayer.setDataSource(get_song);
                                mediaPlayer.prepare();
                                mediaPlayer.start();
                                musicAnimationView.playAnimation();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }

                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mp) {
                                    if (mediaPlayer != null) mediaPlayer.release();
                                    listItemIconView.setTag("NOT_PLAYING");
                                    musicAnimationView.cancelAnimation();
                                    listItemIconView.setImageDrawable(getDrawable(R.drawable.play_icon));
                                }
                            });

                            listItemIconView.setTag("PLAYING");
                            listItemIconView.setImageDrawable(getDrawable(R.drawable.stop_icon));
                            isplaying = false;
                        }else{
                            if (mediaPlayer != null) mediaPlayer.release();
                            listItemIconView.setTag("NOT_PLAYING");
                            listItemIconView.setImageDrawable(getDrawable(R.drawable.play_icon));
                            isplaying = true;
                            musicAnimationView.cancelAnimation();
                        }

                        // এই লুপটি listView এর সকল আইটেমের ইমেজ ভিউকে play_icon সেট করছে যাতে অন্য কোনো গান চালু না থাকে।
                        for (int i=0; i<listView.getChildCount(); i++){
                            View view = listView.getChildAt(i);
                            ImageView imageView = view.findViewById(R.id.listItemIconView);
                            imageView.setImageDrawable(getDrawable(R.drawable.play_icon));
                        }


                        // শেষের এই অংশটি চেক করছে যদি isPlayIcon ফ্ল্যাগটি false থাকে, তাহলে ইমেজ ভিউতে stop_icon রাখা হচ্ছে, অর্থাৎ গান এখন বাজছে।
                        if (!isplaying){
                            listItemIconView.setImageDrawable(getDrawable(R.drawable.stop_icon));
                        }
                    }else{
                        Toast.makeText(SongListActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                    }

                }
            });

            return convertView;
        }
    }




    @Override
    public void onBackPressed() {
        if (mediaPlayer != null) mediaPlayer.release();
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkConnectionCheck,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        if (mediaPlayer != null) mediaPlayer.release();
        unregisterReceiver(networkConnectionCheck);
        super.onStop();
    }

    @Override
    protected void onPause() {
        if (mediaPlayer != null) mediaPlayer.release();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) mediaPlayer.release();
        super.onDestroy();
    }
}