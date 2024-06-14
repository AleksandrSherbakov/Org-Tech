package project.orgtech.frontController.type;

import javafx.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.frontController.utils.DataReceiver;
import project.orgtech.models.Type;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import project.orgtech.service.type.TypeService;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class InfoTypeController implements DataReceiver<Type> {
    private Type type;

    @Autowired
    TypeService typeService;

    @Autowired
    SceneManager sceneManager;

    @FXML
    private Button BackButton;

    @FXML
    private Button DeleteButton;

    @FXML
    private Button EditButton;

    @FXML
    private TextField nameField ;

    @FXML
    private TextField descriptionField;

    @Override
    public void setData(Type type) {
        this.type = type;
        loadTypeData();
    }

    @FXML
    private void initialize() {
    }
    @FXML
    private void handleEditButton(ActionEvent event) throws IOException {
        sceneManager.openScene(EditButton, FxmlView.TYPE_EDIT, type);
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws IOException {
        sceneManager.openScene(BackButton, FxmlView.TYPE_PANEL);
    }
    @FXML
    private void handleDeleteButton(ActionEvent event) throws IOException {
        if (type != null) {
            typeService.deleteType(type.getId());
        }
        sceneManager.openScene(DeleteButton, FxmlView.TYPE_PANEL);
    }

    private void loadTypeData() {
        if (type != null) {
            nameField.setText(type.getName());
            descriptionField.setText(type.getDescription());
        }
    }
}
