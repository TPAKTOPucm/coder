package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.util.Random;

public class Controller {
    @FXML
    private Button codeButton;

    @FXML
    private Button decodeButton;

    @FXML
    private TextField key0Field;

    @FXML
    private TextArea textField;

    @FXML
    void initialize() {
        decodeButton.setOnAction(e -> JOptionPane.showMessageDialog(null,xor(exchange(String.valueOf(textField.getText())), String.valueOf(key0Field.getText()), false)));
        codeButton.setOnAction(e -> System.out.println(exchange(xor(String.valueOf(textField.getText()), String.valueOf(key0Field.getText()), true))));
    }

    String xor(String text, String code, boolean codec){
        Random rand = new Random(code.hashCode());
        String toReturn = "";
        if(codec){
            for (int i = 0; i < text.length(); i++) {
                toReturn += (char) ((int) text.charAt(i) + rand.nextInt());
            }
        }
        else {
            for (int i = 0; i < text.length(); i++) {
                toReturn += (char) ((int) text.charAt(i) - rand.nextInt());
            }
        }
        return toReturn;
    }

    String exchange(String text){
        String toReturn = "";
        for (int i = 0; i < text.length(); i++) {
            toReturn+=(char)(text.charAt(i)%2==1?(int)text.charAt(i)-1:(int)text.charAt(i)+1);
        }
        return toReturn;
    }
}