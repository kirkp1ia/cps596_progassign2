package com.cmich.kirkp1ia.cps596.progassign2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<Button, Boolean> player1;
    private HashMap<Button, Boolean> player2;

    public boolean player1Turn = true;
    private boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.newGame(null);
    }

    public void newGame(View v) {
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

        Button a1 = (Button) this.findViewById(R.id.A1);
        Button a2 = (Button) this.findViewById(R.id.A2);
        Button a3 = (Button) this.findViewById(R.id.A3);
        Button b1 = (Button) this.findViewById(R.id.B1);
        Button b2 = (Button) this.findViewById(R.id.B2);
        Button b3 = (Button) this.findViewById(R.id.B3);
        Button c1 = (Button) this.findViewById(R.id.C1);
        Button c2 = (Button) this.findViewById(R.id.C2);
        Button c3 = (Button) this.findViewById(R.id.C3);
        a1.setText("");
        a2.setText("");
        a3.setText("");
        b1.setText("");
        b2.setText("");
        b3.setText("");
        c1.setText("");
        c2.setText("");
        c3.setText("");

        this.player1Turn = true;
        this.gameOver = false;
    }

    public void nextTurn(Button _square) {
        if (this.player1Turn) {
            this.player1.put(_square, true);
            _square.setText("X");

            if (this.checkWin(this.player1)) {
                ((TextView) this.findViewById(R.id.prompt)).setText("Player 1 wins!");
                this.gameOver = true;
                return;
            } else {
                ((TextView) this.findViewById(R.id.prompt)).setText("Player 2's turn!");
            }
        } else {
            this.player2.put(_square, true);
            _square.setText("O");

            if (this.checkWin(this.player2)) {
                ((TextView) this.findViewById(R.id.prompt)).setText("Player 2 wins!");
                this.gameOver = true;
                return;
            } else {
                ((TextView) this.findViewById(R.id.prompt)).setText("Player 1's turn!");
            }
        }
        this.player1Turn = !this.player1Turn;
    }

    public void moveRequested(View v) {
        Button square = (Button) v;

        if (!square.getText().equals("") || this.gameOver) {
            // Someone already went here or the game is over.
            return;
        }

        this.nextTurn(square);
    }

    private boolean checkWin(HashMap<Button, Boolean> _player) {
        Button a1 = (Button) this.findViewById(R.id.A1);
        Button a2 = (Button) this.findViewById(R.id.A2);
        Button a3 = (Button) this.findViewById(R.id.A3);
        Button b1 = (Button) this.findViewById(R.id.B1);
        Button b2 = (Button) this.findViewById(R.id.B2);
        Button b3 = (Button) this.findViewById(R.id.B3);
        Button c1 = (Button) this.findViewById(R.id.C1);
        Button c2 = (Button) this.findViewById(R.id.C2);
        Button c3 = (Button) this.findViewById(R.id.C3);

        if (_player.get(a1) && _player.get(a2) && _player.get(a3)) {
            return true;
        } else if (_player.get(a1) && _player.get(b2) && _player.get(c3)) {
            return true;
        } else if (_player.get(a1) && _player.get(b1) && _player.get(c1)) {
            return true;
        } else if (_player.get(a2) && _player.get(b2) && _player.get(c2)) {
            return true;
        } else if (_player.get(a3) && _player.get(b3) && _player.get(c3)) {
            return true;
        } else if (_player.get(a3) && _player.get(b2) && _player.get(c1)) {
            return true;
        } else if (_player.get(b1) && _player.get(b2) && _player.get(b3)) {
            return true;
        } else if (_player.get(c1) && _player.get(c2) && _player.get(c3)) {
            return true;
        } else {
            return false;
        }
    }
}
