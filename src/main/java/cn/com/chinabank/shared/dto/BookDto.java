package cn.com.chinabank.shared.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: baowp
 * Date: 12/28/13
 * Time: 12:24 PM
 */
public class BookDto implements Serializable{

    private String title;
    private String author;
    private Float price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String toString() {
        return String.format("title=%1$s,author=%2$s,price=%3$.2f", title, author, price);
    }
}
