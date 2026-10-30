package DSA_Project;
import java.util.ArrayList;
import java.util.Scanner;

class Book{
    Integer bookID;
    boolean availability = true;
    String bookName;
    String authorName;

    public Book(Integer bookID,String BookName, String authorName){
        this.bookID = bookID;
        this.bookName = BookName;
        this.authorName = authorName;
    }

}
public class LibraryManagement {
    public static String addBook(ArrayList<Book> books, int id, String title, String author){
        for (Book b: books){
            if (b.bookID == id){
                return "Book already exist!";
            }
        }
        books.add(new Book(id,title,author));
        return "Book added Successfully!";
    }
    public static String searchBook(ArrayList<Book> books, int id){
        for (Book b: books){
            if (b.bookID == id){
                System.out.println("Book Found!");
                if (b.availability) return "Book is available!";
            }
        }
        return "Book not Found...Recheck the ID";
    }
    public static void displayBooks(ArrayList<Book> books){
        if (books.isEmpty()) {
            System.out.println("No books registered yet!");
        }
        else {
            System.out.println("Listing All Books: ");
            for (Book b : books) {

                System.out.println("ID: " + b.bookID +
                        "\nTitle: " + b.bookName +
                        "\nAuthor: " + b.authorName +
                        "\nAvailable: " + b.availability);
                System.out.println();
            }
        }
    }
    public static String issueBook(ArrayList<Book> books, int pbookIssueID){
        for(Book b: books){
            if(b.bookID == pbookIssueID){
                if(!b.availability) return "Book already issued\nRecheck the Book Id";
                else{
                    b.availability = false;
                    return "Book issued successfully!";
                }
            }
        }
        return "Book not Found...Recheck the ID";

    }
    public static String returnBook(ArrayList<Book> books, int pbookIssueID){
        for(Book b: books){
            if(b.bookID == pbookIssueID){
                if(b.availability) return "book already found!\nRecheck the Book Id";
                return "book returned successfully!";
            }
        }
        return "Book not Found...Recheck the ID";
    }
    public static String removeBook(ArrayList<Book> books, int pbookRemoveID){
        for(Book b: books){
            if(b.bookID == pbookRemoveID){
                books.remove(b);
                return "Book Removed successfully!";
            }
        }
        return "Book not Found...Recheck the ID";
    }


    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        boolean check = true;
        while (check){
            System.out.println("====== Library Management System ======\n1. Add Book\n2. Search Book\n3. Display All Books\n4. Issue Book\n5. Return Book\n6. Remove Book\n7. Exit");
            try{
                System.out.print("Enter your choice: ");
                Scanner input = new Scanner(System.in);
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("====== Adding Book ======");
                        System.out.print("Enter Book ID: ");
                        Scanner scAddID = new Scanner(System.in);
                        int addID = scAddID.nextInt();
                        System.out.print("Enter Title: ");
                        Scanner scAddTitle = new Scanner(System.in);
                        String addTitle = scAddTitle.nextLine();
                        System.out.print("Enter Author: ");
                        Scanner scAddAuthor = new Scanner(System.in);
                        String addAuthor = scAddAuthor.nextLine();
                        System.out.println(addBook(books, addID, addTitle, addAuthor));
                        System.out.println();
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("====== Search Book ======");
                        System.out.print("Enter book Id: ");
                        Scanner scSearchID = new Scanner(System.in);
                        int checkID = scSearchID.nextInt();
                        System.out.println(searchBook(books, checkID));
                        System.out.println();
                        System.out.println();
                        break;

                    case 3:
                        System.out.println("====== Display Book ======");
                        displayBooks(books);
                        System.out.println();
                        System.out.println();
                        break;

                    case 4:
                        System.out.println("====== Issue Book ======");
                        System.out.print("Enter Book ID to issue: ");
                        Scanner inputForBookIssueId = new Scanner(System.in);
                        int bookIssueId = inputForBookIssueId.nextInt();
                        System.out.println(issueBook(books,bookIssueId));
                        System.out.println();
                        System.out.println();
                        break;

                    case 5:
                        System.out.println("====== Return Book ======");
                        System.out.print("Enter Book ID to return: ");
                        Scanner inputForBookReturnId = new Scanner(System.in);
                        int bookReturnId = inputForBookReturnId.nextInt();
                        System.out.println(returnBook(books,bookReturnId));
                        System.out.println();
                        System.out.println();
                        break;

                    case 6:
                        System.out.println("====== Removing Book ======");
                        System.out.print("Enter Book ID to remove: ");
                        Scanner inputForBookRemoveId = new Scanner(System.in);
                        int bookRemoveId = inputForBookRemoveId.nextInt();
                        System.out.println(removeBook(books,bookRemoveId));
                        System.out.println();
                        System.out.println();
                        break;

                    case 7:
                        System.out.println("====== Thank You ======");
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid Option\nTry Again...");
                }
            }
            catch (Exception e){
                System.out.println("Select from the above numbers!");
                System.out.println();
                System.out.println();
            }
        }
    }
}
