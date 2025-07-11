// import logo from './resources/images/cat.png';
import './resources/css/App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignUpPage from './pages/SignUp';
import LoginPage from './pages/Login';
import ProfilePage from './pages/Profile';


function App() {
  return (
    
      <Routes>
        <Route path="/signup" element={<SignUpPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/profile" element={<ProfilePage />} />

        <Route path="/" element={<LoginPage />} />
      </Routes>
   
    
        
  );
}

export default App;
