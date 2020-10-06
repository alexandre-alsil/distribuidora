package edu.ifes.ci.si.les.sdb.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.ifes.ci.si.les.sdb.model.Funcionario;
import edu.ifes.ci.si.les.sdb.service.FuncionarioService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Alexandre
 */
public class FXMLVBoxMainController implements Initializable {

    @FXML
    private AnchorPane APPrincipal;
    @FXML
    private MenuItem MIUf;
    @FXML
    private MenuItem MICidade;
    @FXML
    private MenuItem MIBairro;
    @FXML
    private MenuItem MICliente;
    @FXML
    private MenuItem MIFornecedor;
    @FXML
    private MenuItem MIFuncionario;
    @FXML
    private MenuItem MIProduto;
    @FXML
    private MenuItem MICompraI;
    @FXML
    private MenuItem MIVendaI;
    @FXML
    private MenuItem MISair;
    @FXML
    private Label lbCodUsu;
    @FXML
    private Label lbCodUsu1;

    private Integer i;
    private Funcionario func;
    private Funcionario logado;
    private final FuncionarioService funcService = new FuncionarioService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        System.out.println("logado vbox: " + i);
        //verificarPermissao();

        //setarCodUsu();
        //lbCodUsu1.setText(String.valueOf(func.getId()));

    }

    @FXML
    public void handleMenuItemCadastrosUfs() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroUF.fxml"));
        APPrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadastroCidade() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroCidade.fxml"));
        APPrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadastroBairro() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroBairro.fxml"));
        APPrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadastroCliente() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLCadastroClienteController.class.getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroCliente.fxml"));
        AnchorPane a = (AnchorPane) loader.load();
        FXMLCadastroClienteController controller = loader.getController();
        controller.setId(logado.getId());
        APPrincipal.getChildren().setAll(a);

    }

    @FXML
    public void handleMenuItemCadastroFuncionario() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroFuncionario.fxml"));
        APPrincipal.getChildren().setAll(a);
    }

    @FXML
    public void handleMenuItemCadastroFornecedor() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLCadastroFornecedorController.class.getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroFornecedor.fxml"));
        AnchorPane a = (AnchorPane) loader.load();
        FXMLCadastroFornecedorController controller = loader.getController();
        controller.setId(logado.getId());
        APPrincipal.getChildren().setAll(a);

    }

    @FXML
    public void handleMenuItemCadastroProduto() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLCadastroProdutoController.class.getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroProduto.fxml"));
        AnchorPane a = (AnchorPane) loader.load();
        FXMLCadastroProdutoController controller = loader.getController();
        controller.setId(logado.getId());
        APPrincipal.getChildren().setAll(a);

    }

    @FXML
    private void handleMenuItemCompras(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLCadastroComprasController.class.getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroCompras.fxml"));
        AnchorPane a = (AnchorPane) loader.load();
        FXMLCadastroComprasController controller = loader.getController();
        controller.setFunc(logado);
        APPrincipal.getChildren().setAll(a);

    }

    @FXML
    private void handleMenuItemSair(ActionEvent event) {
        System.out.println("quem está logado? " + logado.getId());
    }

    @FXML
    private void handleMenuItemVendas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLCadastroVendasController.class.getResource("/edu/ifes/ci/si/les/sdb/view/FXMLCadastroVendas.fxml"));
        AnchorPane a = (AnchorPane) loader.load();
        FXMLCadastroVendasController controller = loader.getController();
        controller.setFunc(logado);
        APPrincipal.getChildren().setAll(a);
        
    }

    public void verificarPermissao(int i) {
        //System.out.println("teste id: "+logado.getId());

        func = funcService.find(i);
        if (func.getTipo() == 1) {
            MIFornecedor.setVisible(true);
            MIFuncionario.setVisible(true);
            MIProduto.setVisible(true);
            MICompraI.setVisible(true);

        } else {
            MIFornecedor.setVisible(false);
            MIFuncionario.setVisible(false);
            MIProduto.setVisible(false);
            MICompraI.setVisible(false);
        }
    }

    public void setarCodUsu() {
        
        lbCodUsu1.setText(String.valueOf(func.getId()));
    }

    public Funcionario getLogado() {
        i = Integer.parseInt(lbCodUsu1.getText());
        //logado.getId()= logado;
        return logado;
    }

    public void setLogado(Funcionario logado) {
        this.logado = logado;
        System.out.println("logado2: "+logado);
    
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
        System.out.println("iiiiiiiiiiiiiiiiiiiiiiii = " + i);
        lbCodUsu1.setText(String.valueOf(i));
        verificarPermissao(i);
        
    }

}
