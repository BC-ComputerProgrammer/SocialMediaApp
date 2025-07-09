import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { signUp, signup } from '../services/authService';
import '../resources/css/SignUp.css';
import catImage from '../resources/images/cat.png';

const SignUpPage = () => {
    const navigate = useNavigate();
    const [formData, setFormData] = useState({
        username: '',
        email: '',
        phoneNumber: '',
        fullName: '',
        password: '',
        confirmPassword: ''
    });

    //state for errors
    const [errors, setErrors] = useState({
        username: '',
        email: '',
        phoneNumber: '',
        password: '',
        confirmPassword: '',
        general: ''
    });

    const [successMessage, setSuccessMessage] = useState('');



    const  handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prev => ({
            ...prev,
            [name]: value
        }));
        setErrors(prev => ({ ...prev, [name]: '' }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
          const result = await signUp(formData);
          setSuccessMessage('Account created successfully! Redirecting...');
          
          setTimeout(() => {
            navigate('/login');
          }, 2000);
        } catch (error) {
          const errorMessage = error.message;
    
          setErrors({
            username: /username/i.test(errorMessage) ? errorMessage : '',
            email: /email/i.test(errorMessage) ? errorMessage : '',
            phoneNumber: /phone/i.test(errorMessage) ? errorMessage : '',
            password: /password/i.test(errorMessage) ? errorMessage : '',
            confirmPassword: /match/i.test(errorMessage) ? errorMessage : '',
            general: !/username|email|phone|password|match/i.test(errorMessage) ? errorMessage : ''
        });
          
        }
    };

    return (
        <div className="signup-page">
      {/* Navigation - Consider making this a separate component */}
      <div className='topnav'>
        <a href='/'>Homepage</a>
        <a href='/signup'>Sign Up</a>
        <a href='/login'>Log In</a>
        <a href='/profile'>Profile</a>
      </div>

      <div className="main-content">
        <div className="signup-box">
          <form onSubmit={handleSubmit}>
            <img src={catImage} alt="person" className="logo-icon" />
            <p>Sign up to see photos and videos from your friends.</p><br />
            
            <br />
                        
            {/* Error messages */}
            {errors.general && (
              <p className="error-message">{errors.general}</p>
            )}
            {successMessage && (
              <p className="success-message">{successMessage}</p>
            )}
            <input
              type="text"
              name="username"
              placeholder="Username"
              value={formData.username}
              onChange={handleChange}
              required
            />
            {errors.username && (
              <p className="error-message">{errors.username}</p>
            )}
            
            
            <input
              type="email"
              name="email"
              placeholder="Email"
              value={formData.email}
              onChange={handleChange}
              required
            />
            {errors.email && (
              <p className="error-message">Email is not valid! Try Again</p>
            )}
            
            {/* Continue with other fields similarly */}
            <input
              type="tel"
              name="phoneNumber"
              placeholder="Phone Number"
              value={formData.phoneNumber}
              onChange={handleChange}
              required
            />

            {errors.phoneNumber && (
              <p className="error-message">Phone Number is not valid! Try Again</p>
            )}
            
            {/* Password fields */}
            <input
              type="password"
              name="password"
              placeholder="New Password"
              value={formData.password}
              onChange={handleChange}
              required
            />
            <input
              type="password"
              name="confirmPassword"
              placeholder="Confirm Password"
              value={formData.confirmPassword}
              onChange={handleChange}
              required
            />
            {errors.password && (
              <p className="error-message">Passwords do not match! Try Again</p>
            )}
            
            <p className="terms">
              People who use our service may have uploaded your contact information to Instagram.<br />
              By signing up, you agree to our Terms, Privacy Policy and Cookies Policy.
            </p>
            
            <button type="submit" className="signup-btn">Sign Up</button>
          </form>

          <div className="login-link">
            <p>Have an account? <a href="/login">Log in</a></p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default SignUpPage;