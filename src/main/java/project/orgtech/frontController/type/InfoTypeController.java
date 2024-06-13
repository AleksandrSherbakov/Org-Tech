package project.orgtech.frontController.type;

import project.orgtech.frontController.utils.DataReceiver;
import project.orgtech.models.Type;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
public class InfoTypeController implements DataReceiver<Type> {
    private Type type;

        @FXML
        private Button CategoryButton;

        @FXML
        private Button MyApplicationButton;


        @Override
        public void setData(Type type) {
        this.type = type;
        }
}
