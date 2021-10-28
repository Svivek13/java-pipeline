package app;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import mu.*; 


 public class DatabaseHandler{
 	
 	static Connection con;
 	public static void getConnection(){
		try
	 	{
	 		Class.forName("oracle.jdbc.driver.OracleDriver");
	 		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYS as sysdba","bestcoder091196"); 
	 	}
	 	catch(Exception e)
	 	{
	 		JOptionPane.showMessageDialog(new JDialog()," "+e);
	 	}
	 }

	




	 public void insert(int id,String name)
	 {
	 	try{
	 		getConnection();
	 		String q = "insert into list values(?,?)";
	 		PreparedStatement pst = con.prepareStatement(q);
	 		pst.setInt(1,id);
	 		pst.setString(2,name);
	 		pst.executeUpdate();
            Sound.success();
	 		JOptionPane.showMessageDialog(new JDialog(),"1 Record Added");
	    }
	    catch(IllegalArgumentException e)
	    {
	    	Sound.failure();
			JOptionPane.showMessageDialog(new JDialog(),"Invalid ID or name");
	    }
	    catch(Exception e)
	    {
	    	Sound.failure();
	    	JOptionPane.showMessageDialog(new JDialog(),"Record Already Exists");
	    }
	 }   
	                    //Insert ends
	 




	 public String query()
	 {
	 	StringBuilder sb = new StringBuilder();

 		try{
 			  getConnection();

 			  Statement s = con.createStatement();
 			  ResultSet rs = s.executeQuery("select rollno,name from list");
 			  sb.append("ID: "+"\t"+"NAME: "+"\n");
 			  while(rs.next())
              {
 				  sb.append(" "+rs.getInt(1) +"  \t" + rs.getString(2)+"\n");
 			  }
 
 			  rs.close();
 		}
 		catch(SQLException e){
 			JOptionPane.showMessageDialog(new JDialog()," "+e);
 		}
 		return sb.toString();
 	}

 	





 	public void delete(int id)
 	{
 		try{
 			getConnection();
	    	String q = "delete from list where rollno = ?";
	    	PreparedStatement pst = con.prepareStatement(q);
	        pst.setInt(1,id);
	        int i = pst.executeUpdate();

	        if(i==0)
	        throw new Exception();
	        
	        Sound.success();
	        JOptionPane.showMessageDialog(new JDialog(), "Record Successfully Deleted");
			
	    	
	    }
	    catch(Exception e)
	    {
	    	Sound.failure();
	    	JOptionPane.showMessageDialog(new JDialog()," Record does not exist.");
	    	//System.out.println(e);
	    	
	    	
	    }
 	}

 	


 	public void modify(int id,String s)
 	{
 		String q = "update list set name=? where rollno = ?";

 		
	    try{
	    	 getConnection();
			PreparedStatement pst = con.prepareStatement(q);
	        pst.setString(1,s);
	        pst.setInt(2,id);
	        int i = pst.executeUpdate();

	        if(i==0)
	        	throw new Exception();
	        Sound.success();
	        JOptionPane.showMessageDialog(new JDialog(), "Record Successfully Updated");
							    
	    	
	    }
	    catch(Exception e)
	    {
	    	Sound.failure();
	    	JOptionPane.showMessageDialog(new JDialog()," Record does not exists.");
	    	
	    }
 	}
 } 