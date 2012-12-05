/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import db_objects.Admin;
import java.util.ArrayList;

/**
 *
 * @author Team ParaGoomba 
 */
public class AdminIO {
    
    static DB mydb = new DB();
    
    public static boolean isValidAdmin(String name, String pw)
    {
        ArrayList<Admin> admins = mydb.getAdmins();
        
        if(!admins.isEmpty())
        {
            for(Admin admin: admins)
            {
                if(admin.getName().equals(name) && admin.getPw().equals(pw))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
