package project.orgtech.service.exel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.orgtech.models.Application;
import project.orgtech.models.Client;
import project.orgtech.models.Master;
import project.orgtech.models.Repair;
import project.orgtech.models.Status;
import project.orgtech.models.Type;
import project.orgtech.service.application.ApplicationService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ExcelExportService {

    @Autowired
    private ApplicationService applicationService;

    public void exportApplicationsToExcel(String filePath) throws IOException {
        List<Application> applications = applicationService.getAll();

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Applications");

        // Header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Application ID");
        headerRow.createCell(1).setCellValue("Application Name");
        headerRow.createCell(2).setCellValue("Price");
        headerRow.createCell(3).setCellValue("Date");
        headerRow.createCell(4).setCellValue("Master ID");
        headerRow.createCell(5).setCellValue("Master First Name");
        headerRow.createCell(6).setCellValue("Master Middle Name");
        headerRow.createCell(7).setCellValue("Master Last Name");
        headerRow.createCell(8).setCellValue("Client Bio");
        headerRow.createCell(9).setCellValue("Status");
        headerRow.createCell(10).setCellValue("Type");
        headerRow.createCell(11).setCellValue("Repair");

        // Data rows
        int rowNum = 1;
        BigDecimal totalSum = BigDecimal.ZERO;
        for (Application application : applications) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(application.getId());
            row.createCell(1).setCellValue(application.getName());
            row.createCell(2).setCellValue(application.getPrice().doubleValue());
            row.createCell(3).setCellValue(application.getDate().toString());

            Master master = application.getMaster();
            Client client = application.getClient();
            Status status = application.getStatus();
            Type type = application.getType();
            Repair repair = application.getRepair();
            if (master != null) {
                row.createCell(4).setCellValue(master.getId());
                row.createCell(5).setCellValue(master.getFirstName());
                row.createCell(6).setCellValue(master.getMiddleName());
                row.createCell(7).setCellValue(master.getLastName());
                row.createCell(8).setCellValue(client.getBio());
                row.createCell(9).setCellValue(status.getName());
                row.createCell(10).setCellValue(type.getName());
                row.createCell(11).setCellValue(repair.getName());
            }
            totalSum = totalSum.add(application.getPrice());
        }
        Row totalRow = sheet.createRow(rowNum);
        totalRow.createCell(1).setCellValue("Total:");
        totalRow.createCell(2).setCellValue(totalSum.doubleValue());
        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }
}
