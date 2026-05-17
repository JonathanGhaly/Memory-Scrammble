package ui;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class CardButton extends JButton {

    private final int iconId;

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
}
