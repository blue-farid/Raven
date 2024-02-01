// App.js

import React from 'react';
import { ChakraProvider } from '@chakra-ui/react';
import Header from './components/header/Header';
import Contacts from './components/contacts/Contacts';
import Messaging from './components/messaging/Messaging';

function App() {
    return (
        <ChakraProvider>
            <div>
                <Header />
                <div style={{ display: 'flex', height: 'calc(100vh - 50px)' }}>
                    <Contacts />
                    <Messaging />
                </div>
            </div>
        </ChakraProvider>
    );
}

export default App;
