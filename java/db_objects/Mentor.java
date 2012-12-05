/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db_objects;

import java.io.Serializable;

/**
 *
 * @author Team ParaGoomba
 */
public class Mentor implements Serializable{
    
    private int id;
    private String img;
    private String name;
    private String qual;
    private String email;
    private String comment;
    
    public Mentor()
    {
        id = -1;
        img = null;
        name = "";
        qual = "";
        email = "";
        comment = "";
    }
    
    public Mentor(int id, String img, String name, String qual, String email, String comment)
    {
        this.id = id;
        this.img = img;
        this.name = name;
        this.qual = qual;
        this.email = email;
        this.comment = comment;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    
        
    public int getId()
    {
        return id;
    }
    
    public void setImg(String img)
    {
        this.img = img;
    }
    
    public String getImg()
    {
        return img;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setQual(String qual)
    {
        this.qual = qual;
    }
    
    public String getQual()
    {
        return qual;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setComment(String comment)
    {
        this.comment = comment;
    }
    
    public String getComment()
    {
        return comment;
    }
}
