// import logo from './resources/images/cat.png';
import './resources/css/App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignUpPage from './pages/SignUp';
import LoginPage from './pages/Login';
import ProfilePage from './pages/Profile';
import HomePage from './pages/Home';
import ExplorePage from './pages/Explore';
import MessagePage from './pages/Message';
import CreatePage from './pages/Create';


function App() {
  return (
    
      <Routes>
        <Route path="/signup" element={<SignUpPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/profile" element={<ProfilePage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/explore" element={<ExplorePage />} />
        <Route path="/messages" element={<MessagePage />} />
        <Route path="/create" element={<CreatePage />} />
        <Route path="/" element={<LoginPage />} />
      </Routes>
   
    
        
  );
}

export default App;
