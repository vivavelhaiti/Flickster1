package com.example.shedeline.flickster.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shedeline.flickster.R;
import com.example.shedeline.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by shedeline on 7/21/2017.
 */

public class MovieArrayAdapter extends ArrayAdapter<Movie> {

  public MovieArrayAdapter(Context context, ArrayList<Movie> movie) {
    super(context, android.R.layout.simple_list_item_1, movie);

  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

   //get the data items for position
    Movie movie = getItem(position);
    //check the existing view being used
    if (convertView == null){
      LayoutInflater inflater = LayoutInflater.from(getContext());
      convertView= inflater.inflate(R.layout.item_movie,parent,false);
    }

    //find the image view
    ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
    //clear out image from convertview
    ivImage.setImageResource(0);
    TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
    TextView tvOverview = (TextView)convertView.findViewById(R.id.tvOverview);

    //populate data
    tvTitle.setText(movie.getOriginalTitle());
    tvOverview.setText(movie.getOverview());

    Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage);
    //return the view
    return  convertView;



  }

}


