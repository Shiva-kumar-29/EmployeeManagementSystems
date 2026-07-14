<%@ page import="java.util.List" %>
<%@ page import="model.Employee" %>

<% 
List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee</title>



<style>
body {
 font-family : Arial,sans-serif;
 background-color :#f4f4f4;
}
  table {
    width :80%;
    margin:30px auto;
 border-collapse:collapse;
    background-color:white;
    
  }
  th,td {
   border:1px.solid black;
   padding:10px;
   text-align:cneter; 
  }
  th {
    background-color: lightblue;
        color:white;
    
  }
  tr:nth-child(even){
    background-color:#f2f2f2;
}
  
 h2 {
  text-align:center;
  color:#333;
 }
button{
    background-color:#28a745;
    color:white;
    border:none;
    padding:8px 15px;
    border-radius:5px;
    cursor:pointer;
    margin-right:10px;
}

button:hover{
    background-color:#218838;
}
</style>

</head>
<body>
    
     <h2>Employee Details</h2>
      <table>
         <tr> 
          <th>ID</th>
            <th>Name</th>
              <th>Email</th>
                <th>Phone</th>
                  <th>Department</th>
                    <th>Salary</th>
                    <th>Joining Date</th>  
                    <th>Action</th>
         </tr>
 <%

 if(employeeList != null && !employeeList.isEmpty()){

	    for(Employee employee : employeeList){

%>


<tr>

<td><%= employee.getId() %></td>

<td><%= employee.getName() %></td>

<td><%= employee.getEmail() %></td>

<td><%= employee.getPhone() %></td>

<td><%= employee.getDepartment() %></td>

<td><%= employee.getSalary() %></td>

<td><%= employee.getJoiningDate() %></td>


    <td>

    <a href="<%= request.getContextPath() %>/EditEmployeeServlet?id=<%= employee.getId() %>">
        <button type="button">Edit</button>
    </a>
  &nbsp;&nbsp;
    <a href="<%= request.getContextPath() %>/DeleteEmployeeServlet?id=<%= employee.getId() %>"
       onclick="return confirm('Are you sure you want to delete this employee?');">
        <button type="button">Delete</button>
    </a>

</td>

</tr>


<%
	    }
} else {
	

%>
<tr>
    <td colspan="8">No Employees Found</td>
</tr>
        
<%
}
%>
      </table>
      
      
</body>
</html>