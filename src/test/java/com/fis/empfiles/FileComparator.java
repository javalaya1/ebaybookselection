package com.fis.empfiles;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileComparator {

    public static List<Employee> readTxtFile(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split("\\t"); // Assuming tab-delimited in .txt
            Employee employee = new Employee();
            employee.setId(data[0]);
            employee.setName(data[1]);
            employee.setAge(Integer.parseInt(data[2]));
            employee.setSalary(Double.parseDouble(data[3]));
            employees.add(employee);
        }
        return employees;
    }

    public static List<Employee> readCsvFile(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();
        Reader reader = Files.newBufferedReader(new File(filePath).toPath());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(reader);

        for (CSVRecord record : records) {
            Employee employee = new Employee();
            employee.setId(record.get("id"));
            employee.setName(record.get("name"));
            employee.setAge(Integer.parseInt(record.get("age")));
            employee.setSalary(Double.parseDouble(record.get("salary")));
            employees.add(employee);
        }
        return employees;
    }

    public static void main(String[] args) throws IOException {
        // Read data from files
        List<Employee> txtEmployees = readTxtFile("employee_data.txt");
        List<Employee> csvEmployees = readCsvFile("employee_data.csv");

        // Compare the data
        boolean areDataEqual = compareData(txtEmployees, csvEmployees);
        if (areDataEqual) {
            System.out.println("The data in both files are the same.");
        } else {
            System.out.println("The data in both files are different.");
        }
    }

    public static boolean compareData(List<Employee> txtEmployees, List<Employee> csvEmployees) {
        if (txtEmployees.size() != csvEmployees.size()) {
            return false;
        }

        txtEmployees.sort(Comparator.comparing(Employee::getId));
        csvEmployees.sort(Comparator.comparing(Employee::getId));

        return txtEmployees.equals(csvEmployees);
    }
}