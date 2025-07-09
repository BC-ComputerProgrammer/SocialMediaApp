import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import '../resources/css/LoginPage.css';
import { login } from '../services/authService'; 
import catImage from '../resources/images/cat.png';

const LoginPage = () => {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        username: '',
        password: ''
    });

    const [errors, setErrors] = useState({
        usernameError: '',
        passwordError: '',
        general: ''
    });

    const handleChange = (e) => {
        const {name, value} = e.target;

        setFormData((prev) => ({
            ...prev,
            [name]: value
        }));

        setErrors((prev) => ({
            ...prev,
            [name + 'Error']: '',
            general: ''
        }));
    };

    const handleSubmit = async(e) => {
        e.preventDefault();

        try{
            await login(formData);
            localStorage.setItem("username", formData.username);
            navigate('/Profile');
        }catch(error){

            console.log("RAW ERROR:", error);
            console.log("Response data:", error?.response?.data);

            const errorMessage= error?.response?.data?.error || error.message || 'Login failed';

            if (errorMessage === 'Username does not exist') {
                setErrors((prev) => ({ ...prev, usernameError: errorMessage }));
            } else if (errorMessage === 'Invalid username') {
                setErrors((prev) => ({ ...prev, usernameError: errorMessage }));
            } else if (errorMessage === 'Invalid password') {
                setErrors((prev) => ({ ...prev, passwordError: errorMessage }));
            } else if (errorMessage === 'Incorrect password') {
                setErrors((prev) => ({ ...prev, passwordError: errorMessage }));
            } else {
                setErrors((prev) => ({ ...prev, general: errorMessage }));
            }
        }
    };

    return(
        <div className="login-page">
            <div className="topnav">
                <a href="/">Homepage</a>
                <a href="/signup">Sign Up</a>
                <a href="/login">Log In</a>
                <a href="/profile">Profile</a>
            </div>

            <div className="main-content">
                <div className="login-box">
                    <form onSubmit={handleSubmit}>
                        <img src={catImage} alt="icon" className="logo-icon" /><br /><br />
                        
                        {errors.general && (
                            <p className="error-message">{errors.general}</p>
                        )}

                        {/* Username Input */}
                        <input 
                            type="text"
                            name="username"
                            placeholder="Username"
                            value={formData.username}
                            onChange={handleChange}
                            required
                        />

                        {errors.usernameError && (
                            <p className="error-message">{errors.usernameError}</p>
                        )}

                        {/* Password Input */}
                        <input
                            type="password"
                            name="password"
                            placeholder="Password"
                            value={formData.password}
                            onChange={handleChange}
                            required
                        />

                        {errors.passwordError && (
                            <p className="error-message">{errors.passwordError}</p>
                        )}

                        <p className="question">Forgot password?</p>

                        <button type="submit" className="login-btn">Log In</button>

                    </form>

                    <div className="login-link">
                        <p>Don't have an account? <a href="/signup">Sign up</a></p>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default LoginPage;