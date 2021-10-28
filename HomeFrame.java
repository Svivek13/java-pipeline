
package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import app.*;

public class HomeFrame extends JFrame{

	public JButton add,view,delete,modify;
	JPanel jp;
	public HomeFrame()
	{
			        setVisible(true);                                                   //JFrame properties starts
				setLocationRelativeTo(null);
				setSize(500,150);
				setTitle("Employee Records Management");
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                      //JFrame properties ends
				
				createAndAddButtons(); 
				    								     //Creates buttons and add to JPanel
                		add(jp);                       										 //Adds the JPanel to JFrame


				
	}

	public void createAndAddButtons()
    {
				add = new JButton("Add");   
			        view = new JButton("View");
				delete = new JButton("Delete");
				modify = new JButton("Modify");
				
				jp = new JPanel();
				jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
				//Add all buttons to JPanel
				jp.add(add);
				jp.add(view);
				jp.add(delete);
				jp.add(modify);

				//Adds Action Listeners
				add.addActionListener(new ListenIt());
				view.addActionListener(new ListenIt());
				delete.addActionListener(new ListenIt());
				modify.addActionListener(new ListenIt());
	}
	

	class ListenIt implements ActionListener
	{
			public void actionPerformed(ActionEvent a)
				{
				if(a.getSource() == add)
			        new AddFrame();                                //Open window of Add Frame
			        else if(a.getSource() == view)
			        new ViewFrame();                               //Open window of View Frame
			        else if(a.getSource() == delete)
			        new DeleteFrame();                             //Open window of Delete Frame
			        else if(a.getSource() == modify)
			        new ModifyFrame();                                //Open window of Modify Frame
			        	
			        dispose();                                     //Close Current Home Frame Window 
				
				}
	}



	public static void main(String a[])
    {
				HomeFrame h = new HomeFrame();
	}
}
