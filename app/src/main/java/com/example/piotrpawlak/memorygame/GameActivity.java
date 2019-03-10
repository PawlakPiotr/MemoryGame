package com.example.piotrpawlak.memorygame;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private final int default_level = 16;
    int Level;
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

    private void showCard(ImageView iv, int card) {
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

        checkState(iv, card);
    }

    private void checkState(ImageView iv, int card) {
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
                    calculate();
                }
            }
        }, 1000);
    }

    private void calculate() {

        if (first_card == second_card) {
            if (clicked_first == 0) {
               iv_11.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clicked_first == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            }

            if (clicked_second == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 3) {
                iv_14.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 4) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 5) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 6) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 7) {
                iv_24.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 8) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 9) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 10) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 11) {
                iv_34.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 12) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 13) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 14) {
                iv_43.setVisibility(View.INVISIBLE);
            } else if (clicked_second == 15) {
                iv_44.setVisibility(View.INVISIBLE);
            }

            if (turn == 1) {
                p1_points++;
                player1.setText("P1: " + p1_points);
            } else if (turn == 2) {
                p2_points++;
                player2.setText("P2: " + p2_points);
            }
        } else {
            turnCards(arr_img);

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

        checkWinner();
    }

    private void checkWinner() {
        if(iv_11.getVisibility() == View.INVISIBLE && iv_12.getVisibility() == View.INVISIBLE &&
                iv_13.getVisibility() == View.INVISIBLE && iv_14.getVisibility() == View.INVISIBLE &&
                iv_21.getVisibility() == View.INVISIBLE && iv_22.getVisibility() == View.INVISIBLE &&
                iv_23.getVisibility() == View.INVISIBLE && iv_24.getVisibility() == View.INVISIBLE &&
                iv_31.getVisibility() == View.INVISIBLE && iv_32.getVisibility() == View.INVISIBLE &&
                iv_33.getVisibility() == View.INVISIBLE && iv_34.getVisibility() == View.INVISIBLE &&
                iv_41.getVisibility() == View.INVISIBLE && iv_42.getVisibility() == View.INVISIBLE &&
                iv_43.getVisibility() == View.INVISIBLE && iv_44.getVisibility() == View.INVISIBLE
        ){
            AlertDialog.Builder winner = new AlertDialog.Builder(GameActivity.this);

            String win;
            if(p1_points > p2_points) {
                win = "WON PLAYER 1";
            } else if (p1_points < p2_points) {
                win = "WON PLAYER 2";
            } else {
                win = "DRAW!";
            }

            winner.setMessage("GAME OVER! " + win).setCancelable(false)
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

    private void setComponents(int level) {
        player1 = findViewById(R.id.txt_player1);
        player2 = findViewById(R.id.txt_player2);

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

    private void setClickAction(ImageView[] arr) {

        for (final ImageView img_view : arr) {
            img_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int card = Integer.parseInt((String) v.getTag());
                    showCard(img_view, card);
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
