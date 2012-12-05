/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_objects;
import java.io.Serializable;

/**
 *
 * @author jTeam ParaGoomba
 */
public class Admin implements Serializable{
    
    private String name;
    private String pw;
    
    public Admin()
    {
        name = "";
        pw = "";
    }
    
    public Admin(String name, String pw)
    {
        this.name = name;
        this.pw = pw;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    
    public void setPw(String pw)
    {
        this.pw = pw;
    }
    public String getPw()
    {
        return pw;
    }
}
