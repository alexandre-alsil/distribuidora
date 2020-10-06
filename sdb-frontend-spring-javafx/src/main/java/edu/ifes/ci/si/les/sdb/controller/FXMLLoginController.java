/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.service.FuncionarioService;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alexandre
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private AnchorPane apLogin;
    @FXML
    private Button btnLogar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Label lbUsuario;
    @FXML
    private Label lbSenha;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfSenha;

    private ArrayList<Funcionario> listFunc;

    private final FuncionarioService func1 = new FuncionarioService();
    Funcionario func;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

       

    }
    
     public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/sdb/view/FXMLVBoxMain.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/sdb/view/FXMLLogin.fxml"));
        //root.get
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLVBoxMainController.class.getResource("/edu/ifes/ci/si/les/sdb/view/FXMLVBoxMain.fxml"));
        VBox page = (VBox) loader.load();
        FXMLVBoxMainController controller = loader.getController();
        controller.setLogado(this.func);
        controller.setI(this.func.getId());
        //System.out.println("Start: "+this.func.getId());
         
        
        
        Scene scene = new Scene(page);
        //scene.getStylesheets().add("/styles/Styles.css");
        stage.setScene(scene);
        stage.setTitle("Sistema de Distribuidora de Bebida");
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) throws Exception {
        
        listFunc = (ArrayList<Funcionario>) func1.findAll();
        String us, ps;
        us = tfUsuario.getText();
        ps = tfSenha.getText();
        func = new Funcionario();
        for (Funcionario f : listFunc) {
            if (us.equals(f.getLogin()) && ps.equals(f.getSenha())) {
                System.out.println("usuario logado");
                //System.out.println("teste 1: " +f.getId());
                this.func = f;
                //System.out.println("teste 2: " +this.func.getId());
                //Properties p = new Properties();
                //p.setProperty("funcId", Integer.toString(func.getId()));
                
                Stage stage = new Stage();
                start(stage);
                break;

            } else {
                System.out.println("erro de login");
               // func = null;
            }
        }
        
    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
    }

}
