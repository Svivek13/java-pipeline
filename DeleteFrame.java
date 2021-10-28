package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import app.*;
import mu.*; 


public class DeleteFrame extends JFrame{
	JPanel jp1,jp2;
	JButton delete,close;
	JLabel l1;
	JTextField t1;

		public DeleteFrame(){
				super("Delete Employee");
				setSize(500,200);
				setResizable(false);

				jp1=new JPanel();
				jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

				delete=new JButton("Delete");
				close=new JButton("Close");
				l1=new JLabel("Employee Id:");
				t1=new JTextField(5);
				jp1.add(l1);
				jp1.add(t1);
				add(jp1);

				jp2=new JPanel();						//buttons for adding or closing the frame
				jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
				jp2.add(delete);
				jp2.add(close);
				add(jp2,BorderLayout.SOUTH);

				setLocationRelativeTo(null);
				setVisible(true);

				addWindowListener(new WindowAdapter(){				//event handling
					
					public void windowClosing(WindowEvent we){
					HomeFrame h = new HomeFrame();
					dispose();
					}

				});

				delete.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent ae){
						
						String id = t1.getText();
						
						if(id.length()==0)
						{
							Sound.failure();
							JOptionPane.showMessageDialog(new JDialog(), "Please fill all the fields");
							return;
						}
						try
						{									//Validation
								int a = Integer.parseInt(id);
								
								DatabaseHandler db = new DatabaseHandler();
								db.delete(a);
								t1.requestFocus();
						}
						catch(NumberFormatException nf)
						{
							Sound.failure();
							JOptionPane.showMessageDialog(jp1,"Please enter a number in the Employee id field");	
						}
						
						t1.setText("");

						}
					});



				//Close Button
					close.addActionListener(new ActionListener(){
					
						public void actionPerformed(ActionEvent ae){
                                
                                 new HomeFrame();
                                 dispose();
                        }
                    });


		}
}
	
