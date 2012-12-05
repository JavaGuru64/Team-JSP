/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import db_objects.Mentor;
import java.util.ArrayList;
/**
 *
 * @author Team ParaGoomba
 */
public class MentorIO {
    
    private static DB mydb = new DB();
    
    public static ArrayList<Mentor> listMentors()
    {
        // just in case I need to do some data checking
        ArrayList<Mentor> mentors = mydb.getMentors();
        if(!mentors.isEmpty()){
            return mentors;
        }
        
        mentors.add(new Mentor(0, "no_image.jpg", "NO ONE HERE", "", "", ""));
        return mentors;
    }
            
    public static void addMentor(Mentor m)
    {
        mydb.addMentor(m);
    }
    
    public static void updateMentor(Mentor m)
    {
        mydb.updateMentor(m);
    }
    
    public static void removeMentor(int id)
    {
        mydb.removeMentor(id);
    }         
}
