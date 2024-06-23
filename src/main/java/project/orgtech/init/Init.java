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

        Master master1 = new Master();
        master1.setFirstName("Медведев");
        master1.setMiddleName("Владислав");
        master1.setLastName("Александрович");
        master1.setLogin("vladmed");
        master1.setPassword("pass");
        master1.setGender(genderMale);
        masterService.add(master1);

        Master master2 = new Master();
        master2.setFirstName("Emily");
        master2.setMiddleName("Jane");
        master2.setLastName("Smith");
        master2.setLogin("qwe");
        master2.setPassword("qwe");
        master2.setGender(genderFemale);
        masterService.add(master2);

        Type type1 = new Type();
        type1.setName("Электроника");
        type1.setDescription("Ремонт и обслуживание электронных устройств");
        typeService.add(type1);

        Type type2 = new Type();
        type2.setName("Бытовая техника");
        type2.setDescription("Ремонт и обслуживание бытовой техники");
        typeService.add(type2);

        Type type3 = new Type();
        type3.setName("Компьютеры");
        type3.setDescription("Ремонт и обслуживание компьютеров и ноутбуков");
        typeService.add(type3);

        Type type4 = new Type();
        type4.setName("Мобильные устройства");
        type4.setDescription("Ремонт и обслуживание мобильных телефонов и планшетов");
        typeService.add(type4);

        Type type5 = new Type();
        type5.setName("Аудио и видео техника");
        type5.setDescription("Ремонт и обслуживание аудио и видео техники");
        typeService.add(type5);

        Repair repair1 = new Repair();
        repair1.setName("Замена экрана");
        repair1.setDescription("Замена поврежденного экрана на новый");
        repairService.add(repair1);

        Repair repair2 = new Repair();
        repair2.setName("Замена батареи");
        repair2.setDescription("Замена старой батареи на новую");
        repairService.add(repair2);

        Repair repair3 = new Repair();
        repair3.setName("Ремонт материнской платы");
        repair3.setDescription("Ремонт или замена материнской платы");
        repairService.add(repair3);

        Repair repair4 = new Repair();
        repair4.setName("Настройка программного обеспечения");
        repair4.setDescription("Установка и настройка необходимого программного обеспечения");
        repairService.add(repair4);

        Repair repair5 = new Repair();
        repair5.setName("Чистка устройства");
        repair5.setDescription("Чистка устройства от пыли и замена термопасты");
        repairService.add(repair5);

        Client client1 = new Client();
        client1.setBio("Иван Иванов, постоянный клиент, любит гаджеты.");
        client1.setPhone("89001234567");
        clientService.add(client1);

        Client client2 = new Client();
        client2.setBio("Мария Смирнова, часто заказывает ремонт бытовой техники.");
        client2.setPhone("89007654321");
        clientService.add(client2);

        Client client3 = new Client();
        client3.setBio("Алексей Петров, интересуется новыми технологиями.");
        client3.setPhone("89001237654");
        clientService.add(client3);

        Client client4 = new Client();
        client4.setBio("Ольга Сидорова, часто ремонтирует свою электронику.");
        client4.setPhone("89006543210");
        clientService.add(client4);

        Client client5 = new Client();
        client5.setBio("Дмитрий Кузнецов, любит чинить технику сам.");
        client5.setPhone("89008765432");
        clientService.add(client5);

        Application application1 = new Application();
        application1.setName("Ремонт экрана телефона");
        application1.setPrice(BigDecimal.valueOf(5000));
        application1.setDate(new Date());
        application1.setMaster(master1);
        application1.setClient(client1);
        application1.setStatus(statusService.getById(1L));
        application1.setType(type1);
        application1.setRepair(repair1);
        applicationService.add(application1);

        Application application2 = new Application();
        application2.setName("Замена батареи ноутбука");
        application2.setPrice(BigDecimal.valueOf(8000));
        application2.setDate(new Date());
        application2.setMaster(master1);
        application2.setClient(clientService.getById(2L));
        application2.setStatus(statusService.getById(1L));
        application2.setType(typeService.getById(2L));
        application2.setRepair(repairService.getById(2L));
        applicationService.add(application2);

        Application application3 = new Application();
        application3.setName("Ремонт стиральной машины");
        application3.setPrice(BigDecimal.valueOf(12000));
        application3.setDate(new Date());
        application3.setMaster(master1);
        application3.setClient(clientService.getById(3L));
        application3.setStatus(statusService.getById(1L));
        application3.setType(typeService.getById(3L));
        application3.setRepair(repairService.getById(3L));
        applicationService.add(application3);

        Application application4 = new Application();
        application4.setName("Настройка телевизора");
        application4.setPrice(BigDecimal.valueOf(3000));
        application4.setDate(new Date());
        application4.setMaster(master1);
        application4.setClient(clientService.getById(4L));
        application4.setStatus(statusService.getById(1L));
        application4.setType(typeService.getById(4L));
        application4.setRepair(repairService.getById(4L));
        applicationService.add(application4);

        Application application5 = new Application();
        application5.setName("Установка программного обеспечения");
        application5.setPrice(BigDecimal.valueOf(2000));
        application5.setDate(new Date());
        application5.setMaster(master1);
        application5.setClient(clientService.getById(5L));
        application5.setStatus(statusService.getById(1L));
        application5.setType(typeService.getById(5L));
        application5.setRepair(repairService.getById(5L));
        applicationService.add(application5);

        // Add more applications as needed
    }
}
