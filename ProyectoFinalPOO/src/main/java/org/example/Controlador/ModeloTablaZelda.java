package org.example.Controlador;

import org.example.Persistencia.ZeldaDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaZelda implements TableModel {

    private ArrayList<Zelda> datos;
    public static final int COLS = 6;
    private ZeldaDAO zdao;

    public ModeloTablaZelda() {
        zdao = new ZeldaDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaZelda(ArrayList<Zelda> datos) {
        this.datos = datos;
        zdao = new ZeldaDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombreCol = "";
        switch (columnIndex){
            case 0:
                nombreCol = "Id";
                break;
            case 1:
                nombreCol = "Titulo";
                break;
            case 2:
                nombreCol = "Plataforma";
                break;
            case 3:
                nombreCol = "Año de lanzamiento";
                break;
            case 4:
                nombreCol = "Desarrollador";
                break;
            case 5:
                nombreCol = "Foto (URL)";
                break;
            default:
                nombreCol = "";
        }
        return nombreCol;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zelda tmp =  datos.get(rowIndex);
        switch (columnIndex){
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getTitulo();
            case 2:
                return tmp.getPlataforma();
            case 3:
                return tmp.getAnioLanzamiento();
            case 4:
                return tmp.getDesarrollador();
            case 5:
                return tmp.getUrl();
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                //datos.get(rowIndex).setId(0);
                break;
            case 1:
                datos.get(rowIndex).setTitulo((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setPlataforma((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setAnioLanzamiento((int) aValue);
                break;
            case 4:
                datos.get(rowIndex).setDesarrollador((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            default:
                System.out.println("No se puede modificar la tabla");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void agregarZelda(Zelda zelda){
        datos.add(zelda);
    }

    public Zelda getZeldaAtIndex(int index){
        return datos.get(index);
    }
    public void cargarDatos(){
        try {
            ArrayList<Zelda> tirar = zdao.obtenerTodo();
            System.out.println(tirar);
            datos = zdao.obtenerTodo();
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }

    }

    public boolean agregarLibro(Zelda zelda){
        boolean resultado =  false;
        try {
            if (zdao.insertar(zelda)) {
                resultado = true;
            }else{
                resultado = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public boolean actualizarLibro(Zelda zelda){
        boolean result = false;
        try {
            if (zdao.update(zelda)){
                result = true;
            }else{
                result = false;
            }
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return result;
    }

    public boolean eliminarFila(int id){
        boolean resultado = false;
        try{
            if (zdao.delete(Integer.toString(id))){
                resultado = true;
            }else{
                resultado = false;
            }
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }

    public Zelda buscarPorID(int id){
        Zelda result = null;
        try{
            result = (Zelda) zdao.buscarPorId(Integer.toString(id));
        }catch (SQLException sqle){
            System.out.println(sqle.getMessage());
        }
        return result;
    }

}