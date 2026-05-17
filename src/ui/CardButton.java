package ui;

import javax.swing.*;

public class CardButton extends JButton {

    private final int iconId;

    public CardButton(int iconId) {
        this.iconId = iconId;

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
