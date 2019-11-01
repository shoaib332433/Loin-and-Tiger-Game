package com.example.lionandtigergame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridLayout grid;

    enum Player{
        ONE,TWO,No
    }

    Player currentplayer=Player.ONE;
    Player[] playerchoice=new Player[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<=8;i++){
            playerchoice[i]=currentplayer.No;
        }

    }




    public void onImageclick(View Imageclick){
        ImageView image=(ImageView) Imageclick;
        image.setTranslationX(-2000);

        grid=findViewById(R.id.grid);

        int[][] rowsandcolumn={ {0,1,2},{3,4,5},{6,7,8},
                                {0,3,6},{1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};

        int gettag=Integer.parseInt(image.getTag().toString());
        playerchoice[gettag] = currentplayer;


        if (currentplayer.equals(Player.ONE)){
            image.setImageResource(R.drawable.tiger);
            currentplayer = Player.TWO;

        }else if (currentplayer.equals(Player.TWO)){
            image.setImageResource(R.drawable.lion);
            currentplayer=Player.ONE;
        }

        image.animate().translationXBy(2000).alpha(1).rotationX(3600).setDuration(1000);



        for(int winnerplayer[] : rowsandcolumn){

            if ( playerchoice[winnerplayer[0]] == playerchoice[winnerplayer[1]] &&
                    playerchoice[winnerplayer[1]] == playerchoice[winnerplayer[2]]
                    && playerchoice[winnerplayer[0]] != currentplayer.No ){

                Toast.makeText(MainActivity.this,"Winner",Toast.LENGTH_SHORT).show();

            }

        }

    }

}
