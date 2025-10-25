import logo from './logo.svg';
import './App.css';
import Pro from './Pro';
import EmployeeTable from './EmployeeTable';
import Navbar from './Navbar';
import Carousel from './Carousel';
import CardList from './CardList';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Department from './Department';

function App() {
  return (
    <div>
     <Router>
      <Navbar/>
      <Routes>
        <Route path = '/' element = {<Carousel/>}/>
        <Route path = '/employee' element = {<EmployeeTable/>}/>
        <Route path = '/department' element = {<Department/>}/>
      </Routes>
     </Router>
    </div>
    
  );
}

export default App;
