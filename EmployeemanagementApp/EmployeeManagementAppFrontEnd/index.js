class Employee {
    constructor(empID, name, age, designation, salary) {
        this.empID = empID;
        this.name = name;
        this.age = age;
        this.designation = designation;
        this.salary = salary;
    }
}

let employees = [];
let currentId = 1;

async function fetchEmployees() {
    try {
        const response = await fetch('http://localhost:8080/employees');
        if (!response.ok) {
            console.log(response);
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        console.log(data);
        employees = data.map(emp => new Employee(emp.empID, emp.name, emp.age, emp.designation, emp.salary));
        currentId = employees.length > 0 ? employees[employees.length - 1].empID + 1 : 1;
        console.log(employees);
        saveEmployees();
        filterEmployees();
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}
fetchEmployees();

function saveEmployees() {
    localStorage.setItem('employees', JSON.stringify(employees));
}

function displayEmployee(employee){
    const employeeTable = document.getElementById('searchTableBody');
    employeeTable.innerHTML = '';
    const th = document.createElement('tr');
    th.innerHTML = `<th>ID</th><th>Name</th><th>Age</th><th>Designation</th><th>Salary</th>`;
    employeeTable.appendChild(th);
    const tr = document.createElement('tr');
    tr.innerHTML = `<td>${employee.empID}</td><td>${employee.name}</td><td>${employee.age}</td><td>${employee.designation}</td><td>${employee.salary}</td>`;
    employeeTable.appendChild(tr);
}

async function addEmployeeToServer(employee) {
    try {
        console.log(employee);
        const response = await fetch('http://localhost:8080/employee', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(employee)
        });
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        console.log('Employee added:', data);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

async function addEmployee() {
    const name = document.getElementById('employeeName').value;
    const age = document.getElementById('employeeAge').value;
    const designation = document.getElementById('employeeDesignation').value;
    const salary = document.getElementById('employeeSalary').value;
    if (name && age && designation && salary) {
        const employee = new Employee(currentId++, name, age, designation, salary);
        employees.push(employee);
        saveEmployees();
        displayEmployee(employee);
        await addEmployeeToServer(employee);
    }
    document.getElementById('employeeName').value = '';
    document.getElementById('employeeAge').value = '';
    document.getElementById('employeeDesignation').value = '';
    document.getElementById('employeeSalary').value = '';
}

function filterEmployees() {
    const filterNameElement = document.getElementById('filterName');
    const filterDesignationElement = document.getElementById('filterDesignation');
    const filterAgeElement = document.getElementById('filterAge');
    const filterSalaryElement = document.getElementById('filterSalary');
    const filterIdElement = document.getElementById('filterId');

    const filterName = filterNameElement ? filterNameElement.value.toLowerCase() : '';
    const filterDesignation = filterDesignationElement ? filterDesignationElement.value.toLowerCase() : '';
    const filterAge = filterAgeElement ? filterAgeElement.value : '';
    const filterSalary = filterSalaryElement ? filterSalaryElement.value : '';
    const filterId = filterIdElement ? filterIdElement.value : '';

    const filteredEmployees = employees.filter(employee => {
        return (!filterName || employee.name.toLowerCase().includes(filterName)) &&
               (!filterDesignation || employee.designation.toLowerCase().includes(filterDesignation)) &&
               (!filterAge || employee.age == filterAge) &&
               (!filterSalary || employee.salary == filterSalary) &&
               (!filterId || employee.empID == filterId);
    });

    displayFilteredEmployees(filteredEmployees);
}

function displayFilteredEmployees(filteredEmployees) {
    const employeeTable = document.getElementById('employeeTableBody');
    if (employeeTable) {
        employeeTable.innerHTML = '';
        const th = document.createElement('tr');
        th.innerHTML = `<th>ID</th><th>Name</th><th>Age</th><th>Designation</th><th>Salary</th>`;
        employeeTable.appendChild(th);
        filteredEmployees.forEach(employee => {
            const tr = document.createElement('tr');
            tr.innerHTML = `<td>${employee.empID}</td><td>${employee.name}</td><td>${employee.age}</td><td>${employee.designation}</td><td>${employee.salary}</td>`;
            employeeTable.appendChild(tr);
        });
    }
}

function searchEmployee() {
    const searchId = document.getElementById('updateId') ? document.getElementById('updateId').value : document.getElementById('removeId').value;
    const employee = employees.find(emp => emp.empID == searchId);
    const employeeList = document.getElementById('searchList') ;
    const employeeTable = document.getElementById('searchTableBody');
    employeeTable.innerHTML = '';
    employeeList.innerHTML = '';
    if (employee) {
        displayEmployee(employee);
    } else {
        const li = document.createElement('li');
        li.textContent = "Employee not found";
        employeeList.appendChild(li);
    }
}

async function updateEmployeeToServer(employee){
    if (!employee) {
        throw new Error('Employee not found');
    }
    try {
        console.log(employee);
        const response = await fetch('http://localhost:8080/employee', {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(employee)
        });
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const data = await response.json();
        console.log('Employee added:', data);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

function updateEmployee() {
    const updateId = document.getElementById('updateId').value;
    const employee = employees.find(emp => emp.empID == updateId);
    const updateDesignation = document.getElementById('updateDesignation').value || employee?.designation;
    const updateSalary = document.getElementById('updateSalary').value || employee?.salary;
    if (employee) {
        employee.designation = updateDesignation;
        employee.salary = updateSalary;
        saveEmployees();
        updateEmployeeToServer(employee);
        displayEmployee(employee);
    } else {
        alert('Employee not found');
    }
}

async function removeEmployeeFromServer(empID) {
    try {
        const response = await fetch(`http://localhost:8080/employee/${empID}`, {
            method: 'DELETE'
        });
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        console.log(`Employee with ID ${empID} deleted`);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

function removeEmployee() {
    const removeId = document.getElementById('removeId').value;
    employees = employees.filter(emp => emp.empID != removeId);
    saveEmployees();
    removeEmployeeFromServer(removeId);
}

document.addEventListener('DOMContentLoaded', (event) => {
    filterEmployees();
});