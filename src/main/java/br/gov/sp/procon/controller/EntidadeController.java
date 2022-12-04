    package br.gov.sp.procon.controller;

    import br.gov.sp.procon.model.Entidade;
    import br.gov.sp.procon.utils.ConnectionFactory;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.ActionEvent;
    import javafx.fxml.FXML;
    import javafx.fxml.Initializable;
    import javafx.scene.Cursor;
    import javafx.scene.control.*;
    import javafx.scene.control.cell.PropertyValueFactory;

    import javafx.scene.layout.Background;
    import javafx.scene.paint.Color;
    import javafx.util.Callback;
    import java.net.URL;
    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.ResourceBundle;

    public class EntidadeController implements Initializable {
        @FXML
        public Button btnCadastrar;
        @FXML
        public TextField txtEntidade;
        @FXML
        public TableView<Entidade> tblEntidades;
        @FXML
        public TableColumn<Entidade, Integer> colunaID;
        @FXML
        public TableColumn<Entidade, String> colunaNome;
        @FXML
        public TableColumn<Entidade, Integer> colunaEditar;
        @FXML
        public TableColumn<Entidade, Integer> colunaExcluir;
        public Label txtID;
        Connection conn;
        PreparedStatement stmt;
        ResultSet rs;
        String sql;
        static Entidade ent = null;

        public void adicionar(Entidade e) {
            conn = ConnectionFactory.getConnection();
            sql = "INSERT INTO ENTIDADE VALUES(?, ?)";
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(2, e.getNome());
                stmt.execute();
            } catch (SQLException ex) {
                Alert erro = new Alert(Alert.AlertType.WARNING);
                erro.setTitle("Erro");
                erro.setHeaderText("A nova entidade não foi salva porque já existe no banco de dados.\n" +
                        "O sistema não permite a existência de registros duplicados.");
                erro.setContentText("Cadastro não permitido: " + e.getNome());
                erro.showAndWait();
                txtEntidade.setText("");
                txtEntidade.requestFocus();
                throw new RuntimeException(ex);
            }
            ConnectionFactory.closeConnection(conn, stmt);
        }

        public void editar(Entidade e) {
            conn = ConnectionFactory.getConnection();
            sql = "UPDATE ENTIDADE SET NOME = ? WHERE ID = ?";
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, e.getNome());
                stmt.setInt(2, e.getId());
                stmt.execute();
            } catch (SQLException ex) {
                Alert erro = new Alert(Alert.AlertType.WARNING);
                erro.setTitle("Erro");
                erro.setHeaderText("A nova entidade não foi salva porque já existe no banco de dados.\n" +
                        "O sistema não permite a existência de registros duplicados.");
                erro.setContentText("Cadastro não permitido: " + e.getNome());
                erro.showAndWait();
                txtEntidade.setText("");
                txtEntidade.requestFocus();
                throw new RuntimeException(ex);
            }
            ConnectionFactory.closeConnection(conn, stmt);
        }

        public void remover(Entidade e) throws SQLException {
            conn = ConnectionFactory.getConnection();
            sql = "DELETE FROM ENTIDADE WHERE ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, e.getId());
            stmt.execute();
            ConnectionFactory.closeConnection(conn, stmt);
        }

        public ObservableList<Entidade> listarTodos() throws SQLException {
            conn = ConnectionFactory.getConnection();
            sql = "SELECT * FROM ENTIDADE ORDER BY ID";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Entidade> listaEntidades = new ArrayList<>();
            while (rs.next()) {
                Entidade e = new Entidade();
                e.setId(rs.getInt("ID"));
                e.setNome(rs.getString("NOME"));
                listaEntidades.add(e);
            }
            ConnectionFactory.closeConnection(conn, stmt, rs);
            return FXCollections.observableArrayList(listaEntidades);
        }


        public ObservableList<Entidade> buscar(String string) throws SQLException {
            conn = ConnectionFactory.getConnection();
            sql = "SELECT * FROM ENTIDADE WHERE NOME LIKE '%" + string + "%';";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Entidade> listaEntidades = new ArrayList<>();
            while (rs.next()) {
                Entidade e = new Entidade();
                e.setId(rs.getInt("ID"));
                e.setNome(rs.getString("NOME"));
                listaEntidades.add(e);
            }
            ConnectionFactory.closeConnection(conn, stmt, rs);
            return FXCollections.observableArrayList(listaEntidades);
        }

        public void salvarEntidade() throws SQLException {
            String nomeEntidade = txtEntidade.getText();
            if (nomeEntidade.isEmpty()) {
                btnCadastrar.isDisabled();
                txtEntidade.requestFocus();
            } else {
                if (txtID.getText().isEmpty()) {
                    Entidade e = new Entidade();
                    e.setNome(nomeEntidade);
                    adicionar(e);
                    atualizarTabela();
                    txtEntidade.requestFocus();
                    txtEntidade.setText("");
                } else {
                    ent.setNome(nomeEntidade);
                    editar(ent);
                    atualizarTabela();
                    txtEntidade.requestFocus();
                    txtEntidade.setText("");
                    txtID.setText("");
                }
            }
        }

        public void editarEntidade(Entidade entidade) {
            txtID.setText(String.valueOf(ent.getId()));
            txtEntidade.setText(entidade.getNome());
            txtEntidade.requestFocus();
        }

        public void initialize(URL location, ResourceBundle resources) {
            colunaEditar.setMinWidth(70.0);
            colunaEditar.setMaxWidth(70.0);
            colunaExcluir.setMinWidth(70.0);
            colunaExcluir.setMaxWidth(70.0);
            colunaEditar.setStyle("-fx-alignment: CENTER");
            colunaExcluir.setStyle("-fx-alignment: CENTER");
            colunaID.isSortable();
            colunaNome.isSortable();
            colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
            colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            adicionarBotaoEditar();
            adicionarBotaoExcluir();
            try {
                atualizarTabela();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public void adicionarBotaoEditar() {
            Callback<TableColumn<Entidade, Integer>, TableCell<Entidade, Integer>> cellFactory = new Callback<>() {
                @Override
                public TableCell<Entidade, Integer> call(final TableColumn<Entidade, Integer> param) {
                    return new TableCell<>() {
                        private final Button btnEditar = new Button("Editar");

                        {
                            btnEditar.setOnAction((ActionEvent event) -> {
                                ent = getTableView().getItems().get(getIndex());
                                editarEntidade(ent);
                            });
                        }

                        @Override
                        public void updateItem(Integer item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                btnEditar.setText("Editar");
                                btnEditar.setCursor(Cursor.CLOSED_HAND);
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
            Callback<TableColumn<Entidade, Integer>, TableCell<Entidade, Integer>> cellFactory = new Callback<>() {
                @Override
                public TableCell<Entidade, Integer> call(final TableColumn<Entidade, Integer> param) {
                    return new TableCell<>() {
                        private final Button btnExcluir = new Button("Excluir");

                        {
                            btnExcluir.setOnAction((ActionEvent event) -> {
                                Entidade e = getTableView().getItems().get(getIndex());
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                alert.setTitle("Exclusão");
                                alert.setHeaderText("Tem certeza que deseja excluir a entidade selecionada?");
                                alert.setContentText(e.getNome());
                                alert.showAndWait().ifPresent(response -> {
                                    if (response == ButtonType.OK) {
                                        try {
                                            remover(e);
                                            txtEntidade.setText("");
                                            atualizarTabela();
                                        } catch (SQLException ex) {
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
                                btnExcluir.setCursor(Cursor.CLOSED_HAND);
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

        public void atualizarTabela() throws SQLException {
            tblEntidades.setItems(listarTodos());
        }

        public void buscaEntidade() {
            txtEntidade.textProperty().addListener((observable, oldValue, newValue) -> {
                try {
                    tblEntidades.setItems(buscar(newValue));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        public void selecaoEntidade() {
            Entidade e = tblEntidades.getSelectionModel().getSelectedItem();
            System.out.println(e.getId() + " - " + e.getNome());
        }
    }