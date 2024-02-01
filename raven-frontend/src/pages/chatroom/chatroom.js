import Header from "../../components/header/Header";
import Contacts from "../../components/contacts/Contacts";
import Messaging from "../../components/messaging/Messaging";
import React from "react";

function Chatroom() {
    return (
        <div>
            <Header/>
            <div style={{display: 'flex', height: 'calc(100vh - 50px)'}}>
                <Contacts/>
                <Messaging/>
            </div>
        </div>
    )
}

export default Chatroom;