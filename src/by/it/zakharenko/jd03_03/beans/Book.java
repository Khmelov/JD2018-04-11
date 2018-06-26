package by.it.zakharenko.jd03_03.beans;

public class Book {

    private long id;
    private String description;
    private String name;
    private String author;
    private String genre;
    private int pages;
    private double price;
    private long users_id;

    public Book() {
    }

    public Book(long id, String description, String name, String author, String genre, int pages, double price, long users_id) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.pages = pages;
        this.price = price;
        this.users_id = users_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getUsers_id() {
        return users_id;
    }

    public void setUsers_id(long users_id) {
        this.users_id = users_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", users_id=" + users_id +
                '}';
    }
}
