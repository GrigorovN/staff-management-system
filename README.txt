
Entities:
1.Employee:
    Long ID
    String name,
    String department,
    double salary,
    String role,
    Date StartDate,
    Date EndDate,
---------------------------------------------------------------------------------------------------------
FileManipulators:

interfaces:
1. FileReader ---> read - to return Map<long, Employee>
2. FileWriter ---> write

classes:
 1. CsvFileReader
 2. CsvFileWriter
--------------------------------------------------------------------------------------------------------
Services:
1. abstract class Service -->
fields : Writer, Reader
methods: getByName(), getById(), getByDepartment(), getAllEmployees(), saveEmployee(), deleteEmployee(), updateEmployee();

2. class StaffService extends Service
fields: Map employees
------------------------------------------------------------------------------------------------
DataManagement:

abstract class:
 Manager ---> execute

 Method in main class :             displayCommands()
                                System.out.println("Select an option:");
                                System.out.println("1 - Add employee");
                                System.out.println("2 - Edit employee");
                                System.out.println("3 - Fire Employee");
                                System.out.println("4 - Show all employees");
                                System.out.println("5 - Show employees by name");
                                System.out.println("6 - Show employee by id");
                                System.out.println("7 - Show all employees from department");
                                System.out.println("8 - Exit");
