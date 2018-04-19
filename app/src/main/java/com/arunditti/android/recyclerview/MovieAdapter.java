package com.arunditti.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by arunditti on 4/19/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    //Class variables for the cursor that holds context
    private Context mContext;
    private int[] mMovieList;

    //Constructor for the TaskCursorAdapter that initializes the context
    public MovieAdapter(Context context, int[] movieList) {
        this.mContext = context;
        this.mMovieList = movieList;
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapterViewHolder holder, int position) {
        holder.mMovies.setImageResource(mMovieList[position]);
        holder.mMovies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(mContext, DetailActivity.class);
                mIntent.putExtra("Movie", mMovieList[holder.getAdapterPosition()]);
                mContext.startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovieList.length;
    }

    //Create a class within MovieAdapter  called MovieAdapterViewHolder
    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder{
        ImageView mMovies;

        public MovieAdapterViewHolder(View itemView) {
            super(itemView);

            mMovies = itemView.findViewById(R.id.movie_poster);

        }
    }


}
