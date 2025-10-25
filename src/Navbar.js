import React from 'react'
import './Navbar.css';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <div>
        <nav class="navbar navbar-expand-lg navbar-dark custom-navbar">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarColor01">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <Link class="nav-link" to ="/">Home
          <span class="sr-only">(current)</span>
        </Link>
      </li>
      <li class="nav-item">
        <Link class="nav-link" to ="/employee">EmployeeTable</Link>
      </li>
      <li class="nav-item">
        <Link class="nav-link" to ="department">Department</Link>
      </li>
      <li class="nav-item">
        <Link class="nav-link" to ="Product">Product</Link>
      </li>
      
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search"/>
      <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
      
    </div>
  )
}
