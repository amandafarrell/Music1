package com.amandafarrell.www.music1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private Button mNewNote;
    private ArrayList<ImageView> mImageViews;
    private ArrayList<Integer> mNotes;
    private HashMap<ImageView, Integer> mImageViewImagePairs;

    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;
    private ImageView mImageView5;
    private ImageView mImageView6;
    private ImageView mImageView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNewNote = (Button) findViewById(R.id.button_new_note);

        //Find views
        mImageView1 = findViewById(R.id.image1);
        mImageView2 = findViewById(R.id.image2);
        mImageView3 = findViewById(R.id.image3);
        mImageView4 = findViewById(R.id.image4);
        mImageView5 = findViewById(R.id.image5);
        mImageView6 = findViewById(R.id.image6);
        mImageView7 = findViewById(R.id.image7);


//        //ArrayList of ImageViews
//        mImageViews = new ArrayList<>();
//        mImageViews.add(mImageView1);
//        mImageViews.add(mImageView2);
//        mImageViews.add(mImageView3);

        //ArrayList of image ids
        mNotes = new ArrayList<>();
        mNotes.add(R.drawable.im0);
        mNotes.add(R.drawable.im1);
        mNotes.add(R.drawable.im2);
        mNotes.add(R.drawable.im3);
        mNotes.add(R.drawable.im4);
        mNotes.add(R.drawable.im5);
        mNotes.add(R.drawable.im6);

        //Store ImageView and note pairs in a map
        mImageViewImagePairs = new HashMap<>();
        mImageViewImagePairs.put(mImageView1, 0);
        mImageViewImagePairs.put(mImageView2, 1);
        mImageViewImagePairs.put(mImageView3, 2);
        mImageViewImagePairs.put(mImageView4, 3);
        mImageViewImagePairs.put(mImageView5, 4);
        mImageViewImagePairs.put(mImageView6, 5);
        mImageViewImagePairs.put(mImageView7, 6);

        displayNotes();

        mNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (ImageView key : mImageViewImagePairs.keySet()) {
                    int positionInNoteArrayList = mImageViewImagePairs.get(key);
                    if (positionInNoteArrayList < mNotes.size() - 1){
                        mImageViewImagePairs.put(key,positionInNoteArrayList + 1);
                    } else {
                        mImageViewImagePairs.put(key, 0);
                    }
                }
                displayNotes();
            }
        });
    }

    private void displayNotes() {
        for ( ImageView key : mImageViewImagePairs.keySet() ) {
            key.setImageResource(mNotes.get(mImageViewImagePairs.get(key)));
        }
    }
}
