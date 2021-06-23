package exercicios;

import db.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Exercicio239 {
    public void exercicio239() {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DB.abrirConexao();
            ps = conn.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");

            ps.setDouble(1, 200.0);
            ps.setInt(2, 2);

            int linhasAlteradas = ps.executeUpdate();

            System.out.println("Finalizado! " + linhasAlteradas + " linhas alteradas!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fecharStatement(ps);
            DB.fecharConexao();
        }
    }
}
