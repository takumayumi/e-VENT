package model;

/**
 * 
 * @author Yumi Takuma
 */
public class ClientModel {
    private int id;
    private String lastname;
    private String first;
    private char mi;

    public ClientModel(int id, String lastname, String first, char mi) {
        this.id = id;
        this.lastname = lastname;
        this.first = first;
        this.mi = mi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public char getMi() {
        return mi;
    }

    public void setMi(char mi) {
        this.mi = mi;
    }
    
}
