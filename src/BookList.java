import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class BookList {
    ArrayList<Book> list;
    public BookList(){
        list = new ArrayList();
    }
    public void displayAll(){
        AuthorList objB = new AuthorList();
        objB.loadAuthorFromFile("ListAuthor.dat");
        for(Book book : list){                        
            System.out.print(book);
            objB.searchAuthorID(book.getA().getAuthorID());         
    }
}
    
    public void addBook(Book book){
        AuthorList objB = new AuthorList();       
        objB.loadAuthorFromFile("AuthorList.dat");        
        if(searchISBN(book.getISBN()) != null){
            System.out.println("Book existed, please check again");
        }else{
            if(objB.check(book.getA().getAuthorID()) == true){
                     list.add(book);                     
                     System.out.println("Added");
            }else{
                System.out.println("Faild. Author doesn't exist!");
            }
        }
    }
    
    public Book searchISBN(String ISBN){
        for (Book book : list) {
            if(book.getISBN().equalsIgnoreCase(ISBN))
                return book;
        }
        return null;
    }
    
    public ArrayList<Book> searchBook(String title){
        ArrayList<Book> results = new ArrayList<>();
        for(Book book : list){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()))                
                results.add(book);               
        }
        return results;
    }
    
    public ArrayList<Book> searchAuthor(String name){
        AuthorList objB = new AuthorList();
        objB.loadAuthorFromFile("ListAuthor.dat");
        ArrayList<Book> result2 = new ArrayList<>();
        ArrayList<String> tam = objB.searchBook(name);
        for(Book book : list){
                if(tam.contains(book.getA().getAuthorID()))
                result2.add(book);           
            }                     
        return result2;
    }
    
    public void printResult(ArrayList<Book> books){
        AuthorList objB = new AuthorList();
        objB.loadAuthorFromFile("ListAuthor.dat");
        for (Book book : books){
                System.out.print(book);
                objB.searchAuthorID(book.getA().getAuthorID());
        }
    }
    
    public void removeBook(String ISBN){
        Book kq = searchISBN(ISBN);
        if(kq != null){
            list.remove(kq);
            System.out.println("Delete Successfully");
        }else{
            System.out.println("Not Found");
        }
    }

    public Book searchByAuthorID(String authorID){
        AuthorList objB = new AuthorList();
        objB.loadAuthorFromFile("ListAuthor.dat");        
        for (Book book : list) {
            if(book.getA().getAuthorID().equalsIgnoreCase(authorID))
            return book;
        }
        return null;
    }
    
    public void loadBookFromFile(String fName){
        try{
            File f = new File(fName);
            if(!f.exists())
                return;
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(fis.available()>0){
                Book obj = (Book)ois.readObject();
                list.add(obj);
            }
            fis.close();
            ois.close();
        }
        catch(Exception e){
            
        }
    }
    
    public void savetoFile(String fName){
        try{
            FileOutputStream f = new FileOutputStream(fName);
            ObjectOutputStream fo = new ObjectOutputStream(f);
            for (Book book : list) {
                fo.writeObject(book);
            }
            fo.close();
            f.close();
        }catch(Exception e){
            
        }
    }
    
    public void updateBook(String ISBN){
        AuthorList objB = new AuthorList();
        objB.loadAuthorFromFile("ListAuthor.dat");
        Book kq = searchISBN(ISBN);
        if(kq == null){
            System.out.println("Not Found! ");
        }else{
            kq.update();
            if(objB.check(kq.getA().getAuthorID()) == true){
                System.out.println("Updated");
            }else{
                System.out.println("Not Updated");
                while(objB.check(kq.getA().getAuthorID()) == true){
                    System.out.println("Enter Again");
                    kq.update();
                    if(objB.check(kq.getA().getAuthorID()) == true){
                        System.out.println("Updated");
                    }else{
                        System.out.println("Not Updated");
                    }
                }
            }           
        }
    }
}
