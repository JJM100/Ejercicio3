package com.init;

import com.componentes.CustomPanel;
import com.componentes.DeleteDialog;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

public class PrincipalForm extends javax.swing.JFrame {

    private Map<Integer, CustomPanel> map = new HashMap<>();

    private GridLayout layout = new GridLayout();

    public PrincipalForm() {  
        initComponents();
        agregarPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        bottomPanel = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        scrollPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principalPanel.setPreferredSize(new java.awt.Dimension(298, 429));
        principalPanel.setLayout(new java.awt.BorderLayout());

        topPanel.setPreferredSize(new java.awt.Dimension(100, 100));
        topPanel.setLayout(new java.awt.BorderLayout());

        bottomPanel.setPreferredSize(new java.awt.Dimension(30, 30));

        btnAgregar.setText("Agregar Componente");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        bottomPanel.add(btnAgregar);

        btnEliminar.setText("Eliminar Componente");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        bottomPanel.add(btnEliminar);

        topPanel.add(bottomPanel, java.awt.BorderLayout.SOUTH);

        scrollPanel.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane.setViewportView(scrollPanel);

        topPanel.add(jScrollPane, java.awt.BorderLayout.CENTER);

        principalPanel.add(topPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(principalPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        agregar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        borrar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JPanel scrollPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

    private void agregar() {
        agregarPanel();
        setLayoutForm();
        refreshPanel();
    } 

    private void setLayoutForm() {
        int size = map.size();
        layout.setRows(size);
        layout.setColumns(1);
        scrollPanel.setLayout(layout);
    }

    private void agregarPanel() {
        int panelNumber = map.size() + 1;
        CustomPanel panel = new CustomPanel(panelNumber);
        map.put(panelNumber, panel);
        scrollPanel.add(panel);
    }

    private void borrar() {
        DeleteDialog dialog = new DeleteDialog(this);
        dialog.setVisible(true);
        dialog.setLocationRelativeTo(null);
        int option = dialog.getOption();
        CustomPanel panel = map.get(option);        
        if (panel != null) {
            scrollPanel.remove(panel);
        }
    }

    private void refreshPanel() {
        scrollPanel.revalidate();
        scrollPanel.repaint();
        jScrollPane.revalidate();
        jScrollPane.repaint();
    }
}
