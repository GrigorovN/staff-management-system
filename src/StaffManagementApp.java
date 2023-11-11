import com.sirma.staffmanagementsystem.entitiy.Employee;
import com.sirma.staffmanagementsystem.filemanipulator.CSVReader;
import com.sirma.staffmanagementsystem.filemanipulator.CSVWriter;
import com.sirma.staffmanagementsystem.filemanipulator.Reader;
import com.sirma.staffmanagementsystem.filemanipulator.Writer;
import com.sirma.staffmanagementsystem.manager.Manager;
import com.sirma.staffmanagementsystem.manager.StaffManager;
import com.sirma.staffmanagementsystem.service.Service;
import com.sirma.staffmanagementsystem.service.StaffService;

import java.text.ParseException;
import java.util.Scanner;

public class StaffManagementApp {
    public static void main(String[] args) throws ParseException {

        Reader reader = new CSVReader();
        Writer writer = new CSVWriter();
        Service service = new StaffService(reader, writer);
        Manager manager = new StaffManager(service);
        System.out.println("Welcome to Staff Management System");
        displayCommands();
        boolean isRunning = true;

        while (isRunning) {
            Scanner command = new Scanner(System.in);
            isRunning = manager.execute(command); // This line is not like in the description.
        }
    }

    public static void displayCommands() {
        System.out.println("Select an option:");
        System.out.println("1 - Add employee");
        System.out.println("2 - Edit employee");
        System.out.println("3 - Fire Employee");
        System.out.println("4 - Show all employees");
        System.out.println("5 - Show employees by name");
        System.out.println("6 - Show employee by id");
        System.out.println("7 - Show all employees from department");
        System.out.println("8 - Exit");
    }
}