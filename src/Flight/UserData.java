package Flight;

import sample.User;
import java.util.ArrayList;

class UserData {
    // static variable single_instance of type Singleton
    private static UserData single_instance = null;

    // variable of type String
    public User user;
    public Flight flight;
    public ArrayList<Integer> seats;
    public int price;

    // private constructor restricted to this class itself
    private UserData() {
        user = null;
        flight = null;
        seats = new ArrayList<Integer>();
        price = 0;
    }

    // static method to create instance of Singleton class
    public static UserData getInstance() {
        if (single_instance == null)
        {
            single_instance = new UserData();
        }
        return single_instance;
    }
}