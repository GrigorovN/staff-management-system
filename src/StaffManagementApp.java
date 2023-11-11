import com.sirma.staffmanagementsystem.entitiy.Employee;
import com.sirma.staffmanagementsystem.filemanipulator.CSVReader;
import com.sirma.staffmanagementsystem.filemanipulator.CSVWriter;
import com.sirma.staffmanagementsystem.filemanipulator.Reader;
import com.sirma.staffmanagementsystem.filemanipulator.Writer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class StaffManagementApp {
    public static void main(String[] args) throws ParseException {

        Reader reader = new CSVReader();
        Writer writer = new CSVWriter();
       Map<Long, Employee> employeeMap = reader.read("employees.csv");
       Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-10-07");
       employeeMap.put(2l, new Employee(2l, "Gosho", startDate,null,"IT","Java", 1022.23));

        for (Employee employee : employeeMap.values()) {
            System.out.println(employee.toString());
        }
        writer.write(employeeMap, "employees.csv");
    }
}