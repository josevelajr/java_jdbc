package aplication;

import db.DB;

import java.sql.Connection;

public class Program {

    public static void main(String[] args) {

        Connection connection = DB.getConexao();
        DB.fecharConexao();


    }
}
