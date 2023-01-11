package br.gov.sp.procon.controller;

import br.gov.sp.procon.dao.UsuarioDAO;
import br.gov.sp.procon.model.Usuario;

import br.gov.sp.procon.view.TelaCadastroUsuarios;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class UsuarioController implements Initializable {

    @FXML public TextField txtPesquisar;
    @FXML public Button btnNovoUsuario;
    @FXML public TableView<Usuario> tblUsuarios;
    @FXML public TableColumn<Usuario, Integer> colunaID;
    @FXML public TableColumn<Usuario, String> colunaUsuario;
    @FXML public TableColumn<Usuario, String> colunaNome;
    @FXML public TableColumn<Usuario, String> colunaEmail;
    @FXML public TableColumn<Usuario, Integer> colunaEditar;
    @FXML public TableColumn<Usuario, Integer> colunaExcluir;

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    static Usuario usr = null;
    static Window window;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaUsuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        adicionarBotaoEditar();
        adicionarBotaoExcluir();
        colunaEditar.setStyle("-fx-alignment: CENTER");
        colunaExcluir.setStyle("-fx-alignment: CENTER");
        try {
            atualizarTabela();
        } catch (SQLException ex){
            ex.printStackTrace();
            ex.getCause();
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void adicionarBotaoEditar() {
        Callback<TableColumn<Usuario, Integer>, TableCell<Usuario, Integer>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Usuario, Integer> call(final TableColumn<Usuario, Integer> param) {
                return new TableCell<>() {
                    private void handle(ActionEvent event) {
                        usr = getTableView().getItems().get(getIndex());
                        CadastroUsuarioController cadastroUsuarioController = new CadastroUsuarioController();
                        try {
                            cadastroUsuarioController.editarUsuario();
                        } catch (Exception e) {
                            e.printStackTrace();
                            e.getCause();
                            throw new RuntimeException(e.getMessage());
                        }
                    }

                    private final Button btnEditar = new Button("Editar");

                    {
                        btnEditar.setOnAction(this::handle);
                    }

                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btnEditar.setText("Editar");
                            btnEditar.setCursor(Cursor.HAND);
                            btnEditar.setBackground(Background.fill(Color.rgb(255, 140, 0)));
                            btnEditar.setStyle("-fx-text-fill: #FFFFFF");
                            setGraphic(btnEditar);
                        }
                    }
                };
            }
        };
        colunaEditar.setCellFactory(cellFactory);
    }

    public void adicionarBotaoExcluir() {
        Callback<TableColumn<Usuario, Integer>, TableCell<Usuario, Integer>> cellFactory = new Callback<>() {
            @Override
            public TableCell<Usuario, Integer> call(final TableColumn<Usuario, Integer> param) {
                return new TableCell<>() {
                    private final Button btnExcluir = new Button("Excluir");

                    {
                        btnExcluir.setOnAction((ActionEvent event) -> {
                            Usuario u = getTableView().getItems().get(getIndex());
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Exclusão");
                            alert.setHeaderText("Tem certeza que deseja excluir o usuário selecionado?");
                            alert.setContentText("Usuário: "+ u.getUsuario() + " - Nome: " + u.getNome());
                            alert.showAndWait().ifPresent(response -> {
                                if (response == ButtonType.OK) {
                                    try {
                                        usuarioDAO.remover(u);
                                        limparCampos();
                                        atualizarTabela();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                        ex.getCause();
                                        throw new RuntimeException(ex);
                                    }
                                }
                            });
                        });
                    }

                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            btnExcluir.setText("Excluir");
                            btnExcluir.setCursor(Cursor.HAND);
                            btnExcluir.setBackground(Background.fill(Color.rgb(220, 20, 60)));
                            btnExcluir.setStyle("-fx-text-fill: #FFFFFF");
                            setGraphic(btnExcluir);
                        }
                    }
                };
            }
        };
        colunaExcluir.setCellFactory(cellFactory);
    }

    public void buscarUsuario() {
        txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
            try{
                tblUsuarios.setItems(usuarioDAO.buscar(newValue));
            } catch (Exception e) {
                e.printStackTrace();
                e.getCause();
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    public void novoUsuario() throws Exception {
        usr = null;
        TelaCadastroUsuarios telaCadastroUsuarios = new TelaCadastroUsuarios();
        telaCadastroUsuarios.start(new Stage());
    }

    public void atualizarTabela() throws SQLException {
        tblUsuarios.setItems(usuarioDAO.listar());
    }

    public void limparCampos(){
        txtPesquisar.setText("");
        txtPesquisar.requestFocus();
    }

    public void focoBtnNovo(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            btnNovoUsuario.requestFocus();
        }
    }



}
