import React from 'react'
import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Product from './Product';


export default function Login() {
    const [emailId, setEmaiId] = useState('');
    const [password, setPassword] = useState('');
    const navigate = useNavigate();

    const handleLogin= (e) =>{
        e.preventDefault();
        axios.post('http://localhost:8082/login',{
            emailId: emailId,
            password: password
        })
        .then(res => {
            console.log('Login Successful', res.data);
            alert('login successful');
            navigate('/Product');

        })
        .catch(err => {
            console.error('error during login', err);
            alert('login failed. please chech your credentials.');
        });
    }


  return (
    <div>
      <hi> Login Page</hi>
      <form onSubmit={handleLogin}> 
        <div>
            <label>EmailId:</label>
            <input type= "text" name= "emailId" placeholder='Enter EmailId' onChange={e => setEmaiId(e.target.value) }/>
            <br/>
            <label>Password:</label>
            <input type= "password" name= "password" placeholder='Enter Password' onChange={e => setPassword(e.target.value)} />
            <br/>
            <button type= "submit"> Login</button>


        </div>
      </form>
    </div>
  )
}
