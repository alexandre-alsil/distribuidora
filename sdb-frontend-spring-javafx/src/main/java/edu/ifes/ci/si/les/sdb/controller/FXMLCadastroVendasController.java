/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Bairro;
import edu.ifes.ci.si.les.sdb.model.Cliente;
import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.model.ItemVenda;
import edu.ifes.ci.si.les.sdb.model.Produto;
import edu.ifes.ci.si.les.sdb.model.Venda;
import edu.ifes.ci.si.les.sdb.service.BairroService;
import edu.ifes.ci.si.les.sdb.service.ClienteService;
import edu.ifes.ci.si.les.sdb.service.ItensServiceVenda;
import edu.ifes.ci.si.les.sdb.service.ProdutoService;
import edu.ifes.ci.si.les.sdb.service.VendaService;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Alexandre
 */
public class FXMLCadastroVendasController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private Label lbFuncao;
    @FXML
    private Button btConfirmar;
    @FXML
    private Button btCancelar;
    @FXML
    private Label lbFuncionario1;
    @FXML
    private Label lbFuncionario;
    @FXML
    private Label lbProduto1;
    @FXML
    private Label lbVenc1;
    @FXML
    private Label lbEntrega;
    @FXML
    private Label lbNomeProd1;
    @FXML
    private Label lbData1;
    @FXML
    private Label lbData;
    @FXML
    private Label lbNomeCliente;
    @FXML
    private Label lbFuncao1;
    @FXML
    private Button btnListar;
    @FXML
    private Button btnDetalhar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnInserir;
    @FXML
    private ComboBox<Cliente> cbFornc;
    @FXML
    private DatePicker dpDataCompra;
    @FXML
    private ComboBox<Produto> cbProdVenda;
    @FXML
    private Label lbProd;
    @FXML
    private Label lbPreco;
    @FXML
    private Label lbPreco1;
    @FXML
    private TextField tfPrecoCompra;
    @FXML
    private Label lbQtde;
    @FXML
    private TextField tfQtdeCompra;
    @FXML
    private Label lbTotal;
    @FXML
    private Label lbTotal1;
    @FXML
    private Button btAdicionar;
    @FXML
    private Button btRemover;
    @FXML
    private Label lbInserir;
    @FXML
    private Label lbRemover;
    @FXML
    private AnchorPane apTV;
    @FXML
    private TableView<Venda> tvListCompras;
    @FXML
    private TableColumn<Venda, String> tcForn;
    @FXML
    private TableColumn<Venda, Date> tcData;
    @FXML
    private TableColumn<Venda, Double> tcTotal;
    @FXML
    private TableView<ItemVenda> tvListProd;
    @FXML
    private TableColumn<Produto, String> tcProd;
    @FXML
    private TableColumn<Produto, Double> tcPreco;
    @FXML
    private TableColumn<Produto, Integer> tcQtde;
    @FXML
    private TableColumn<Double, Double> tcSubTotal;
    @FXML
    private Label lbStatus;
    @FXML
    private Label lbStatus1;
    @FXML
    private Label lbQtde1;
    @FXML
    private RadioButton rbLocal;
    @FXML
    private RadioButton rbCliente;

    private Funcionario func;
    boolean b;
    private List<Cliente> listCliente;
    private List<Venda> listVenda;
    private List<ItemVenda> listItens;
    private List<ItemVenda> listItensRemover;
    private List<Produto> listItensCb;
    private List<Bairro> listBairro;

    private ObservableList<Cliente> observableListCliente;
    private ObservableList<Venda> observableListVenda;
    private ObservableList<ItemVenda> observableListItens;
    private ObservableList<Produto> observableListItensCb;

    private final ClienteService cliService = new ClienteService();
    private final VendaService vendaService = new VendaService();
    private final ProdutoService prodService = new ProdutoService();
    private final ItensServiceVenda itVendaService = new ItensServiceVenda();
    private final BairroService bairroService = new BairroService();
    final ToggleGroup group = new ToggleGroup();

    private Venda venda;
    @FXML
    private Label lbEntrega1;
    @FXML
    private Label lbRua;
    @FXML
    private Label lbNum;
    @FXML
    private TextField tfRua;
    @FXML
    private TextField tfNum;
    @FXML
    private Label lbRua1;
    @FXML
    private Label lbNum1;
    @FXML
    private Group groupEnt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTableViewVendas();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewVendas(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvListCompras.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewVendas(newValue));

        tvListProd.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableProdutos(newValue));

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                if (group.getSelectedToggle() != null) {

                    String s = group.getSelectedToggle().toString();
                    if(s.equals(rbLocal.toString())){
                        tfRua.setText("Rua Estab.");
                        tfNum.setText("21");
                    }else{
                        tfRua.setText("");
                        tfNum.setText("");
                    }
                           
                }
            }
        
       
    });

    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) {

        //b = validarEntradaDeDados(); 
        b = true;
        if (b && "Inserir Venda".equals(lbFuncao1.getText())) {
            //uf.setId(3);
            //Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            venda.setCliente(cbFornc.getValue());
            venda.setData(java.sql.Date.valueOf(dpDataCompra.getValue().plusDays(1)));

            //venda.setDataVencimento(java.sql.Date.valueOf(dpDataVenc.getValue().plusDays(1)));
            venda.setFuncionario(func);
            //compra.setStatus(1);

            //compra.setItemCompra(listItens);
            for (ItemVenda it : venda.getItemVenda()) {
                for (Produto p : listItensCb) {
                    if (Objects.equals(it.getProduto().getId(), p.getId())) {
                        p.setEstoque(p.getEstoque() - it.getQuantidadeVenda());
                        //listForn.add(compra.getFornecedor());
                        //compra.getFornecedor();
                        //p.setFornecedor(compra.getFornecedor());
                        //fazer uma variavel receber string
                        //compra.setTotal(Double.valueOf(String.format("%.2f", lbTotal1.getText())));
                        //lbPreco1.setText(value);
                        venda.setTotal(Double.valueOf(lbTotal1.getText()));

                        //p.setPrecoVenda(it.getProduto().getPrecoCompra());
                        prodService.update(p);
                        System.out.println("fiz uppppppppppppp" + p);
                    }
                }
            }

            if (rbCliente.isSelected()) {
                venda.setBairro(venda.getCliente().getBairro());
                venda.setRua(tfRua.getText());
                venda.setNumero(tfNum.getText());
            } else if (rbLocal.isSelected()) {
                //listBairro = bairroService.find(0);
                Bairro bairro = bairroService.find(1);
                venda.setBairro(bairro);
                tfRua.setText("Rua Estab.");
                tfNum.setText("21");
                venda.setRua(tfRua.getText());
                venda.setNumero(tfNum.getText());
            } else {
                tfRua.setText("");
                tfNum.setText("");
            }

            venda.setStatus(Integer.parseInt(lbStatus1.getText()));
            //venda.setStatus(Integer.BYTES);
            //String.format("%.2f", compra.getTotal())
            //compra.setTotal(Double.valueOf(lbTotal1.getText()));
            //compra.setTotal(Double.valueOf(String.format("%.2f", lbTotal1.getText())));
            vendaService.insert(venda);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Venda inserida com sucesso");
            alert.show();

            carregarTableViewVendas();
            btnCancelar.setVisible(true);
            btnDetalhar.setVisible(true);
            btnInserir.setVisible(true);
            btnListar.setVisible(true);
            btnRemover.setVisible(true);

        }

    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
        carregarTableViewVendas();
    }

    @FXML
    private void handleButtonListar(ActionEvent event) {
    }

    @FXML
    private void handleButtonDetalhar(ActionEvent event) {
    }

    @FXML
    private void handleButtonRemoverVenda(ActionEvent event) {
    }

    @FXML
    private void handleButtonCancelarAP(ActionEvent event) {
        apPrincipal.getChildren().clear();
    }

    @FXML
    private void handleButtonInserir(ActionEvent event) {

        lbFuncao1.setVisible(true);
        lbFuncao1.setText("Inserir Venda");
        //carregarComboBoxFornecedor();
        tvListCompras.setVisible(false);
        tvListProd.setVisible(true);
        mostrarLabelsTitulo();
        cbFornc.setVisible(true);
        carregarComboBoxCliente();
        dpDataCompra.setVisible(true);
        lbEntrega.setVisible(true);
        rbCliente.setVisible(true);
        rbLocal.setVisible(true);
        rbLocal.setSelected(true);
        rbCliente.setVisible(true);
        //lbRua.setVisible(true);
        lbRua1.setVisible(false);
        lbNum1.setVisible(false);
        tfRua.setVisible(true);
        tfNum.setVisible(true);
        //dpDataVenc.setVisible(true);
        cbProdVenda.setVisible(true);
        carregarComboBoxProduto();
        //groupEnt.getChildren().add(rbCliente);
        //groupEnt.getChildren().add(rbLocal);

        rbCliente.setToggleGroup(group);
        rbLocal.setToggleGroup(group);

        tfPrecoCompra.setVisible(true);
        tfQtdeCompra.setVisible(true);
        btAdicionar.setVisible(true);
        btConfirmar.setVisible(true);
        btCancelar.setVisible(true);
        btRemover.setVisible(true);
        btnInserir.setVisible(false);
        btnListar.setVisible(false);
        btnRemover.setVisible(false);
        btnCancelar.setVisible(false);
        btnDetalhar.setVisible(false);
        venda = new Venda();
        lbFuncionario1.setVisible(true);
        lbFuncionario1.setText(func.getNome());
        lbStatus1.setVisible(true);
        lbStatus1.setText("1");

    }

    @FXML
    private void handleButtonAdicionar(ActionEvent event) {
        Produto p;
        if (venda == null) {
            venda = new Venda();
        }

        ItemVenda itVenda = new ItemVenda();
        if (cbProdVenda.getSelectionModel().getSelectedItem() != null) {
            p = cbProdVenda.getSelectionModel().getSelectedItem();

            if (p.getEstoque() > 0) {
                p.setPrecoCompra(Double.valueOf(tfPrecoCompra.getText()));
                itVenda.setProduto(p);
                itVenda.setQuantidadeVenda(Integer.parseInt(tfQtdeCompra.getText()));
                itVenda.setSubTotal(p.getPrecoCompra() * (Integer.parseInt(tfQtdeCompra.getText())));
                //itComp.setCompra(compra);

                //venda.getBairro().equals()
                venda.getItemVenda().add(itVenda);
                //listItens.add(itComp);
                if (venda.getTotal() != null) {
                    venda.setTotal(venda.getTotal() + itVenda.getSubTotal());
                } else {
                    venda.setTotal(itVenda.getSubTotal());
                }
                observableListItensCb.remove(p);
                //carregarComboBoxProduto();
                observableListItens = FXCollections.observableArrayList(venda.getItemVenda());
                tvListProd.setItems(observableListItens);
                lbTotal1.setVisible(true);
                lbTotal1.setText(String.valueOf(venda.getTotal()));
            }
        }

        carregarTableViewItens(venda);

    }

    @FXML
    private void handleButtonRemover(ActionEvent event) {
    }

    public void carregarTableViewVendas() {
        tvListCompras.setVisible(true);
        tcForn.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        tcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tcTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        listVenda = vendaService.findAll();
        observableListVenda = FXCollections.observableArrayList(listVenda);
        tvListCompras.setItems(observableListVenda);
        tvListProd.setVisible(false);
        esconderTodosLabels();

    }

    public void carregarTableViewItens(Venda venda) {

        tvListCompras.setVisible(false);
        tvListProd.setVisible(true);

        tcProd.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("precoVenda"));
        tcQtde.setCellValueFactory(new PropertyValueFactory<>("quantidadeVenda"));
        tcSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        listVenda = vendaService.findAll();
        observableListItens = FXCollections.observableArrayList(venda.getItemVenda());
        tvListProd.setItems(observableListItens);
        //tvListProd.setVisible(false);
        //esconderTodosLabels();

    }

    public void selecionarItemTableViewVendas(Venda venda) {
        if (venda != null) {
            Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            lbFuncao1.setVisible(true);
            lbFuncao1.setText("Listar Vendas");
            lbData.setVisible(true);
            lbData1.setVisible(true);
            lbData1.setText(formatter.format(venda.getData()));
            lbEntrega.setVisible(true);
            lbEntrega1.setVisible(true);
            lbEntrega1.setText(venda.getBairro().getNome());
            lbRua.setVisible(true);
            lbRua1.setVisible(true);
            lbRua1.setText(venda.getRua());
            lbNum.setVisible(true);
            lbNum1.setVisible(true);
            lbNum1.setText(venda.getNumero());
            //lbFuncao1.setVisible(true);
            //lbVenc.setVisible(true);
            //lbVenc1.setVisible(true);
            //lbVenc1.setText(formatter.format(venda.getDataVencimento()));
            lbFuncionario.setVisible(true);
            lbFuncionario1.setVisible(true);
            lbFuncionario1.setText(venda.getFuncionario().getNome());
            lbNomeCliente.setVisible(true);
            lbNomeProd1.setVisible(true);
            lbNomeProd1.setText(venda.getCliente().getNome());
            lbInserir.setVisible(false);
            lbPreco.setVisible(false);
            lbPreco1.setVisible(false);
            lbProduto1.setVisible(false);
            lbNum.setVisible(false);
            lbNum1.setVisible(false);
            lbRua.setVisible(false);
            lbRua1.setVisible(false);
            tfNum.setVisible(false);
            tfRua.setVisible(false);

            lbProd.setVisible(false);
            lbQtde.setVisible(false);
            lbRemover.setVisible(false);
            lbTotal.setVisible(true);
            lbTotal1.setVisible(true);
            lbTotal1.setText(String.format("%.2f", venda.getTotal())); //como fazer pra pegar dois dígitos no tv
            //lbVenc.setVisible(true);
            lbStatus.setVisible(true);
            lbStatus1.setVisible(true);
            lbStatus1.setText(verificarStatus(venda.getStatus().toString()));
            cbFornc.setVisible(false);
            dpDataCompra.setVisible(false);
            //dpDataVenc.setVisible(false);
            cbProdVenda.setVisible(false);
            tfPrecoCompra.setVisible(false);
            tfQtdeCompra.setVisible(false);
            carregarBotoesPrincipais();

        } else {
            esconderTodosLabels();
        }
    }

    public void selecionarItemTableProdutos(ItemVenda it) {
        if (lbFuncao1.getText().equals("Listar Itens")) {
            if (it != null) {
                mostrarTodosLabels();
                Format formatter = new SimpleDateFormat("dd/MM/yyyy");
                if (venda.getId() != null) {
                    lbFuncao1.setText("Detalhes da Compra" + venda.getId());
                    lbData1.setText(formatter.format(venda.getData()));
                    //lbVenc1.setText(formatter.format(compra.getDataVencimento()));
                    lbFuncionario1.setText(func.getNome());
                    lbStatus1.setText(String.valueOf(venda.getStatus()));
                    lbTotal1.setText(String.valueOf(venda.getTotal()));
                }
                lbNomeProd1.setVisible(true);
                lbEntrega.setVisible(true);
                lbEntrega1.setVisible(true);
                lbEntrega1.setText(it.getVenda().getBairro().getNome());
                lbNomeProd1.setText(it.getProduto().getNome());
                lbPreco1.setText(String.valueOf(it.getProduto().getPrecoVenda()));
                lbQtde1.setText(String.valueOf(it.getQuantidadeVenda()));
                //lb.setText(it.getProduto().getNome());
                lbInserir.setVisible(false);
                lbRemover.setVisible(false);
                cbFornc.setVisible(false);
                dpDataCompra.setVisible(false);
                //dpDataVenc.setVisible(false);
                cbProdVenda.setVisible(false);
                tfPrecoCompra.setVisible(false);
                tfQtdeCompra.setVisible(false);
                btAdicionar.setVisible(true);
                btRemover.setVisible(true);
                btCancelar.setVisible(false);
                btConfirmar.setVisible(false);
            }
        } else {
            lbFuncao1.setVisible(true);
            lbFuncao1.setText("Inserir Compra");
            //carregarComboBoxFornecedor();
            tvListCompras.setVisible(false);
            tvListProd.setVisible(true);
            mostrarLabelsTitulo();
            cbFornc.setVisible(true);
            carregarComboBoxCliente();
            dpDataCompra.setVisible(true);
            //dpDataVenc.setVisible(true);
            cbProdVenda.setVisible(true);
            carregarComboBoxProduto();
            lbEntrega.setVisible(true);
            lbEntrega1.setVisible(false);
            rbCliente.setVisible(true);
            rbLocal.setVisible(true);
            tfPrecoCompra.setVisible(true);
            tfQtdeCompra.setVisible(true);
            btAdicionar.setVisible(true);
            btConfirmar.setVisible(true);
            btCancelar.setVisible(true);
            btRemover.setVisible(true);
            btnInserir.setVisible(false);
            btnListar.setVisible(false);
            btnRemover.setVisible(false);
            btnCancelar.setVisible(false);
            btnDetalhar.setVisible(false);
            //compra = new Compra();
            lbFuncionario1.setVisible(true);
            lbFuncionario1.setText(func.getNome());
            lbStatus1.setVisible(true);
            lbStatus1.setText("1");
        }

    }

    public String verificarStatus(String s) {
        if ("1".equals(s)) {
            return "Pago";
        } else {
            return "A Pagar";
        }
    }

    public void carregarComboBoxCliente() {
        listCliente = cliService.findAll();
        observableListCliente = FXCollections.observableArrayList(listCliente);
        cbFornc.setItems(observableListCliente);
    }

    public void carregarComboBoxProduto() {
        listItensCb = prodService.findAll();
        observableListItensCb = FXCollections.observableArrayList(listItensCb);
        cbProdVenda.setItems(observableListItensCb);
    }

    public void esconderTodosLabels() {
        lbData.setVisible(false);
        lbData1.setVisible(false);
        lbFuncao1.setVisible(false);
        lbFuncionario.setVisible(false);
        lbFuncionario1.setVisible(false);
        lbNomeCliente.setVisible(false);
        lbNomeProd1.setVisible(false);
        lbInserir.setVisible(false);
        lbPreco.setVisible(false);
        lbPreco1.setVisible(false);
        lbEntrega.setVisible(false);
        rbCliente.setVisible(false);
        rbLocal.setVisible(false);
        //lbPreco1.setVisible(false);
        lbNum.setVisible(false);
        lbNum1.setVisible(false);
        lbRua.setVisible(false);
        lbRua1.setVisible(false);
        tfNum.setVisible(false);
        tfRua.setVisible(false);
        lbProd.setVisible(false);
        lbQtde.setVisible(false);
        lbRemover.setVisible(false);
        lbTotal.setVisible(false);
        lbTotal1.setVisible(false);
        //lbVenc.setVisible(false);
        lbVenc1.setVisible(false);
        cbFornc.setVisible(false);
        dpDataCompra.setVisible(false);
        //dpDataVenc.setVisible(false);
        cbProdVenda.setVisible(false);
        tfPrecoCompra.setVisible(false);
        tfQtdeCompra.setVisible(false);
        btAdicionar.setVisible(false);
        btRemover.setVisible(false);
        btConfirmar.setVisible(false);
        btCancelar.setVisible(false);
        lbStatus.setVisible(false);
        lbStatus1.setVisible(false);
        lbQtde1.setVisible(false);
    }

    public void esconderLabels() {
        lbData.setVisible(true);
        lbData1.setVisible(false);
        lbFuncao1.setVisible(true);
        lbFuncionario.setVisible(true);
        lbFuncionario1.setVisible(false);
        lbNomeCliente.setVisible(true);
        lbNomeProd1.setVisible(false);
        lbInserir.setVisible(true);
        lbPreco.setVisible(true);
        lbPreco1.setVisible(false);
        //lbPrecoCompra1.setVisible(false);
        lbProd.setVisible(true);
        lbQtde.setVisible(true);
        lbRemover.setVisible(true);
        lbTotal.setVisible(true);
        lbTotal1.setVisible(false);
        //lbVenc.setVisible(true);
        lbVenc1.setVisible(false);
    }

    public void mostrarTodosLabels() {
        lbData.setVisible(true);
        lbData1.setVisible(true);
        lbFuncao1.setVisible(true);
        lbFuncionario.setVisible(true);
        lbFuncionario1.setVisible(true);
        lbNomeCliente.setVisible(true);
        lbNomeProd1.setVisible(true);
        lbInserir.setVisible(true);
        lbPreco.setVisible(true);
        lbPreco1.setVisible(true);
        //lbPrecoCompra1.setVisible(true);
        lbProd.setVisible(true);
        lbQtde.setVisible(true);
        lbRemover.setVisible(true);
        lbTotal.setVisible(true);
        lbTotal1.setVisible(true);
        lbEntrega.setVisible(true);
        lbStatus.setVisible(true);
        lbStatus1.setVisible(true);
        lbVenc1.setVisible(true);
        //lbPrecoCompra1.setVisible(true);

        cbFornc.setVisible(false);
        dpDataCompra.setVisible(false);
        //dpDataVenc.setVisible(false);
        cbProdVenda.setVisible(false);
        tfPrecoCompra.setVisible(false);
        tfQtdeCompra.setVisible(false);
        btAdicionar.setVisible(false);
        btRemover.setVisible(false);

    }

    public void mostrarLabelsTitulo() {
        lbNum.setVisible(true);
        lbRua.setVisible(true);
        lbData.setVisible(true);
        lbData1.setVisible(false);
        lbFuncao1.setVisible(true);
        lbFuncionario.setVisible(true);
        lbFuncionario1.setVisible(false);
        lbNomeCliente.setVisible(true);
        lbNomeProd1.setVisible(false);
        lbInserir.setVisible(true);
        lbPreco.setVisible(true);
        lbPreco1.setVisible(false);
        lbEntrega.setVisible(true);
        //lbPrecoCompra1.setVisible(false);
        lbProd.setVisible(true);
        lbQtde.setVisible(true);
        lbRemover.setVisible(true);
        lbTotal.setVisible(true);
        lbTotal1.setVisible(false);
        //lbVenc.setVisible(true);
        lbVenc1.setVisible(false);
        lbStatus.setVisible(true);
        lbStatus1.setVisible(false);
    }
    public void carregarBotoesPrincipais(){
        btnCancelar.setVisible(true);
        btnDetalhar.setVisible(true);
        btnInserir.setVisible(true);
        btnListar.setVisible(true);
        btnRemover.setVisible(true);
        btAdicionar.setVisible(false);
        btCancelar.setVisible(false);
        btConfirmar.setVisible(false);
        btRemover.setVisible(false);
        
        
    }
    
    public void naoCarregarBotoes(){
        btnCancelar.setVisible(false);
        btnDetalhar.setVisible(false);
        btnInserir.setVisible(false);
        btnListar.setVisible(false);
        btnRemover.setVisible(false);
        btAdicionar.setVisible(false);
        btCancelar.setVisible(false);
        btConfirmar.setVisible(false);
        btRemover.setVisible(false);
        
        
    }

    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

}
