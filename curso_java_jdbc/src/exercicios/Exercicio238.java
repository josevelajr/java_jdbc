package exercicios;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Exercicio238 {

    public void exercicio238() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DB.abrirConexao();
            ps = conn.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
                            + "VALUES "
                            + "(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, "Osvaldo");
            ps.setString(2, "osvaldo@gmail.com");
            ps.setDate(3, new java.sql.Date(sdf.parse("11/11/1981").getTime()));
            ps.setDouble(4, 5000.00);
            ps.setInt(5, 4);

            int linhasAlteradas = ps.executeUpdate();

            if (linhasAlteradas > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    int idseller = rs.getInt(1);
                    System.out.println("Finalizado! ID " + idseller + " cadastrado com sucesso!");
                }

            } else {
                System.out.println("Nenhuma linha alterada!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            DB.fecharStatement(ps);
            DB.fecharConexao();
        }
    }
}
