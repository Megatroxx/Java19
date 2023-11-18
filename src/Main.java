import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws InvalidINNException {

        ArrayList<User> users = new ArrayList<>();
        User user1 = new User("Megatroxx", "123456781234");
        User user2 = new User("ritaro", "555555555555");
        User user3 = new User("bazar", "111111111111");
        users.add(user1);
        users.add(user2);

        users.add(user3);
        System.out.println(InvalidINN.isUserValid(users));





    }
}