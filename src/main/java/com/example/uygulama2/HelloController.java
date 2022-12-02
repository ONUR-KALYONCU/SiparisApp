package com.example.uygulama2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private ComboBox<String> cmbsiparitur;

    @FXML
    private ListView<String> lstsiparisler;

    @FXML
    private Spinner<Integer> spnadet;

    private ObservableList<String> siparisler= FXCollections.observableArrayList();

    @FXML
    private TextField txtmusteriadresi;

    @FXML
    private TextField txtmusteritel;

    @FXML
    void siparisKaydet(ActionEvent event) {

        String siparistur= cmbsiparitur.getValue();
        String musteritel=txtmusteriadresi.getText();
        String musteriadres= txtmusteriadresi.getText();

        int adet=spnadet.getValue();

        siparisler.add(siparistur+ " " + musteritel+ " " + musteriadres);
    }

    @FXML
    void siparisiPtal(ActionEvent event) {

        int index =lstsiparisler.getSelectionModel().getSelectedIndex();

        if (index>=0){
            siparisler.remove(index);
        }else{
            Alert hata=new Alert(Alert.AlertType.WARNING);
            hata.setTitle("Hata");
            hata.setHeaderText("Silinecek sipariş bulunamadı...");
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbsiparitur.getItems().add("Kaşarlı Tost");
        cmbsiparitur.getItems().add("Karışık Tost");
        cmbsiparitur.getItems().add("Ayvalık Tostu");
        cmbsiparitur.getItems().add("Hamburger");

        spnadet.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1,50,1,1));

        lstsiparisler.setItems(siparisler);
    }
}
