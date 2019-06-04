package com.example.liontigertictac;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum player
    {
        ONE,TWO ,No

    }
        player CurrentPlayer=player.ONE;

    player[] playerChoices= new player[9];

    Button button;
    private GridLayout gridLayout;





    int[][] winnerRowsColumn =
            {{0, 1, 2}, {3, 4, 5},
            {6, 7, 8}, {0, 3, 6},
            {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4,6}};

    public Boolean gameover=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int index=0;index<playerChoices.length;index++)
        {
            playerChoices[index]=player.No;

        }

//        playerChoices[0]=player.No;
//        playerChoices[1]=player.No;
//        playerChoices[2]=player.No;
//        playerChoices[3]=player.No;
//        playerChoices[4]=player.No;
//        playerChoices[5]=player.No;
//        playerChoices[6]=player.No;
//        playerChoices[7]=player.No;
//        playerChoices[8]=player.No;


        gridLayout=findViewById(R.id.gridLayout);

        button=findViewById(R.id.bt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reset();

            }
        });
    }

    public void imageViewIsTapped(View imageView) {


        ImageView tappedImageView = (ImageView) imageView;

        int tiTag = Integer.parseInt(tappedImageView.getTag().toString());

        if (playerChoices[tiTag] == player.No && gameover == false) {

            tappedImageView.setTranslationX(-2000);


            playerChoices[tiTag] = CurrentPlayer;


            if (CurrentPlayer == player.ONE) {
                tappedImageView.setImageResource(R.drawable.tiger);
                CurrentPlayer = player.TWO;
            } else if (CurrentPlayer == player.TWO) {
                tappedImageView.setImageResource(R.drawable.lion);
                CurrentPlayer = player.ONE;
            }

            tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

            Toast.makeText(this, tappedImageView.getTag().toString(), Toast.LENGTH_SHORT).show();

            String winnerofgame = "";


            for (int[] winnerColumn : winnerRowsColumn) {
                if (playerChoices[winnerColumn[0]] ==
                        playerChoices[winnerColumn[1]]
                        && playerChoices[winnerColumn[1]]
                        == playerChoices[winnerColumn[2]]
                        && playerChoices[winnerColumn[0]] != player.No)
                {
                    button.setVisibility(View.VISIBLE);
                    gameover = true;



                    if (CurrentPlayer == player.ONE) {

                        winnerofgame = "TWO IS THE WINNER";
                    }
                    else if (CurrentPlayer == player.TWO)
                    {
                        winnerofgame = "ONE IS THE WINNER";
                    }
                    else
                    {
                        button.setVisibility(View.VISIBLE);
                    }


                    Toast.makeText(this, winnerofgame, Toast.LENGTH_SHORT).show();



                }
            }

        }//false

    }//is tapped

    public void reset()
    {

      int i;
      for(i=0;i < gridLayout.getChildCount();i++)
      {
          ImageView ig= (ImageView) gridLayout.getChildAt(i);
          ig.setImageDrawable(null);
          ig.setAlpha(0.2000f);

      }

       CurrentPlayer=player.ONE;

      int index;

        for(index=0;index<playerChoices.length;index++)
        {
            playerChoices[index]=player.No;
        }


//        playerChoices[0]=player.No;
//        playerChoices[1]=player.No;
//        playerChoices[2]=player.No;
//        playerChoices[3]=player.No;
//        playerChoices[4]=player.No;
//        playerChoices[5]=player.No;
//        playerChoices[6]=player.No;
//        playerChoices[7]=player.No;
//        playerChoices[8]=player.No;

        gameover=false;
        button.setVisibility(View.INVISIBLE);
        button.setVisibility(View.VISIBLE);


    }
}//main
