package dk.E5ASU.Lasse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;


public class main extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		File beer_data = new File("C:\\Users\\lager\\Dropbox\\beer_data.xls");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table_1 = new JTable(model);
		table_1.setBounds(0, 0, 765, 262);
		
		model.addColumn("Navn//Drikkevarer"); 
		model.addRow(new Object [] {"Navn//Drikkevarer"});
		
		JPanel panel_buttons = new JPanel();
		panel_buttons.setBounds(5, 5, 100, 262);
		panel_buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TabletoExcel(table_1,beer_data);
			}
		});
		panel_buttons.add(btnSave);
		
		JButton btnAddRow = new JButton("Add row");
		panel_buttons.add(btnAddRow);
		
		JButton btnAddColumn = new JButton("Add column");
		panel_buttons.add(btnAddColumn);
		
		/*JButton btnRemoveColumn = new JButton("Remove column");
		btnRemoveColumn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//model.removeColumn(model.getColumnCount() - 1);
			}
		});*/
		
		JButton btnRemoveRow = new JButton("Remove row");
		btnRemoveRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.removeRow(model.getRowCount() - 1);

			}
		});
		panel_buttons.add(btnRemoveRow);
		contentPane.setLayout(null);
		contentPane.add(panel_buttons);
		
		JPanel panel = new JPanel();
		panel.setBounds(109, 5, 775, 262);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.add(table_1);
		
		//panel.add(btnRemoveColumn);
		
		btnAddColumn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addColumn("Drikkevarer");
				
			}
		});
		btnAddRow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addRow(new Object [] {"Navn"});
				
			}
		});
	}


	//Not mine taken from "https://sites.google.com/site/teachmemrxymon/java/export-records-from-jtable-to-ms-excel"
	public void TabletoExcel(JTable table, File file){
		try{
			TableModel model = table.getModel();
			FileWriter excel = new FileWriter(file);

			for(int i = 0; i < model.getColumnCount(); i++){
				excel.write(model.getColumnName(i) + "\t");
				}
			excel.write("\n");

			for(int i=0; i< model.getRowCount(); i++) {
				for(int j=0; j < model.getColumnCount(); j++) {
					excel.write(model.getValueAt(i,j).toString()+"\t");
					}
				excel.write("\n");
				}

			excel.close();

		}catch(IOException e){ System.out.println(e); }
}
}