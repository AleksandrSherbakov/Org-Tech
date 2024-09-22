package project.orgtech.frontController.master;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.frontController.utils.DataReceiver;
import project.orgtech.models.Master;
import project.orgtech.utils.AuthManager;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class MasterInfoController implements DataReceiver<Master> {

    public ComboBox genderComboBox;
    public Button saveButton;
    @Autowired
    private SceneManager sceneManager;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField firstNameLabel;

    @FXML
    private TextField middleNameLabel;

    @FXML
    private TextField lastNameLabel;

    @FXML
    private TextField genderLabel;

    @FXML
    private Button editButton;

    @FXML
    private Button backButton;

    @FXML
    private Button exitButton;

    @FXML
    private void handleEditButton(ActionEvent event) throws IOException {
        sceneManager.openScene(editButton, FxmlView.EDIT_MASTER); // Assuming there is an EDIT_MASTER view for editing
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(backButton, FxmlView.MAIN);
    }

    @FXML
    private void handleExitButton(ActionEvent event) throws IOException {
        AuthManager.cleanMaster();
        sceneManager.openScene(exitButton, FxmlView.LOGIN);
    }

    @FXML
    public void initialize() {
        Master master = AuthManager.getMaster();
        if (master != null) {
            firstNameField.setText(master.getLogin());
            firstNameLabel.setText(master.getFirstName());
            middleNameLabel.setText(master.getMiddleName());
            lastNameLabel.setText(master.getLastName());
            genderLabel.setText(master.getGender().getName());
        }
    }

    @Override
    public void setData(Master data) {

    }

    public void handleSaveButton(ActionEvent actionEvent) {
    }

}
