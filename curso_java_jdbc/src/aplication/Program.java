package aplication;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DB.abrirConexao();
            ps = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?");

            ps.setInt(1, 2);

            int linhasAlteradas = ps.executeUpdate();

            System.out.println("Finalizado! " + linhasAlteradas + " linhas apagadas!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fecharStatement(ps);
            DB.fecharConexao();
        }
    }
}
