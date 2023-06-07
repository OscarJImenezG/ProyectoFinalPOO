package org.example.Controlador;

import org.example.Vista.VentanaCompu;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorZelda extends MouseAdapter {

    private VentanaCompu view;
    private ModeloTablaZelda modelo;
    public ControladorZelda(VentanaCompu view) {
        this.view = view;
        modelo = new ModeloTablaZelda();
        this.view.getTabla().setModel(modelo);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTabla().addMouseListener(this);
        this.view.getBtnMostarTbl().addMouseListener(this);
        this.view.getBtnDelete().addMouseListener(this);
        this.view.getBtnAgregarAct().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == view.getBtnAgregar()) {
            try {
            if (view.getTxtTitulo().getText().equals("") && view.getTxtPlataforma().getText().equals("") && view.getTxtAnioLanzamiento().getText().equals("") && view.getTxtDesarrollador().getText().equals("") && view.getTxtImagen().getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Las celdas estan vacias. No hay cambios en la tabla", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }else{
                System.out.println("Evento sobre boton add");
                modelo.cargarDatos();
                this.view.getTabla().setModel(modelo);
                this.view.getTabla().updateUI();
                Zelda zelda = new Zelda();
                zelda.setId(Integer.parseInt(this.view.getTxtId().getText()));
                zelda.setTitulo(this.view.getTxtTitulo().getText());
                zelda.setPlataforma(this.view.getTxtPlataforma().getText());
                if (view.getTxtAnioLanzamiento().getText().equals("")){
                    zelda.setAnioLanzamiento(0);
                }else {
                    zelda.setAnioLanzamiento(Integer.parseInt(this.view.getTxtAnioLanzamiento().getText()));
                }
                zelda.setDesarrollador(this.view.getTxtDesarrollador().getText());
                zelda.setUrl(this.view.getTxtImagen().getText());
                modelo.agregarZelda(zelda);
                this.view.getTabla().updateUI();
                this.view.limpiar();
                if (modelo.agregarLibro(zelda)) {
                    JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    modelo.cargarDatos();
                    this.view.getTabla().setModel(modelo);
                    this.view.getTabla().updateUI();
                }
            }
            }catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "El campo \"año de lanzamiento\" solo admite numeros\nPor favor rectifique su entrada", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if (e.getSource() == view.getBtnMostarTbl()) {
            modelo.cargarDatos();
            this.view.getTabla().setModel(modelo);
            this.view.getTabla().updateUI();
        }
        if (e.getSource() == view.getTabla()) {
            System.out.println("Evento sobre tabla");
            int index = this.view.getTabla().getSelectedRow();
            Zelda tmp = modelo.getZeldaAtIndex(index);

            try {
                this.view.getImagen().setIcon(tmp.getimagen());
                this.view.getImagen().setText("");
            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
            }
        }
        if (e.getSource() == this.view.getBtnDelete()) {
            try {
                if (modelo.buscarPorID(Integer.parseInt(this.view.getTxtDelete().getText())) == null) {
                    JOptionPane.showMessageDialog(view, "El ID que ingreso no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                    this.view.getTxtDelete().setText("");
                } else {
                    int result = JOptionPane.showConfirmDialog(view, "ESTA A PUNTO DE ELIMINAR LA FILA " + this.view.getTxtDelete().getText() + "\n" + modelo.buscarPorID(Integer.parseInt(this.view.getTxtDelete().getText())) + "\n¿ESTA SEGURO?", "ATENCION", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        if (modelo.eliminarFila(Integer.parseInt(this.view.getTxtDelete().getText()))) {
                            JOptionPane.showMessageDialog(view, "Se elimino correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            this.view.getTxtDelete().setText("");
                            modelo.cargarDatos();
                            this.view.getTabla().setModel(modelo);
                            this.view.getTabla().updateUI();
                        }
                    } else {
                        JOptionPane.showMessageDialog(view, "Se ha cancelado la operacion", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        this.view.getTxtDelete().setText("");
                        modelo.cargarDatos();
                        this.view.getTabla().setModel(modelo);
                        this.view.getTabla().updateUI();
                    }
                }
            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(view, "El campo \"ID\" solo admite numeros o esta vacio\nPor favor rectifique su entrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == this.view.getBtnAgregarAct()) {
            try{
                    Zelda zelda = new Zelda();
                    zelda.setId(Integer.parseInt(this.view.getTxtIdAct().getText()));
                    zelda = modelo.buscarPorID(Integer.parseInt(this.view.getTxtIdAct().getText()));

                    if (view.getTxtTituloAct().getText().equals("")){
                    }else{
                        zelda.setTitulo(view.getTxtTituloAct().getText());
                    }

                    if (view.getTxtPlataformaAct().getText().equals("")){
                    }else{
                        zelda.setPlataforma(view.getTxtPlataformaAct().getText());
                    }

                    if (view.getTxtAnioLanzamientoAct().getText().equals("")){
                    }else{
                        zelda.setAnioLanzamiento(Integer.parseInt(view.getTxtAnioLanzamientoAct().getText()));
                    }

                    if (view.getTxtDesarrolladorAct().getText().equals("")){
                    }else{
                        zelda.setDesarrollador(view.getTxtDesarrolladorAct().getText());
                    }

                    if (view.getTxtImagenAct().getText().equals("")){

                    }else{
                        zelda.setUrl(view.getTxtImagenAct().getText());
                    }

                    if (zelda == null) {
                        JOptionPane.showMessageDialog(view, "El ID que ingreso no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                        this.view.limpiarAct();
                    } else {
                        if (modelo.actualizarLibro(zelda)) {
                            JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                            modelo.cargarDatos();
                            this.view.getTabla().setModel(modelo);
                            this.view.getTabla().updateUI();
                            this.view.limpiarAct();

                        } else {
                            JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. Por favor revise los datos ingresados", "Error al insertar", JOptionPane.ERROR_MESSAGE);
                            modelo.cargarDatos();
                            this.view.getTabla().setModel(modelo);
                            this.view.getTabla().updateUI();
                            this.view.limpiarAct();
                        }
                    }
            }catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(view, "El campo \"ID\" solo admite numeros o esta vacio\nPor favor rectifique su entrada", "Error", JOptionPane.ERROR_MESSAGE);
            }catch (NullPointerException npoe){
                JOptionPane.showMessageDialog(view, "El ID que ingreso no existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                this.view.limpiarAct();
            }
        }
    }
}
