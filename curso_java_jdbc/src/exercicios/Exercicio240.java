package exercicios;

import db.DB;
import db.DbIntegrityException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercicio240 {

    public void exercicio240() {

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
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.fecharStatement(ps);
            DB.fecharConexao();
        }
    }
}
