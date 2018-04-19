package com.arunditti.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by arunditti on 4/19/18.
 */

public class DetailActivity extends AppCompatActivity{
    ImageView mMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mMovie = findViewById(R.id.image_view);
        Bundle mBundle = getIntent().getExtras();
        if(mBundle != null){
            mMovie.setImageResource(mBundle.getInt("Movie"));
        }
    }
}
