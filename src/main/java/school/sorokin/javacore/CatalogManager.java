package school.sorokin.javacore;

import school.sorokin.javacore.exceptions.ItemNotFoundException;
import school.sorokin.javacore.exceptions.NoAvailableCopiesException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CatalogManager {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Book> catalog;
    private final String INVALID_MESSAGE = "Invalid %s try again.\n";
    private final String ENTER_MESSAGE = "Enter %s : ";

    public CatalogManager() {
        catalog = new ArrayList<>();
    }

    public void addBook() {
        while (true) {
            String title = validName("title");
            String author = validName("author");
            int copies = validateNumber("copies");
            catalog.add(new Book(title, author, copies));
            System.out.println("Book added successfully.");
            break;
        }
    }

    public void getCatalog() {
        if (catalog.isEmpty()) {
            System.out.println("There are no books in the catalog.");
        } else {
            for (Book book : catalog) {
                System.out.println(book);
            }
        }
    }

    public void takeBook() {
        mangeCopies(0);
        System.out.println("The book has been taken.");
    }

    public void returnBook() {
        mangeCopies(1);
        System.out.println("The book has been returned.");
    }

    private void mangeCopies(int indicate) {
        String title = "";
        while (true) {
            System.out.print("Enter title: ");
            title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("Title cannot be empty.");
            } else {
                break;
            }
        }
        int count = 0;
        if (!catalog.isEmpty()) {
            for (Book temp : catalog) {
                if (temp.getTitle().equals(title)) {
                    count++;
                    switch (indicate) {
                        case 0 -> {
                            if (temp.getAvailableCopies() > 0) {
                                temp.decreaseAvailableCopies(1);
                            } else {
                                throw new NoAvailableCopiesException("The book does not have enough copies. Choose another one.");
                            }
                        }
                        case 1 -> {
                            temp.increaseAvailableCopies(1);
                        }
                    }
                }
            }
            if (count == 0) {
                throw new ItemNotFoundException("There is no book with title : " + title);
            }
        } else {
            System.out.println("Catalog is empty");
        }
    }

    private String validName(String nameOfField) {
        while (true) {
            System.out.printf(ENTER_MESSAGE, nameOfField);
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) {
                return name;
            } else {
                System.out.printf(INVALID_MESSAGE, nameOfField);
            }
        }
    }

    private int validateNumber(String nameOfField) {
        while (true) {
            System.out.printf(ENTER_MESSAGE, nameOfField);
            String number = scanner.nextLine().trim();
            try {
                int copies = Integer.parseInt(number);
                if (copies > 0) {
                    return copies;
                } else {
                    System.out.printf(INVALID_MESSAGE, nameOfField);
                }
            } catch (NumberFormatException e) {
                System.out.printf(INVALID_MESSAGE, nameOfField);
            }
        }
    }

}