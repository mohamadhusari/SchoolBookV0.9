package SchoolAdmin;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import OurMessage.Message;
import OurMessage.QTypes;
import chat.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class RequestPanel extends JPanel {
	public JTable table;
	public JLabel lblRequestDone;
	
	
	public RequestPanel() {
		setLayout(null);
		table = new JTable(){  
		       public boolean isCellEditable(int row,int column){  
		           Object o = getValueAt(row,column);  
		           if(o!=null) return false;  
		           return true;  
		         }  
		       }; 
		       
		       
		String [] colName={"idRequests", "idStudent", "idCourse", "idClass", "aprove", "type"};
		Object [][] rows={};
		  DefaultTableModel model = new DefaultTableModel(rows,colName);
		  
		  table.setModel(model);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(213, 11, 417, 258);
		add(table);
		
		JButton btnDeny = new JButton("Deny");
		btnDeny.setBackground(Color.RED);
		btnDeny.setBounds(424, 280, 89, 23);
		add(btnDeny);
		
		JButton btnApprove = new JButton("Approve");
		btnApprove.setBackground(Color.GREEN);
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=table.getSelectedRow();
				int id =Integer.parseInt(table.getValueAt(index, 1).toString());
				System.out.println(id);
				String Query="UPDATE requests SET aprove='Approved' WHERE idStudent="+id+";";
				Message msg=new Message(Query,QTypes.updateBlockRequest);
				Client.client.handleMessageFromClientUI(msg);
				
				
			}
		});
		btnApprove.setBounds(308, 280, 89, 23);
		add(btnApprove);
		
		 lblRequestDone = new JLabel("Request Done");
		lblRequestDone.setVisible(false);
		
		lblRequestDone.setBounds(223, 280, 97, 23);
		add(lblRequestDone);

	}
	
//	public void updatelbl(){
//		lblRequestDone=new JLabel("Request Done");
//		
//	}
}
