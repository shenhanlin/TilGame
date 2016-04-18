package tilgame;

import javax.swing.JOptionPane;

public class TilesGame {

    /**
     *
     * @author Hanlin Shen
     * @version Feb 19, 2013
     */
    public static void main(String[] args) {
        GameRule game = new GameRule();
        String s = "";
        int x;
        while (!game.over(s)) {
            String pop = "" + game + "" + game.ShowOptions();
            s = JOptionPane.showInputDialog("" + pop + "");
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isLetter(s.charAt(i))) {
                    x = Integer.parseInt(s);
                    game.move(x);
                }

            }

        }
        
    }
}
