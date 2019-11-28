package br.com.tiagosalla.model.dao;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import javax.sql.DataSource;

import br.com.tiagosalla.model.entidades.Usuario;
import org.postgresql.ds.PGConnectionPoolDataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class UsuarioDAO {

    private final DataSource dataSource;

    public UsuarioDAO() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setUser("tiago");
        dataSource.setPassword("123123");
        dataSource.setDatabaseName("livraria");
        this.dataSource = dataSource;
    }


    public void insert(final Usuario usuario) {
        try (
                final Connection connection = dataSource.getConnection();
                final PreparedStatement stmt = connection.prepareStatement(
                        "INSERT INTO usuario (usuario, senha, nome, email) VALUES (?, ?, ?, ?)"
                );
        ) {
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Deu ruim");
            throw new RuntimeException(e);
        }
    }
}
