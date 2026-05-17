package ui;

import logic.GameManager;
import model.GameSettings;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.*;

public class MemoryScramble extends JFrame {

    private final JLabel timerLabel;
    private Timer timer;

    private int remainingTime;

    public MemoryScramble() {

        GameSettings settings = setupGameConfig();

        remainingTime = settings.timeLimit();

        GameManager gameManager = new GameManager(this);

        setTitle("Memory Scramble");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        timerLabel = new JLabel(
                "Time: " + remainingTime + "s",
                SwingConstants.CENTER
        );

        timerLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        20
                )
        );

        add(
                timerLabel,
                BorderLayout.NORTH
        );

        add(
                gameManager.createBoard(
                        settings.rows(),
                        settings.columns()
                ),
                BorderLayout.CENTER
        );

        startTimer();

        pack();

        setLocationRelativeTo(null);

        setVisible(true);
    }

    private void startTimer() {

        timer = new Timer(
                1000,
                e -> {

                    remainingTime--;

                    timerLabel.setText(
                            "Time: "
                                    + remainingTime
                                    + "s"
                    );

                    if (remainingTime <= 0) {

                        timer.stop();

                        JOptionPane.showMessageDialog(
                                this,
                                "Game Over! Time is up."
                        );

                        System.exit(0);
                    }

                });

        timer.start();
    }

    public void playerWon() {

        timer.stop();

        JOptionPane.showMessageDialog(
                this,
                "Congratulations! You matched all cards!"
        );

        System.exit(0);
    }

    private GameSettings setupGameConfig() {

        try {

            int rows = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter rows:"
                    ));

            int columns = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter columns:"
                    ));

            int time = Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter timeout:"
                    ));

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