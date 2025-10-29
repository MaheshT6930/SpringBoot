import React, { useState } from 'react';


import axios from 'axios';


export default function Registration() {
    
  const [user, setUser] =  useState({name:"", emailId:"", password:"",address:""})

  const handleChange = (e) => {  
    setUser({...user, [e.target.name]: e.target.value});
  }

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post("http://localhost:8082/register", user)
    .then(response => {
      alert(response.data);
setUser({name:"", emailId:"", password:"",address:""});
    }
    ).catch(error => {
      console.error("There was an error!", error);
    });
  }

  return (
    <div>
      <h1>Registration Page</h1>
      <form >
<label>Name:</label><br/>
<input type="text" name="name" value={user.name} onChange={handleChange} required /><br/><br/>
<label>Email ID:</label><br/> 
<input type="email" name="emailId" value={user.emailId} onChange={handleChange} required /><br/><br/>
<label>Password:</label><br/>
<input type="password" name="password" value={user.password} onChange={handleChange} required /><br/><br/>      

<label>Address:</label><br/>
<input type="text" name="address" value={user.address} onChange={handleChange} required /><br/><br/>
<button type="submit" onClick={handleSubmit} class="btn btn-primary">Register</button>
    
      </form>

    </div>
  )
}
