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
    Button arrayLengthButton = new Button("Enter new array length");
    
    JTextField text1 = new JTextField(30);
    
    String input = text1.getText();
    String[] letters = new String [9];
    String[] newArray = new String[1];
    
    int index;
    int arrayLength = letters.length;
    int changedArrayLength = newArray.length;
    int hashWert;
    
    boolean arrayLengthChanged = false;
        
    public int hashWertErmitteln(String input){
        hashWert = Hashing.hashing(input);
        return hashWert;
    }
    
    public void newArrayLength (){
        int newLength = Integer.parseInt(text1.getText());
        String[] newArray = new String[newLength];
        //int lettersLength = newArray.length;
        //String[] letters = new String [lettersLength];
    }
    
    public int arrayPlatz(int hashWert){
        if (arrayLengthChanged == false){
            index = hashWert % letters.length;
        }else{
            index = hashWert % newArray.length;
        }
        return index - 1;
    }
    
    ActionListener insertActionListener = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            input = text1.getText();
            int a = arrayPlatz(hashWertErmitteln(input));
            int start = a;
            if (arrayLengthChanged == false){
                if (letters [a] == null){
                    letters [a] = input;
                }else{
                    for (int  i = a;i < arrayLength;i++){
                        if (letters[i] == null){
                            letters [i] = input;
                            break;
                        }
                         if(i >= arrayLength - 1){
                            for(int c = 0;c < start;c++){
                                if (letters[c] == null){
                                    letters [c] = input;
                                    break;
                                }
                            }
                        }   
                    }   
                }
                System.out.println(Arrays.toString(letters));
            }else{
                if (newArray [a] == null){
                    newArray [a] = input;
                }else{
                    for (int  i = 0;i < changedArrayLength;i++){
                        if (letters[i] == null){
                            letters [i] = input;
                            break;
                        }
                    }   
                }
                System.out.println(Arrays.toString(newArray));
            }
        }
    };
    
    ActionListener deleteActionListener = new ActionListener(){
        public void actionPerformed(ActionEvent a ){
            int b = arrayPlatz(hashWertErmitteln(input));
            if (arrayLengthChanged == false){    
                for (int i = 0; i < arrayLength ; i++){
                    if(letters[b] != null){
                        letters[b] = null;
                    }
                }
                System.out.println(Arrays.toString(letters));
            }else{
                for (int i = 0; i < arrayLength ; i++){
                    if(letters[b] != null){
                        letters[b] = null;
                    }
                }
                System.out.println(Arrays.toString(newArray));
            }
        }
    };
    
    ActionListener arrayLengthActionListener = new ActionListener(){
        public void actionPerformed(ActionEvent b){
            arrayLengthChanged = true;
            System.out.println(Arrays.toString(newArray));
        }
    };
    
    public void main(String[]args){
        f.setSize(500,500);
        f.setVisible(true);
        f.setLayout(bl);
        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        p1.add(text1);
        p1.add(insertButton);
        p1.add(deleteButton);
        p1.add(arrayLengthButton);
        
        insertButton.addActionListener(insertActionListener);
        deleteButton.addActionListener(deleteActionListener);
        arrayLengthButton.addActionListener(arrayLengthActionListener);
    }
}
