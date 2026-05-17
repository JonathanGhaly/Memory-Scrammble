package ui;

import javax.swing.*;
import java.awt.*;

public class CardButton extends JButton {

    private final int iconId;
    private boolean matched = false;

    public CardButton(int iconId) {
        this.iconId = iconId;

        setPreferredSize(
                new Dimension(
                        80,
                        100));

        setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30));

        hideCard();
    }

    public int getIconId() {
        return iconId;
    }

    public void reveal() {
        setText(String.valueOf(iconId));
    }

    public void hideCard() {
        setText("?");
    }

    public boolean isMatched(){

        return matched;
    }

    public void setMatched(
            boolean matched){

        this.matched=matched;

        if(matched){

            setBackground(
                    Color.GREEN
            );
        }
    }

}
