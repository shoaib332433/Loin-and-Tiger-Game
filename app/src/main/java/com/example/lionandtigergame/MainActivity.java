package com.example.lionandtigergame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    enum Player{
        ONE,TWO,NO
    }

    private GridLayout grid;
    private Button btn;
    Player currentplayer=Player.ONE;
    Player[] playerindexvalue=new Player[9];
    Boolean selected=false;

    String winplayer;

    int[][] dimentions={{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i=0;i<playerindexvalue.length;i++){
            playerindexvalue[i] = Player.NO;
        }

        btn=findViewById(R.id.restart);
        grid=findViewById(R.id.grid);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }


    public void onImageclick(View Imageclick){
        ImageView img= (ImageView) Imageclick;
        btn.setVisibility(View.VISIBLE);
        int index=Integer.parseInt(img.getTag().toString());


        if ( playerindexvalue[index]==Player.NO && selected.equals(false)){

            playerindexvalue[index]=currentplayer;

            if (currentplayer==Player.ONE){
                img.setImageResource(R.drawable.lion);
                currentplayer=Player.TWO;

            }else if (currentplayer==Player.TWO){
                img.setImageResource(R.drawable.tiger);
                currentplayer=Player.ONE;
            }

            for (int[] playerindex: dimentions){

                if (playerindexvalue[playerindex[0]] == playerindexvalue[playerindex[1]] &&
                        playerindexvalue[playerindex[1]] == playerindexvalue[playerindex[2]] &&
                        playerindexvalue[playerindex[0]] != Player.NO){

                    if (currentplayer==Player.ONE){
                        winplayer="Two Tiger";
                    }else if(currentplayer==Player.TWO){
                        winplayer="One Lion";
                    }

                    selected=true;
                    Toast.makeText(MainActivity.this,"Player "+winplayer+" is the  Winner",Toast.LENGTH_SHORT).show();
                }
            }
            img.animate().alpha(1).setDuration(1000);
        }

    }


    public void reset(){
        btn.setVisibility(View.GONE);
        for (int i=0;i<grid.getChildCount();i++){
            ImageView img=(ImageView) grid.getChildAt(i);
            img.setImageDrawable(null);
            img.setAlpha(0.2f);
        }
        for (int i=0;i<playerindexvalue.length;i++){
            playerindexvalue[i] = Player.NO;
        }
        selected=false;
        currentplayer=Player.ONE;

    }


}
