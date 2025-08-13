package br.fiap.connection;

import br.fiap.entidades.Categoria;
import br.fiap.entidades.CategoriaDAO;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        CategoriaDAO dao = new CategoriaDAO();
        Categoria categoria = new Categoria(6L, "Educação");
        List<Categoria> lista = dao.listarCategorias();

        for (Categoria c : lista) {
            System.out.println(c.getId() + "-" + c.getCategoria());
        }
    }
}
