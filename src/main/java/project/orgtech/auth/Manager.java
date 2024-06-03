package project.orgtech.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.orgtech.dao.MasterDaoImpl;
import project.orgtech.models.Master;

@Component
public class Manager {

    static Master curentMaster;

    public static Master getMaser() {
        return curentMaster;
    }

    public static void setMaster(Master master) {
        curentMaster = master;
    }

    public static void cleanMaster() {
        curentMaster = null;
    }

}
