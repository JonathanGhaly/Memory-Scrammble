package logic;

import ui.CardButton;
import ui.MemoryScramble;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameManager {

    private CardButton firstSelected;
    private CardButton secondSelected;

    private boolean checking=false;

    private int matchesFound=0;

    private final MemoryScramble game;

    public GameManager(
            MemoryScramble game){

        this.game=game;
    }

    public JPanel createBoard(
            int rows,
            int columns){

        JPanel panel=
                new JPanel(
                        new GridLayout(
                                rows,
                                columns,
                                5,
                                5
                        )
                );

        int totalCells=
                rows*columns;

        int pairs=
                totalCells/2;

        ArrayList<Integer> icons=
                new ArrayList<>();

        for(int i=1;i<=pairs;i++){

            icons.add(i);
            icons.add(i);
        }

        Collections.shuffle(
                icons
        );

        for(int icon:icons){

            CardButton button=
                    new CardButton(
                            icon
                    );

            button.addActionListener(
                    e->handleClick(
                            (CardButton)e.getSource(),
                            pairs
                    )
            );

            panel.add(
                    button
            );
        }

        return panel;
    }

    private void handleClick(
            CardButton clicked,
            int totalPairs){

        if(checking)
            return;

        if(clicked.isMatched())
            return;

        if(clicked==firstSelected)
            return;

        clicked.reveal();

        if(firstSelected==null){

            firstSelected=clicked;
        }

        else{

            secondSelected=clicked;

            checkMatch(
                    totalPairs
            );
        }
    }

    private void checkMatch(
            int totalPairs){

        if(firstSelected.getIconId()
                ==
                secondSelected.getIconId()){

            firstSelected.setMatched(
                    true
            );

            secondSelected.setMatched(
                    true
            );

            matchesFound++;

            if(matchesFound
                    ==
                    totalPairs){

                game.playerWon();
            }

            firstSelected=null;
            secondSelected=null;
        }

        else{

            checking=true;

            Timer timer=
                    new Timer(
                            800,
                            e->{

                                firstSelected.hideCard();

                                secondSelected.hideCard();

                                firstSelected=null;

                                secondSelected=null;

                                checking=false;
                            }
                    );

            timer.setRepeats(false);

            timer.start();
        }
    }
}