/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kesehatanmu;

import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author AREMA
 */
public class FXML2Controller implements Initializable {

    @FXML
    private Label Nama;
    @FXML
    private JFXTextArea Ta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    public void myFunction(String text , String ta , Double taideal , String ta1 ){
         Nama.setText(text);
         Ta.setText("Kondisi Anda Saat ini : "+ta1+"\nSaran "
                 + "Untuk Anda  : "+ta+"\nBerat ideal anda : "+taideal+"Kg");
     }

    @FXML
    private void Exit(ActionEvent event) {
        Platform.exit();
    }
    
}
