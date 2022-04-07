import com.sun.jndi.toolkit.dir.SearchFilter;
import java.util.ArrayList;
import java.util.List;
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
public class Tester {
    public static void main(String[] args) {
        int choice = 0;
        boolean connhap = false;
        Scanner sc = new Scanner(System.in);
        BookList obj = new BookList();
        String fName = "bookList.dat";
        obj.loadBookFromFile(fName);
        AuthorList objB = new AuthorList();
        objB.loadAuthorFromFile("ListAuthor.dat");
        objB.displayAll();
        System.out.println("\n----------------------------\n");
        do{
            System.out.println("-HKT BOOK STORE MANAGEMENT-");
            System.out.println("1/ Show the book list");
            System.out.println("2/ Add new book");
            System.out.println("3/ Update book");
            System.out.println("4/ Delete book");
            System.out.println("5/ Search book");
            System.out.println("6/ Store data to file");
            System.out.println("7/ Delete author");
            System.out.println("8/ Exit");
            System.out.println("Enter your choice");
            do{
                try {
                    sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    if(choice < 0 || choice > 9)
                        throw new Exception();
                        connhap = false;
                } catch (Exception ex) {
                    System.out.println("Enter Again");
                    connhap = true;
                }
            }while(connhap);
            switch(choice){
        case 1:     
                    obj.displayAll();                    
                    break;
                    
//      --------------------- ADD BOOK -----------------------
                    
        case 2:
                    Book tmp = new Book();
                    String Choice2 = "";
                    tmp.input();
//                    
                    obj.addBook(tmp);
                    System.out.println("Do you want to continue adding please enter {y} or return to the menu please enter {n}");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice2 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice2) && !"n".equalsIgnoreCase(Choice2))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                    while("y".equalsIgnoreCase(Choice2)){
                        tmp = new Book();
                        tmp.input();
//
                        obj.addBook(tmp);                       
                        System.out.println("Do you want to continue adding please enter {y} or return to the menu please enter {n}");
                        do{
                            try {
                                sc = new Scanner(System.in);
                                Choice2 = sc.nextLine();
                                if(!"y".equalsIgnoreCase(Choice2) && !"n".equalsIgnoreCase(Choice2))
                                    throw new Exception();
                                    connhap = false;
                            } catch (Exception ex) {
                                System.out.println("Enter Again");
                                connhap = true;
                            }
                        }while(connhap);
                    }
                    break;
//      -------------------- UPDATE BOOK ----------------------------
        case 3:
                    String bookCanUpdate = "";
                    String Choice3 = "";
                    do{
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter Book's ISBN to Update");
                            bookCanUpdate = sc.nextLine().toUpperCase();
                            if(bookCanUpdate.equalsIgnoreCase(""))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    obj.updateBook(bookCanUpdate);    
                    
                    System.out.println("Do you want to continue updating please enter {y} or return to the menu please enter {n} ");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice3 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice3) && !"n".equalsIgnoreCase(Choice3))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                    while("y".equalsIgnoreCase(Choice3)){
                    do{
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter Book's ISBN to Update");
                            bookCanUpdate = sc.nextLine().toUpperCase();
                            if(bookCanUpdate.equalsIgnoreCase(""))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    obj.updateBook(bookCanUpdate);
                    System.out.println("Do you want to continue updating please enter {y} or return to the menu please enter {n} ");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice3 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice3) && !"n".equalsIgnoreCase(Choice3))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                }
                    break;
//      ---------------- DELETE BOOK ----------------------                     
        case 4:
                    String bookCanXoa = "";
                    String Choice4 = "";
                    String userChoice = "";
                    do{
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter Book's ISBN to Delete");
                            bookCanXoa = sc.nextLine().toUpperCase();
                            if(bookCanXoa.equalsIgnoreCase(""))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    if(obj.searchBook(bookCanXoa) != null){
                        System.out.println("Do you really want to delete it, please enter {y} or no please enter {n}");
                        do{
                            try {
                                sc = new Scanner(System.in);
                                userChoice = sc.nextLine();
                                if(!"y".equalsIgnoreCase(userChoice) && !"n".equalsIgnoreCase(userChoice))
                                    throw new Exception();
                                    connhap = false;
                            } catch (Exception ex) {
                                System.out.println("Enter Again");
                                connhap = true;
                            }
                        }while(connhap);
                        if("y".equalsIgnoreCase(userChoice)){
                            obj.removeBook(bookCanXoa);                            
                        }
                    }
                    else{
                        System.out.println("Not Found");
                    }
                    System.out.println("Do you want to continue removing please enter {y} or return to the menu please enter {n}");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice4 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice4) && !"n".equalsIgnoreCase(Choice4))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                    while("y".equalsIgnoreCase(Choice4)){
                    do{
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter Book's ISBN to Delete");
                            bookCanXoa = sc.nextLine().toUpperCase();
                            if(bookCanXoa.equalsIgnoreCase(""))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    if(obj.searchBook(bookCanXoa)!= null){
                        System.out.println("Do you really want to remove it please enter {y} or no please enter {n}");
                        do{
                            try {
                                sc = new Scanner(System.in);
                                userChoice = sc.nextLine();
                                if(!"y".equalsIgnoreCase(userChoice) && !"n".equalsIgnoreCase(userChoice))
                                    throw new Exception();
                                    connhap = false;
                            } catch (Exception ex) {
                                System.out.println("Enter Again");
                                connhap = true;
                            }
                        }while(connhap);
                        if("y".equalsIgnoreCase(userChoice)){
                            obj.removeBook(bookCanXoa);
                        }  
                    }
                    else {
                        System.out.println("Not Found");
                    }
                    System.out.println("Do you want to continue removing please enter {y} or return to the menu please enter {n}");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice4 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice4) && !"n".equalsIgnoreCase(Choice4))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                }
                    break;
//      ------------------- SEARCH BOOK -----------------------------
        case 5:            
            System.out.println("1/ Search by book title:");
            System.out.println("2/ Search by author name:");  
            System.out.println("3/ Exit");
            System.out.println("Enter your choice:");
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
                
//        ------------------- SEARCH BY BOOK TITLE --------------------------

                    case 1: 
                        String bookCanTim = "";
                        String Choice5 = "";
                    do{
                    try {
                        sc = new Scanner(System.in);
                        System.out.println("Enter Book's Title to Search");
                        bookCanTim = sc.nextLine().toUpperCase();
                        if(bookCanTim.equalsIgnoreCase(""))
                            throw new Exception();
                            connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    ArrayList<Book> kq = obj.searchBook(bookCanTim);
                    if(obj.searchBook(bookCanTim).isEmpty()){
                        System.out.println("Book does't exist");
                    }else{
                        System.out.println("Books are found:");
                        obj.printResult(kq);
                    }
                    System.out.println("Do you want to continue searching please enter {y} or return to menu please enter {n}");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice5 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice5) && !"n".equalsIgnoreCase(Choice5)) 
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                    while("y".equalsIgnoreCase(Choice5)){
                    do{
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter Book's Title to Search");
                            bookCanTim = sc.nextLine().toUpperCase();
                            if(bookCanTim.equalsIgnoreCase(""))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    ArrayList<Book> kq2 = obj.searchBook(bookCanTim);
                    if(obj.searchBook(bookCanTim).isEmpty()){
                        System.out.println("Book does't exist");
                    }else{
                        System.out.println("Books are found:");
                        obj.printResult(kq2);
                    }
                    System.out.println("Do you want to continue searching please enter {y} or return to menu please enter {n}");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice5 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice5) && !"n".equalsIgnoreCase(Choice5)) 
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                }
                   break; 
                   
//        ------------------- SEARCH BY AUTHOR --------------------------
                   
                    case 2:                    
                    String authorCanTim = "";
                    do{
                    try {
                        sc = new Scanner(System.in);
                        System.out.println("Enter Author's Name to Search:");
                        authorCanTim = sc.nextLine().toUpperCase();
                        if(authorCanTim.equalsIgnoreCase(""))
                            throw new Exception();
                            connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//                 
                    ArrayList<Book> result = obj.searchAuthor(authorCanTim);
                    if(result.isEmpty()){
                        System.out.println("Not found");
                    }else{
                        obj.printResult(result);
                    }                                      
            }
 
                    break;
                    
//      ---------------- STORE BOOKLIST -------------------
                    
        case 6:
                    String fName2 = "bookList.dat";
                    obj.savetoFile(fName2);
                    System.out.println("Save Successfully !");
                    break;
//      ---------------- DELETE AUTHOR --------------------                    
        case 7:
                    String authorCanXoa = "";
                    String Choice7 = "";
                    String userChoiceA = "";
                    do{
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter Book's AuthorID to Delete");
                            authorCanXoa = sc.nextLine().toUpperCase();
                            if(authorCanXoa.equalsIgnoreCase(""))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    if(obj.searchByAuthorID(authorCanXoa) == null){
                        System.out.println("Do you really want to delete it, please enter {y} or no please enter {n}");
                        do{
                            try {
                                sc = new Scanner(System.in);
                                userChoiceA = sc.nextLine();
                                if(!"y".equalsIgnoreCase(userChoiceA) && !"n".equalsIgnoreCase(userChoiceA))
                                    throw new Exception();
                                    connhap = false;
                            } catch (Exception ex) {
                                System.out.println("Enter Again");
                                connhap = true;
                            }
                        }while(connhap);
                        if("y".equalsIgnoreCase(userChoiceA)){ 
                            objB.removeAuthor(authorCanXoa);
                            objB.displayAll();
            // luu file tu don
                            String fNameA = "AuthorList.dat";
                            objB.saveFile(fNameA);
                        }
                    }
                    else{
                        System.out.println("The author has books in list. Enter again!");
                    }
                    System.out.println("Do you want to continue removing please enter {y} or return to the menu please enter {n}");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice7 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice7) && !"n".equalsIgnoreCase(Choice7))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                    while("y".equalsIgnoreCase(Choice7)){
                    do{
                        try {
                            sc = new Scanner(System.in);
                            System.out.println("Enter Book's AuthorID to Delete");
                            authorCanXoa = sc.nextLine().toUpperCase();
                            if(authorCanXoa.equalsIgnoreCase(""))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
//
                    if(obj.searchByAuthorID(authorCanXoa)== null){
                        
                        System.out.println("Do you really want to remove it please enter {y} or no please enter {n}");
                        do{
                            try {
                                sc = new Scanner(System.in);
                                userChoiceA = sc.nextLine();
                                if(!"y".equalsIgnoreCase(userChoiceA) && !"n".equalsIgnoreCase(userChoiceA))
                                    throw new Exception();
                                    connhap = false;
                            } catch (Exception ex) {
                                System.out.println("Enter Again");
                                connhap = true;
                            }
                        }while(connhap);
                        if("y".equalsIgnoreCase(userChoiceA)){
//                            
                            objB.removeAuthor(authorCanXoa);
                            objB.displayAll();
            // luu file tu don
                            String fNameA = "AuthorList.dat";
                            objB.saveFile(fNameA);
                        }  
                    }
                    else {
                        System.out.println("The author has books in list. Enter again!");

                    }
                    System.out.println("Do you want to continue removing please enter {y} or return to the menu please enter {n}");
                    do{
                        try {
                            sc = new Scanner(System.in);
                            Choice7 = sc.nextLine();
                            if(!"y".equalsIgnoreCase(Choice7) && !"n".equalsIgnoreCase(Choice7))
                                throw new Exception();
                                connhap = false;
                        } catch (Exception ex) {
                            System.out.println("Enter Again");
                            connhap = true;
                        }
                    }while(connhap);
                }
            
            break;
            
            }
            
        }while(choice <= 8);
    
    }
}
