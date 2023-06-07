package org.example.Vista;

import javax.swing.*;
import java.awt.*;

public class VentanaCompu extends JFrame {
    private JLabel lblId;
    private JLabel lblTitulo;
    private JLabel lblPlataforma;
    private JLabel lblAnioLanzamiento;
    private JLabel lblDesarrollador;
    private JLabel lblImagen;
    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtPlataforma;
    private JTextField txtAnioLanzamiento;
    private JTextField txtDesarrollador;
    private JTextField txtImagen;
    private JButton btnAgregar;
    private JTable tabla;
    private JScrollPane scrollpane;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel imagen;
    private JButton btnMostarTbl;
    private JLabel lblDelete;
    private TextField txtDelete;
    private JButton btnDelete;
    private JLabel lblIdAct;
    private JLabel lblTituloAct;
    private JLabel lblPlataformaAct;
    private JLabel lblAnioLanzamientoAct;
    private JLabel lblDesarrolladorAct;
    private JLabel lblImagenAct;
    private JTextField txtIdAct;
    private JTextField txtTituloAct;
    private JTextField txtPlataformaAct;
    private JTextField txtAnioLanzamientoAct;
    private JTextField txtDesarrolladorAct;
    private JTextField txtImagenAct;
    private JButton btnAgregarAct;

    public VentanaCompu(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 800);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        // panel1
        panel1 = new JPanel(new FlowLayout());
        panel1.setBackground(new Color(239, 200, 200));
        lblId = new JLabel("Id:");
        lblTitulo = new JLabel("Titulo:");
        lblPlataforma = new JLabel("Plataforma:");
        lblAnioLanzamiento = new JLabel("Año/lanzamiento:");
        lblDesarrollador = new JLabel("Desarrollador:");
        lblImagen = new JLabel("Imagen (URL):");

        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtTitulo = new JTextField(15);
        txtAnioLanzamiento = new JTextField(6);
        txtPlataforma = new JTextField(15);
        txtDesarrollador = new JTextField(15);
        txtImagen = new JTextField(30);
        btnAgregar = new JButton("Agregar");
        btnMostarTbl = new JButton("Mostar datos");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblTitulo);
        panel1.add(txtTitulo);
        panel1.add(lblPlataforma);
        panel1.add(txtPlataforma);
        panel1.add(lblAnioLanzamiento);
        panel1.add(txtAnioLanzamiento);
        panel1.add(lblDesarrollador);
        panel1.add(txtDesarrollador);
        panel1.add(lblImagen);
        panel1.add(txtImagen);
        panel1.add(btnAgregar);
        panel1.add(btnMostarTbl);

        // panel2
        panel2 = new JPanel(new FlowLayout());
        panel2.setBackground(new Color(209, 241, 193));
        tabla = new JTable();
        scrollpane = new JScrollPane(tabla);
        panel2.add(scrollpane);
        // panel3
        panel3 = new JPanel(new FlowLayout());
        panel3.setBackground(new Color(200, 239, 232));
        imagen = new JLabel("...");
        panel3.add(imagen);
        // panel4
        panel4 = new JPanel(new FlowLayout());
        panel4.setBackground(new Color(213, 200, 239));
        lblDelete = new JLabel("Ingrese el ID de la fila en la tabla que desea eliminar: ");
        txtDelete = new TextField(4);
        btnDelete = new JButton("Eliminar");
        panel4.add(lblDelete);
        panel4.add(txtDelete);
        panel4.add(btnDelete);

        lblIdAct = new JLabel("Id:");
        lblTituloAct = new JLabel("Titulo:");
        lblPlataformaAct = new JLabel("Plataforma:");
        lblAnioLanzamientoAct = new JLabel("Año/lanzamiento:");
        lblDesarrolladorAct = new JLabel("Desarrollador:");
        lblImagenAct = new JLabel("Imagen (URL):");

        txtIdAct = new JTextField(3);
        txtTituloAct = new JTextField(15);
        txtAnioLanzamientoAct = new JTextField(6);
        txtPlataformaAct = new JTextField(15);
        txtDesarrolladorAct = new JTextField(15);
        txtImagenAct = new JTextField(30);
        btnAgregarAct = new JButton("Actualizar");

        panel4.add(lblIdAct);
        panel4.add(txtIdAct);
        panel4.add(lblTituloAct);
        panel4.add(txtTituloAct);
        panel4.add(lblPlataformaAct);
        panel4.add(txtPlataformaAct);
        panel4.add(lblAnioLanzamientoAct);
        panel4.add(txtAnioLanzamientoAct);
        panel4.add(lblDesarrolladorAct);
        panel4.add(txtDesarrolladorAct);
        panel4.add(lblImagenAct);
        panel4.add(txtImagenAct);
        panel4.add(btnAgregarAct);

        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblTitulo() {
        return lblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        this.lblTitulo = lblTitulo;
    }

    public JLabel getLblPlataforma() {
        return lblPlataforma;
    }

    public void setLblPlataforma(JLabel lblPlataforma) {
        this.lblPlataforma = lblPlataforma;
    }

    public JLabel getLblAnioLanzamiento() {
        return lblAnioLanzamiento;
    }

    public void setLblAnioLanzamiento(JLabel lblAnioLanzamiento) {
        this.lblAnioLanzamiento = lblAnioLanzamiento;
    }

    public JLabel getLblDesarrollador() {
        return lblDesarrollador;
    }

    public void setLblDesarrollador(JLabel lblDesarrollador) {
        this.lblDesarrollador = lblDesarrollador;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public void setTxtTitulo(JTextField txtTitulo) {
        this.txtTitulo = txtTitulo;
    }

    public JTextField getTxtPlataforma() {
        return txtPlataforma;
    }

    public void setTxtPlataforma(JTextField txtPlataforma) {
        this.txtPlataforma = txtPlataforma;
    }

    public JTextField getTxtAnioLanzamiento() {
        return txtAnioLanzamiento;
    }

    public void setTxtAnioLanzamiento(JTextField txtAnioLanzamiento) {
        this.txtAnioLanzamiento = txtAnioLanzamiento;
    }

    public JTextField getTxtDesarrollador() {
        return txtDesarrollador;
    }

    public void setTxtDesarrollador(JTextField txtDesarrollador) {
        this.txtDesarrollador = txtDesarrollador;
    }

    public JTextField getTxtImagen() {
        return txtImagen;
    }

    public void setTxtImagen(JTextField txtImagen) {
        this.txtImagen = txtImagen;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScrollpane() {
        return scrollpane;
    }

    public void setScrollpane(JScrollPane scrollpane) {
        this.scrollpane = scrollpane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public JButton getBtnMostarTbl() {
        return btnMostarTbl;
    }

    public void setBtnMostarTbl(JButton btnMostarTbl) {
        this.btnMostarTbl = btnMostarTbl;
    }

    public JLabel getLblDelete() {
        return lblDelete;
    }

    public void setLblDelete(JLabel lblDelete) {
        this.lblDelete = lblDelete;
    }

    public TextField getTxtDelete() {
        return txtDelete;
    }

    public void setTxtDelete(TextField txtDelete) {
        this.txtDelete = txtDelete;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JLabel getLblIdAct() {
        return lblIdAct;
    }

    public void setLblIdAct(JLabel lblIdAct) {
        this.lblIdAct = lblIdAct;
    }

    public JLabel getLblTituloAct() {
        return lblTituloAct;
    }

    public void setLblTituloAct(JLabel lblTituloAct) {
        this.lblTituloAct = lblTituloAct;
    }

    public JLabel getLblPlataformaAct() {
        return lblPlataformaAct;
    }

    public void setLblPlataformaAct(JLabel lblPlataformaAct) {
        this.lblPlataformaAct = lblPlataformaAct;
    }

    public JLabel getLblAnioLanzamientoAct() {
        return lblAnioLanzamientoAct;
    }

    public void setLblAnioLanzamientoAct(JLabel lblAnioLanzamientoAct) {
        this.lblAnioLanzamientoAct = lblAnioLanzamientoAct;
    }

    public JLabel getLblDesarrolladorAct() {
        return lblDesarrolladorAct;
    }

    public void setLblDesarrolladorAct(JLabel lblDesarrolladorAct) {
        this.lblDesarrolladorAct = lblDesarrolladorAct;
    }

    public JLabel getLblImagenAct() {
        return lblImagenAct;
    }

    public void setLblImagenAct(JLabel lblImagenAct) {
        this.lblImagenAct = lblImagenAct;
    }

    public JTextField getTxtIdAct() {
        return txtIdAct;
    }

    public void setTxtIdAct(JTextField txtIdAct) {
        this.txtIdAct = txtIdAct;
    }

    public JTextField getTxtTituloAct() {
        return txtTituloAct;
    }

    public void setTxtTituloAct(JTextField txtTituloAct) {
        this.txtTituloAct = txtTituloAct;
    }

    public JTextField getTxtPlataformaAct() {
        return txtPlataformaAct;
    }

    public void setTxtPlataformaAct(JTextField txtPlataformaAct) {
        this.txtPlataformaAct = txtPlataformaAct;
    }

    public JTextField getTxtAnioLanzamientoAct() {
        return txtAnioLanzamientoAct;
    }

    public void setTxtAnioLanzamientoAct(JTextField txtAnioLanzamientoAct) {
        this.txtAnioLanzamientoAct = txtAnioLanzamientoAct;
    }

    public JTextField getTxtDesarrolladorAct() {
        return txtDesarrolladorAct;
    }

    public void setTxtDesarrolladorAct(JTextField txtDesarrolladorAct) {
        this.txtDesarrolladorAct = txtDesarrolladorAct;
    }

    public JTextField getTxtImagenAct() {
        return txtImagenAct;
    }

    public void setTxtImagenAct(JTextField txtImagenAct) {
        this.txtImagenAct = txtImagenAct;
    }

    public JButton getBtnAgregarAct() {
        return btnAgregarAct;
    }

    public void setBtnAgregarAct(JButton btnAgregarAct) {
        this.btnAgregarAct = btnAgregarAct;
    }

    public void limpiar(){
        txtTitulo.setText("");
        txtPlataforma.setText("");
        txtAnioLanzamiento.setText("");
        txtDesarrollador.setText("");
        txtImagen.setText("");
    }
    public void limpiarAct(){
        txtIdAct.setText("");
        txtTituloAct.setText("");
        txtPlataformaAct.setText("");
        txtAnioLanzamientoAct.setText("");
        txtDesarrolladorAct.setText("");
        txtImagenAct.setText("");
    }
}
