package edu.ifes.ci.si.les.sdb.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.ifes.ci.si.les.sdb.model.UF;
import edu.ifes.ci.si.les.sdb.service.UFService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author 20151si007
 */
public class FXMLCadastroUFController implements Initializable {

    @FXML
    private TableView<UF> tvUf;
    @FXML
    private TableColumn<UF, Integer> tcId;
    @FXML
    private TableColumn<UF, String> tcUf;
    @FXML
    private TableColumn<UF, String> tcNomeUf;
    @FXML
    private Button btnInserir;
    @FXML
    private Button btnListar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnLocalizar;
    @FXML
    private TextField tfUf;
    @FXML
    private TextField tfNomeUf;
    @FXML
    private Label lbUf;
    @FXML
    private Label lbNomeUf;
    @FXML
    private Label lbFuncao;
    @FXML
    private Label lbNomeUF1;
    @FXML
    private Label lbUF1;
    @FXML
    private Button btConfirmar;
    @FXML
    private Button btCancelar;
    @FXML
    private AnchorPane apUF;

    private List<UF> listUFs;
    private ObservableList<UF> observableListUFs;
    boolean b;

    private final UFService ufService = new UFService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        carregarTableViewUFs();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewUFs(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvUf.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewUFs(newValue));
    }

    public void carregarTableViewUFs() {
        tcId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcUf.setCellValueFactory(new PropertyValueFactory<>("uf"));
        tcNomeUf.setCellValueFactory(new PropertyValueFactory<>("nome"));

        listUFs = ufService.findAll();

        observableListUFs = FXCollections.observableArrayList(listUFs);
        tvUf.setItems(observableListUFs);
        tvUf.refresh();
        tfUf.setVisible(false);
        tfUf.setText("");
        tfNomeUf.setVisible(false);
        tfNomeUf.setText("");
        lbNomeUf.setVisible(false);
        lbUf.setVisible(false);
        lbFuncao.setVisible(false);
        lbNomeUF1.setVisible(false);
        lbUF1.setVisible(false);
        btCancelar.setVisible(false);
        btConfirmar.setVisible(false);
        btnCancelar.setVisible(true);
        btnInserir.setVisible(true);
        btnListar.setVisible(true);
        btnLocalizar.setVisible(true);
        btnRemover.setVisible(true);
        //selecionarItemTableViewUFs(null);

    }

    public void selecionarItemTableViewUFs(UF uf) {
        if (uf != null) {
            lbUF1.setVisible(true);
            lbNomeUF1.setVisible(true);
            tfUf.setVisible(false);
            tfNomeUf.setVisible(false);
            lbNomeUf.setVisible(true);
            lbUf.setVisible(true);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Listar UF");
            lbNomeUF1.setText(uf.getNome());
            lbUF1.setText(uf.getSigla());
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        } else {
            tfUf.setVisible(false);
            tfNomeUf.setVisible(false);
            lbNomeUf.setVisible(false);
            lbUf.setVisible(false);
            lbFuncao.setVisible(false);
            lbNomeUF1.setVisible(false);
            lbUF1.setVisible(false);
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        }
    }

    public boolean bt() {

        return b;
    }

    @FXML
    public void handleButtonListar() throws IOException {

        carregarTableViewUFs();
    }

    @FXML
    public void handleButtonInserir() throws IOException {

        tfUf.setVisible(true);
        tfNomeUf.setVisible(true);
        lbNomeUf.setVisible(true);
        lbUf.setVisible(true);
        lbFuncao.setVisible(true);
        lbFuncao.setText("Inserir UF");
        lbNomeUF1.setVisible(false);
        lbUF1.setVisible(false);
        btCancelar.setVisible(true);
        btConfirmar.setVisible(true);
        btnCancelar.setVisible(false);
        btnInserir.setVisible(false);
        btnListar.setVisible(false);
        btnLocalizar.setVisible(false);
        btnRemover.setVisible(false);
        //selecionarItemTableViewUFs(null);

    }

    @FXML
    public void handleButtonConfirmar() {
        UF uf = new UF();
        b = validarEntradaDeDados(); //dialogStage.close();
        if (b && "Inserir UF".equals(lbFuncao.getText())) {
            //uf.setId(3);
            uf.setNome(tfNomeUf.getText());
            uf.setSigla(tfUf.getText());
            ufService.insert(uf);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("UF inserida com sucesso");
            alert.show();
            carregarTableViewUFs();
            //selecionarItemTableViewUFs(null);
        }

        if (b && "Alterar UF".equals(lbFuncao.getText())) {
            //uf.setId(3);
            uf.setId(tvUf.getSelectionModel().getSelectedItem().getId());
            uf.setNome(tfNomeUf.getText());
            uf.setSigla(tfUf.getText());
            ufService.update(uf);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("UF alterada com sucesso");
            alert.show();
            carregarTableViewUFs();
            //selecionarItemTableViewUFs(null);
        }

    }

    @FXML
    public void handleButtonCancelar() {
        b = false;
        selecionarItemTableViewUFs(null);
        carregarTableViewUFs();
    }

    @FXML
    public void handleButtonCancelarAP() {
        apUF.getChildren().clear();
    }

    @FXML
    public void handleButtonAlterar() throws IOException {
        UF uf = tvUf.getSelectionModel().getSelectedItem();

        if (uf != null) {
            tfUf.setVisible(true);
            tfNomeUf.setVisible(true);
            lbNomeUf.setVisible(true);
            lbUf.setVisible(true);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Alterar UF");
            lbNomeUF1.setVisible(false);
            lbUF1.setVisible(false);
            btCancelar.setVisible(true);
            btConfirmar.setVisible(true);
            tfNomeUf.setText(uf.getNome());
            tfUf.setText(uf.getSigla());
            btnCancelar.setVisible(false);
            btnInserir.setVisible(false);
            btnListar.setVisible(false);
            btnLocalizar.setVisible(false);
            btnRemover.setVisible(false);
            //selecionarItemTableViewUFs(null);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma UF na Tabela!");
            alert.show();
        }
        //selecionarItemTableViewUFs(null);

    }

    @FXML
    public void handleButtonRemover() throws IOException {
        UF uf = tvUf.getSelectionModel().getSelectedItem();
        if (uf != null) {
            ufService.delete(uf.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("UF deletada com sucesso!");
            alert.show();
            carregarTableViewUFs();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma UF na Tabela!");
            alert.show();
        }
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (tfUf.getText() == null || tfUf.getText().length() == 0) {
            errorMessage += "Sigla inválida!\n";
        }
        if (tfNomeUf.getText() == null || tfNomeUf.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
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
