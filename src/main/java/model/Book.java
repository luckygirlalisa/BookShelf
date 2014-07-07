package model;

public class Book {
    private int ISBN;
    private String name;

    public int getISBN() {
        return ISBN;
    }

    public String getName() {
        return name;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }
}
