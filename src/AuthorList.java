
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */
public class AuthorList {

    ArrayList<Author> list2;

    public AuthorList() {
        list2 = new ArrayList<>();
    }

    public void loadAuthorFromFile(String fName) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fName)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String authorID = parts[0];
                String name = parts[1];
                Author newAuthor = new Author(authorID.toUpperCase(), name.toUpperCase());
                list2.add(newAuthor);
            }
        } catch (Exception e) {

        }
    }
    
    public void saveFile(String fName) {
        if (list2.size() == 0) {
            System.out.println("Empty list.");
            return;
        }
        try {
            File f = new File(fName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(f);
            for (Author a : list2) {
                pw.println( a.getName() +", " + a.getAuthorID());
            }
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public boolean check(String authorID){
        for (Author author : list2) {
            if(author.getAuthorID().equalsIgnoreCase(authorID))
                return true;
            }
        return false;
    }
    
    public Author searchAuthorID(String authorID){
        for (Author author : list2) {
            if(author.getAuthorID().equalsIgnoreCase(authorID)){
                System.out.println(author);
                return author;               
            }
        }
        return null;
    }
    public Author searchAuthorName(String name){
        for (Author author : list2) {
            if(author.getName().contains(name)){
                return author;
            }
        }
        return null;
    }
    public ArrayList<String> searchBook(String name){
        ArrayList<String> results = new ArrayList<>();
        for (Author author : list2) {
            if(author.getName().contains(name))
                results.add(author.getAuthorID());
        }
        return results;
    }
    
    public void displayAll(){
        for(Author a : list2)
            System.out.println("Author ID: " +a.getAuthorID() + "  Author's name: "+a.getName());
    }
    
    public void removeAuthor(String authorID){
        Author kq = searchAuthorID(authorID);
        if(kq != null){
            list2.remove(kq);
            System.out.println("AuthorList after delete:");
        }else{
            System.out.println("Author doesn't existed!");
        }
    }
}
