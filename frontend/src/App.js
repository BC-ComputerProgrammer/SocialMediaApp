// import logo from './resources/images/cat.png';
import './resources/css/App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignUpPage from './pages/SignUp';
import Login from './pages/Login';
import Profile from './pages/Profile';


function App() {
  return (
   <div>
    <SignUpPage />
    <LoginPage />
   </div>
    
        
  );
}

export default App;
