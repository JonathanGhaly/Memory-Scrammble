package logic;

import ui.CardButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameManager {

    private CardButton firstSelected;
    private CardButton secondSelected;

    private boolean checking = false;

    public JPanel createBoard(
            int rows,
            int columns) {

        JPanel panel = new JPanel(
                new GridLayout(
                        rows,
                        columns,
                        5,
                        5
                ));

        int totalCells = rows * columns;
        int pairs = totalCells / 2;

        ArrayList<Integer> icons =
                new ArrayList<>();

        for (int i = 1; i <= pairs; i++) {

            icons.add(i);
            icons.add(i);
        }

        Collections.shuffle(icons);

        for (int icon : icons) {

            CardButton button =
                    new CardButton(icon);

            button.addActionListener(
                    e -> handleClick(
                            (CardButton) e.getSource()
                    )
            );

            panel.add(button);
        }

        return panel;
    }

    private void handleClick(
            CardButton clicked) {

        if (checking)
            return;

        if (clicked.isMatched())
            return;

        if (clicked == firstSelected)
            return;

        clicked.reveal();

        if (firstSelected == null) {

            firstSelected = clicked;
        }
        else {

            secondSelected = clicked;

            checkMatch();
        }
    }

    private void checkMatch() {

        if (firstSelected.getIconId()
                ==
                secondSelected.getIconId()) {

            firstSelected.setMatched(
                    true);

            secondSelected.setMatched(
                    true);

            firstSelected = null;
            secondSelected = null;
        }

        else {

            checking = true;

            Timer timer =
                    new Timer(
                            800,
                            e -> {

                                firstSelected.hideCard();

                                secondSelected.hideCard();

                                firstSelected = null;
                                secondSelected = null;

                                checking = false;
                            }
                    );

            timer.setRepeats(false);

            timer.start();
        }
    }
}