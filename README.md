# Employee Management System (CRUD Application)

This is a CRUD application built on the Spring Boot framework. The purpose of this application is to efficiently manage employee information by providing users with the ability to add, view, update, and delete employee data.
## Features

1. **Add Employee**
   - **Endpoint**: `/employees`
   - **Method**: POST
   - **Description**: Adds a new employee to the system.
   - **Screenshot**:

   <img width="1004" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/fea8d98f-2c4f-44f9-bb47-5397eb79e2a6">


2. **Get Specific Employee**
   - **Endpoint**: `/employees/{id}`
   - **Method**: GET
   - **Description**: Retrieves the details of a specific employee using their ID.
   - **Screenshot**:

   <img width="1017" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/bfc18ed0-22b8-409b-a1cb-5b34554173df">


3. **Get All Employees**
   - **Endpoint**: `/employees`
   - **Method**: GET
   - **Description**: Retrieves the details of all employees.
   - **Screenshot**:

   <img width="1006" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/ae16105b-a576-48f2-8d4d-0162e746bf47">

4. **Update Employee's Data**
   - **Endpoint**: `/employees/{id}`
   - **Method**: PUT
   - **Description**: Updates the data of an existing employee using their ID.
   - **Screenshot**:

   <img width="1024" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/3863d899-903f-478c-9495-297c28bd4b77">
   <img width="1033" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/8b5c6967-50bc-43d4-be52-f2428b68dea1">



5. **Update Specific Employee Info**
   - **Endpoint**: `/employees/{id}`
   - **Method**: PATCH
   - **Description**:  Updates the data of an existing employee using their ID partially.
   - **Screenshot**:
     
   <img width="1050" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/505aaa24-4f2b-46d6-982c-0732656a4cb3">



6. **Delete Employee**
   - **Endpoint**: `/employees/{id}`
   - **Method**: DELETE
   - **Description**: Deletes a specific employee using their ID.
   - **Screenshot**:
   - 
   <img width="1038" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/c4e7d798-c89f-42d1-bbf1-983454174b6f">
   <img width="1032" alt="image" src="https://github.com/Aman3407/CRUD-WITH-SPRINGBOOT/assets/174441737/9e0c3434-7ac4-47a3-b3af-3fb36a2d02e7">



## Fields

- **id**: The unique identifier for the employee.
- **name**: The name of the employee.
- **dateOfJoining**: The date the employee joined the company.
- **isActive**: The active status of the employee.
