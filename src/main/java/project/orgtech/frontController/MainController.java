package project.orgtech.frontController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    @FXML
    private ListView<?> ApplicationListView;

    @FXML
    private Button CategoryButton;

    @FXML
    private Button CreateButton;

    @FXML
    private Button MyApplicationButton;

    @FXML
    private Button ReportsButton;
}
