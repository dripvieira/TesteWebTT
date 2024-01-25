package com.titansoftware.reports;

import com.rajatthareja.reportbuilder.ReportBuilder;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GenerateHtmlReport {
    public static void main(String... args){

        DateTimeFormatter formatoDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime atual = LocalDateTime.now();

        // Create ReportBuilder Object
        ReportBuilder reportBuilder = new ReportBuilder();

        String path = System.getProperty("user.dir");

        // Set output Report Dir
        reportBuilder.setReportDirectory(path + "//reports//");

        // Set output report file name
        reportBuilder.setReportFileName("TitanSoftware");

        // Set Report Title
        reportBuilder.setReportTitle("Execução de testes web - Titan Software");

        reportBuilder.setReportColor("blue");

        // Enable voice control for report
        reportBuilder.enableVoiceControl();

        // Add additional info for Report
        reportBuilder.setAdditionalInfo("Ambiente", "Base Testes/http://192.168.2.254/testeqa/index.php");

        reportBuilder.setAdditionalInfo("Data e hora", formatoDataHora.format(atual));

        // Create list or report Files or Directories or URLs or JSONObject or
        // JSONString
        List<Object> cucumberJsonReports = new ArrayList<>();
        cucumberJsonReports.add(new File(path + "//reports//cucumber.json"));

        // Build your report
        reportBuilder.build(cucumberJsonReports);

    }
}
