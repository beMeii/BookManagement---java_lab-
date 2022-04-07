import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class Author implements Serializable{
    private String authorID;
    private String name;
    public Author(){
        authorID = "";
        name = "";
    }

    public Author(String authorID, String name) {
        this.authorID = authorID;
        this.name = name;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void input(){
        Scanner sc = new Scanner(System.in);
        boolean connhap = false;
        do{
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter Author's ID:");
                authorID = sc.nextLine().toUpperCase();
                if(authorID.equalsIgnoreCase(""))
                    throw new Exception();
                    connhap = false;
            } catch (Exception ex) {
                System.out.println("Enter Again");
                connhap = true;
            }
        }while(connhap);
    }

    @Override
    public String toString() {
        return ", authorID=" + authorID + ", name=" + name;
    }
    
}
