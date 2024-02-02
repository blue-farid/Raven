import React, { useState, useRef, useEffect } from 'react';
import { Box, Text, List, ListItem } from '@chakra-ui/react';
import MessageInput from "../messageInput/messageInput";

function Messaging() {
    const [messages, setMessages] = useState([]);
    const messageListRef = useRef();

    useEffect(() => {
        // Scroll to the bottom of the message list when messages change
        if (messageListRef.current) {
            messageListRef.current.scrollTop = messageListRef.current.scrollHeight;
        }
    }, [messages]);

    const handleSendMessage = (newMessage) => {
        // Add the new message to the messages state
        setMessages([...messages, { text: newMessage, sender: 'user' }]);
        // Add your logic to send the message to the server or recipient
    };

    return (
        <Box flex="1" p={4} position="relative">
            <Text fontSize="xl" fontWeight="bold">Messaging</Text>
            <Box
                ref={messageListRef}
                overflowY="auto"
                maxHeight="calc(100% - 80px)" // Adjust as needed to leave space for the input
                mt={4}
            >
                <List spacing={4}>
                    {messages.map((message, index) => (
                        <ListItem key={index}>
                            {message.sender === 'user' ? 'You: ' : 'Other: '}
                            {message.text}
                        </ListItem>
                    ))}
                </List>
            </Box>
            <Box position="absolute" bottom="0" left="0" width="100%">
                <MessageInput onSendMessage={handleSendMessage} />
            </Box>
        </Box>
    );
}

export default Messaging;
