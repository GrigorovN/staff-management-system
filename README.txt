
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