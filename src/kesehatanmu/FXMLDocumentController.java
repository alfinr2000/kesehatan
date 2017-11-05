/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kesehatanmu;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author AREMA
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private JFXTextField Nama;
    @FXML
    private JFXTextField Tinggi;
    @FXML
    private JFXTextField Berat;
    @FXML
    private JFXRadioButton p;
    @FXML
    private ToggleGroup jk;
    @FXML
    private JFXRadioButton w;
    @FXML
    private JFXButton Proses;
    @FXML
    private JFXButton Exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Oke(ActionEvent event) throws IOException {
       if(Nama.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Isi Data Nama Anda Dulu !");
        }
        else if(Tinggi.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Isi Data Tinggi Badan Dulu !");
        }
        else if(Berat.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Isi Data Berat Badan Dulu !");
        }
        else{
            
        String nama =Nama.getText();
        String tinggi = Tinggi.getText();
        Double hitung_tinggi = Double.parseDouble(tinggi);
        String berat = Berat.getText();
        Double hitung_berat = Double.parseDouble(berat);
        String kondisi= null;
        String jk ="";
        
         
        if (p.isSelected()){
            jk = "Pria";
        }
        else if (w.isSelected()){
            jk = "Wanita";
        }
        else  {
            JOptionPane.showMessageDialog(null,"Silahkan Pilih Jenis Kelamin");
        }
        if(p.isSelected()){
            hitung_tinggi -=110;
        }
        else if (w.isSelected()){
            hitung_tinggi -=100;
        }
        double taideal;
            taideal = hitung_tinggi;
        
            if (hitung_tinggi == hitung_berat){
                kondisi = "Ideal";
            }
            else if (hitung_tinggi > hitung_berat){
                kondisi = "Underweight";
            }
            else if (hitung_tinggi < hitung_berat){
                kondisi = "Overweight";
            }
        
        
            String ta = null;
        if(null != kondisi) 
            switch (kondisi){
                case "Ideal":
                    ta = "Kondisi badan anda baik, jaga dan tingkatkan kondisi badan Anda ";
                   break;
                case "Underweight":
                     ta= "Anda Terlalu Kurus, makanlah makanan yang sehat dan teratur !";
                      break;
                case "Overweight":
                     ta= "Anda Terlalu gemuk, Kurangi makan sebelum tidur dan olahragalah yang teratur !";
                      break;
                 default:
                break;}
            
        try {
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML2.fxml"));
            Parent root = (Parent) loader.load();
           
            FXML2Controller fxml2Controller = loader.getController();
          
            fxml2Controller.myFunction(Nama.getText() , ta , taideal , kondisi);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();   
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e);
        }
        }        
    }     

    @FXML
    private void Keluar(ActionEvent event) {
        Platform.exit();
    }
    
}
