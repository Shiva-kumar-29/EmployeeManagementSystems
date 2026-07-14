const loginForm = document.querySelector('form');
const usernameField = document.querySelector('input[name="userName"]');
const passwordField = document.querySelector('input[name="password"]');
const emailField = document.querySelector('input[name="email"]');
const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;


loginForm.addEventListener('submit',function(event) {
	event.preventDefault();
   
	
	const usernameValue = usernameField.value.trim();	
	const passwordValue = passwordField.value.trim();
    const emailValue = emailField.value.trim(); 
	
	if(usernameValue === ""){
		alert("Username cannot be empty");
		return;
	}
	if(passwordValue === ""){
		alert("Password cannot be empty");
		return;
	}
	if(passwordValue.length <6){
		alert("Password must be atlease 6 characters")
		return 
	}
	if(emailValue === "") {
		alert("Email cannot be empty")
		return 
	}
	
	if(!emailPattern.test(emailValue)) {
		alert("Please enter a valid email address");
		return;
	}
	
	console.log("Validation passed. Ready to send to server.");
	
});