/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Bairro;
import edu.ifes.ci.si.les.sdb.model.Fornecedor;
import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.service.BairroService;
import edu.ifes.ci.si.les.sdb.service.FornecedorService;
import edu.ifes.ci.si.les.sdb.service.FuncionarioService;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
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
public class FXMLCadastroFornecedorController implements Initializable {

    @FXML
    private AnchorPane apForn;
    @FXML
    private TextField tfTel2;
    @FXML
    private TextField tfTel1;
    @FXML
    private Label lbFuncId;
    @FXML
    private ComboBox<Bairro> cbBairro;
    @FXML
    private TextField tfNum;
    @FXML
    private TextField tfRua;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfTipo;
    @FXML
    private TextField tfCPF;
    @FXML
    private TextField tfNome;
    @FXML
    private Label lbTele1;
    @FXML
    private Label lbTela1;
    @FXML
    private Label lbFunc1;
    @FXML
    private Label lbBairro1;
    @FXML
    private Label lbStatus1;
    @FXML
    private Label lbNum1;
    @FXML
    private Label lbRua1;
    @FXML
    private Label lbEmail1;
    @FXML
    private Label lbTipo1;
    @FXML
    private Label lbCPF1;
    @FXML
    private Label lbNomeForn1;
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
    private Button btConfirmar;
    @FXML
    private Button btCancelar;
    @FXML
    private Label lbTele;
    @FXML
    private Label lbTela;
    @FXML
    private Label lbFunc;
    @FXML
    private Label lbBairro;
    @FXML
    private Label lbStatus;
    @FXML
    private Label lbNum;
    @FXML
    private Label lbRua;
    @FXML
    private Label lbEmail;
    @FXML
    private Label lbTipo;
    @FXML
    private Label lbCPF;
    @FXML
    private Label lbNomeForn;
    @FXML
    private Label lbFuncao;
    @FXML
    private TableView<Fornecedor> tvForn;
    @FXML
    private TableColumn<Fornecedor, Integer> tcIdForn;
    @FXML
    private TableColumn<Fornecedor, String> tcNomeForn;
    @FXML
    private TableColumn<Fornecedor, String> tcCPF;

    private Funcionario func;
    private Integer id;
    private List<Bairro> listBairro;
    private List<Fornecedor> listForn;
    private List<String> listTel;
    private ArrayList<String> aTel;
    private ObservableList<Funcionario> observableListFunc;
    private ObservableList<Bairro> observableListBairro;
    private ObservableList<Fornecedor> observableListForn;
    boolean b;

    private final FuncionarioService funcService = new FuncionarioService();
    private final BairroService bairroService = new BairroService();
    private final FornecedorService fornService = new FornecedorService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTableViewFornecedores();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewFornecedores(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvForn.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewFornecedores(newValue));

    }

    public void carregarTableViewFornecedores() {
        tcIdForn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeForn.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCPF.setCellValueFactory(new PropertyValueFactory<>("cpfCnpj"));

        listForn = fornService.findAll();
        observableListForn = FXCollections.observableArrayList(listForn);
        tvForn.setItems(observableListForn);
        tvForn.refresh();
        tfNome.setVisible(false);
        tfNome.setText("");
        tfCPF.setVisible(false);
        tfCPF.setText("");
        tfTipo.setVisible(false);
        tfTipo.setText("");
        tfEmail.setVisible(false);
        tfEmail.setText("");
        tfNum.setVisible(false);
        tfNum.setText("");
        tfRua.setVisible(false);
        tfRua.setText("");
        tfTel1.setVisible(false);
        tfTel1.setText("");
        tfTel2.setVisible(false);
        tfTel2.setText("");
        cbBairro.setVisible(false);
        cbBairro.setValue(null);
        lbFuncId.setVisible(false);
        lbFuncId.setText("");
        lbNomeForn.setVisible(false);
        lbNomeForn1.setVisible(false);
        lbCPF.setVisible(false);
        lbCPF1.setVisible(false);
        lbEmail.setVisible(false);
        lbEmail1.setVisible(false);
        lbStatus.setVisible(false);
        lbStatus1.setVisible(false);
        lbFunc.setVisible(false);
        lbFunc1.setVisible(false);
        lbNum.setVisible(false);
        lbNum1.setVisible(false);
        lbRua.setVisible(false);
        lbRua1.setVisible(false);
        lbTela.setVisible(false);
        lbTela1.setVisible(false);
        lbTele.setVisible(false);
        lbTele1.setVisible(false);
        lbTipo.setVisible(false);
        lbTipo1.setVisible(false);
        lbBairro.setVisible(false);
        lbBairro1.setVisible(false);
        lbFuncao.setVisible(false);
        btCancelar.setVisible(false);
        btConfirmar.setVisible(false);
        btnInserir.setVisible(true);
        btnCancelar.setVisible(true);
        btnListar.setVisible(true);
        btnLocalizar.setVisible(true);
        btnRemover.setVisible(true);

    }

    public void selecionarItemTableViewFornecedores(Fornecedor fornecedor) {
        if (fornecedor != null) {

            lbNomeForn.setVisible(true);
            lbNomeForn1.setVisible(true);
            lbNomeForn1.setText(fornecedor.getNome());
            lbCPF.setVisible(true);
            lbCPF1.setVisible(true);
            lbCPF1.setText(fornecedor.getCpfCnpj());
            lbEmail.setVisible(true);
            lbEmail1.setVisible(true);
            lbEmail1.setText(fornecedor.getEmail());
            lbFunc.setVisible(true);
            lbFunc1.setVisible(true);
            lbFunc1.setText(fornecedor.getFuncionario().getNome());
            lbNum.setVisible(true);
            lbNum1.setVisible(true);
            lbNum1.setText(fornecedor.getNumero());
            lbRua.setVisible(true);
            lbRua1.setVisible(true);
            lbRua1.setText(fornecedor.getRua());
            lbTela.setVisible(true);
            lbTela1.setVisible(true);
            //lbTela1.setText(fornecedor.getTelefones().toString());
            lbTele.setVisible(true);
            lbTele1.setVisible(true);
            //fornecedor.getTelefones().addAll(Arrays.asList(tfTel1.getText(), tfTel2.getText()));
            aTel = new ArrayList<>();
            aTel.addAll(fornecedor.getTelefones());
            int i = 0;
            while (i < aTel.size()) {

                lbTela1.setText(aTel.get(i));

                lbTele1.setText(aTel.get(i + 1));

                i = i + 2;
            }

            lbTipo.setVisible(true);
            lbTipo1.setVisible(true);
            lbTipo1.setText(fornecedor.getTipo().toString());
            lbBairro.setVisible(true);
            lbBairro1.setVisible(true);
            lbStatus.setVisible(true);
            lbStatus1.setVisible(true);
            lbStatus1.setText(fornecedor.getStatus().toString());
            lbBairro1.setText(fornecedor.getBairro().getNome());
            lbFuncao.setVisible(true);
            lbFuncao.setText("Listar Fornecedores");
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        } else {

            carregarTableViewFornecedores();
        }
    }

    public void carregarComboBoxBairro() {
        listBairro = bairroService.findAll();
        observableListBairro = FXCollections.observableArrayList(listBairro);
        cbBairro.setItems(observableListBairro);
    }

    public void carregarLabelFunc() {
        
        int i =  id;
        func = funcService.find(i);
        lbFuncId.setText(func.getNome());
    }

    @FXML
    private void handleButtonListar(ActionEvent event) {
        carregarTableViewFornecedores();
    }

    @FXML
    private void handleButtonRemover(ActionEvent event) {
        Fornecedor fornecedor = tvForn.getSelectionModel().getSelectedItem();
        if (fornecedor != null) {
            fornService.delete(fornecedor.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fornecedor deletado com sucesso!");
            alert.show();
            carregarTableViewFornecedores();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Fornecedor na Tabela!");
            alert.show();
        }
    }

    @FXML
    private void handleButtonCancelarAP(ActionEvent event) {
        apForn.getChildren().clear();
    }

    @FXML
    private void handleButtonAlterar(ActionEvent event) {

        Fornecedor fornecedor = tvForn.getSelectionModel().getSelectedItem();

        if (fornecedor != null) {
            tfNome.setVisible(true);
            tfNome.setText(fornecedor.getNome());
            tfCPF.setVisible(true);
            tfCPF.setText(fornecedor.getCpfCnpj());
            tfTipo.setVisible(true);
            tfTipo.setText(fornecedor.getTipo().toString());
            tfEmail.setVisible(true);
            tfEmail.setText(fornecedor.getEmail());
            tfNum.setVisible(true);
            tfNum.setText(fornecedor.getNumero());
            tfRua.setVisible(true);
            tfRua.setText(fornecedor.getRua());
            tfTel1.setVisible(true);
            tfTel2.setVisible(true);
            aTel = new ArrayList<>();
            aTel.addAll(fornecedor.getTelefones());
            int i = 0;
            while (i < aTel.size()) {
                tfTel1.setText(aTel.get(i));

                tfTel2.setText(aTel.get(i + 1));

                i = i + 2;
            }

            cbBairro.setVisible(true);
            cbBairro.setValue(fornecedor.getBairro());
            lbFuncId.setVisible(true);
            lbFuncId.setText(fornecedor.getFuncionario().getNome());
            lbNomeForn.setVisible(true);
            lbNomeForn1.setVisible(false);
            lbCPF.setVisible(true);
            lbCPF1.setVisible(false);
            lbEmail.setVisible(true);
            lbEmail1.setVisible(false);
            lbStatus.setVisible(true);
            lbStatus1.setVisible(true);
            lbStatus1.setText(fornecedor.getStatus().toString());
            lbFunc.setVisible(true);
            lbFunc1.setVisible(false);
            lbNum.setVisible(true);
            lbNum1.setVisible(false);
            lbRua.setVisible(true);
            lbRua1.setVisible(false);
            lbTela.setVisible(true);
            lbTela1.setVisible(false);
            lbTele.setVisible(true);
            lbTele1.setVisible(false);
            lbTipo.setVisible(true);
            lbTipo1.setVisible(false);
            lbBairro.setVisible(true);
            lbBairro1.setVisible(false);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Alterar Fornecedor");
            btCancelar.setVisible(true);
            btConfirmar.setVisible(true);
            btnInserir.setVisible(false);
            btnCancelar.setVisible(false);
            btnListar.setVisible(false);
            btnLocalizar.setVisible(false);
            btnRemover.setVisible(false);
            carregarComboBoxBairro();
            carregarLabelFunc();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Fornecedor na Tabela!");
            alert.show();
        }

    }

    @FXML
    private void handleButtonInserir(ActionEvent event) {

        tfNome.setVisible(true);
        tfNome.setText("");
        tfCPF.setVisible(true);
        tfCPF.setText("");
        tfTipo.setVisible(true);
        tfTipo.setText("");
        tfEmail.setVisible(true);
        tfEmail.setText("");
        tfNum.setVisible(true);
        tfNum.setText("");
        tfRua.setVisible(true);
        tfRua.setText("");
        tfTel1.setVisible(true);
        tfTel1.setText("");
        tfTel2.setVisible(true);
        tfTel2.setText("");
        cbBairro.setVisible(true);
        //cbBairro.setValue(null);
        lbFuncId.setVisible(true);
        //cbFunc.setValue(null);
        lbNomeForn.setVisible(true);
        lbNomeForn1.setVisible(false);
        lbCPF.setVisible(true);
        lbCPF1.setVisible(false);
        lbEmail.setVisible(true);
        lbEmail1.setVisible(false);
        lbStatus.setVisible(true);
        lbStatus1.setVisible(true);
        lbStatus1.setText("0");
        //lbStatus1.setVisible(false);
        lbFunc.setVisible(true);
        lbFunc1.setVisible(false);
        lbNum.setVisible(true);
        lbNum1.setVisible(false);
        lbRua.setVisible(true);
        lbRua1.setVisible(false);
        lbTela.setVisible(true);
        lbTela1.setVisible(false);
        lbTele.setVisible(true);
        lbTele1.setVisible(false);
        lbTipo.setVisible(true);
        lbTipo1.setVisible(false);
        lbBairro.setVisible(true);
        lbBairro1.setVisible(false);
        lbFuncao.setVisible(true);
        lbFuncao.setText("Inserir Fornecedor");
        btCancelar.setVisible(true);
        btConfirmar.setVisible(true);
        btnInserir.setVisible(false);
        btnCancelar.setVisible(false);
        btnListar.setVisible(false);
        btnLocalizar.setVisible(false);
        btnRemover.setVisible(false);
        carregarComboBoxBairro();
        carregarLabelFunc();

    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) {
        Fornecedor fornecedor = new Fornecedor();
        b = validarEntradaDeDados(); //dialogStage.close();
        if (b && "Inserir Fornecedor".equals(lbFuncao.getText())) {
            //uf.setId(3);
            fornecedor.setNome(tfNome.getText());
            fornecedor.setCpfCnpj(tfCPF.getText());
            fornecedor.setEmail(tfEmail.getText());
            fornecedor.setNumero(tfNum.getText());
            fornecedor.setStatus(0);
            fornecedor.setRua(tfRua.getText());
            fornecedor.setTipo(Integer.parseInt(tfTipo.getText()));
            fornecedor.setBairro(cbBairro.valueProperty().getValue());
            fornecedor.setFuncionario(func);
            //System.out.println("teste1" +tfTel1.getText());
            //listTel.add(tfTel1.getText());
            // listTel.add(tfTel2.getText());
            //System.out.println("teste2" +listTel);
            //cliente.setTelefone((Set<String>) listTel);
            fornecedor.getTelefones().addAll(Arrays.asList(tfTel1.getText(), tfTel2.getText()));
            /*
            private List<Cliente> listCliente;
    private ObservableList<Funcionario> observableListFunc;
            @ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
            cliente1.getTelefone().addAll(Arrays.asList("111111111", "222222222"));
             */

            fornService.insert(fornecedor);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fornecedor inserido com sucesso");
            alert.show();
            carregarTableViewFornecedores();
        }

        if (b && "Alterar Fornecedor".equals(lbFuncao.getText())) {
            //uf.setId(3);
            fornecedor.setId(tvForn.getSelectionModel().getSelectedItem().getId());
            fornecedor.setNome(tfNome.getText());
            fornecedor.setCpfCnpj(tfCPF.getText());
            fornecedor.setStatus(fornecedor.getStatus());
            fornecedor.setEmail(tfEmail.getText());
            fornecedor.setNumero(tfNum.getText());
            fornecedor.setStatus(Integer.parseInt(lbStatus1.getText()));
            fornecedor.setRua(tfRua.getText());
            fornecedor.setTipo(Integer.parseInt(tfTipo.getText()));
            fornecedor.setBairro(cbBairro.valueProperty().getValue());
            fornecedor.setFuncionario(func);
            listTel = new ArrayList<>();
            //listTel.add(0,tfTel1.getText());
            //listTel.add(1,tfTel2.getText());
            System.out.println("teste1: " + tfTel1.getText() + "\n");
            System.out.println("teste2: " + tfTel2.getText() + "\n");
            //observableListTel.add(tfTel1.getText());
            //observableListTel.add(tfTel2.getText());
            String str, str1;
            str = tfTel1.getText();
            //listTel.add(str);
            str1 = tfTel2.getText();
            //listTel.add(str);
            System.out.println("teste lista: " + listTel);

            fornecedor.getTelefones().addAll(Arrays.asList(str, str1));
            fornService.update(fornecedor);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fornecedor alterado com sucesso");
            alert.show();
            carregarTableViewFornecedores();
        }
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (tfNome.getText() == null || tfNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (tfCPF.getText() == null || tfCPF.getText().length() == 0) {
            errorMessage += "CPF ou CNPJ inválido!\n";
        }
        if (tfTipo.getText() == null || tfTipo.getText().length() == 0) {
            errorMessage += "Tipo inválido!\n";
        }
        if (Integer.parseInt(tfTipo.getText()) < 1 || Integer.parseInt(tfTipo.getText()) > 2) {
            errorMessage += "Tipo Inválido - 1 = CPF e 2 = CNPJ!\n";
        }
        if (lbStatus1.getText() == null || lbStatus1.getText().length() == 0) {
            errorMessage += "Status inválido!\n";
        }
        if (tfEmail.getText() == null || tfEmail.getText().length() == 0) {
            errorMessage += "Email inválido!\n";
        }
        if (tfNum.getText() == null || tfNum.getText().length() == 0) {
            errorMessage += "Número inválido!\n";
        }
        if (cbBairro.getValue() == null || cbBairro.toString().equals(0)) {
            errorMessage += "Bairro inválido!\n";
        }
        if (lbFuncId.getText() == null || lbFuncId.toString().equals(0)) {
            errorMessage += "Funcionário inválido!\n";
        }
        if (((tfTel1.getText() == null) || (tfTel1.getText().length() == 0)) && ((tfTel2.getText() == null) || (tfTel2.getText().length() == 0))) {
            errorMessage += "Insira pelo menos um número de telefone!\n";
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
        carregarTableViewFornecedores();
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

}
