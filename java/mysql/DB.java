/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import db_objects.*;
import java.sql.*;

import java.util.ArrayList;

/**
*
* @author Team ParaGoomba
*/
public class DB {
    private Connection connect = null;
    private String dbURL = "database url";
    private String username = "db username";
    private String password = "db password";

    /**
    * DB Constructor
    */
    public DB()
    {
        getConnection();
    }
	  
    /**
    * Starts a connection with the database. Called by constructor.
    */
    private void getConnection()
    {
        try
	{
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(dbURL, username, password);
	}
	catch (Exception e)
	{
            System.out.println("Exception thrown calling getConnection.\n" + e.getMessage());
        }
    }
    
    public ArrayList<Admin> getAdmins()
    {
        ArrayList<Admin> result = new ArrayList<Admin>();
	PreparedStatement ps = null;
	ResultSet rs = null;	
	try
	{
            String q = "SELECT admin_name, admin_password FROM admin";
            ps = connect.prepareStatement(q);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                result.add(new Admin(rs.getString("admin_name"), rs.getString("admin_password")));
            }   
            
            ps.close();
            rs.close();
	}
	catch(Exception e)
	{
            //System.out.println("QUERY: " + ps.toString());
            System.out.println("Error: " + e);
            
	}
		
	return result;
    }
    
    
    public ArrayList<Mentor> getMentors()
    {
        ArrayList<Mentor> result = new ArrayList<Mentor>();
	PreparedStatement ps = null;
	ResultSet rs = null;	
        
	try
	{

            String q = "SELECT mentor_id, img, name, email, m_comment FROM mentor";
            ps = connect.prepareStatement(q);
            rs = ps.executeQuery();
            
            
            while(rs.next())
            {
                // Change database
                result.add(new Mentor(rs.getInt("mentor_id"), 
                        rs.getString("img"), rs.getString("name"), "", rs.getString("email"), rs.getString("m_comment")));
            }   
            
            q = "SELECT mentor_id, qual FROM qualify";
            ps = connect.prepareStatement(q);
            rs = ps.executeQuery();
            
            
            while(rs.next())
            {
                for(Mentor m: result)
                {
                    if(m.getId() == rs.getInt("mentor_id"))
                    {
                        m.setQual(m.getQual() + rs.getString("qual") + ", ");
                    }
                }
            }
            
            for(Mentor m: result)
            {
                m.setQual(m.getQual().substring(0, m.getQual().length()-2));
            }
            
            ps.close();
            rs.close();
	}
	catch(Exception e)
	{
            //System.out.println("QUERY: " + ps.toString());
            System.out.println("Error: " + e);
	}
		
	return result;
    }
    
    public void addMentor(Mentor m)
    {
	PreparedStatement ps = null;	
        ResultSet rs = null;
        
	try
	{
            String q = "INSERT INTO mentor VALUES(null, ?, ?, ?, ?)";
            ps = connect.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, m.getName());
            ps.setString(2, m.getEmail());
            ps.setString(3, m.getComment());
            ps.setString(4, m.getImg());
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            
            q = "DELETE FROM qualify WHERE mentor_id = ?";
            ps = connect.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            String[] quals = m.getQual().split(", ");
            
            for(int i=0; i < quals.length; i++)
            {
                System.out.println(quals[i]);
                q = "INSERT INTO qualify VALUES(null, ?, ?)";
                ps = connect.prepareStatement(q);
                ps.setInt(1, id);
                ps.setString(2, quals[i]);
                ps.executeUpdate();
            }
            ps.close();
            rs.close();
            
        }
	catch(Exception e)
        {
            System.out.println("QUERY: " + ps.toString());
            System.out.println("Error: " + e);
	}
    }
    
    public void updateMentor(Mentor m)
    {
	PreparedStatement ps = null;
        
	try
	{
            String q = "UPDATE mentor SET name = ?, email = ?, m_comment = ?, img = ? WHERE mentor_id = ?";
            ps = connect.prepareStatement(q);
            ps.setString(1, m.getName());
            ps.setString(2, m.getEmail());
            ps.setString(3, m.getComment());
            ps.setString(4, m.getImg());
            ps.setInt(5, m.getId());
            ps.executeUpdate();
            
            String[] quals = m.getQual().split(", ");
            
            q = "DELETE FROM qualify WHERE mentor_id = ?";
            ps = connect.prepareStatement(q);
            ps.setInt(1, m.getId());
            ps.executeUpdate();
            
            for(String s: quals)
            {
                q = "INSERT INTO qualify VALUES(null, ?, ?)";
                ps = connect.prepareStatement(q);
                ps.setInt(1, m.getId());
                ps.setString(2, s);
                ps.executeUpdate();
            }
            
            ps.close();
	}
	catch(Exception e)
	{
            System.out.println("QUERY: " + ps.toString());
            System.out.println("Error: " + e);
	}
    }
    
    public void removeMentor(int id)
    {
	PreparedStatement ps = null;
        
	try
	{
            String q = "DELETE FROM mentor WHERE mentor_id = ?";
            ps = connect.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            
            
            q = "DELETE FROM qualify WHERE mentor_id = ?";
            ps = connect.prepareStatement(q);
            ps.setInt(1, id);
            ps.executeUpdate();
            
            
            ps.close();
	}
	catch(Exception e)
	{
            System.out.println("QUERY: " + ps.toString());
            System.out.println("Error: " + e);
	}
    }
}
