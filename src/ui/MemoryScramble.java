package ui;

import logic.GameManager;
import model.GameSettings;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.*;

public class MemoryScramble extends JFrame {

    public MemoryScramble() {

        GameSettings settings = setupGameConfig();

        GameManager gameManager = new GameManager();

        setTitle("Memory Scramble");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        add(
                gameManager.createBoard(
                        settings.rows(),
                        settings.columns()
                ),
                BorderLayout.CENTER
        );

        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private GameSettings setupGameConfig() {

        try {

            int rows = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter rows:")
            );

            int columns = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter columns:")
            );

            int time = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter timeout:")
            );

            if (!ValidationUtil.isBoardValid(
                    rows,
                    columns)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Board size must be even"
                );

                System.exit(0);
            }

            return new GameSettings(
                    rows,
                    columns,
                    time
            );
        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input"
            );

            System.exit(0);
        }

        return null;
    }
}