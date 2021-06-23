package exercicios;

import db.DB;

import java.sql.Connection;

public class Exercicio236 {

    public void exercicio236() {

        Connection connection = DB.abrirConexao();
        DB.fecharConexao();

    }
}
