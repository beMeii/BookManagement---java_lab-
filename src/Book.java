
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
public class Book implements Serializable{
    public String ISBN;
    public String title;
    public int price;
    public Author a; //has-a 
   
    public Book(){
        ISBN = "";
        title = "";
        price = 0;
        a = new Author();
    }

    public Book(String ISBN, String title, int price, Author a) {
        this.ISBN = ISBN;
        this.title = title;
        this.price = price;
        this.a = a;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public Author getA() {
        return a;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setA(Author a) {
        this.a = a;
    }
        
    public void input(){
        boolean connhap = false;
        Scanner sc = new Scanner(System.in);
        
        do{
            try {
                boolean flag;
                sc = new Scanner(System.in);
                String isbnPattern = "B\\d";
                System.out.println("Enter book's ISBN");
                ISBN = sc.nextLine().toUpperCase();
                flag=ISBN.matches(isbnPattern);
                if(!flag)                   
                    throw new Exception();
                    connhap = false;
            } catch (Exception ex) {
                System.out.println("Enter Again!. Book's ISBN must start Bxxx...");
                connhap = true;
            }
        }while(connhap);
  
        do{
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter book's Title");
                title = sc.nextLine().toUpperCase();
                if("".equalsIgnoreCase(title))
                    throw new Exception();
                    connhap = false;
            } catch (Exception ex) {
                System.out.println("Enter Again");
                connhap = true;
            }
        }while(connhap);
        do{
            try {
                sc = new Scanner(System.in);
                System.out.println("Enter book's Price:");
                price = sc.nextInt();
                if(price <= 0)
                    throw new Exception();
                    connhap = false;
            } catch (Exception ex) {
                System.out.println("Enter Again");
                connhap = true;
            }
        }while(connhap);
        a.input();
    }

    @Override
    public String toString() {
        return "Book:" + "ISBN=" + ISBN + ", title=" + title + ", price=" + price;
    }
    
    public void update(){
            int choice = 0;          
            boolean connhap = false;
            do{            
            Scanner sc = new Scanner(System.in);
            System.out.println("1/ Update title:");
            System.out.println("2/ Update price:");
            System.out.println("3/ Update authorID:");  
            System.out.println("4/ Exit");
            System.out.println("Enter your choice");
            do{
                try {
                    sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    if(choice<=0)
                        throw new Exception();
                        connhap = false;
                } catch (Exception ex) {
                    System.out.println("Enter Again");
                    connhap = true;
                }
            }while(connhap);
            switch(choice){
                case 1:
                        do{
                            try {
                                sc = new Scanner(System.in);
                                System.out.println("Enter book's Title");
                                title = sc.nextLine().toUpperCase();                
                                if("".equalsIgnoreCase(title))
                                    throw new Exception();
                                    connhap = false;
                            } catch (Exception ex) {
                                System.out.println("Enter Again");
                                connhap = true;
                            }
                        }while(connhap);
                   break; 
                   
                case 2:
                        do{
                            try {
                                sc = new Scanner(System.in);
                                System.out.println("Enter book's Price:");
                                price = sc.nextInt();
                                if(price <= 0)
                                    throw new Exception();
                                    connhap = false;
                            } catch (Exception ex) {
                                System.out.println("Enter Again");
                                connhap = true;
                            }
                        }while(connhap);
                    break;
                case 3:
                    a.input();
                    break;
            }
            }while(choice<=3);
}

}
