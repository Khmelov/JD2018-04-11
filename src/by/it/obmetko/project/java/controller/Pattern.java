package by.it.obmetko.project.java.controller;

public interface Pattern {
   String LOGIN="\\w+";
    String EMAIL="(\\w{2,})@(\\w+\\.)([a-z]{2,4})";
    String PASSWORD="\\w+";
    String ROLE="\\w.+";
    String CATEGORY="\\w.+";
   String CATALOG="\\w.+";
   String BOOK="\\w.+";
}