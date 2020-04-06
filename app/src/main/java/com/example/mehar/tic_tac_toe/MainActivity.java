package com.example.mehar.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int[] game = {-8,-7,-6,-5,-4,-3,-2,-1,0};
    boolean[] used = {true,true,true,true,true,true,true,true,true};
    boolean flag=true,gameActive=true;
    void Click(View view){
        if (gameActive) {
            if (flag) {
                int tag = Integer.parseInt(view.getTag().toString());
                if (used[tag-1]) {
                    ImageView imageView =(ImageView) (view);
                    imageView.animate().alpha(1).setDuration(1);
                    game[tag - 1] = 1;
                    used[tag-1] = false;
                    flag = false;
                }
            }
            else{
                int tag = Integer.parseInt(view.getTag().toString());
                if (used[tag-1]) {
                    ImageView imageView = (ImageView) (view);
                    imageView.setImageResource(0);
                    imageView.setImageResource(R.drawable.round);
                    imageView.animate().alpha(1).setDuration(1);
                    game[tag - 1] = 2;
                    used[tag - 1] = false;
                    flag = true;
                }
            }
            if ((game[0] == game[1] && game[1] == game[2] && game[2] == game[0])
                    || (game[3] == game[4] && game[4] == game[5] && game[5] == game[3])
                    || (game[6] == game[7] && game[7] == game[8] && game[8] == game[6])
                    || (game[0] == game[3] && game[3] == game[6] && game[0] == game[6])
                    || (game[1] == game[4] && game[4] == game[7] && game[1] == game[7])
                    || (game[2] == game[5] && game[5] == game[8] && game[2] == game[8])
                    || (game[0] == game[4] && game[4] == game[8] && game[8] == game[0])
                    || (game[2] == game[4] && game[4] == game[6] && game[2] == game[6])) {
                String s = flag ? "Player2" : "Player1";
                gameActive = false;
                Button button = (Button) (findViewById(R.id.button));
                TextView winner = (TextView) (findViewById(R.id.WinnertextView));
                winner.setText(s+" Wins!!");
                button.setVisibility(View.VISIBLE);
                winner.setVisibility(View.VISIBLE);
            }
            else{
                int count=0;
                for(int i=0;i<9;i++){
                    if (used[i]==false){
                        count+=1;
                    }
                }
                if (count==9){
                    String finish ="Draw !!";
                    Button button = (Button) (findViewById(R.id.button));
                    TextView winner = (TextView) (findViewById(R.id.WinnertextView));
                    winner.setText(finish);
                    button.setVisibility(View.VISIBLE);
                    winner.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void playAgain(View view){
        Button button = (Button) (findViewById(R.id.button));
        TextView winner = (TextView) (findViewById(R.id.WinnertextView));
        button.setVisibility(View.INVISIBLE);
        winner.setVisibility(View.INVISIBLE);
        GridLayout gridLayout = (GridLayout) (findViewById(R.id.gridLayout));
        gameActive = true;
        flag = true;
        for(int i=0; i<gridLayout.getChildCount();i++) {
            ImageView counter = (ImageView)gridLayout.getChildAt(i);
            counter.setImageResource(0);
            counter.setImageResource(R.drawable.cross);
            counter.animate().alpha(0).setDuration(1);
        }
        for(int i=0;i<9;i++){
            game[i] = i-8;
            used[i] = true;
        }

    }
}
