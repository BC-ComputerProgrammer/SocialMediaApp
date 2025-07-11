import React from "react";
import { FaHome, FaCompass, FaEnvelope, FaPlus, FaBell, FaBars} from "react-icons/fa";
import { useNavigate } from "react-router-dom";
import profilePic from '../resources/images/default-profile-pic.jpg';
import '../resources/css/Sidebar.css';

export default function Sidebar(){
    const navigate = useNavigate();

    return (
        <aside className="sidebar">
            <h2 className="app-name">Social Media App</h2>

            <nav className="sidebar-nav">
                <SidebarLink icon={<FaHome />} label="Home" onClick={() => navigate ("/home")} />
                <SidebarLink icon={<FaCompass />} label="Explore" onClick={() => navigate ("/explore")} />
                <SidebarLink icon={<FaEnvelope />} label="Messages" onClick={() => navigate ("/messages")} />
                <SidebarLink icon={<FaPlus />} label="Create" onClick={() => navigate ("/create")} />

                <div className="profile-link" onClick={() => navigate("/profile")}>
                    <img src={profilePic} alt="avatar" className="avatar"/>
                    <span>Profile</span>
                </div>
                <SidebarLink icon={<FaBell />} label="Notifications" onClick={() => navigate ("/notifications")} />
                <SidebarLink icon={<FaBars />} label="More" onClick={() => console.log("More")} />

            </nav>
        </aside>
    )

} 

function SidebarLink({icon, label, onClick}){
    return (
        <div className="sidebar-link" onClick={onClick}>
            {icon}
            <span>{label}</span>
        </div>
    );
}

