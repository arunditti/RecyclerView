package com.arunditti.android.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by arunditti on 4/19/18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    final private ListItemClickListener mOnClickListener;
    private final Context mContext;

    /**
     * The interface that receives onClick messages.
     */
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    private int[] mMovieList;

    public MovieAdapter(Context mContext, ListItemClickListener mOnClickListener, int[] movieList) {
        this.mOnClickListener = mOnClickListener;
        this.mMovieList = movieList;
        this.mContext = mContext;
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        //Get the RecyclerView item layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MovieAdapterViewHolder holder, int position) {
       int movieId = mMovieList[position];
        holder.mMovies.setImageResource(movieId);
    }

    @Override
    public int getItemCount() {
        return mMovieList.length;
    }

    //Create a class within MovieAdapter  called MovieAdapterViewHolder
    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mMovies;

        public MovieAdapterViewHolder(View itemView) {
            super(itemView);

            mMovies = itemView.findViewById(R.id.movie_poster);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
