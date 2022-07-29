package net.javaguides.springboot.repository;

public class SearchCriteria {
    private String email;

    public SearchCriteria(String email) {
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

}