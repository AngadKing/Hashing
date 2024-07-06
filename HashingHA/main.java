import java.awt.*;
import java.util.*;
import java.lang.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class main{
    JFrame f = new JFrame();
    BorderLayout bl = new BorderLayout();
    
    Panel p1 = new Panel();
    Panel p2 = new Panel();
    
    Button insertButton = new Button("Insert");
    Button deleteButton = new Button("Delete");
    
    JTextField text1 = new JTextField(30);
    
    String input = text1.getText();
    String[] letters = new String [9];
    
    int index;
    int arrayLength = letters.length;
    public int hashWert;
    public void hashWertErmitteln(String input){
        hashWert = Hashing.hashing(input);
    }
    public void newArrayLength (){
        int newLength = Integer.parseInt(text1.getText());
        String[] newArray = new String[newLength];
        int lettersLength = newArray.length;
        String[] letters = new String [lettersLength];
    }
    public void arrayPlatz(int hashWert){
        index = hashWert % letters.length;
    }
    ActionListener insertActionListener = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int a = index;
            
            if (letters[a] == null){
                letters [a] = input;
            }else{
                for (int  i = 0;i < arrayLength;i++){
                    if (letters[i] == null){
                        letters [i] = input;
                    }
                }
            }
            System.out.println(Arrays.toString(letters));    
        }
    };
    
    ActionListener deleteActionListener = new ActionListener(){
        public void actionPerformed(ActionEvent a ){
            int b = index;
            for (int i = 0; i < arrayLength ; i++){
                if(letters[b] != null){
                    letters[b] = null;
                }
            }
        }
    };
       
    
    //    int index = sum % letters.length;
     //   String[] letters = new String [9];
    public void main(String[]args){
        f.setSize(1000,500);
        f.setVisible(true);
        f.setLayout(bl);
        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
        p1.add(text1);
        p1.add(insertButton);
        p1.add(deleteButton);
       
        insertButton.addActionListener(insertActionListener);
        deleteButton.addActionListener(deleteActionListener);
    }
}
