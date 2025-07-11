import React, { useEffect, useState} from "react";
import { useNavigate } from "react-router-dom";
import "../resources/css/common.css";
import "../resources/css/Profile.css";
import {Link} from "react-router-dom";
import profilePic from '../resources/images/default-profile-pic.jpg';
import Sidebar from '../components/Sidebar';



const ProfilePage = () => {
    const navigate = useNavigate();
    const [profileData, setProfileData] = useState(null);

    const username = localStorage.getItem("username") || "Guest";


    useEffect(() => {
        if(!localStorage.getItem("username")){
            navigate("/login");
            return;
        }

        fetch("http://localhost:7001/api/profile", {
            credentials: "include"
        })
        .then((res) => {
            if(res.redirected || res.status === 401){
                navigate("/login");
                return;
            }
            return res.json();
        })
        .then((data) => {
            console.log("Received profile data:", data); 
            if(data) setProfileData(data);
        })
        .catch((err) => console.error("Failed to fetch profile:", err));

    }, [navigate]);

    const handleLogout = () => {
        localStorage.removeItem("username");
        navigate("/login");
    }

    if(!profileData) return <p>Loading...</p>

    return(
        <div className="profile-container">
            {/* Profile Sidebar */}
            <Sidebar />

            {/* Profile Header */}
            <header className="profile-header">
                <img
                    src={profilePic}
                    alt='Profile'
                    className='profile-pic'
                    onError={(e) => e.target.style.display = 'none'}
                />
                <h1>{profileData.username}'s Profile</h1>
            </header>

            {/* Profile Details */}
            <section className='profile-details'>
                <div className="detail-item">
                    <h3>Bio</h3>
                    <p> {profileData.bio} </p>
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