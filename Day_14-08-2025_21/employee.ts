
interface Employee {
    empId: number;
    empName: string;
    salary: number;
}


let employees: Employee[] = [
    { empId: 101, empName: "Tanuja", salary: 50000 },
    { empId: 102, empName: "Arjun", salary: 60000 },
    { empId: 103, empName: "Sriya", salary: 55000 }
];


function printEmployees(empList: Employee[]): number {
    console.log("Employee Details:");
    empList.forEach(emp => {
        console.log(`ID: ${emp.empId}, Name: ${emp.empName}, Salary: ${emp.salary}`);
    });
    return empList.length;
}


let totalEmployees = printEmployees(employees);
console.log("Total Employees:", totalEmployees);
