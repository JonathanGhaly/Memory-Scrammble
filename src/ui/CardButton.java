package ui;

import javax.swing.*;

public class CardButton extends JButton {

    private final int iconId;

    public CardButton(int iconId) {
        this.iconId = iconId;
    }

    public int getIconId() {
        return iconId;
    }
}
