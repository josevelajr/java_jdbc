package exercicios;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercicio237 {

    public void exercicio237() {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.abrirConexao();
            st = conn.createStatement();
            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.fecharResultSet(rs);
            DB.fecharStatement(st);
            DB.fecharConexao();
        }
    }
}
