/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pro.luciene.bibliotecapessoal.extras;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.ViewportLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucienecavalcanti
 */
public class Formularios {
    public static void limparCampos(JInternalFrame form) {
        for(Component c: form.getContentPane().getComponents()){
            if(c instanceof JTextField){
                ((JTextField) c).setText(null);
            }
            if(c instanceof JPasswordField){
                ((JPasswordField) c).setText(null);
            }
            if(c instanceof JComboBox){
                ((JComboBox) c).setSelectedIndex(0);
            }
        }
    }
    public static void limparCampos(JFrame form) {
        for(Component c: form.getContentPane().getComponents()){
            if(c instanceof JTextField){
                ((JTextField) c).setText(null);
            }
            if(c instanceof JPasswordField){
                ((JPasswordField) c).setText(null);
            }
            if(c instanceof JScrollPane){
                limparCampos(((JScrollPane) c).getComponents());
            }
        }
    }
    public static void limparCampos(Component componentes[]) {
        for(Component c: componentes){
            if(c instanceof JTextField){
                ((JTextField) c).setText(null);
            }
            if(c instanceof JPasswordField){
                ((JPasswordField) c).setText(null);
            }
            if(c instanceof JTextPane){
                ((JTextPane) c).setText(null);
            }
            if(c instanceof JTextArea){
                ((JTextArea) c).setText(null);
            }
            if(c instanceof JViewport){
                limparCampos(((JViewport) c).getComponents());
            }
        }
    }
    public static void tratarCampos(JInternalFrame form, boolean t) {
        for(Component c: form.getContentPane().getComponents()){
            if(c instanceof JTextField){
                ((JTextField) c).setEnabled(t);   
            }
            if(c instanceof JComboBox){
                ((JComboBox) c).setEnabled(t);   
            }
        }
    }
    public static void limparTabela(JTable tabela)  {
        DefaultTableModel mp = (DefaultTableModel)tabela.getModel();
            mp.setNumRows(0);
    }
}
