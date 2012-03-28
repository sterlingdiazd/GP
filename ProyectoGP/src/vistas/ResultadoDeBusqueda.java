package vistas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import tableModels.UserTableModel;
import controladores.ControladorAdministrador;
import controladores.ControladorGenerico;

public class ResultadoDeBusqueda extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTable table;
    private ArrayList<Object> allUsers;
    private ControladorGenerico controlador;
    private String usuarioBuscado;

    public ResultadoDeBusqueda(String usuarioBuscado) {
    	setResizable(false);
    	setTitle("Resultados de Busqueda");
    	setModal(true);
    	setResizable(false);
    	initComponents(usuarioBuscado);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    public void initComponents(String usuarioBuscado){
	setBounds(100, 100, 867, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(null, "Resultados Encontrados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panel.setBounds(10, 11, 841, 250);
	contentPanel.add(panel);
	panel.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 33, 821, 206);
	panel.add(scrollPane);
	
	controlador = new ControladorAdministrador();
    	allUsers = new ArrayList<Object>();
	allUsers = controlador.buscarPorAtributoPrincipal(usuarioBuscado);
	
	UserTableModel userTableModel = new UserTableModel(allUsers);
	
	table = new JTable();
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	table.setAlignmentX(Component.CENTER_ALIGNMENT);
	table.setAutoCreateRowSorter(true);
	scrollPane.setViewportView(table);
	table.setModel(userTableModel);
    }
}
