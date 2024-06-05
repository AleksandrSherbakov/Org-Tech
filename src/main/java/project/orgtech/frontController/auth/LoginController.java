package project.orgtech.frontController.auth;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.utils.AuthManager;
import project.orgtech.models.Master;
import project.orgtech.service.auth.MasterService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    private MasterService masterService; // Внедрено Spring

    @Autowired
    private SceneManager sceneManager;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button loginButton;

    @FXML
    private Button registrationButton;

    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        Master master = masterService.findMasterByLogin(loginText.getText());
        if (master != null && master.getPassword().equals(passwordText.getText())) {
            AuthManager.setMaster(master);
            sceneManager.openScene(loginButton, FxmlView.MAIN);
        } else {
            if(master != null){
                sceneManager.showAlert("Ошибка","Пароль неверный");
            }
            else{
                sceneManager.showAlert("Ошибка","Логин неверный");
            }

        }
    }

    @FXML
    private void handleRegistrationButton(ActionEvent event) throws IOException {
        sceneManager.openScene(registrationButton, FxmlView.REGISTRATION);
    }

    @FXML
    void initialize() {
        // Логика инициализации, если необходимо
    }
}
