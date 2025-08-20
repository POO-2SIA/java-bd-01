package br.fiap.entidades;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class TesteDespesa {
    public static void main(String[] args) {
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        DespesaDAO dao = new DespesaDAO();

//        Despesa despesa = new Despesa();
//        despesa.setId(103L);
//        despesa.setDescricao("Viagem de Uber para a FIAP");
//        despesa.setValor(2000.00);
//        despesa.setData(LocalDate.parse("20/08/2025", mascara));
//        despesa.setCategoria(new Categoria(3L, ""));
//        dao.inserir(despesa);

        List<Despesa> listaDespesas = dao.listarDespesas();

        for (Despesa d : listaDespesas) {
            System.out.println(d.getId() + "\t" + d.getDescricao() + "\t" + "R$ " + d.getValor() + "\t"
                    + d.getData().format(mascara) + "\t" + d.getCategoria().getId());
            System.out.println("------------------------------------------------------------");
        }
    }
}
