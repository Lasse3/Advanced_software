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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;


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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		DefaultTableModel model = new DefaultTableModel(); 
		JTable table = new JTable(model); 
		table.setBounds(104, 0, 340, 257);

	
		model.addColumn("Navn//Drikkevarer"); 
		model.addRow(new Object [] {"Navn//Drikkevarer"});
		contentPane.setLayout(null);
		contentPane.add(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 100, 262);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnAddRow = new JButton("Add row");
		panel.add(btnAddRow);
		
		JButton btnAddColumn = new JButton("Add column");
		panel.add(btnAddColumn);
		
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
		panel.add(btnRemoveRow);
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
}
