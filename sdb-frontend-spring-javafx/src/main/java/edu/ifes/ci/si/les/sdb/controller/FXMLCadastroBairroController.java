/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Bairro;
import edu.ifes.ci.si.les.sdb.model.Cidade;
import edu.ifes.ci.si.les.sdb.service.BairroService;
import edu.ifes.ci.si.les.sdb.service.CidadeService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Alexandre
 */
public class FXMLCadastroBairroController implements Initializable {

    @FXML
    private AnchorPane apBairro;
    @FXML
    private TableView<Bairro> tvBairro;
    @FXML
    private TableColumn<Bairro, Integer> tcIdBairro;
    @FXML
    private TableColumn<Bairro, String> tcNomeBairro;
    @FXML
    private TableColumn<Bairro, Bairro> tcNomeCidade;
    @FXML
    private Button btnListar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnLocalizar;
    @FXML
    private Button btnInserir;
    @FXML
    private Label lbFuncao;
    @FXML
    private Label lbNomeBairro;
    @FXML
    private Label lbCidade;
    @FXML
    private Label lbNomeBairro1;
    @FXML
    private Label lbCidade1;
    @FXML
    private TextField tfNomeBairro;
    @FXML
    private ComboBox<Cidade> cbCidade;
    @FXML
    private Button btConfirmar;
    @FXML
    private Button btCancelar;

    private List<Cidade> listCidades;
    private List<Bairro> listBairro;
    private ObservableList<Cidade> observableListCidade;
    private ObservableList<Bairro> observableListBairro;
    boolean b;

    private final CidadeService cidadeService = new CidadeService();
    private final BairroService bairroService = new BairroService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        carregarTableViewBairros();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewBairros(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvBairro.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewBairros(newValue));

    }

    public void carregarTableViewBairros() {
        tcIdBairro.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeBairro.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcNomeCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));

        listBairro = bairroService.findAll();

        observableListBairro = FXCollections.observableArrayList(listBairro);
        tvBairro.setItems(observableListBairro);
        tvBairro.refresh();
        tfNomeBairro.setVisible(false);
        tfNomeBairro.setText("");
        cbCidade.setVisible(false);
        cbCidade.setValue(null);
        lbCidade.setVisible(false);
        lbNomeBairro.setVisible(false);
        lbFuncao.setVisible(false);
        lbCidade1.setVisible(false);
        lbNomeBairro1.setVisible(false);
        btCancelar.setVisible(false);
        btConfirmar.setVisible(false);
        btnCancelar.setVisible(true);
        btnInserir.setVisible(true);
        btnListar.setVisible(true);
        btnLocalizar.setVisible(true);
        btnRemover.setVisible(true);


    }

    public void selecionarItemTableViewBairros(Bairro bairro) {
        if (bairro != null) {
            lbCidade.setVisible(true);
            lbNomeBairro.setVisible(true);
            cbCidade.setVisible(false);
            tfNomeBairro.setVisible(false);
            lbCidade1.setVisible(true);
            lbNomeBairro1.setVisible(true);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Listar Bairros");
            lbNomeBairro1.setText(bairro.getNome());
            lbCidade1.setText(bairro.getCidade().getNome());
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        } else {
            carregarTableViewBairros();
        }
    }

    public void carregarComboBoxCidade() {
        listCidades = cidadeService.findAll();
        observableListCidade = FXCollections.observableArrayList(listCidades);
        cbCidade.setItems(observableListCidade);
    }

    @FXML
    private void handleButtonListar(ActionEvent event) {
        carregarTableViewBairros();
    }

    @FXML
    private void handleButtonRemover(ActionEvent event) {

        Bairro bairro = tvBairro.getSelectionModel().getSelectedItem();
        if (bairro != null) {
            bairroService.delete(bairro.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Bairro deletado com sucesso!");
            alert.show();
            carregarTableViewBairros();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Bairro na Tabela!");
            alert.show();
        }

    }

    @FXML
    private void handleButtonCancelarAP(ActionEvent event) {
        apBairro.getChildren().clear();
    }

    @FXML
    private void handleButtonAlterar(ActionEvent event) {

        Bairro bairro = tvBairro.getSelectionModel().getSelectedItem();

        if (bairro != null) {
            tfNomeBairro.setVisible(true);
            cbCidade.setVisible(true);
            lbCidade.setVisible(true);
            lbNomeBairro.setVisible(true);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Alterar Bairro");
            lbCidade1.setVisible(false);
            lbNomeBairro1.setVisible(false);
            btCancelar.setVisible(true);
            btConfirmar.setVisible(true);
            tfNomeBairro.setText(bairro.getNome());
            carregarComboBoxCidade();
            cbCidade.setValue(bairro.getCidade());
            btnCancelar.setVisible(false);
            btnInserir.setVisible(false);
            btnListar.setVisible(false);
            btnLocalizar.setVisible(false);
            btnRemover.setVisible(false);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Bairro na Tabela!");
            alert.show();
        }

    }

    @FXML
    private void handleButtonInserir(ActionEvent event) {
        tfNomeBairro.setVisible(true);
        cbCidade.setVisible(true);
        lbNomeBairro.setVisible(true);
        lbCidade.setVisible(true);
        lbFuncao.setVisible(true);
        lbFuncao.setText("Inserir Bairro");
        lbCidade1.setVisible(false);
        lbNomeBairro1.setVisible(false);
        btCancelar.setVisible(true);
        btConfirmar.setVisible(true);
        carregarComboBoxCidade();
        btnCancelar.setVisible(false);
        btnInserir.setVisible(false);
        btnListar.setVisible(false);
        btnLocalizar.setVisible(false);
        btnRemover.setVisible(false);

    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) {
        Bairro bairro = new Bairro();
        b = validarEntradaDeDados(); 
        if (b && "Inserir Bairro".equals(lbFuncao.getText())) {
            //uf.setId(3);
            bairro.setNome(tfNomeBairro.getText());
            bairro.setCidade(cbCidade.valueProperty().getValue());
            bairroService.insert(bairro);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Bairro inserido com sucesso");
            alert.show();
            carregarTableViewBairros();
        }

        if (b && "Alterar Bairro".equals(lbFuncao.getText())) {
            //uf.setId(3);
            bairro.setId(tvBairro.getSelectionModel().getSelectedItem().getId());
            bairro.setNome(tfNomeBairro.getText());
            bairro.setCidade(cbCidade.valueProperty().getValue());
            bairroService.update(bairro);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Bairro alterado com sucesso");
            alert.show();
            carregarTableViewBairros();
        }

    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (tfNomeBairro.getText() == null || tfNomeBairro.getText().length() == 0) {
            errorMessage += "Nome inválida!\n";
        }
        if (cbCidade.getValue() == null || cbCidade.toString().equals(0)) {
            errorMessage += "Combobox inválido!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
        carregarTableViewBairros();
    }

}
