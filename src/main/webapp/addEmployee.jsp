<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
 <link rel = "stylesheet" href = "css/addEmp.css" >
</head>
<body>
     <h2>Add Employee</h2>
     
     <form action="EmployeeServlet" method="post">
    
      <div class = "form-group">
       <label>Employee Name</label>
       <input type = "text"  name ="name" placeholder = "Enter the EmployeeName" required>
      </div> 
     
      
      <div class = "form-row">
          <div class = "form-group">
           <label>Email</label>
     
       <input type = "email"  name ="email" placeholder = "Enter the Email" required>
       <label>Phone Number</label>
      
       <input type = "number"  name ="number" placeholder = "Enter the PhoneNumber" required>
     
       </div>
      </div>
    
         <label>Gender</label>
       <br>
       <input type = "radio"  name ="gender" value = "male">Male
          <input type = "radio"  name ="gender" value = "Female">Female
             <input type = "radio"  name ="gender" value = "Other">Other
       <br><br>
         <label>Department</label>
       <br>
       <select name = "department">
          <option>HR </option>
            <option>IT </option>
              <option>Finance </option>
                <option>Testing </option>
                <option> Developer </option>
       </select>
       <br><br>
            <div class = "form-row">
             <div class="form-group"> 
                 <label>Salary</label>
       <input type = "number" name = "salary"  required>
       <label>Joining Date</label>
       <input type = "date" name = "joiningdate"  required>
       
             </div>
         </div>
       
        <label>Address</label>
       <br>
        <textarea name = "address" rows = "4" cols = "30"></textarea>
       <br><br>
        <label>Skills</label>
       <br>
       <input type = "checkbox" name = "skills"  value = "Java">Java
       <input type = "checkbox" name = "skills"  value = "HTML">HTML
       <input type = "checkbox" name = "skills"  value = "CSS">CSS
       <input type = "checkbox" name = "skills"  value = "SQL">SQL
       <br><br>
        <div class="button-row">
            <button type = "submit">Save Employee</button>
       <button type = "reset"> Cancel</button>
        </div>
      
     </form>
</body>
</html>