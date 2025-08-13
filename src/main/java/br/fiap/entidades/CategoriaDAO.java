package br.fiap.entidades;

import br.fiap.connection.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private PreparedStatement ps; // Equivalente às operações no SQL (insert into, create table)
    private ResultSet rs; // Equivalente ao SELECT do SQL
    private String sql; //Vamos utilizar essa string para inserir os comandos do SQL

    public void inserir (Categoria categoria) {
        sql = "insert into java_categoria values (?, ?)";

        try (Connection connection = Conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            ps.setLong(1, categoria.getId()); // Esse set define o que será concatenado nas interrogações da ação do prepareStatement
            ps.setString(2, categoria.getCategoria());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao iserir uma categoria: " + e);
        }
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> lista = new ArrayList<>();
        sql = "select * from java_categoria";

        try(Connection connection = Conexao.conectar()) {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getLong("id_categoria"),
                        rs.getString("categoria"));

                lista.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar categoia: " + e);
        }

        return lista;
    }
}
