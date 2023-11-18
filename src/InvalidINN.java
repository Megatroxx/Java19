import java.util.ArrayList;
import java.util.Scanner;
public class InvalidINN {


    public static String isUserValid(ArrayList<User> users) throws InvalidINNException {
        Scanner in = new Scanner(System.in);
        int pos = -1;
        System.out.println("Введите имя пользователя: ");
        String name = in.nextLine();
        System.out.println("Введите ИНН: ");
        String INN = in.nextLine();
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).fullname.equals(name)){
                pos = i;
            }
        }
        if (pos == -1){
            return "Неверно введено имя пользователя";
        }
        if (users.get(pos).INN.equals(INN)){
            return "Пользователь найден";
        }
        else{
            throw new InvalidINNException("Wrong INN");
        }
    }
}
