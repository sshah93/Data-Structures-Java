package tictactoegame;
import java.awt.event.*;
import javax.swing.*;

public class Tictactoegame implements ActionListener {

    private String letter = " ";
    private int count = 0;
    private boolean win = false;
    String [] [] board = new String [3] [3];
            
    public Tictactoegame(){
        board [0] [0] = "1";
        board [0] [1] = "2";
        board [0] [2] = "3";
        board [1] [0] = "4";
        board [1] [1] = "5";
        board [1] [2] = "6";
        board [2] [0] = "7";
        board [2] [1] = "8";
        board [2] [2] = "9";
    }
    
    public void actionPerformed (ActionEvent game){
        count++;
        
        //public void setText(){
            
        if(count == 1 || count == 3 || count == 5 || count == 7 || count == 9)
        {
            letter = "X";
        } 
        
        else if(count == 2 || count == 4 || count == 6 || count == 8 || count == 10)
        {
            letter = "O";
        }
     }
        
        /**if(game.getSource() == "1"){
            "1".setText (letter);
            "1".setEnabled(false);
} 
        else if(a.getSource() == button2){
            button2.setText(letter);
            button2.setEnabled(false);
} 
        else if(a.getSource() == button3){
            button3.setText(letter);
            button3.setEnabled(false);
} 
        else if(a.getSource() == button4){
            button4.setText(letter);
            button4.setEnabled(false);
} 
        else if(a.getSource() == button5){
            button5.setText(letter);
            button5.setEnabled(false);
} 
        else if(a.getSource() == button6){
            button6.setText(letter);
            button6.setEnabled(false);
} 
        else if(a.getSource() == button7){
            button7.setText(letter);
            button7.setEnabled(false);
} 
        else if(a.getSource() == button8){
            button8.setText(letter);
            button8.setEnabled(false);
} 
        else if(a.getSource() == button9){
            button9.setText(letter);
            button9.setEnabled(false);
}
    }**/
        
    public static void main(String[] args) {
 
    }
}
