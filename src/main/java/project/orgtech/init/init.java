package project.orgtech.init;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import project.orgtech.dao.application.ApplicationDao;
import project.orgtech.dao.client.ClientDao;
import project.orgtech.models.Application;
import project.orgtech.models.Status;
import project.orgtech.service.application.ApplicationService;
import project.orgtech.service.auth.MasterService;
import project.orgtech.service.client.ClientService;
import project.orgtech.service.gender.GenderService;
import project.orgtech.service.repair.RepairService;
import project.orgtech.service.status.StatusService;
import project.orgtech.service.type.TypeService;

import javax.annotation.PostConstruct;

@Component
public class init {

    @Autowired
    ApplicationService applicationService;
    @Autowired
    ClientService clientService;
    @Autowired
    GenderService genderService;
    @Autowired
    MasterService masterService;
    @Autowired
    RepairService repairService;
    @Autowired
    StatusService statusService;
    @Autowired
    TypeService typeService;


    @PostConstruct
    public void init() {
        Status status = new Status();
        status.setName("В работе");
        status.setDescription("Находится в работе у мастера");
        statusService.
        Application application = new Application();

    }
}
