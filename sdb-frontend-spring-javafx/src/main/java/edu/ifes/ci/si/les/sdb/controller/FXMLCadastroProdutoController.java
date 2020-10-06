/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Fornecedor;
import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.model.Produto;
import edu.ifes.ci.si.les.sdb.service.FornecedorService;
import edu.ifes.ci.si.les.sdb.service.FuncionarioService;
import edu.ifes.ci.si.les.sdb.service.ProdutoService;
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
public class FXMLCadastroProdutoController implements Initializable {

    @FXML
    private AnchorPane apProduto;
    @FXML
    private TableView<Produto> tvProd;
    @FXML
    private TableColumn<Produto, Integer> tcIdProd;
    @FXML
    private TableColumn<Produto, String> tcNomeProd;
    @FXML
    private TableColumn<Produto, Integer> tcEst;
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
    private Label lbFuncao;
    @FXML
    private TextField tfNome;
    @FXML
    private Label lbNomeProd;
    @FXML
    private Label lbTipo;
    @FXML
    private Label lbTipo1;
    @FXML
    private Label lbNomeProd1;
    @FXML
    private TextField tfTipo;
    @FXML
    private Label lbStatus;
    @FXML
    private TextField tfStatus;
    @FXML
    private Label lbStatus1;
    @FXML
    private Label lbPreco;
    @FXML
    private Label lbPreco1;
    @FXML
    private Label lbPrecoCompra;
    @FXML
    private Label lbPrecoCompra1;
    @FXML
    private Label lbPrecoPromocao;
    @FXML
    private Label lbPrecoPromocao1;
    @FXML
    private TextField tfPrecoPromocao;
    @FXML
    private Label lbCurvaABC;
    @FXML
    private Label lbCurvaABC1;
    @FXML
    private Label lbCurvaXYZ;
    @FXML
    private Label lbCurvaXYZ1;
    @FXML
    private Label lbEstoque;
    @FXML
    private Label lbEstoque1;
    @FXML
    private Label lbEstoqueMin;
    @FXML
    private Label lbEstoqueMin1;
    @FXML
    private Label lbFuncionario;
    
    @FXML
    private Label lbFuncionario1;
    @FXML
    private Button btCancelar;
    @FXML
    private Button btConfirmar;
    @FXML
    private Label lbFornecedor;
    @FXML
    private Label lbFornecedor1;
    @FXML
    private TextField tfPreco;
    @FXML
    private Label lbFuncId;

    private Funcionario func;
    private Integer id;
    
    private List<Fornecedor> listForn;
    private List<Produto> listProd;

    private ObservableList<Fornecedor> observableListForn;
    private ObservableList<Produto> observableListProd;
    boolean b;

    private final FuncionarioService funcService = new FuncionarioService();
    private final FornecedorService fornService = new FornecedorService();
    private final ProdutoService prodService = new ProdutoService();
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTableViewProdutos();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewProdutos(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvProd.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewProdutos(newValue));

    }

    public void carregarTableViewProdutos() {

        tcIdProd.setCellValueFactory(new PropertyValueFactory<>("id"));
        tcNomeProd.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcEst.setCellValueFactory(new PropertyValueFactory<>("estoque"));

        listProd = prodService.findAll();
        observableListProd = FXCollections.observableArrayList(listProd);
        tvProd.setItems(observableListProd);
        tvProd.refresh();
        tfNome.setVisible(false);
        tfNome.setText("");
        tfPrecoPromocao.setVisible(false);
        tfPrecoPromocao.setText("");
        tfTipo.setVisible(false);
        tfTipo.setText("");
        tfStatus.setVisible(false);
        tfStatus.setText("");
        tfPreco.setVisible(false);
        tfPreco.setText("");
        lbCurvaABC.setVisible(false);
        //lbCurvaABC.setText("");
        lbCurvaXYZ.setVisible(false);
        //lbCurvaXYZ.setText("");
        lbCurvaABC1.setVisible(false);
        lbCurvaABC1.setText("");
        lbCurvaXYZ1.setVisible(false);
        lbCurvaXYZ1.setText("");
        lbEstoque.setVisible(false);
        //lbEstoque.setText("");
        lbEstoque1.setVisible(false);
        lbEstoque1.setText("");
        lbEstoqueMin.setVisible(false);
        //lbEstoqueMin.setText("");
        lbEstoqueMin1.setVisible(false);
        lbEstoqueMin1.setText("");
        lbFornecedor.setVisible(false);
        //lbFornecedor.setText("");
        lbFornecedor1.setVisible(false);
        lbFornecedor1.setText("");
        lbStatus.setVisible(false);
        //lbStatus.setText("");
        lbStatus1.setVisible(false);
        lbStatus1.setText("");
        lbTipo.setVisible(false);
        lbTipo1.setVisible(false);
        lbFuncionario.setVisible(false);
        //lbFuncionario.setText("");
        lbFuncionario1.setVisible(false);
        lbFuncionario1.setText("");
        lbPreco.setVisible(false);
        //lbPreco.setText("");
        lbPreco1.setVisible(false);
        lbPreco1.setText("");
        lbPrecoCompra.setVisible(false);
        //lbPrecoCompra.setText("");
        lbPrecoCompra1.setVisible(false);
        lbPrecoCompra1.setText("");
        lbPrecoPromocao.setVisible(false);
        //lbPrecoPromocao.setText("");
        lbPrecoPromocao1.setVisible(false);
        lbPrecoPromocao1.setText("");
        lbNomeProd.setVisible(false);
        //lbNomeProd.setText("");
        lbNomeProd1.setVisible(false);
        lbNomeProd1.setText("");

        lbFuncId.setVisible(false);
        lbFuncId.setText("");

        lbFuncao.setVisible(false);
        btCancelar.setVisible(false);
        btConfirmar.setVisible(false);
        btnInserir.setVisible(true);
        btnCancelar.setVisible(true);
        btnListar.setVisible(true);
        btnLocalizar.setVisible(true);
        btnRemover.setVisible(true);
        tvProd.setPlaceholder(null);

    }

    public void selecionarItemTableViewProdutos(Produto produto) {
        if (produto != null) {

            /*tfNome.setVisible(false);
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
            cbFunc.setVisible(false);
            cbFunc.setValue(null);*/
            lbNomeProd.setVisible(true);
            lbNomeProd1.setVisible(true);
            lbNomeProd1.setText(produto.getNome());
            lbTipo.setVisible(true);
            lbTipo1.setVisible(true);
            lbTipo1.setText(produto.getTipo().toString());
            lbStatus.setVisible(true);
            lbStatus1.setVisible(true);
            lbStatus1.setText(produto.getStatus().toString());
            lbPreco.setVisible(true);
            lbPreco1.setVisible(true);
            lbPreco1.setText(produto.getPrecoVenda().toString());
            lbPrecoCompra.setVisible(true);
            lbPrecoCompra1.setVisible(true);
            lbPrecoCompra1.setText(produto.getPrecoCompra().toString());
            lbPrecoPromocao.setVisible(true);
            lbPrecoPromocao1.setVisible(true);
            lbPrecoPromocao1.setText(produto.getPrecoPromocao().toString());
            lbCurvaABC.setVisible(true);
            lbCurvaABC1.setVisible(true);
            lbCurvaABC1.setText(produto.getCurvaABC());
            lbCurvaXYZ.setVisible(true);
            lbCurvaXYZ1.setVisible(true);
            lbCurvaXYZ1.setText(produto.getCurvaXYZ());
            lbEstoque.setVisible(true);
            lbEstoque1.setVisible(true);
            lbEstoque1.setText(produto.getEstoque().toString());
            lbEstoqueMin.setVisible(true);
            lbEstoqueMin1.setVisible(true);
            lbEstoqueMin1.setText(produto.getEstoqueMinimo().toString());
            lbFuncionario.setVisible(true);
            lbFuncionario1.setVisible(true);
            lbFuncionario1.setText(produto.getFuncionario().getNome());
            lbFornecedor.setVisible(true);
            lbFornecedor1.setVisible(true);
            listForn = produto.getFornecedor();
            if(listForn.isEmpty()){
                  lbFornecedor1.setText("Ainda não temos fornecedor");
              }
            else{
                String forn = "";
                for (Fornecedor f : listForn) {

                    
                    forn = forn +" "+ f.getNome();

                    
            }
            lbFornecedor1.setText(forn);
            }
            //lbFornecedor1.setText(produto.getFornecedor().containsAll(listFunc));
            lbFuncao.setVisible(true);
            lbFuncao.setText("Listar Produtos");
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        } else {
            carregarTableViewProdutos();
        }
    }

    public void carregarLabelFunc() {
        
        int i =  id;
        func = funcService.find(i);
        lbFuncId.setText(func.getNome());
    }

    @FXML
    private void handleButtonInserir(ActionEvent event) {

        tfNome.setVisible(true);
        tfNome.setText("");

        tfTipo.setVisible(true);
        tfTipo.setText("");

        lbNomeProd.setVisible(true);
        lbTipo.setVisible(true);
        lbPreco.setVisible(true);
        lbPreco1.setVisible(true);
        lbPreco1.setText("0");
        lbPrecoCompra.setVisible(true);
        lbPrecoCompra1.setVisible(true);
        lbPrecoCompra1.setText("0");
        lbPrecoPromocao.setVisible(true);
        lbPrecoPromocao1.setVisible(true);
        lbPrecoPromocao1.setText("0");
        lbCurvaABC.setVisible(true);
        //lbCurvaABC.setText("");
        lbCurvaXYZ.setVisible(true);
        //lbCurvaXYZ.setText("");
        lbCurvaABC1.setVisible(true);
        lbCurvaABC1.setText("0");
        lbCurvaXYZ1.setVisible(true);
        lbCurvaXYZ1.setText("0");
        lbEstoque.setVisible(true);
        //lbEstoque.setText("");
        lbEstoque1.setVisible(true);
        lbEstoque1.setText("0");
        lbEstoqueMin.setVisible(true);
        //lbEstoqueMin.setText("");
        lbEstoqueMin1.setVisible(true);
        lbEstoqueMin1.setText("0");
        lbFornecedor.setVisible(false);
        //lbFornecedor.setText("");
        lbFornecedor1.setVisible(false);
        lbFornecedor1.setText("Vazio");
        lbStatus.setVisible(true);
        lbStatus1.setText("0");
        //lbPrecoPromocao1.setVisible(false);
        lbFuncId.setVisible(true);
        lbNomeProd1.setVisible(false);
        lbTipo1.setVisible(false);
        lbStatus1.setVisible(true);
        lbFuncao.setVisible(true);
        lbFuncao.setText("Inserir Produto");
        btCancelar.setVisible(true);
        btConfirmar.setVisible(true);
        btnInserir.setVisible(false);
        btnCancelar.setVisible(false);
        btnListar.setVisible(false);
        btnLocalizar.setVisible(false);
        btnRemover.setVisible(false);
        carregarLabelFunc();

    }

    @FXML
    private void handleButtonAlterar(ActionEvent event) {

        Produto produto = tvProd.getSelectionModel().getSelectedItem();

        if (produto != null) {
            tfNome.setVisible(true);
            tfNome.setText(produto.getNome());
            tfPrecoPromocao.setVisible(true);
            tfPrecoPromocao.setText(produto.getPrecoPromocao().toString());
            tfTipo.setVisible(true);
            tfTipo.setText(produto.getTipo().toString());
            tfStatus.setVisible(true);
            tfStatus.setText(produto.getStatus().toString());
            tfPreco.setVisible(true);
            tfPreco.setText(produto.getPrecoVenda().toString());
            lbNomeProd.setVisible(true);
            lbTipo.setVisible(true);
            lbPreco.setVisible(true);
            lbPrecoPromocao.setVisible(true);
            lbFornecedor.setVisible(true);
            //lbFornecedor1.setVisible(true);
            lbPrecoCompra.setVisible(true);
            lbPrecoCompra1.setVisible(true);
            lbPrecoCompra1.setText(produto.getPrecoCompra().toString());
            lbCurvaABC.setVisible(true);
            //lbCurvaABC.setText("");
            lbCurvaXYZ.setVisible(true);
            //lbCurvaXYZ.setText("");
            lbCurvaABC1.setVisible(true);
            lbCurvaABC1.setText(produto.getCurvaABC());
            lbCurvaXYZ1.setVisible(true);
            lbCurvaXYZ1.setText(produto.getCurvaXYZ());
            lbEstoque.setVisible(true);
            //lbEstoque.setText("");
            lbEstoque1.setVisible(true);
            lbEstoque1.setText(produto.getEstoque().toString());
            lbEstoqueMin.setVisible(true);
            //lbEstoqueMin.setText("");
            lbEstoqueMin1.setVisible(true);
            lbEstoqueMin1.setText(produto.getEstoqueMinimo().toString());
            lbFornecedor.setVisible(false);
            //lbFornecedor.setText("");
            lbNomeProd1.setVisible(false);
            lbTipo1.setVisible(false);
            lbStatus1.setVisible(false);
            lbPreco1.setVisible(false);
            lbPrecoPromocao1.setVisible(false);
            lbFuncionario1.setVisible(false);
            lbFornecedor1.setVisible(false);
            lbFornecedor1.setText(produto.getFornecedor().toString());
            lbStatus.setVisible(true);
            lbStatus1.setText(produto.getStatus().toString());
            lbFuncId.setVisible(true);
            lbFuncId.setText(produto.getFuncionario().getNome());
            lbFuncao.setVisible(true);
            lbFuncao.setText("Alterar Produto");
            btCancelar.setVisible(true);
            btConfirmar.setVisible(true);
            btnInserir.setVisible(false);
            btnCancelar.setVisible(false);
            btnListar.setVisible(false);
            btnLocalizar.setVisible(false);
            btnRemover.setVisible(false);
            carregarLabelFunc();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Produto na Tabela!");
            alert.show();
        }
    }

    @FXML
    private void handleButtonCancelarAP(ActionEvent event) {
        apProduto.getChildren().clear();
    }

    @FXML
    private void handleButtonRemover(ActionEvent event) {
        Produto produto = tvProd.getSelectionModel().getSelectedItem();
        if (produto != null) {
            prodService.delete(produto.getId());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Fornecedor deletado com sucesso!");
            alert.show();
            carregarTableViewProdutos();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um Produto na Tabela!");
            alert.show();
        }
    }

    @FXML
    private void handleButtonListar(ActionEvent event) {
        carregarTableViewProdutos();
    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
        carregarTableViewProdutos();
    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) {
        Produto produto = new Produto();
        b = validarEntradaDeDados(); //dialogStage.close();
        if (b && "Inserir Produto".equals(lbFuncao.getText())) {
            //uf.setId(3);
            produto.setNome(tfNome.getText());
            produto.setTipo(Integer.parseInt(tfTipo.getText()));
            produto.setStatus(Integer.parseInt(lbStatus1.getText()));
            produto.setPrecoCompra(0.00);
            produto.setPrecoPromocao(0.00);
            produto.setPrecoVenda(0.00);
            produto.setEstoque(0);
            produto.setEstoqueMinimo(0);
            produto.setCurvaABC("");
            produto.setCurvaXYZ("");
            produto.setFuncionario(func);
            produto.setFornecedor(listForn);
            prodService.insert(produto);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Produto inserido com sucesso");
            alert.show();

            carregarTableViewProdutos();

        }

        if (b && "Alterar Produto".equals(lbFuncao.getText())) {
            //uf.setId(3);
            produto.setId(tvProd.getSelectionModel().getSelectedItem().getId());
            produto.setNome(tfNome.getText());
            produto.setTipo(Integer.parseInt(tfTipo.getText()));
            produto.setStatus(Integer.parseInt(tfStatus.getText()));
            produto.setPrecoVenda(Double.parseDouble(tfPreco.getText()));
            produto.setPrecoPromocao(Double.parseDouble(tfPrecoPromocao.getText()));
            produto.setPrecoCompra(Double.parseDouble(lbPrecoCompra1.getText()));
            produto.setCurvaABC(lbCurvaABC1.getText());
            produto.setCurvaXYZ(lbCurvaXYZ1.getText());
            produto.setEstoque(Integer.parseInt(lbEstoque1.getText()));
            produto.setEstoqueMinimo(Integer.parseInt(lbEstoqueMin1.getText()));
            produto.setFuncionario(func);
            //listForn.(produto.getFornecedor());
            produto.setFornecedor(listForn);

            prodService.update(produto);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Produto alterado com sucesso");
            alert.show();
            carregarTableViewProdutos();
        }
    }

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (tfNome.getText() == null || tfNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        /*if (tfCPF.getText() == null || tfCPF.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (tfEmail.getText() == null || tfEmail.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (tfNum.getText() == null || tfNum.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }
        if (cbBairro.toString() == null || cbBairro.toString().length() == 0) {
            errorMessage += "Bairro inválido!\n";
        }
        if (cbFunc.toString() == null || cbFunc.toString().length() == 0) {
            errorMessage += "Funcionário inválido!\n";
        }*/

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

    public void setId(Integer id) {
        this.id = id;
    }
    
    

}
