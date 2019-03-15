package com.example.piotrpawlak.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    GameBuilder gameBuilder;
    Player p1, p2;
    private final int default_level = 16;
    int Level, Mode;
    ImageView[] arr_img;

    TextView player1, player2;

    ImageView iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24,
                    iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44;

    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108, 201, 202, 203, 204, 205, 206, 207, 208};

    int img101, img102, img103, img104, img105, img106, img107, img108;
    int img201, img202, img203, img204, img205, img206, img207, img208;


    int first_card, second_card, clicked_first, clicked_second, cardNumber = 1;

    int turn = 1, p1_points = 0, p2_points = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Level = getIntent().hasExtra("level") ? Integer.parseInt(getIntent().getStringExtra("level")) : default_level;
        Mode = Integer.parseInt(getIntent().getStringExtra("mode"));

        setComponents(Level);
        setCards();

        Collections.shuffle(Arrays.asList(cardsArray));
        player2.setTextColor(Color.GRAY);

        ImageView[] img_arr = {iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24,
                                    iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44};
        arr_img = img_arr;
        setImagesTags(Level);
        setClickAction(img_arr);
    }

    private void setUpGame() { //TODO add game mode handler
        p1 = new Player(player1);
        p2 = new Player(player2);

        gameBuilder = new GameBuilder(Mode, p1, p2);

        p2.p_txt_view.setTextColor(Color.GRAY);
    }

    private void showCard(ImageView iv, int card, ImageView[] img_arr) {
        if (cardsArray[card] == 101 || cardsArray[card] == 201) {
            iv.setImageResource(img101);
        } else if (cardsArray[card] == 102 || cardsArray[card] == 202) {
            iv.setImageResource(img102);
        } else if (cardsArray[card] == 103 || cardsArray[card] == 203) {
            iv.setImageResource(img103);
        } else if (cardsArray[card] == 104 || cardsArray[card] == 204) {
            iv.setImageResource(img104);
        } else if (cardsArray[card] == 105 || cardsArray[card] == 205) {
            iv.setImageResource(img105);
        } else if (cardsArray[card] == 106 || cardsArray[card] == 206) {
            iv.setImageResource(img106);
        } else if (cardsArray[card] == 107 || cardsArray[card] == 207) {
            iv.setImageResource(img107);
        } else if (cardsArray[card] == 108 || cardsArray[card] == 208) {
            iv.setImageResource(img108);
        }

        iv.setEnabled(false);

        checkState(iv, card, img_arr);
    }

    private void checkState(ImageView iv, int card, final ImageView[] img_arr) {
        if (cardNumber == 1) {
            first_card = cardsArray[card];

            if (first_card > 200) {
                first_card -= 100;
            }
            cardNumber = 2;
            clicked_first = card;
        } else if (cardNumber == 2) {

            second_card = cardsArray[card];

            if (second_card > 200) {
                second_card -= 100;
            }
            cardNumber = 1;
            clicked_second = card;

        }

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
            if (cardNumber == 1) {
                calculate(img_arr);
            }
            }
        }, 1000);
    }

    private void setVisibility(ImageView[] arr, int clicked) {
        for (int i = 0; i< arr.length; i++) {
            if (clicked == i) {
                arr[i].setVisibility(View.INVISIBLE);
            }
        }
    }

    private void calculatePoints(int mode) {
        if (mode == 1) {

            p1_points++;
            player1.setText("POINTS: " + p1_points);

        } else if (mode == 2) {

            if (turn == 1) {
                p1_points++;
                player1.setText("P1: " + p1_points);
            } else if (turn == 2) {
                p2_points++;
                player2.setText("P2: " + p2_points);
            }
        }
    }

    private void calculate(ImageView[] img_arr) {

        if (first_card == second_card) {

            setVisibility(img_arr, clicked_first);
            setVisibility(img_arr, clicked_second);
            calculatePoints(Mode);

        } else {
            turnCards(arr_img);

            for (ImageView iv : img_arr) {
                iv.setEnabled(true);
            }

            changePlayer();
        }

        checkWinner();
    }

    private void changePlayer() {
        if (Mode == 2) {
            if (turn == 1) {
                turn = 2;
                player2.setTextColor(Color.BLACK);
                player1.setTextColor(Color.GRAY);
            } else if(turn == 2){
                turn = 1;
                player1.setTextColor(Color.BLACK);
                player2.setTextColor(Color.GRAY);
            }
        }
    }

    private boolean checkVisibility(ImageView[] arr) {
        List<Boolean> state = new ArrayList<Boolean>();
        for (ImageView iv : arr) {
            if (iv.getVisibility() == View.INVISIBLE) {
                state.add(true);
            } else {
                state.add(false);
            }
        }

        return !state.contains(Boolean.valueOf(false));
    }

    private void checkWinner() {
        ImageView[] img_arr = {iv_11, iv_12, iv_13, iv_14, iv_21, iv_22, iv_23, iv_24,
                iv_31, iv_32, iv_33, iv_34, iv_41, iv_42, iv_43, iv_44};

        if(checkVisibility(img_arr)){
            AlertDialog.Builder winner = new AlertDialog.Builder(GameActivity.this);


            winner.setMessage(setUpWinnerInformation(Mode)).setCancelable(false)
                    .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            final Intent new_game = new Intent(getApplicationContext(), GameActivity.class);
                            startActivity(new_game);
                        }
                    })
            .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    final Intent exit = new Intent(getApplicationContext(), StartActivity.class);
                    startActivity(exit);
                }
            });

            AlertDialog alert = winner.create();
            alert.show();
        }
    }

    private String setUpWinnerInformation(int mode) {
        String winner_msg = "GAME OVER! ";

        if (mode == 1) {
            winner_msg += "YOU WIN!";
        } else {
            if(p1_points > p2_points) {
                winner_msg += "WON PLAYER 1";
            } else if (p1_points < p2_points) {
                winner_msg += "WON PLAYER 2";
            } else {
                winner_msg += "DRAW!";
            }
        }

        return winner_msg;
    }

    private void setComponents(int level) {
        player1 = findViewById(R.id.txt_player1);
        player2 = findViewById(R.id.txt_player2);

        player1.setText(Mode == 1 ? "POINTS" : "P1: 0");
        player2.setText(Mode == 1 ? "" : "P2: 0");

        setImages(level);
    }

    private void setImages(int level) {
        iv_11 = findViewById(R.id.iv_11);
        iv_12 = findViewById(R.id.iv_12);
        iv_13 = findViewById(R.id.iv_13);
        iv_14 = findViewById(R.id.iv_14);

        iv_21 = findViewById(R.id.iv_21);
        iv_22 = findViewById(R.id.iv_22);
        iv_23 = findViewById(R.id.iv_23);
        iv_24 = findViewById(R.id.iv_24);

        iv_31 = findViewById(R.id.iv_31);
        iv_32 = findViewById(R.id.iv_32);
        iv_33 = findViewById(R.id.iv_33);
        iv_34 = findViewById(R.id.iv_34);

        iv_41 = findViewById(R.id.iv_41);
        iv_42 = findViewById(R.id.iv_42);
        iv_43 = findViewById(R.id.iv_43);
        iv_44 = findViewById(R.id.iv_44);
    }

    private void setImagesTags(int level) {

        int i = 0;

        for (ImageView img: arr_img) {
            img.setTag(String.valueOf(i));
            i++;
        }

    }

    private void setCards() {
        img101 = R.drawable.ic_image_101;
        img102 = R.drawable.ic_image_102;
        img103 = R.drawable.ic_image_103;
        img104 = R.drawable.ic_image_104;
        img105 = R.drawable.ic_image_105;
        img106 = R.drawable.ic_image_106;
        img107 = R.drawable.ic_image_107;
        img108 = R.drawable.ic_image_108;

        img201 = R.drawable.ic_image_101;
        img202 = R.drawable.ic_image_102;
        img203 = R.drawable.ic_image_103;
        img204 = R.drawable.ic_image_104;
        img205 = R.drawable.ic_image_105;
        img206 = R.drawable.ic_image_106;
        img207 = R.drawable.ic_image_107;
        img208 = R.drawable.ic_image_108;


    }

    private void setClickAction(final ImageView[] arr) {

        for (final ImageView img_view : arr) {
            img_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int card = Integer.parseInt((String) v.getTag());
                    showCard(img_view, card, arr);
                }
            });
        }
    }

    private void turnCards(ImageView[] arr) {
        for ( ImageView img_view: arr) {
            img_view.setImageResource(R.drawable.card);
        }
    }
}
