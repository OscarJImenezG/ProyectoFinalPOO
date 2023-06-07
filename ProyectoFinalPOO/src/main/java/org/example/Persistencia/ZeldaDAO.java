package org.example.Persistencia;

import org.example.Controlador.Zelda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ZeldaDAO implements InterfazDAO{

    public ZeldaDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO zelda(Titulo, Plataforma, Lanzamiento, Desarrollador, URL) VALUES (? ,? ,? ,? ,? )";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Zelda.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Zelda)obj).getTitulo());
        pstm.setString(2, ((Zelda)obj).getPlataforma());
        pstm.setString(3, Integer.toString(((Zelda)obj).getAnioLanzamiento()));
        pstm.setString(4, ((Zelda)obj).getDesarrollador());
        pstm.setString(5, ((Zelda)obj).getUrl());
        rowCount = pstm.executeUpdate();
        return  rowCount > 0;
    }

    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE zelda SET Titulo = ?, Plataforma = ?, Lanzamiento = ?, Desarrollador = ?, URL = ? WHERE Id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Zelda.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((Zelda)obj).getTitulo());
        pstm.setString(2, ((Zelda)obj).getPlataforma());
        pstm.setString(3, Integer.toString(((Zelda)obj).getAnioLanzamiento()));
        pstm.setString(4, ((Zelda)obj).getDesarrollador());
        pstm.setString(5, ((Zelda)obj).getUrl());
        pstm.setInt(6, ((Zelda)obj).getId());
        rowCount = pstm.executeUpdate();
        return  rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM zelda WHERE Id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Zelda.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();

        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM zelda";
        ArrayList<Zelda> resultado = new ArrayList<>();

            Statement stm = ConexionSingleton.getInstance("Zelda.db").getConnection().createStatement();
            ResultSet rst = stm.executeQuery(sql);
            while (rst.next()){
                resultado.add(new Zelda(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6)));
            }

        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM zelda WHERE Id = ? ;";
        Zelda zelda = null;

            PreparedStatement pstm = ConexionSingleton.getInstance("Zelda.db").getConnection().prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            ResultSet rst = pstm.executeQuery();
            if(rst.next()){
                zelda = new Zelda(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getString(5),rst.getString(6));
                return zelda;
            }

        return null;
    }
}
