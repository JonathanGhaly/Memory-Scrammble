package logic;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

  public class GameManager {

      public JPanel createBoard(
              int rows,
              int columns,
              MemoryScramble game){

          JPanel panel=
                  new JPanel(
                          new GridLayout(
                                  rows,
                                  columns));

          int totalCells=
                  rows*columns;

          int pairs=
                  totalCells/2;

          ArrayList<Integer>
                  icons=
                  new ArrayList<>();

          for(
                  int i=1;
                  i<=pairs;
                  i++){

              icons.add(i);
              icons.add(i);
          }

          for(
                  int icon:
                  icons){

              CardButton button=
                      new CardButton(
                              icon);

              panel.add(button);
          }

          return panel;
      }

  }
