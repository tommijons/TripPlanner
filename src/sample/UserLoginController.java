package sample;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserLoginController implements Initializable {
    @FXML
    private BorderPane fxPane;
    @FXML
    private TextField fxUserName;
    @FXML
    private TextField fxEmail;
    @FXML
    private PasswordField fxPassword;
    @FXML
    private Label fxError;

    private static final String ERROR_EMAIL = "Must be a valid email address";
    private BooleanBinding validEmail;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        validEmail = validEmail();
    }

    /**
     * Biður um upplýsingar frá User.
     * @return
     */
    public String [] userInfo() {
        DialogPane p = new DialogPane();
        fxPane.setVisible(true);
        p.setContent(fxPane);
        Dialog<ButtonType> d = new Dialog<>();
        d.setDialogPane(p);
        ButtonType login = buttonOkay(d);
        loginOkay(p, login);

        return getUserInfo(d);
    }

    /**
     * Fá upplýsingar frá User.
     * @param d dialog
     * @return upplýsingar um User
     */
    private String[] getUserInfo(Dialog<ButtonType> d) {
        String [] userInfo =null;
        Optional<ButtonType> result = d.showAndWait();
        if (result.isPresent() && (result.get()
                .getButtonData() == ButtonBar.ButtonData.OK_DONE)) {
            userInfo = new String[]{fxUserName.getText(), fxEmail.getText(), fxPassword.getText()};
        }
        return userInfo;
    }

    /**
     * Login button óvirkur nema allar upplýsingar frá user séu komnar.
     * @param p
     * @param login
     */
    private void loginOkay(DialogPane p, ButtonType login) {
        final Node confirmButton = p.lookupButton(login);
        confirmButton.disableProperty()
                .bind(fxUserName.textProperty().isEmpty()
                        .or(fxEmail.textProperty().isEmpty())
                        .or(validEmail)
                        .or(fxPassword.textProperty().isEmpty()
                        ));
    }

    /**
     * Athugar hvort Email address sé valid, þ.e. það þarf að innihalda "@".
     * @return
     */
    private BooleanBinding validEmail() {
        BooleanBinding binding = Bindings.createBooleanBinding(
                () -> (new SimpleBooleanProperty(fxEmail.getText().contains("@")).not().get()
                ),
                fxEmail.textProperty());
        binding.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1) {
                    fxError.setText(ERROR_EMAIL);
                    fxEmail.requestFocus();
                } else
                    fxError.setText(" ");
            }
        });
        return binding;
    }


    private ButtonType buttonOkay(Dialog<ButtonType> d) {
        ButtonType login = new ButtonType("Login",
                ButtonBar.ButtonData.OK_DONE);
        d.getDialogPane().getButtonTypes().add(login);
        ButtonType cancel = new ButtonType("Cancel",
                ButtonBar.ButtonData.CANCEL_CLOSE);
        d.getDialogPane().getButtonTypes().add(cancel);
        return login;
    }

}
