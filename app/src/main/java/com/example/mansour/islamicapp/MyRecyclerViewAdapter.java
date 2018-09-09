package com.example.mansour.islamicapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mansour on 9/7/2018.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    List<Readers> mReaders;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextViewReaderName;
        public ImageView mImageViewReaderImage;
        public Button mBtnPlay;
        public Button mBtnStop;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextViewReaderName = (TextView) itemView.findViewById(R.id.textViewReaderName);
            mImageViewReaderImage = (ImageView) itemView.findViewById(R.id.imageViewReaderImage);
            mBtnPlay = (Button) itemView.findViewById(R.id.btnPlay);
            mBtnStop = (Button) itemView.findViewById(R.id.btnStop);
        }

    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyRecyclerViewAdapter(List<Readers> mReaders) {
        this.mReaders = mReaders;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // create a new view
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder mViewHolder = new ViewHolder(mView);
        return (mViewHolder);
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextViewReaderName.setText(mReaders.get(position).mReaderName);
        holder.mImageViewReaderImage.setImageResource(mReaders.get(position).mReaderImage);

        holder.mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListenToQuran.mListenToQuranService.setUrl(mReaders.get(position).mUrl);
                holder.mBtnPlay.setEnabled(false);
                holder.mBtnStop.setEnabled(true);
            }
        });

        holder.mBtnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ListenToQuranService.mMediaPlayer != null) {
                    ListenToQuranService.mMediaPlayer.stop();
                    ListenToQuranService.isPlaying = false;
                    holder.mBtnStop.setEnabled(false);
                    holder.mBtnPlay.setEnabled(true);
                }
            }
        });

    }
    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mReaders.size();
    }

}
