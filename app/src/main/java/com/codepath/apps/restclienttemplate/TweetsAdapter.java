package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<Tweet> tweets;
    public TweetsAdapter(Context context, List<Tweet> tweets){
        this.context = context;
        this.tweets = tweets;
    }
    // For each row, inflate the layout

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_tweets,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
    //Bind values base on the position of the element


    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Get the data at position
       Tweet tweet = tweets.get(position);
        // Bind the tweet at the viewholder
        holder.bind(tweet);

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }
    public  void clear(){
        tweets.clear();

        notifyDataSetChanged();
    }
    public  void addAll (List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    // Pass in context and list of tweets
    // Define a viewholder
     public  class ViewHolder extends RecyclerView.ViewHolder{
         ImageView ivProfileImage;
         TextView tvBody;
         TextView tvScreenName;
         Tweet tweet;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);

        }

        public void bind(Tweet tweet) {
                this.tweet = tweet;
                tvBody.setText(tweet.body);
                tvScreenName.setText(tweet.user.ScreenName);
                Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);


        }
    }
}
