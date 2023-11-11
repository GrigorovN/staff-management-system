
Entities:

1.Employee:
    Long ID
    String name,
    String department,
    double salary,
    UserRole role

2. User Role --> enum
    admin, employee


FileManipulators:

interfaces:
1. FileReader ---> read - to return Map<long, Employee>
2. FileWriter ---> write

classes:
 1. CsvFileReader
 2. CsvFileWriter


DataManagement:

abstract class:
 Manager ---> execute