public class User {

    String fullname;
    String INN;


    public User(String fullname, String INN) {
        this.fullname = fullname;
        this.INN = INN;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }
}
