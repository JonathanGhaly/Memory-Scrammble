import javax.swing.*;

public class MemoryScrambler {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                MemoryScramble::new
        );
    }
}
