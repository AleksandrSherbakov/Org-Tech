package project.orgtech.frontController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.utils.SceneManager;
import project.orgtech.utils.FxmlView;

import java.io.IOException;

@Controller
public class CategoryController {

    @Autowired
    private SceneManager sceneManager;

    @FXML
    private Button CategoryButton;

    @FXML
    private Button ClientButton;

    @FXML
    private Button MyApplicationButton;

    @FXML
    private Button ReportsButton;

    @FXML
    private Button RepairButton;

    @FXML
    private Button TypeButton;

    @FXML
    private void handleMyApplicationButton(ActionEvent event) throws IOException {
        sceneManager.openScene(MyApplicationButton, FxmlView.MAIN);
    }

    @FXML
    private void handleCategoryButton(ActionEvent event) throws IOException {
        sceneManager.openScene(CategoryButton, FxmlView.CATEGORY);
    }

    @FXML
    private void handleReportsButton(ActionEvent event) throws IOException {
        //sceneManager.openScene(ReportsButton, FxmlView.REPORTS);
    }

    @FXML
    private void handleClientButton(ActionEvent event) throws IOException {
        sceneManager.openScene(ClientButton, FxmlView.CLIENT_PANEL);
    }

    @FXML
    private void handleRepairButton(ActionEvent event) throws IOException {
        sceneManager.openScene(RepairButton, FxmlView.REPAIR_PANEL);
    }

    @FXML
    private void handleTypeButton(ActionEvent event) throws IOException {
        sceneManager.openScene(TypeButton, FxmlView.TYPE_PANEL);
    }

}
