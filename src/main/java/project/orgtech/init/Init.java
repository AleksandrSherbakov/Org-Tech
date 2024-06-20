package project.orgtech.init;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import project.orgtech.models.Application;
import project.orgtech.models.Status;
import project.orgtech.models.Gender;
import project.orgtech.models.Type;
import project.orgtech.models.Master;
import project.orgtech.models.Repair;
import project.orgtech.models.Client;
import project.orgtech.service.application.ApplicationService;
import project.orgtech.service.auth.MasterService;
import project.orgtech.service.client.ClientService;
import project.orgtech.service.gender.GenderService;
import project.orgtech.service.repair.RepairService;
import project.orgtech.service.status.StatusService;
import project.orgtech.service.type.TypeService;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Date;

@Component
public class Init {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private GenderService genderService;
    @Autowired
    private MasterService masterService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private TypeService typeService;

    @PostConstruct
    public void init() {
        initializeData();
    }

    @Transactional
    public void initializeData() {
        // Create and save statuses
        Status status1 = new Status();
        status1.setName("В работе");
        status1.setDescription("Находится в работе у мастера");
        statusService.add(status1);

        Status status2 = new Status();
        status2.setName("Завершено");
        status2.setDescription("Работа завершена");
        statusService.add(status2);

        // Create and save genders
        Gender genderMale = new Gender();
        genderMale.setName("Мужской");
        genderService.add(genderMale);

        Gender genderFemale = new Gender();
        genderFemale.setName("Женский");
        genderService.add(genderFemale);

        // Create and save masters
        Master master = new Master();
        master.setFirstName("qwe");
        master.setMiddleName("qwe");
        master.setLastName("qwe");
        master.setLogin("qwe");
        master.setPassword("qwe");
        master.setGender(genderService.getById(1L));
        masterService.add(master);

        // Create and save repairs
        for (int i = 1; i <= 5; i++) {
            Repair repair = new Repair();
            repair.setName("Ремонт " + i);
            repairService.add(repair);
        }

        // Create and save types
        for (int i = 1; i <= 5; i++) {
            Type type = new Type();
            type.setName("Тип " + i);
            typeService.add(type);
        }

        // Create and save clients
        for (int i = 1; i <= 5; i++) {
            Client client = new Client();
            client.setBio("Клиент " + i);
            client.setPhone("88005553535");
            clientService.add(client);
        }
        Application application = new Application();
        application.setName("application1");
        application.setPrice(BigDecimal.valueOf(1000));
        application.setDate(new Date(2024,06,24));
        application.setMaster(master);
        application.setClient(clientService.getById(1L));
        application.setStatus(status1);
        application.setType(typeService.getById(1L));
        application.setRepair(repairService.getById(1L));
        applicationService.add(application);
    }
}
