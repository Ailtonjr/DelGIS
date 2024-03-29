package br.univali.delgis.visao;

import br.univali.delgis.controle.ControladorTipo;

public class JanelaTipos extends javax.swing.JDialog {

    ControladorTipo ctrlTipo = new ControladorTipo();
    private int idSelecionado;
    private String operacao = "novo";

    public JanelaTipos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        panel_Principal = new javax.swing.JPanel();
        button_Novo = new javax.swing.JButton();
        button_Editar = new javax.swing.JButton();
        button_Confirmar = new javax.swing.JButton();
        button_Excluir = new javax.swing.JButton();
        scrollPane_Tipos = new javax.swing.JScrollPane();
        tabela_Tipos = new javax.swing.JTable();
        label_Nome = new javax.swing.JLabel();
        field_Nome = new javax.swing.JTextField();
        separator = new javax.swing.JSeparator();
        label_Separador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DelGIS - Tipos de Ocorrência");
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        panel_Principal.setToolTipText("");
        panel_Principal.setMaximumSize(new java.awt.Dimension(480, 420));
        panel_Principal.setMinimumSize(new java.awt.Dimension(480, 420));
        panel_Principal.setName("dfd"); // NOI18N
        panel_Principal.setPreferredSize(new java.awt.Dimension(480, 420));

        button_Novo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Novo.setText("Novo");
        button_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_NovoActionPerformed(evt);
            }
        });

        button_Editar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Editar.setText("Editar");
        button_Editar.setEnabled(false);
        button_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_EditarActionPerformed(evt);
            }
        });

        button_Confirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Confirmar.setText("Confirmar");
        button_Confirmar.setEnabled(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, field_Nome, org.jdesktop.beansbinding.ObjectProperty.create(), button_Confirmar, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        button_Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ConfirmarActionPerformed(evt);
            }
        });

        button_Excluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        button_Excluir.setText("Excluir");
        button_Excluir.setEnabled(false);
        button_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ExcluirActionPerformed(evt);
            }
        });

        tabela_Tipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_Tipos.getTableHeader().setReorderingAllowed(false);
        tabela_Tipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_TiposMouseClicked(evt);
            }
        });
        scrollPane_Tipos.setViewportView(tabela_Tipos);
        if (tabela_Tipos.getColumnModel().getColumnCount() > 0) {
            tabela_Tipos.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        label_Nome.setText("Nome");

        field_Nome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        field_Nome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        field_Nome.setEnabled(false);

        separator.setForeground(new java.awt.Color(153, 153, 153));
        separator.setToolTipText("");
        separator.setName(""); // NOI18N

        label_Separador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label_Separador.setForeground(new java.awt.Color(102, 102, 102));
        label_Separador.setText("Tipos Cadastrados");

        javax.swing.GroupLayout panel_PrincipalLayout = new javax.swing.GroupLayout(panel_Principal);
        panel_Principal.setLayout(panel_PrincipalLayout);
        panel_PrincipalLayout.setHorizontalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_Nome)
                    .addComponent(field_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addComponent(button_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(button_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(button_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(button_Confirmar))
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addComponent(label_Separador)
                        .addGap(14, 14, 14)
                        .addComponent(separator))
                    .addComponent(scrollPane_Tipos, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panel_PrincipalLayout.setVerticalGroup(
            panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PrincipalLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(label_Nome)
                .addGap(6, 6, 6)
                .addComponent(field_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_Novo)
                    .addComponent(button_Editar)
                    .addComponent(button_Excluir)
                    .addComponent(button_Confirmar))
                .addGap(18, 18, 18)
                .addGroup(panel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Separador)
                    .addGroup(panel_PrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(separator, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(scrollPane_Tipos, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 473, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

// Confirmar e clique na tabela
    private void setaBotoesConfirmar() {
        button_Novo.setEnabled(true);
        button_Editar.setEnabled(true);
        button_Excluir.setEnabled(true);
        button_Confirmar.setEnabled(false);
        field_Nome.setEnabled(false);
    }

    private void setaBotoesEditar() {
        button_Novo.setEnabled(false);
        button_Editar.setEnabled(false);
        button_Excluir.setEnabled(false);
        button_Confirmar.setEnabled(true);
        field_Nome.setEnabled(true);
    }

    private void atualizaTabela() {
        tabela_Tipos.setModel(ctrlTipo.montaTabela());
    }

    private void button_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ExcluirActionPerformed
        ctrlTipo.excluirTipo(idSelecionado, "");
        operacao = "novo";
        atualizaTabela();
        button_Novo.doClick();
    }//GEN-LAST:event_button_ExcluirActionPerformed

    private void button_ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ConfirmarActionPerformed
        if (operacao.equals("novo")) {
            tabela_Tipos.setRowSelectionInterval(tabela_Tipos.getRowCount() - 1, tabela_Tipos.getRowCount() - 1);
            ctrlTipo.novoTipo(field_Nome.getText());
        }else{
            tabela_Tipos.setRowSelectionInterval(tabela_Tipos.getRowCount() - 1, tabela_Tipos.getRowCount() - 1);
            ctrlTipo.atualizarTipo(idSelecionado, field_Nome.getText());
        }
        setaBotoesConfirmar();
        atualizaTabela();
    }//GEN-LAST:event_button_ConfirmarActionPerformed

    private void button_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_EditarActionPerformed
        operacao = "editar";
        setaBotoesEditar();
    }//GEN-LAST:event_button_EditarActionPerformed

    private void tabela_TiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_TiposMouseClicked
        if (evt.getClickCount() == 1) {
            idSelecionado = Integer.parseInt((String) tabela_Tipos.getValueAt(tabela_Tipos.getSelectedRow(), 0));
            setaBotoesConfirmar();
        }
    }//GEN-LAST:event_tabela_TiposMouseClicked

    private void button_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_NovoActionPerformed
        operacao = "novo";
        setaBotoesEditar();
        field_Nome.setText("");
        button_Confirmar.transferFocus();
    }//GEN-LAST:event_button_NovoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_Confirmar;
    private javax.swing.JButton button_Editar;
    private javax.swing.JButton button_Excluir;
    private javax.swing.JButton button_Novo;
    private javax.swing.JTextField field_Nome;
    private javax.swing.JLabel label_Nome;
    private javax.swing.JLabel label_Separador;
    private javax.swing.JPanel panel_Principal;
    private javax.swing.JScrollPane scrollPane_Tipos;
    private javax.swing.JSeparator separator;
    private javax.swing.JTable tabela_Tipos;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
