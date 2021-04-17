package Tour;

import javafx.collections.ObservableList;
import tripPackage.User;

public class TourUserController {
    private TourDataFactory tourdataFactory = new TourDataFactory();

    public User findUserByID(String ID){
        ObservableList<User> users = tourdataFactory.getUsers();
        User theUser = null;
        for (User user : users) {
            if (user.getUserName().equals(ID)){ //5T-ath: breytt úr userID í password
                theUser=user;
            }
        }
        return theUser;
    }

    public void addNewUser(User user) {
        tourdataFactory.insertUser(user);
    }

    public boolean isUserInSystem(String userID){
        ObservableList<User> users = tourdataFactory.getUsers();
        boolean inSystem= false;
        for (User user : users) {
            if (user.getPassword().equals(userID)){ //5T-ath: breytt úr userID í password
                inSystem= true;
            }
        }
        return inSystem;
    }
}