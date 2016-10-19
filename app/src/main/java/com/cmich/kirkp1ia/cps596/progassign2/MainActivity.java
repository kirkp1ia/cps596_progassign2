package com.cmich.kirkp1ia.cps596.progassign2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<Button, Boolean> player1;
    private HashMap<Button, Boolean> player2;

    public boolean player1Turn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.newGame();
    }

    public void newGame() {
        this.player1 = new HashMap<Button, Boolean>();
        this.player2 = new HashMap<Button, Boolean>();

        this.player1.put((Button) this.findViewById(R.id.A1), false);
        this.player1.put((Button) this.findViewById(R.id.A2), false);
        this.player1.put((Button) this.findViewById(R.id.A3), false);
        this.player1.put((Button) this.findViewById(R.id.B1), false);
        this.player1.put((Button) this.findViewById(R.id.B2), false);
        this.player1.put((Button) this.findViewById(R.id.B3), false);
        this.player1.put((Button) this.findViewById(R.id.C1), false);
        this.player1.put((Button) this.findViewById(R.id.C2), false);
        this.player1.put((Button) this.findViewById(R.id.C3), false);


        this.player2.put((Button) this.findViewById(R.id.A1), false);
        this.player2.put((Button) this.findViewById(R.id.A2), false);
        this.player2.put((Button) this.findViewById(R.id.A3), false);
        this.player2.put((Button) this.findViewById(R.id.B1), false);
        this.player2.put((Button) this.findViewById(R.id.B2), false);
        this.player2.put((Button) this.findViewById(R.id.B3), false);
        this.player2.put((Button) this.findViewById(R.id.C1), false);
        this.player2.put((Button) this.findViewById(R.id.C2), false);
        this.player2.put((Button) this.findViewById(R.id.C3), false);

        ((TextView) this.findViewById(R.id.prompt)).setText("Player 1's turn!");
    }

    public void nextTurn(Button _square) {
        if (this.player1Turn) {
            this.player1.put(_square, true);
            _square.setText("X");
            ((TextView) this.findViewById(R.id.prompt)).setText("Player 2's turn!");
        } else {
            this.player2.put(_square, true);
            _square.setText("O");
            ((TextView) this.findViewById(R.id.prompt)).setText("Player 1's turn!");
        }
        this.player1Turn = !this.player1Turn;
    }

    public void moveRequested(View v) {
        Button square = (Button) v;

        this.nextTurn(square);
    }
}
