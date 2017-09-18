/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saipe.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Josh6
 */
public class MenuPrincipal extends JFrame{
    
   public MenuPrincipal() {
       this.setTitle("SAIPE");
       configuracion();
       agregarComponentes(this.getContentPane());
       iniciar();
       
   }
   public void mostrar() {
       this.setVisible(true);
   }
   private void iniciar() {
       mostrar();
   }
   private void configuracion(){
       this.setSize(600,400);
       this.setResizable(false);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                cerrarAplicacion();
            }

        });
   }
   private void agregarEventos(){
       
   }
    private void cerrarAplicacion() {
        if (JOptionPane.showConfirmDialog(this,
                "Desea cerrar la aplicación?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION)
                == JOptionPane.YES_OPTION ) {
            System.exit(0);
        }
    }
    private void agregarComponentes(Container c){
        Insets insets=new Insets(8,16,8,16);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=insets;
        
        panelPrincipal=new JPanel();
        panelMenu=new JPanel();
        barraMenu=new JMenuBar();
        
        menuUsuarios=new JMenu();
        menuUsuarios.setText("Usuarios");
        for(int i=0; i < opcionesUsuarios.length; ++i) {
            JMenuItem mi = new JMenuItem();
            mi.setText(opcionesUsuarios[i]);
            menuUsuarios.add(mi);
        }
        barraMenu.add(menuUsuarios);
        //barraMenu.add(new JSeparator());
        
        menuProductosNuevos=new JMenu();
        menuProductosNuevos.setText("Productos Nuevos");
        barraMenu.add(menuProductosNuevos);
        //barraMenu.add(new JSeparator());
        
        menuProductos=new JMenu();
        menuProductos.setText("Productos");
        for(int i=0; i < opcionesProductos.length; ++i) {
            JMenuItem mi = new JMenuItem();
            mi.setText(opcionesProductos[i]);
            menuProductos.add(mi);
        }
        barraMenu.add(menuProductos);
        panelMenu.add(barraMenu);
        panelPrincipal.add(panelMenu);
        c.add(panelPrincipal);
    }
    //Atributos
    
    private JMenuBar barraMenu;
    private JPanel panelPrincipal;
    private JPanel panelMenu;
    
    //Usuarios
    private JMenu menuUsuarios;
    private final String[] opcionesUsuarios = {"Ingresar","Consultar","Actualizar","Inactivar"};
    
    //Productos
    private JMenu menuProductos;
    private JMenu menuProductosNuevos;
    private final String[] opcionesProductos = {"Ingresar","Consultar","Actualizar","Inactivar"};
    
}
