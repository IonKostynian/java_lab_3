package com.labs.model;

import com.labs.enums.Genre;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.Year;
import java.util.Comparator;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class TextBook extends Book implements Comparable<TextBook>{
    @XmlElement
    public Genre genre;

    public TextBook () {

        setYearOfPublication(Year.now());

    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return super.getAuthor();
    }

    public void setAuthor(String author) {
        super.setAuthor(author);
    }

    public String getName() {
        return super.getName();
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getPublication() {
        return super.getPublication();
    }

    public void setPublication(String publication) {
        super.setPublication(publication);
    }

    public int getYearOfPublication() {
        return super.getYearOfPublication();
    }

    public void setYearOfPublication(Year yearOfPublication) {
        super.setYearOfPublication(yearOfPublication);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextBook textBook = (TextBook) o;
        return Objects.equals(getAuthor(),textBook.getAuthor())
                && Objects.equals(getName(),textBook.getName())
                && Objects.equals(getPublication(),textBook.getPublication())
                && Objects.equals(getYearOfPublication(),textBook.getYearOfPublication())
                && genre == textBook.genre;
    }
    @Override
    public int hashCode() {
        return Objects.hash(getAuthor(), getName(), getPublication(), getYearOfPublication(), genre);
    }

    @Override
    public String toString() {
        return "TextBook{" +
                "author=" + getAuthor() +
                ", name=" + getName() +
                ", publication=" + getPublication() +
                ", yearOfPublication=" + getYearOfPublication() +
                ", genre=" + genre +
                "}";
    }

    @Override
    public int compareTo(TextBook o) {
        int compareByGenre = this.genre.toString().compareTo(o.genre.toString());
        if (compareByGenre != 0) return compareByGenre;

        int compareByName = this.getName().compareTo(o.getName());
        if (compareByName != 0) return compareByName;

        int compareByAuthor = this.getAuthor().compareTo(o.getAuthor());
        if (compareByAuthor != 0) return compareByAuthor;

        int compareByPublication = this.getPublication().compareTo(o.getPublication());
        if (compareByPublication != 0) return compareByPublication;

        return this.getYearOfPublication()-o.getYearOfPublication();
    }

    public static class TextBookBuilder {
        private TextBook textBook = new TextBook();

        public TextBookBuilder setName(String name) {
            textBook.setName(name);
            return this;
        }

        public TextBookBuilder setAuthor(String author) {
            textBook.setAuthor(author);
            return this;
        }

        public TextBookBuilder setPublication (String publication) {
            textBook.setPublication(publication);
            return this;
        }

        public TextBookBuilder setYearOfPublication(int yearOfPublication) {
            textBook.setYearOfPublication(Year.of(yearOfPublication));
            return this;
        }

        public TextBookBuilder setGenre(Genre genre) {
            textBook.setGenre(genre);
            return this;
        }

        public TextBook build() {
            return textBook;
        }
    }
}