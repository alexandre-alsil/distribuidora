/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Cidade;
import edu.ifes.ci.si.les.sdb.model.UF;
import edu.ifes.ci.si.les.sdb.service.CidadeService;
import edu.ifes.ci.si.les.sdb.service.UFService;
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
public class FXMLCadastroCidadeController implements Initializable {

    @FXML
    private AnchorPane apCidade;
    @FXML
    private TableView<Cidade> tvCidade;
    @FXML
    private Label lbFuncao;
    @FXML
    private Label lbNomeCidade;
    @FXML
    private Label lbUFCidade;
    @FXML
    private Label lbNomeCidade1;
    @FXML
    private Label lbUFCidade1;
    @FXML
    private Button btnInserir;
    @FXML
    private Button btnLocalizar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnListar;
    @FXML
    private TextField tfNomeCidade;
    @FXML
    private ComboBox<UF> cbUF;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btConfirmar;
    @FXML
    private TableColumn<Cidade, Integer> tcIdCidade;
    @FXML
    private TableColumn<Cidade, String> tcNomeCidade;
    @FXML
    private TableColumn<Cidade, Cidade> tcUFCidade;

    private List<Cidade> listCidades;
    private List<UF> listUF;
    private ObservableList<Cidade> observableListCidade;
    private ObservableList<UF> observableListUF;
    boolean b;

    private final CidadeService cidadeService = new CidadeService();
    private final UFService ufService = new UFService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTableViewCidades();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewCidades(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvCidade.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewCidades(newValue));

    }

    public void carregarTableViewCidades() {
        tcIdCidade.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeCidade.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcUFCidade.setCellValueFactory(new PropertyValueFactory<>("uf"));

        listCidades = cidadeService.findAll();

        observableListCidade = FXCollections.observableArrayList(listCidades);
        tvCidade.setItems(observableListCidade);
        tvCidade.refresh();
        tfNomeCidade.setVisible(false);
        tfNomeCidade.setText("");
        cbUF.setVisible(false);
        cbUF.setValue(null);
        lbNomeCidade.setVisible(false);
        lbUFCidade.setVisible(false);
        lbFuncao.setVisible(false);
        lbNomeCidade1.setVisible(false);
        lbUFCidade1.setVisible(false);
        btCancelar.setVisible(false);
        btConfirmar.setVisible(false);
        btnCancelar.setVisible(true);
        btnInserir.setVisible(true);
        btnListar.setVisible(true);
        btnLocalizar.setVisible(true);
        btnRemover.setVisible(true);

    }

    public void selecionarItemTableViewCidades(Cidade cidade) {
        if (cidade != null) {
            lbUFCidade.setVisible(true);
            lbNomeCidade.setVisible(true);
            cbUF.setVisible(false);
            tfNomeCidade.setVisible(false);
            lbNomeCidade1.setVisible(true);
            lbUFCidade1.setVisible(true);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Listar Cidades");
            lbNomeCidade1.setText(cidade.getNome());
            lbUFCidade1.setText(cidade.getUf().getSigla());
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        } else {
            carregarTableViewCidades();
        }
    }

    public void carregarComboBoxUF() {
        listUF = ufService.findAll();
        observableListUF = FXCollections.observableArrayList(listUF);
        cbUF.setItems(observableListUF);
    }

    @FXML
    private void handleButtonInserir(ActionEvent event) {
        tfNomeCidade.setVisible(true);
        cbUF.setVisible(true);
        lbNomeCidade.setVisible(true);
        lbUFCidade.setVisible(true);
        lbFuncao.setVisible(true);
        lbFuncao.setText("Inserir Cidade");
        lbNomeCidade1.setVisible(false);
        lbUFCidade1.setVisible(false);
        btCancelar.setVisible(true);
        btConfirmar.setVisible(true);
        btnCancelar.setVisible(false);
        btnInserir.setVisible(false);
        btnListar.setVisible(false);
        btnLocalizar.setVisible(false);
        btnRemover.setVisible(false);
        carregarComboBoxUF();
    }

    @FXML
    private void handleButtonAlterar(ActionEvent event) {

        Cidade cidade = tvCidade.getSelectionModel().getSelectedItem();

        if (cidade != null) {
            tfNomeCidade.setVisible(true);
            cbUF.setVisible(true);
            lbNomeCidade.setVisible(true);
            lbUFCidade.setVisible(true);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Alterar Cidade");
            lbNomeCidade1.setVisible(false);
            lbUFCidade1.setVisible(false);
            btCancelar.setVisible(true);
            btConfirmar.setVisible(true);
            tfNomeCidade.setText(cidade.getNome());
            carregarComboBoxUF();
            cbUF.setValue(cidade.getUf());
            btnCancelar.setVisible(false);
            btnInserir.setVisible(false);
            btnListar.setVisible(false);
            btnLocalizar.setVisible(false);
            btnRemover.setVisible(false);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma UF na Tabela!");
            alert.show();
        }

    }

    @FXML
    private void handleButtonCancelarAP(ActionEvent event) {
        apCidade.getChildren().clear();
    }

    @FXML
    private void handleButtonRemover(ActionEvent event) {
        Cidade cidade = tvCidade.getSelectionModel().getSelectedItem();
        if (cidade != null) {
            cidadeService.delete(cidade.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Cidade deletada com sucesso!");
            alert.show();
            carregarTableViewCidades();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma Cidade na Tabela!");
            alert.show();
        }
    }

    @FXML
    private void handleButtonListar(ActionEvent event) {
        carregarTableViewCidades();
    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
        b = false;
        carregarTableViewCidades();
    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) {

        Cidade cidade = new Cidade();
        b = validarEntradaDeDados(); //dialogStage.close();
        if (b && "Inserir Cidade".equals(lbFuncao.getText())) {
            //uf.setId(3);
            cidade.setNome(tfNomeCidade.getText());
            cidade.setUf(cbUF.valueProperty().getValue());
            cidadeService.insert(cidade);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Cidade inserida com sucesso");
            alert.show();
            carregarTableViewCidades();
        }

        if (b && "Alterar Cidade".equals(lbFuncao.getText())) {
            //uf.setId(3);
            cidade.setId(tvCidade.getSelectionModel().getSelectedItem().getId());
            cidade.setNome(tfNomeCidade.getText());
            cidade.setUf(cbUF.valueProperty().getValue());
            cidadeService.update(cidade);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Cidade alterada com sucesso");
            alert.show();
            carregarTableViewCidades();
        }

    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (tfNomeCidade.getText() == null || tfNomeCidade.getText().length() == 0) {
            errorMessage += "Nome inválida!\n";
        }
        if (cbUF.getValue() == null || cbUF.toString().length() == 0) {
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

}
