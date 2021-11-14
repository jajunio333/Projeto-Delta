import logo from 'assets/img/home.png'
import { Link } from 'react-router-dom';

function NavBar() {
    return (
        <div className="d-flex flex-column flex-md-row align-items-center  px-md-4 mb-3 bg-ligth border-bottom shadow-sm">
        <div className="container" >
          <nav className="my-2 my-md-1 mr-md-3">
           <Link to="/">
            <img src={logo} alt="falhou" width="60" height="60"/> 
            </Link>
          </nav>
        </div>
      </div>
      
    );
  }
  
  export default NavBar;
  