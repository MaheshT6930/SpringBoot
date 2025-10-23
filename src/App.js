import logo from './logo.svg';
import './App.css';
import Pro from './Pro';
import EmployeeTable from './EmployeeTable';
import Navbar from './Navbar';
import Carousel from './Carousel';
import CardList from './CardList';

function App() {
  return (
    <div>
      <Navbar/>
      <Carousel/>
      <CardList/>
    
      
      <Pro name = "Mobile"  Price= "5000" Discription = "A sleek smartphone with powerful performance and all-day battery life"/>
      <Pro name = "Mobile2"  Price= "5000" Discription = "A sleek smartphone with powerful performance and all-day battery life"/>
     

      <EmployeeTable/>
    </div>
    
  );
}

export default App;
