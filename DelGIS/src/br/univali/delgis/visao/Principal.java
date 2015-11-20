package br.univali.delgis.visao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    private DefaultTableModel modelo;
    private int idSelecionado;

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panel_Ocorrencias = new javax.swing.JPanel();
        scrollPane_Ocorrencias = new javax.swing.JScrollPane();
        table_Ocorrencias = new javax.swing.JTable();
        button_Excluir = new javax.swing.JButton();
        button_Novo = new javax.swing.JButton();
        label_Separador1 = new javax.swing.JLabel();
        panel_Bairros = new javax.swing.JPanel();
        scrollPane_Ocorrencias1 = new javax.swing.JScrollPane();
        table_Ocorrencias1 = new javax.swing.JTable();
        button_Excluir1 = new javax.swing.JButton();
        button_Novo1 = new javax.swing.JButton();
        label_Separador2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menu_Gerenciar = new javax.swing.JMenu();
        menuItem_Bairro = new javax.swing.JMenuItem();
        menuItem_Ocorrencia = new javax.swing.JMenuItem();
        menuItem_TipoOcorrencia = new javax.swing.JMenuItem();
        menu_Relatorio = new javax.swing.JMenu();
        menuItem_Relatorio = new javax.swing.JMenuItem();
        menu_Sobre = new javax.swing.JMenu();
        menu_Sair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DelGIS - Ocorrências");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        table_Ocorrencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descrição", "Coordenada", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Ocorrencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_OcorrenciasMouseClicked(evt);
            }
        });
        scrollPane_Ocorrencias.setViewportView(table_Ocorrencias);
        if (table_Ocorrencias.getColumnModel().getColumnCount() > 0) {
            table_Ocorrencias.getColumnModel().getColumn(3).setHeaderValue("Tipo");
        }

        button_Excluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Excluir.setText("Excluir");
        button_Excluir.setEnabled(false);
        button_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ExcluirActionPerformed(evt);
            }
        });

        button_Novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Novo.setText("Novo");
        button_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_NovoActionPerformed(evt);
            }
        });

        label_Separador1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Separador1.setForeground(new java.awt.Color(102, 102, 102));
        label_Separador1.setText("Ocorrências");

        javax.swing.GroupLayout panel_OcorrenciasLayout = new javax.swing.GroupLayout(panel_Ocorrencias);
        panel_Ocorrencias.setLayout(panel_OcorrenciasLayout);
        panel_OcorrenciasLayout.setHorizontalGroup(
            panel_OcorrenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_OcorrenciasLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(panel_OcorrenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Separador1)
                    .addGroup(panel_OcorrenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane_Ocorrencias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_OcorrenciasLayout.createSequentialGroup()
                            .addComponent(button_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(button_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(239, 239, 239))))
                .addGap(97, 97, 97))
        );
        panel_OcorrenciasLayout.setVerticalGroup(
            panel_OcorrenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OcorrenciasLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(label_Separador1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane_Ocorrencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_OcorrenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Excluir)
                    .addComponent(button_Novo))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Ocorrências", panel_Ocorrencias);

        table_Ocorrencias1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Coordenadas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_Ocorrencias1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Ocorrencias1MouseClicked(evt);
            }
        });
        scrollPane_Ocorrencias1.setViewportView(table_Ocorrencias1);

        button_Excluir1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Excluir1.setText("Excluir");
        button_Excluir1.setEnabled(false);
        button_Excluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Excluir1ActionPerformed(evt);
            }
        });

        button_Novo1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Novo1.setText("Novo");
        button_Novo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_Novo1ActionPerformed(evt);
            }
        });

        label_Separador2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Separador2.setForeground(new java.awt.Color(102, 102, 102));
        label_Separador2.setText("Bairros");

        javax.swing.GroupLayout panel_BairrosLayout = new javax.swing.GroupLayout(panel_Bairros);
        panel_Bairros.setLayout(panel_BairrosLayout);
        panel_BairrosLayout.setHorizontalGroup(
            panel_BairrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_BairrosLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(panel_BairrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Separador2)
                    .addGroup(panel_BairrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane_Ocorrencias1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_BairrosLayout.createSequentialGroup()
                            .addComponent(button_Novo1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(button_Excluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(239, 239, 239))))
                .addGap(97, 97, 97))
        );
        panel_BairrosLayout.setVerticalGroup(
            panel_BairrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_BairrosLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(label_Separador2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane_Ocorrencias1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_BairrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_Excluir1)
                    .addComponent(button_Novo1))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Bairros", panel_Bairros);

        menu_Gerenciar.setText("Gerenciar");

        menuItem_Bairro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_Bairro.setText("Novo Bairro");
        menuItem_Bairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_BairroActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_Bairro);

        menuItem_Ocorrencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_Ocorrencia.setText("Nova Ocorrência");
        menuItem_Ocorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_OcorrenciaActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_Ocorrencia);

        menuItem_TipoOcorrencia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        menuItem_TipoOcorrencia.setText("Tipo Ocorrencia");
        menuItem_TipoOcorrencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItem_TipoOcorrenciaActionPerformed(evt);
            }
        });
        menu_Gerenciar.add(menuItem_TipoOcorrencia);

        menuBar.add(menu_Gerenciar);

        menu_Relatorio.setText("Relatórios");

        menuItem_Relatorio.setText("Ocorrências por Bairro");
        menu_Relatorio.add(menuItem_Relatorio);

        menuBar.add(menu_Relatorio);

        menu_Sobre.setText("Sobre");
        menuBar.add(menu_Sobre);

        menu_Sair.setText("Sair");
        menuBar.add(menu_Sair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuItem_TipoOcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_TipoOcorrenciaActionPerformed
        new TiposOcorrencias(this, true).setVisible(true);
    }//GEN-LAST:event_menuItem_TipoOcorrenciaActionPerformed

    private void menuItem_BairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_BairroActionPerformed
        tabbedPane.setSelectedIndex(1);
        new Bairro(this, true).setVisible(true);
    }//GEN-LAST:event_menuItem_BairroActionPerformed

    private void menuItem_OcorrenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItem_OcorrenciaActionPerformed
        tabbedPane.setSelectedIndex(0);
        button_Novo.doClick();
    }//GEN-LAST:event_menuItem_OcorrenciaActionPerformed

    private void table_OcorrenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_OcorrenciasMouseClicked
        if (evt.getClickCount() == 1) {
            //idSelecionado = Integer.parseInt((String) table_Ocorrencias.getValueAt(table_Ocorrencias.getSelectedRow(), 0));
            button_Excluir.setEnabled(true);
        }
    }//GEN-LAST:event_table_OcorrenciasMouseClicked

    private void button_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_NovoActionPerformed
        new Ocorrencia(this, true).setVisible(true);
    }//GEN-LAST:event_button_NovoActionPerformed

    private void button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExcluirActionPerformed
        button_Excluir.setEnabled(false);
    }//GEN-LAST:event_button_ExcluirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void table_Ocorrencias1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Ocorrencias1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_Ocorrencias1MouseClicked

    private void button_Excluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Excluir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_Excluir1ActionPerformed

    private void button_Novo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_Novo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_Novo1ActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Excluir;
    private javax.swing.JButton button_Excluir1;
    private javax.swing.JButton button_Novo;
    private javax.swing.JButton button_Novo1;
    private javax.swing.JLabel label_Separador1;
    private javax.swing.JLabel label_Separador2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem_Bairro;
    private javax.swing.JMenuItem menuItem_Ocorrencia;
    private javax.swing.JMenuItem menuItem_Relatorio;
    private javax.swing.JMenuItem menuItem_TipoOcorrencia;
    private javax.swing.JMenu menu_Gerenciar;
    private javax.swing.JMenu menu_Relatorio;
    private javax.swing.JMenu menu_Sair;
    private javax.swing.JMenu menu_Sobre;
    private javax.swing.JPanel panel_Bairros;
    private javax.swing.JPanel panel_Ocorrencias;
    private javax.swing.JScrollPane scrollPane_Ocorrencias;
    private javax.swing.JScrollPane scrollPane_Ocorrencias1;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable table_Ocorrencias;
    private javax.swing.JTable table_Ocorrencias1;
    // End of variables declaration//GEN-END:variables
}
