
package tilgame;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author hjs29282
 * @version Feb 19, 2013
 */
public class GameRule {

    int[][] game;          // the game
    int[][] correctAnswer; // correctAnswer
    int i2; //new vale for row
    int j2; //new vale for clow
/**
 * The constructor of GameRule class 
 */
    public GameRule() {
        correctAnswer = new int[6][6];
        int correctAnswer1[][] = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 2, 3, 4, 0},
            {0, 5, 6, 7, 8, 0},
            {0, 9, 10, 11, 12, 0},
            {0, 13, 14, 15, 0, 0},
            {0, 0, 0, 0, 0, 0}};
        for (int i = 0; i < 6; i++) {
            System.arraycopy(correctAnswer1[i], 0, correctAnswer[i], 0, 6);
        }
        game = new int[6][6];
        int game1[][] = {
            {0, 0, 0, 0, 0, 0},
            {0, 1, 2, 3, 4, 0},
            {0, 5, 6, 7, 8, 0},
            {0, 9, 10, 11, 12, 0},
            {0, 13, 14, 15, 0, 0},
            {0, 0, 0, 0, 0, 0}};
        for (int i = 0; i < 6; i++) {
            System.arraycopy(game1[i], 0, game[i], 0, 6);

        }

        //random move 1000times
        Random rd = new Random();
        int n = 0;
        for (int i = 0; i < 1000; i++) {
            n = rd.nextInt(15) + 1;
            move(n);
        }

    }

    //-------------------------------------------------------------------
    /*
     * @returen String show the options user have
     */
    public String ShowOptions() {
        String s = "";
        s += '\n';
        s += '\n';
        s += '\n';
        s += "Your Options is: ";
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (game[i][j] == 0) {
                    if (game[i][j + 1] == 0) {
                    } else {
                        s += game[i][j + 1] + ",";
                    }
                    if (game[i][j - 1] == 0) {
                    } else {
                        s += game[i][j - 1] + ",";
                    }
                    if (game[i + 1][j] == 0) {
                    } else {
                        s += game[i + 1][j] + ",";
                    }
                    if (game[i - 1][j] == 0) {
                    } else {
                        s += game[i - 1][j];
                    }
                }
            }
        }
        return s;
    }
    //-------------------------------------------------------------------
/*
     * @ Game Move
     * @param the number user entered
     */

    public void move(int x) {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (game[i][j] == 0) {
                    if (i + 1 < 5 && x == game[i + 1][j]) {
                        // System.out.println("fuck1");
                        i2 = i + 1;
                        j2 = j;

                    } else if (x == game[i - 1][j] && i - 1 > 0) {
                        // System.out.println("fuck2");
                        i2 = i - 1;
                        j2 = j;

                    } else if (j + 1 < 5 && x == game[i][j + 1]) {
                        // System.out.println("fuck3");
                        i2 = i;
                        j2 = j + 1;

                    } else if (x == game[i][j - 1] && j - 1 > 0) {
                        // System.out.println("fuck4");
                        i2 = i;
                        j2 = j - 1;

                    }
                    game[i][j] = game[i2][j2];
                    game[i2][j2] = 0;
                    return;
                }
            }
        }

    }

//-------------------------------------------------------------------
    /*
     * @return Print out the game
     */
    @Override
    public String toString() {
        String s = "";

        for (int i = 1; i < 2; i++) {
            for (int j = 1; j < 5; j++) {
                if (game[i][j] < 10) {
                    s += game[i][j] + "    ";
                } else {
                    s += game[i][j] + "  ";
                }


            }

        }
        s += '\n';
        for (int i = 2; i < 3; i++) {
            for (int j = 1; j < 5; j++) {
                if (game[i][j] < 10) {
                    s += game[i][j] + "    ";
                } else {
                    s += game[i][j] + "  ";
                }
            }

        }
        s += '\n';
        for (int i = 3; i < 4; i++) {
            for (int j = 1; j < 5; j++) {
                if (game[i][j] < 10) {
                    s += game[i][j] + "    ";
                } else {
                    s += game[i][j] + "  ";
                }
            }

        }
        s += '\n';
        for (int i = 4; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (game[i][j] < 10) {
                    s += game[i][j] + "    ";
                } else {
                    s += game[i][j] + "  ";
                }
            }

        }

        return s;

    }
//--------------------------------------------------------------------
    /*
     * @return true the game end, return false the game not end
     */   

    public boolean over(String s) {
        if (s.equalsIgnoreCase("quit")) {
                JOptionPane.showMessageDialog(null, "Quitter");
                return true;
                }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (game[i][j] != correctAnswer[i][j]) {
                    return false;
                }

            }
        }
        JOptionPane.showMessageDialog(null, "You Win");
        return true;
    }
}
