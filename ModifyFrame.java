package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import app.*;
import mu.*; 


public class ModifyFrame extends JFrame{
	JPanel jp1,jp2;
	JButton modify,close;
	JLabel l1,l2;
	JTextField t1,t2;

		public ModifyFrame(){
				super("Update Employee");
				setSize(500,200);
				setResizable(false);

				jp1=new JPanel();
				jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));

				modify=new JButton("Update");
				close=new JButton("Close");
				l1=new JLabel("Employee Id:");
				l2=new JLabel("Employee Name:");
				t1=new JTextField(5);
				t2=new JTextField(10);
				jp1.add(l1);
				jp1.add(t1);
				jp1.add(l2);
				jp1.add(t2);
				add(jp1);

				jp2=new JPanel();						//buttons for adding or closing the frame
				jp2.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
				jp2.add(modify);
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

				modify.addActionListener(new ActionListener(){
					
					public void actionPerformed(ActionEvent ae){
						
						String id = t1.getText();
						String name = t2.getText();
						if((id.length()==0)||(name.length()==0))
						{
							Sound.failure();
							JOptionPane.showMessageDialog(new JDialog(), "Please fill all the fields");
							return;
						}
						try
						{									//Validation
								int a = Integer.parseInt(id);
								char[] chars = name.toCharArray();

								    for (char c : chars) {
								        if(!Character.isLetter(c)) {
								            throw new Exception();
								        }
								    }

								
								DatabaseHandler db = new DatabaseHandler();
								db.modify(a,name);
								t1.requestFocus();

						}
						catch(NumberFormatException nf)
						{
							Sound.failure();
							JOptionPane.showMessageDialog(jp1,"Please enter a number in the Employee id field");	
						}
						catch(Exception e)
						{
							Sound.failure();
							JOptionPane.showMessageDialog(jp1,"Please enter alphabet only in the Employee name field");
						}

						t1.setText("");t2.setText("");

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
	
