package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import app.*;


public class ViewFrame extends JFrame{
JTextArea t;
JScrollPane sp;

		public ViewFrame(){
				super("View All Employees");
				setSize(500,200);
				setResizable(false);

				t=new JTextArea(10,10);
				t.setEditable(false);

				sp=new JScrollPane(t);
				sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

				add(sp);

				DatabaseHandler db = new DatabaseHandler();
				t.setText(db.query());

				setLocationRelativeTo(null);
				setVisible(true);

				addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent we){
				HomeFrame h = new HomeFrame();
				dispose();
				}
				});
		}

}
			
