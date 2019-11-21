package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    Button mTop;
    Button mBottom;
    TextView mStoryTextView;

    int mStoryIndex;
    int mAns1;
    int mAns2;

    private int[] theAnswer1 = new int[]{

            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1,
            R.string.T7_End,
            R.string.T9_End

    };

    private int[] theAnswer2 = new int[]{

            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2,
            R.string.T8_End,
            R.string.T10_End

    };

    private int[] theStory = new int[]{

            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mTop = findViewById(R.id.buttonTop);
        mBottom = findViewById(R.id.buttonBottom);
        mStoryTextView = findViewById(R.id.storyTextView);

        mStoryIndex = 0;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              if (mStoryIndex == 0){

                  mStoryIndex = 2;
                  mAns1 =2;
                  mAns2 =2;

                } else  if (mStoryIndex == 1) {

                  mStoryIndex = 2;
                  mAns1 = 2;
                  mAns2 = 2;



                } else if (mStoryIndex == 2) {

                  mStoryIndex = 5;
                  mAns1 = 3;
                  mAns2 = 3;



                }

                storyUpdate(mStoryIndex,mAns1,mAns2);

            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mStoryIndex == 0){

                    mStoryIndex = 1;
                    mAns1 = 1;
                    mAns2 = 1;

                } else  if (mStoryIndex == 1) {

                    mStoryIndex = 3;
                    mAns1 = 3;
                    mAns2 = 3;



                } else if (mStoryIndex == 2) {

                    mStoryIndex = 4;
                    mAns1 = 4;
                    mAns2 = 4;

                }

                storyUpdate(mStoryIndex,mAns1,mAns2);



            }
        });

    }

    private void storyUpdate(int updateIndex,int updateAnsTop, int updateAnsBot){

        mStoryTextView.setText(theStory[updateIndex]);
        mTop.setText(theAnswer1[updateAnsTop]);
        mBottom.setText(theAnswer2[updateAnsBot]);

        if (mStoryIndex > 2) {

            mTop.setVisibility(View.GONE);
            mBottom.setVisibility(View.GONE);


            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over !");
            alert.setCancelable(false);
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();

                }
            });
            alert.show();

        } else {

            mStoryTextView.setText(theStory[updateIndex]);
            mTop.setText(theAnswer1[updateAnsTop]);
            mBottom.setText(theAnswer2[updateAnsBot]);

        }

    }
}
