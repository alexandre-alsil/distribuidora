/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Bairro;
import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.service.BairroService;
import edu.ifes.ci.si.les.sdb.service.FuncionarioService;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
public class FXMLCadastroFuncionarioController implements Initializable {

    @FXML
    private AnchorPane apFunc;
    @FXML
    private TextField tfTel2;
    @FXML
    private TextField tfTel1;
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
    private Label lbNomeFunc1;
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
    private Label lbNomeFunc;
    @FXML
    private Label lbFuncao;
    @FXML
    private TableView<Funcionario> tvFunc;
    @FXML
    private TableColumn<Funcionario, Integer> tcIdFunc;
    @FXML
    private TableColumn<Funcionario, String> tcNomeFunc;
    @FXML
    private TableColumn<Funcionario, String> tcCPF;
    @FXML
    private Label lbUsuario;
    @FXML
    private Label lbSenha;
    @FXML
    private Label lbUsuario1;
    @FXML
    private Label lbSenha1;
    @FXML
    private TextField tfUsuario;
    @FXML
    private TextField tfSenha;

    private List<Funcionario> listFunc;
    private List<Bairro> listBairro;
    private List<Funcionario> listFunc1;
    private List<String> listTel;    
    private ArrayList<String> aTel;
    private ObservableList<Funcionario> observableListFunc;
    private ObservableList<Bairro> observableListBairro;
    //private ObservableList<Funcionario> observableListFunc1;
    boolean b;

    private final FuncionarioService funcService = new FuncionarioService();
    private final BairroService bairroService = new BairroService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTableViewFunc();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewFunc(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvFunc.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewFunc(newValue));

    }

    public void carregarTableViewFunc() {
        tcIdFunc.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeFunc.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCPF.setCellValueFactory(new PropertyValueFactory<>("cpfCnpj"));

        listFunc = funcService.findAll();
        observableListFunc = FXCollections.observableArrayList(listFunc);
        tvFunc.setItems(observableListFunc);
        tvFunc.refresh();
        tfNome.setVisible(false);
        tfNome.setText("");
        tfCPF.setVisible(false);
        tfCPF.setText("");
        tfTipo.setVisible(false);
        tfTipo.setText("");
        tfEmail.setVisible(false);
        tfEmail.setText("");
        tfSenha.setVisible(false);
        tfSenha.setText("");
        tfUsuario.setVisible(false);
        tfUsuario.setText("");
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
        lbNomeFunc.setVisible(false);
        lbNomeFunc1.setVisible(false);
        lbCPF.setVisible(false);
        lbCPF1.setVisible(false);
        lbEmail.setVisible(false);
        lbEmail1.setVisible(false);
        lbStatus.setVisible(false);
        lbStatus1.setVisible(false);
        lbUsuario.setVisible(false);
        lbUsuario1.setVisible(false);
        lbSenha.setVisible(false);
        lbSenha1.setVisible(false);
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

    public void selecionarItemTableViewFunc(Funcionario func) {
        if (func != null) {

            /* procurar informação de controls FX */
            lbNomeFunc.setVisible(true);
            lbNomeFunc1.setVisible(true);
            lbNomeFunc1.setText(func.getNome());
            lbCPF.setVisible(true);
            lbCPF1.setVisible(true);
            lbCPF1.setText(func.getCpfCnpj());
            lbEmail.setVisible(true);
            lbEmail1.setVisible(true);
            lbEmail1.setText(func.getEmail());
            lbNum.setVisible(true);
            lbNum1.setVisible(true);
            lbNum1.setText(func.getNumero());
            lbRua.setVisible(true);
            lbRua1.setVisible(true);
            lbRua1.setText(func.getRua());
            lbTela.setVisible(true);
            lbTela1.setVisible(true);
            //lbTela1.setText(func.getTelefones().toString());
            lbTele.setVisible(true);
            lbTele1.setVisible(true);

            aTel = new ArrayList<>();
            aTel.addAll(func.getTelefones());
            int i = 0;
            while (i < aTel.size()) {

                    lbTela1.setText(aTel.get(i));

                    lbTele1.setText(aTel.get(i+1));

                i=i+2;
            }

            lbTipo.setVisible(true);
            lbTipo1.setVisible(true);
            lbTipo1.setText(func.getTipo().toString());
            lbBairro.setVisible(true);
            lbBairro1.setVisible(true);
            lbStatus.setVisible(true);
            lbStatus1.setVisible(true);
            lbUsuario.setVisible(true);
            lbUsuario1.setVisible(true);
            lbUsuario1.setText(func.getLogin());
            lbSenha.setVisible(true);
            lbSenha1.setVisible(true);
            lbSenha1.setText(func.getSenha());
            lbStatus1.setText(func.getStatus().toString());
            lbBairro1.setText(func.getBairro().getNome());
            lbFuncao.setVisible(true);
            lbFuncao.setText("Listar Funcionário");
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        } else {
            carregarTableViewFunc();
        }
    }

    public void carregarComboBoxBairro() {
        listBairro = bairroService.findAll();
        observableListBairro = FXCollections.observableArrayList(listBairro);
        cbBairro.setItems(observableListBairro);
    }

    @FXML
    private void handleButtonListar(ActionEvent event) {
        carregarTableViewFunc();
    }

    @FXML
    private void handleButtonRemover(ActionEvent event) {
        Funcionario func = tvFunc.getSelectionModel().getSelectedItem();
        if (func != null) {
            funcService.delete(func.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Funcionário deletado com sucesso!");
            alert.show();
            carregarTableViewFunc();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Funcionário na Tabela!");
            alert.show();
        }
    }

    @FXML
    private void handleButtonCancelarAP(ActionEvent event) {
        apFunc.getChildren().clear();
    }

    @FXML
    private void handleButtonAlterar(ActionEvent event) {

        Funcionario func = tvFunc.getSelectionModel().getSelectedItem();

        if (func != null) {
            tfNome.setVisible(true);
            tfNome.setText(func.getNome());
            tfCPF.setVisible(true);
            tfCPF.setText(func.getCpfCnpj());
            tfTipo.setVisible(true);
            tfTipo.setText(func.getTipo().toString());
            tfEmail.setVisible(true);
            tfEmail.setText(func.getEmail());
            tfNum.setVisible(true);
            tfNum.setText(func.getNumero());
            tfRua.setVisible(true);
            tfRua.setText(func.getRua());
            tfTel1.setVisible(true);
            tfTel2.setVisible(true);
            tfUsuario.setVisible(true);
            tfUsuario.setText(func.getLogin());
            tfSenha.setVisible(true);
            tfSenha.setText(func.getSenha());

            cbBairro.setVisible(true);
            cbBairro.setValue(func.getBairro());
            lbNomeFunc.setVisible(true);
            lbNomeFunc1.setVisible(false);
            lbCPF.setVisible(true);
            lbCPF1.setVisible(false);
            lbEmail.setVisible(true);
            lbEmail1.setVisible(false);
            lbStatus.setVisible(true);
            lbStatus1.setVisible(true);
            lbStatus1.setText(func.getStatus().toString());
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
            lbUsuario.setVisible(true);
            lbUsuario1.setVisible(false);
            lbSenha.setVisible(true);
            lbSenha1.setVisible(false);
            lbFuncao.setVisible(true);
            lbFuncao.setText("Alterar Funcionário");
            btCancelar.setVisible(true);
            btConfirmar.setVisible(true);
            btnInserir.setVisible(false);
            btnCancelar.setVisible(false);
            btnListar.setVisible(false);
            btnLocalizar.setVisible(false);
            btnRemover.setVisible(false);
            //teste 
            //String it[];
            //String it;
            //Iterable it[];
            //listTel.addAll(func.getTelefones().toArray());
            //it = (String[]) func.getTelefones().toArray();
            //it = func.getTelefones().toString();
            //it = iti.;
            //tfTel1.setText(func.getTelefones().iterator().next());

            aTel = new ArrayList<>();
            aTel.addAll(func.getTelefones());
            int i = 0;
            while (i < aTel.size()) {
                    tfTel1.setText(aTel.get(i));
             
                    tfTel2.setText(aTel.get(i+1));
               
                i=i+2;
            }
            //tfTel1.setText(it[0]);        
            //tfTel2.setText(it[1]);
            //func.getTelefones().addAll(Arrays.asList(tfTel1.getText(), tfTel2.getText()));
            //tfTel1.setText(func.getTelefones().toString());
            //tfTel2.setText(func.getTelefones().toString());
            carregarComboBoxBairro();
            //selecionarItemTableViewFunc(null);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Funcionário na Tabela!");
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
        tfUsuario.setVisible(true);
        tfUsuario.setText("");
        tfSenha.setVisible(true);
        tfSenha.setText("");
        cbBairro.setVisible(true);
        //cbBairro.setValue(null);
        //cbFunc.setValue(null);
        lbNomeFunc.setVisible(true);
        lbNomeFunc1.setVisible(false);
        lbCPF.setVisible(true);
        lbCPF1.setVisible(false);
        lbEmail.setVisible(true);
        lbEmail1.setVisible(false);
        lbStatus.setVisible(true);
        lbStatus1.setVisible(true);
        lbStatus1.setText("0");
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
        lbFuncao.setText("Inserir Funcionário");
        btCancelar.setVisible(true);
        btConfirmar.setVisible(true);
        btnInserir.setVisible(false);
        btnCancelar.setVisible(false);
        btnListar.setVisible(false);
        btnLocalizar.setVisible(false);
        btnRemover.setVisible(false);
        carregarComboBoxBairro();
        // selecionarItemTableViewFunc(null);

    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) {
        Funcionario func = new Funcionario();
        b = validarEntradaDeDados(); //dialogStage.close();
        if (b && "Inserir Funcionário".equals(lbFuncao.getText())) {
            //uf.setId(3);
            func.setNome(tfNome.getText());
            func.setCpfCnpj(tfCPF.getText());
            func.setEmail(tfEmail.getText());
            func.setNumero(tfNum.getText());
            func.setStatus(0);
            func.setRua(tfRua.getText());
            func.setTipo(Integer.parseInt(lbStatus1.getText()));
            func.setBairro(cbBairro.valueProperty().getValue());
            func.setLogin(tfUsuario.getText());
            func.setSenha(tfSenha.getText());
            //func.setFuncionario(cbFunc.valueProperty().getValue());
            //System.out.println("teste1" +tfTel1.getText());
            //listTel.add(tfTel1.getText());
            // listTel.add(tfTel2.getText());
            //System.out.println("teste2" +listTel);
            //cliente.setTelefone((Set<String>) listTel);
            func.getTelefones().addAll(Arrays.asList(tfTel1.getText(), tfTel2.getText()));
            /*
            private List<Cliente> listCliente;
    private ObservableList<Funcionario> observableListFunc;
            @ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<>();
            cliente1.getTelefone().addAll(Arrays.asList("111111111", "222222222"));
             */

            funcService.insert(func);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Funcionário inserido com sucesso");
            alert.show();
            //carregarTableViewFunc();
            selecionarItemTableViewFunc(null);

        }

        if (b && "Alterar Funcionário".equals(lbFuncao.getText())) {
            //uf.setId(3);
            func.setId(tvFunc.getSelectionModel().getSelectedItem().getId());
            func.setNome(tfNome.getText());
            func.setCpfCnpj(tfCPF.getText());
            func.setEmail(tfEmail.getText());
            func.setNumero(tfNum.getText());
            func.setStatus(Integer.parseInt(lbStatus1.getText()));
            func.setRua(tfRua.getText());
            func.setTipo(Integer.parseInt(tfTipo.getText()));
            func.setBairro(cbBairro.valueProperty().getValue());
            func.setLogin(tfUsuario.getText());
            func.setSenha(tfSenha.getText());
            listTel = new ArrayList<>();
            System.out.println("teste1: "+tfTel1.getText()+"\n");
            System.out.println("teste2: "+tfTel2.getText()+"\n");
            String str, str1;
            str = tfTel1.getText();
            str1 = tfTel2.getText();
            System.out.println("teste lista: "+listTel);
            func.getTelefones().addAll(Arrays.asList(str, str1));
            funcService.update(func);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Funcionário alterado com sucesso");
            alert.show();
            //carregarTableViewFunc();
            selecionarItemTableViewFunc(null);
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
            errorMessage += "Tipo Inválido - 1 = Gerente e 2 = Comum!\n";
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
        if (((tfTel1.getText() == null) || (tfTel1.getText().length() == 0)) && ((tfTel2.getText() == null) || (tfTel2.getText().length() == 0))) {
            errorMessage += "Insira pelo menos um número de telefone!\n";
        }
        if (tfUsuario.getText() == null || tfUsuario.getText().length() == 0) {
            errorMessage += "Usuário inválido!\n";
        }
        if (tfSenha.getText() == null || tfSenha.getText().length() == 0) {
            errorMessage += "Senha inválida!\n";
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
        carregarTableViewFunc();
    }

}
