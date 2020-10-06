/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifes.ci.si.les.sdb.controller;

import edu.ifes.ci.si.les.sdb.model.Compra;
import edu.ifes.ci.si.les.sdb.model.Fornecedor;
import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.model.ItemCompra;
import edu.ifes.ci.si.les.sdb.model.Produto;
import edu.ifes.ci.si.les.sdb.service.CompraService;
import edu.ifes.ci.si.les.sdb.service.FornecedorService;
import edu.ifes.ci.si.les.sdb.service.ItensService;
import edu.ifes.ci.si.les.sdb.service.ProdutoService;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class FXMLCadastroComprasController implements Initializable {

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
    private Label lbPrecoCompra1;
    @FXML
    private Label lbVenc1;
    @FXML
    private Label lbVenc;
    @FXML
    private Label lbNomeProd1;
    @FXML
    private Label lbData1;
    @FXML
    private Label lbData;
    @FXML
    private Label lbNomeForn;
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
    private ComboBox<Fornecedor> cbFornc;
    @FXML
    private DatePicker dpDataCompra;
    @FXML
    private Label lbProd;
    @FXML
    private Label lbPreco;
    @FXML
    private Label lbPreco1;
    @FXML
    private Label lbQtde;
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
    private TableView<Compra> tvListCompras;
    @FXML
    private TableColumn<Compra, String> tcForn;
    @FXML
    private TableColumn<Compra, Date> tcData;
    @FXML
    private TableColumn<Compra, Double> tcTotal;
    @FXML
    private TableView<ItemCompra> tvListProd;
    @FXML
    private TableColumn<Produto, String> tcProd;
    @FXML
    private TableColumn<Produto, Double> tcPreco;
    @FXML
    private TableColumn<Produto, Integer> tcQtde;
    @FXML
    private TableColumn<Double, Double> tcSubTotal;
    @FXML
    private DatePicker dpDataVenc;
    @FXML
    private ComboBox<Produto> cbProdCompra;
    @FXML
    private TextField tfPrecoCompra;
    @FXML
    private TextField tfQtdeCompra;
    @FXML
    private Label lbStatus;
    @FXML
    private Label lbStatus1;

    private Funcionario func;
    boolean b;
    private List<Fornecedor> listForn;
    private List<Compra> listCompra;
    private List<ItemCompra> listItens;
    private List<ItemCompra> listItensRemover;
    private List<Produto> listItensCb;

    private ObservableList<Fornecedor> observableListForn;
    private ObservableList<Compra> observableListCompra;
    private ObservableList<ItemCompra> observableListItens;
    private ObservableList<Produto> observableListItensCb;

    private final FornecedorService fornService = new FornecedorService();
    private final CompraService compraService = new CompraService();
    private final ProdutoService prodService = new ProdutoService();
    private final ItensService itCompraService = new ItensService();
    
    private Compra compra;
    @FXML
    private Label lbQtde1;

    //private final Format formatter = new SimpleDateFormat("dd/MM/yyyy");   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        carregarTableViewCompras();

        // Limpando a exibição dos detalhes do cliente
        selecionarItemTableViewCompras(null);

        // Listen acionado diante de quaisquer alterações na seleção de itens do TableView
        tvListCompras.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewCompras(newValue));

        tvListProd.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableProdutos(newValue));

    }

    @FXML
    private void handleButtonConfirmar(ActionEvent event) {
        //Compra compra = new Compra();
        b = validarEntradaDeDados(); //dialogStage.close();
        //b = true;
        if (b && "Inserir Compra".equals(lbFuncao1.getText())) {
            //uf.setId(3);
            //Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            compra.setFornecedor(cbFornc.getValue());
            compra.setData(java.sql.Date.valueOf(dpDataCompra.getValue().plusDays(1)));

            compra.setDataVencimento(java.sql.Date.valueOf(dpDataVenc.getValue().plusDays(1)));
            compra.setFuncionario(func);
            //compra.setStatus(1);

            //compra.setItemCompra(listItens);
            for (ItemCompra it : compra.getItemCompra()) {
                for (Produto p : listItensCb) {
                    if (Objects.equals(it.getProduto().getId(), p.getId())) {
                        p.setEstoque(p.getEstoque() + it.getQuantidadeCompra());
                        //listForn.add(compra.getFornecedor());
                        //compra.getFornecedor();
                        //p.setFornecedor(compra.getFornecedor());
                        //fazer uma variavel receber string
                        //compra.setTotal(Double.valueOf(String.format("%.2f", lbTotal1.getText())));
                        compra.setTotal(Double.valueOf(lbTotal1.getText()));
                        if (!p.getFornecedor().contains(compra.getFornecedor())) {
                            p.getFornecedor().add(compra.getFornecedor());
                        }
                        p.setPrecoCompra(it.getProduto().getPrecoCompra());
                        prodService.update(p);
                        System.out.println("fiz uppppppppppppp" + p);
                    }
                }
            }
            compra.setStatus(Integer.parseInt(lbStatus1.getText()));
            compra.setFormaPagamento(1);
            //String.format("%.2f", compra.getTotal())
            //compra.setTotal(Double.valueOf(lbTotal1.getText()));
            //compra.setTotal(Double.valueOf(String.format("%.2f", lbTotal1.getText())));
            compraService.insert(compra);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Compra inserida com sucesso");
            alert.show();

            carregarTableViewCompras();
            btnCancelar.setVisible(true);
            btnDetalhar.setVisible(true);
            btnInserir.setVisible(true);
            btnListar.setVisible(true);
            btnRemover.setVisible(true);

        }
    }
    
     @FXML
    private void handleButtonRemoverCompra(ActionEvent event) {
        //Compra compra = new Compra();
        //b = validarEntradaDeDados(); //dialogStage.close();
        Compra c = tvListCompras.getSelectionModel().getSelectedItem();
        if (c!=null) {
            //uf.setId(3);
            //Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            Compra co = compraService.find(c.getId());
            System.out.println("Compra ID: "+co.getId());
            //observableListItens.addAll(co.getItemCompra());
            listItensCb = prodService.findAll();
            //listItensRemover = itCompraService.findAll();
            //for()
            //listItensCb.addAll(listItens.containsAll(listItensCb));
            
            //compra.setData(java.sql.Date.valueOf(dpDataCompra.getValue().plusDays(1)));

            //compra.setDataVencimento(java.sql.Date.valueOf(dpDataVenc.getValue().plusDays(1)));
            //compra.setFuncionario(func);
            //compra.setStatus(1);

            //compra.setItemCompra(listItens);
            for (ItemCompra it : co.getItemCompra()) {
                //System.out.println("item compra"+it.getProduto().getNome());
                for (Produto p : listItensCb) {
                    //System.out.println("Produto ID: "+p.getId());
                    if (Objects.equals(it.getProduto().getId(), p.getId())) {
                        p.setEstoque(p.getEstoque() - it.getQuantidadeCompra());
                        //listForn.add(compra.getFornecedor());
                        //compra.getFornecedor();
                        //p.setFornecedor(compra.getFornecedor());
                        //fazer uma variavel receber string
                        //compra.setTotal(Double.valueOf(String.format("%.2f", lbTotal1.getText())));
                        //c.setTotal(Double.valueOf(lbTotal1.getText()));
                        if (p.getFornecedor().contains(co.getFornecedor())) {
                            p.getFornecedor().remove(co.getFornecedor());
                            
                        }
                        //p.setPrecoCompra(it.getProduto().getPrecoCompra());
                        prodService.update(p);
                        //System.out.println("fiz uppppppppppppp" + p);
                    }
                
                }
                //c.getItemCompra().remove(co);
            }
            //compra.setStatus(Integer.parseInt("0"));
            //compra.setFormaPagamento(0);
            //String.format("%.2f", compra.getTotal())
            //compra.setTotal(Double.valueOf(lbTotal1.getText()));
            //compra.setTotal(Double.valueOf(String.format("%.2f", lbTotal1.getText())));
            compraService.delete(c.getId());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Compra deletada com sucesso");
            alert.show();

            carregarTableViewCompras();
            btnCancelar.setVisible(true);
            btnDetalhar.setVisible(true);
            btnInserir.setVisible(true);
            btnListar.setVisible(true);
            btnRemover.setVisible(true);

        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Selecione uma Compra para Deletar");
            alert.show();
        }
    }

    @FXML
    private void handleButtonCancelar(ActionEvent event) {
        lbFuncao1.setVisible(true);
        lbFuncao1.setText("Listar Compras");
        carregarTableViewCompras();
    }

    @FXML
    private void handleButtonListar(ActionEvent event) {
        lbFuncao1.setVisible(true);
        lbFuncao1.setText("Listar Compras");
        carregarTableViewCompras();
    }

    @FXML
    private void handleButtonRemover(ActionEvent event) {
        Produto p;
        if (compra.getItemCompra().isEmpty()) {
            System.out.println("Compra = nulooooooooo");
        }
        //ItemCompra itComp = tvListProd.getSelectionModel().getSelectedItem();
        if (tvListProd.getSelectionModel().getSelectedItem() != null) {
            //p = cbProdCompra.getSelectionModel().getSelectedItem();

            ItemCompra itComp = tvListProd.getSelectionModel().getSelectedItem();
            System.out.println("Item Compraaaaaa: ");
            p = itComp.getProduto();
            observableListItensCb.add(p);
            compra.getItemCompra().remove(itComp);
            /*itComp.setCompra(null);
            compra.getItemCompra().remove(itComp);
            
            compra.setItemCompra(listItens);
            */
            observableListItens.remove(itComp);
            if (compra.getTotal() > 0.0) {
                compra.setTotal(compra.getTotal() - itComp.getSubTotal());          
                //carregarComboBoxProduto();
                //carregarTableViewItens(compra);
            } else {
                compra.setTotal(itComp.getSubTotal());
            }

            
            tvListProd.setItems(observableListItens);
            lbTotal1.setVisible(true);
            lbTotal1.setText(String.valueOf(compra.getTotal()));
            //lbFuncao1.setVisible(true);
            //lbFuncao1.setText("Inserir Compra");
            /*
            lbFuncao1.setVisible(true);
        lbFuncao1.setText("Inserir Compra");
        carregarComboBoxFornecedor();
        tvListCompras.setVisible(false);
        tvListProd.setVisible(true);
        mostrarLabelsTitulo();
        cbFornc.setVisible(true);
        carregarComboBoxFornecedor();
        dpDataCompra.setVisible(true);
        dpDataVenc.setVisible(true);
        cbProdCompra.setVisible(true);
        carregarComboBoxProduto();
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
        compra = new Compra();
        lbFuncionario1.setVisible(true);
        lbFuncionario1.setText(func.getNome());
        lbStatus1.setVisible(true);
        lbStatus1.setText("1");
            */
            /*tvListCompras.setVisible(false);
            tvListProd.setVisible(true);
            //mostrarLabelsTitulo();
            //mostrarTodosLabels();
            cbFornc.setVisible(true);
            carregarComboBoxFornecedor();
            //carregarTableViewItens(compra);
            carregarComboBoxProduto();
            cbFornc.setVisible(true);
            dpDataCompra.setVisible(true);
            cbProdCompra.setVisible(true);
            dpDataVenc.setVisible(true);
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
            lbStatus1.setText("1");*/
        }

        carregarTableViewItens(compra);
    }

    @FXML
    private void handleButtonCancelarAP(ActionEvent event) {
        apPrincipal.getChildren().clear();
    }

    @FXML
    private void handleButtonInserir(ActionEvent event) {
        lbFuncao1.setVisible(true);
        lbFuncao1.setText("Inserir Compra");
        //carregarComboBoxFornecedor();
        tvListCompras.setVisible(false);
        tvListProd.setVisible(true);
        mostrarLabelsTitulo();
        cbFornc.setVisible(true);
        carregarComboBoxFornecedor();
        dpDataCompra.setVisible(true);
        dpDataVenc.setVisible(true);
        cbProdCompra.setVisible(true);
        carregarComboBoxProduto();
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
        compra = new Compra();
        lbFuncionario1.setVisible(true);
        lbFuncionario1.setText(func.getNome());
        lbStatus1.setVisible(true);
        lbStatus1.setText("1");

    }

    @FXML
    private void handleButtonAdicionar(ActionEvent event) {
        Produto p;
        if (compra == null) {
            compra = new Compra();
        }
        ItemCompra itComp = new ItemCompra();
        if (cbProdCompra.getSelectionModel().getSelectedItem() != null) {
            p = cbProdCompra.getSelectionModel().getSelectedItem();

            if (p.getEstoque() > 0) {
                p.setPrecoCompra(Double.valueOf(tfPrecoCompra.getText()));
                itComp.setProduto(p);
                itComp.setQuantidadeCompra(Integer.parseInt(tfQtdeCompra.getText()));
                itComp.setSubTotal(p.getPrecoCompra() * (Integer.parseInt(tfQtdeCompra.getText())));
                //itComp.setCompra(compra);
                compra.getItemCompra().add(itComp);
                //listItens.add(itComp);
                if (compra.getTotal() != null) {
                    compra.setTotal(compra.getTotal() + itComp.getSubTotal());
                } else {
                    compra.setTotal(itComp.getSubTotal());
                }
                observableListItensCb.remove(p);
                //carregarComboBoxProduto();
                observableListItens = FXCollections.observableArrayList(compra.getItemCompra());
                tvListProd.setItems(observableListItens);
                lbTotal1.setVisible(true);
                lbTotal1.setText(String.valueOf(compra.getTotal()));
            }
        }

        carregarTableViewItens(compra);
    }

    @FXML
    private void handleButtonDetalhar(ActionEvent event) {
        lbFuncao1.setText("Listar Itens");
        tvListCompras.setVisible(false);
        tvListProd.setVisible(true);
        compra = tvListCompras.getSelectionModel().getSelectedItem();
        carregarTableViewItens(compra);

    }

    public void carregarComboBoxProduto() {
        listItensCb = prodService.findAll();
        observableListItensCb = FXCollections.observableArrayList(listItensCb);
        cbProdCompra.setItems(observableListItensCb);
    }

    public void carregarComboBoxFornecedor() {
        listForn = fornService.findAll();
        observableListForn = FXCollections.observableArrayList(listForn);
        cbFornc.setItems(observableListForn);
    }

    public void carregarTableViewCompras() {
        tvListCompras.setVisible(true);
        tcForn.setCellValueFactory(new PropertyValueFactory<>("fornecedor"));
        tcData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tcTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        listCompra = compraService.findAll();
        observableListCompra = FXCollections.observableArrayList(listCompra);
        tvListCompras.setItems(observableListCompra);
        tvListProd.setVisible(false);
        esconderTodosLabels();

    }

    public void selecionarItemTableViewCompras(Compra compra) {
        if (compra != null) {
            Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            lbFuncao1.setVisible(true);
            lbFuncao1.setText("Listar Compras");
            lbData.setVisible(true);
            lbData1.setVisible(true);
            lbData1.setText(formatter.format(compra.getData()));
            //lbFuncao1.setVisible(true);
            lbVenc.setVisible(true);
            lbVenc1.setVisible(true);
            lbVenc1.setText(formatter.format(compra.getDataVencimento()));
            lbFuncionario.setVisible(true);
            lbFuncionario1.setVisible(true);
            lbFuncionario1.setText(compra.getFuncionario().getNome());
            lbNomeForn.setVisible(true);
            lbNomeProd1.setVisible(true);
            lbNomeProd1.setText(compra.getFornecedor().getNome());
            lbInserir.setVisible(false);
            lbPreco.setVisible(false);
            lbPreco1.setVisible(false);
            lbPrecoCompra1.setVisible(false);

            lbProd.setVisible(false);
            lbQtde.setVisible(false);
            lbRemover.setVisible(false);
            lbTotal.setVisible(true);
            lbTotal1.setVisible(true);
            lbTotal1.setText(String.format("%.2f", compra.getTotal())); //como fazer pra pegar dois dígitos no tv
            lbVenc.setVisible(true);
            lbStatus.setVisible(true);
            lbStatus1.setVisible(true);
            lbStatus1.setText(verificarStatus(compra.getStatus().toString()));
            cbFornc.setVisible(false);
            dpDataCompra.setVisible(false);
            dpDataVenc.setVisible(false);
            cbProdCompra.setVisible(false);
            tfPrecoCompra.setVisible(false);
            tfQtdeCompra.setVisible(false);
            btAdicionar.setVisible(false);
            btRemover.setVisible(false);
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);

        } else {
            esconderTodosLabels();
        }
    }

    public void selecionarItemTableProdutos(ItemCompra it) {
        if(lbFuncao1.getText().equals("Listar Itens")){
        if (it != null) {
            mostrarTodosLabels();
            Format formatter = new SimpleDateFormat("dd/MM/yyyy");
            if (compra.getId() != null) {
                lbFuncao1.setText("Detalhes da Compra" + compra.getId());
                lbData1.setText(formatter.format(compra.getData()));
                lbVenc1.setText(formatter.format(compra.getDataVencimento()));
                lbFuncionario1.setText(func.getNome());
                lbStatus1.setText(String.valueOf(compra.getStatus()));
                lbTotal1.setText(String.valueOf(compra.getTotal()));
            }
            lbNomeProd1.setVisible(true);
            lbNomeProd1.setText(it.getProduto().getNome());
            lbPreco1.setText(String.valueOf(it.getProduto().getPrecoCompra()));
            lbQtde1.setText(String.valueOf(it.getQuantidadeCompra()));
            lbPrecoCompra1.setText(it.getProduto().getNome());
            lbInserir.setVisible(false);
            lbRemover.setVisible(false);
            cbFornc.setVisible(false);
            dpDataCompra.setVisible(false);
            dpDataVenc.setVisible(false);
            cbProdCompra.setVisible(false);
            tfPrecoCompra.setVisible(false);
            tfQtdeCompra.setVisible(false);
            btAdicionar.setVisible(true);
            btRemover.setVisible(true);
            btCancelar.setVisible(false);
            btConfirmar.setVisible(false);
        }
        }
        else{
            lbFuncao1.setVisible(true);
        lbFuncao1.setText("Inserir Compra");
        //carregarComboBoxFornecedor();
        tvListCompras.setVisible(false);
        tvListProd.setVisible(true);
        mostrarLabelsTitulo();
        cbFornc.setVisible(true);
        carregarComboBoxFornecedor();
        dpDataCompra.setVisible(true);
        dpDataVenc.setVisible(true);
        cbProdCompra.setVisible(true);
        carregarComboBoxProduto();
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

    public void carregarTableViewItens(Compra compra) {

        tvListCompras.setVisible(false);
        tvListProd.setVisible(true);

        tcProd.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tcPreco.setCellValueFactory(new PropertyValueFactory<>("precoCompra"));
        tcQtde.setCellValueFactory(new PropertyValueFactory<>("quantidadeCompra"));
        tcSubTotal.setCellValueFactory(new PropertyValueFactory<>("subTotal"));
        listCompra = compraService.findAll();
        observableListItens = FXCollections.observableArrayList(compra.getItemCompra());
        tvListProd.setItems(observableListItens);
        //tvListProd.setVisible(false);
        //esconderTodosLabels();

    }

    public String verificarStatus(String s) {
        if ("1".equals(s)) {
            return "Pago";
        } else {
            return "A Pagar";
        }
    }

    public void mostrarTodosLabels() {
        lbData.setVisible(true);
        lbData1.setVisible(true);
        lbFuncao1.setVisible(true);
        lbFuncionario.setVisible(true);
        lbFuncionario1.setVisible(true);
        lbNomeForn.setVisible(true);
        lbNomeProd1.setVisible(true);
        lbInserir.setVisible(true);
        lbPreco.setVisible(true);
        lbPreco1.setVisible(true);
        lbPrecoCompra1.setVisible(true);
        lbProd.setVisible(true);
        lbQtde.setVisible(true);
        lbRemover.setVisible(true);
        lbTotal.setVisible(true);
        lbTotal1.setVisible(true);
        lbVenc.setVisible(true);
        lbStatus.setVisible(true);
        lbStatus1.setVisible(true);
        lbVenc1.setVisible(true);
        lbPrecoCompra1.setVisible(true);

        cbFornc.setVisible(false);
        dpDataCompra.setVisible(false);
        dpDataVenc.setVisible(false);
        cbProdCompra.setVisible(false);
        tfPrecoCompra.setVisible(false);
        tfQtdeCompra.setVisible(false);
        btAdicionar.setVisible(false);
        btRemover.setVisible(false);

    }

    public void mostrarLabelsTitulo() {
        lbData.setVisible(true);
        lbData1.setVisible(false);
        lbFuncao1.setVisible(true);
        lbFuncionario.setVisible(true);
        lbFuncionario1.setVisible(false);
        lbNomeForn.setVisible(true);
        lbNomeProd1.setVisible(false);
        lbInserir.setVisible(true);
        lbPreco.setVisible(true);
        lbPreco1.setVisible(false);
        lbPrecoCompra1.setVisible(false);
        lbProd.setVisible(true);
        lbQtde.setVisible(true);
        lbRemover.setVisible(true);
        lbTotal.setVisible(true);
        lbTotal1.setVisible(false);
        lbVenc.setVisible(true);
        lbVenc1.setVisible(false);
        lbStatus.setVisible(true);
        lbStatus1.setVisible(false);
    }

    public void esconderLabels() {
        lbData.setVisible(true);
        lbData1.setVisible(false);
        lbFuncao1.setVisible(true);
        lbFuncionario.setVisible(true);
        lbFuncionario1.setVisible(false);
        lbNomeForn.setVisible(true);
        lbNomeProd1.setVisible(false);
        lbInserir.setVisible(true);
        lbPreco.setVisible(true);
        lbPreco1.setVisible(false);
        lbPrecoCompra1.setVisible(false);
        lbProd.setVisible(true);
        lbQtde.setVisible(true);
        lbRemover.setVisible(true);
        lbTotal.setVisible(true);
        lbTotal1.setVisible(false);
        lbVenc.setVisible(true);
        lbVenc1.setVisible(false);
    }

    public void esconderTodosLabels() {
        lbData.setVisible(false);
        lbData1.setVisible(false);
        lbFuncao1.setVisible(false);
        lbFuncionario.setVisible(false);
        lbFuncionario1.setVisible(false);
        lbNomeForn.setVisible(false);
        lbNomeProd1.setVisible(false);
        lbInserir.setVisible(false);
        lbPreco.setVisible(false);
        lbPreco1.setVisible(false);
        lbPrecoCompra1.setVisible(false);
        lbProd.setVisible(false);
        lbQtde.setVisible(false);
        lbRemover.setVisible(false);
        lbTotal.setVisible(false);
        lbTotal1.setVisible(false);
        lbVenc.setVisible(false);
        lbVenc1.setVisible(false);
        cbFornc.setVisible(false);
        dpDataCompra.setVisible(false);
        dpDataVenc.setVisible(false);
        cbProdCompra.setVisible(false);
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

    private boolean validarEntradaDeDados() {
        String errorMessage = "";

         if (cbFornc.getValue() == null || cbFornc.toString().equals(0)) {
            errorMessage += "Combobox Fornecedor inválido!\n";
        }
         
         if (dpDataCompra.getValue() == null || dpDataCompra.toString().equals(0)) {
            errorMessage += "Data Compra inválido!\n";
        }
        
         if (dpDataVenc.getValue() == null || dpDataVenc.toString().equals(0)) {
            errorMessage += "Data Vencimento inválido!\n";
        }
         
         if (cbProdCompra.getValue() == null || cbProdCompra.toString().equals(0)) {
            errorMessage += "Combobox Produto inválido!\n";
        }
         
        if (tfPrecoCompra.getText() == null || tfPrecoCompra.getText().length() == 0) {
            errorMessage += "Preço Compra inválido!\n";
        }
        
        if (tfQtdeCompra.getText() == null || tfQtdeCompra.getText().length() == 0) {
            errorMessage += "Quantidade Compra inválido!\n";
        }
        
        if (tvListProd.getItems().isEmpty()) {
            errorMessage += "Compra sem Itens!\n";
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

    
    public Funcionario getFunc() {
        return func;
    }

    public void setFunc(Funcionario func) {
        this.func = func;
    }

   

}
