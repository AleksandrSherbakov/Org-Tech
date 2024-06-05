package project.orgtech.frontController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.orgtech.utils.FxmlView;
import project.orgtech.utils.SceneManager;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private SceneManager sceneManager;

    @FXML
    private ListView<?> ApplicationListView;

    @FXML
    private Button CategoryButton;

    @FXML
    private Button MyApplicationButton;

    @FXML
    private Button ReportsButton;
    @FXML
    private void handleMyApplicationButton(ActionEvent event) throws IOException {
        //sceneManager.openScene(MyRequestButton, FxmlView.);
    }

    @FXML
    private void handleCategoryButton(ActionEvent event) throws IOException {
        sceneManager.openScene(CategoryButton, FxmlView.CATEGORY);
    }

    @FXML
    private void handleReportsButton(ActionEvent event) throws IOException {
        //sceneManager.openScene(ReportsButton, FxmlView.REPORTS);
    }

}
