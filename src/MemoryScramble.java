import model.GameSettings;
import util.ValidationUtil;

import javax.swing.*;
import java.awt.*;

public class MemoryScramble extends Component {
    private GameSettings setupGameConfig(){
        try{
            int rows=Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter rows:")
            );
            int columns=Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter columns:")
            );
            int time=Integer.parseInt(
                    JOptionPane.showInputDialog(
                            "Enter timeout:")
            );
            if(!ValidationUtil
                    .isBoardValid(
                            rows,
                            columns))
            {
                JOptionPane.showMessageDialog(
                        this,
                        "Board size must be even");
                System.exit(0);
            }
            return new GameSettings(
                    rows,
                    columns,
                    time
            );

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid input");

            System.exit(0);
        }
        return null;
    }
}
