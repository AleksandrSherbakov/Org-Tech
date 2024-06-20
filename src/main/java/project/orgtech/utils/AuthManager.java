package project.orgtech.utils;

import org.springframework.stereotype.Component;
import project.orgtech.models.Master;

@Component
public class AuthManager {

    static Master curentMaster;

    public static Master getMaster() {
        return curentMaster;
    }

    public static void setMaster(Master master) {
        curentMaster = master;
    }

    public static void cleanMaster() {
        curentMaster = null;
    }

}
