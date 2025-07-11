import React from "react";
import { useNavigate } from "react-router-dom";
import "../resources/css/common.css";
import "../resources/css/Profile.css";

const ProfilePage = () => {
    const navigate = useNavigate();

    const username = localStorage.getItem("username") || "Guest";

    const handleLogout = () => {
        localStorage.removeItem("username");
        navigate("/login");
    }

    if(!localStorage.getItem("username")) {
        navigate("/login");
        return null;
    }

    return(
        <div className="profile-container">
            <div className="topnav">
                <a href="/">Home</a>
                <a href="/signup">Sign Up</a>
                <a href="/login">Log In</a>
                <a href="/profile">Profile</a>
                <button onClick={handleLogout} className="logout-button">Log Out</button>
            </div>


            {/* Profile Header */}
            <header className="profile-header">
                <img
                    src='default-profile-pic.jpg'
                    alt='Profile'
                    className='profile-pic'
                />
                <h1>{username}'s Profile</h1>
            </header>

            {/* Profile Details */}
            <section className='profile-details'>
                <div className="detail-item">
                    <h3>Bio</h3>
                    <p> {/* users bio */} </p>
                </div>


            </section>

            {/* Footer */}
            <div className="footer">
                <p>Created by Bradley and Danya</p>
            </div>
        </div>

    
    );

};

export default ProfilePage;