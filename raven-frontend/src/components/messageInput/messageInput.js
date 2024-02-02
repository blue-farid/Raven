import React, { useState } from 'react';
import { Input, Button, Flex } from '@chakra-ui/react';
import {Form} from "react-router-dom";

function MessageInput({ onSendMessage }) {
    const [message, setMessage] = useState('');

    const handleSendMessage = () => {
        if (message.trim() !== '') {
            // Call the onSendMessage prop with the current message
            onSendMessage(message);
            // Clear the input field after sending the message
            setMessage('');
        }
    };

    return (
        <Form onSubmit={handleSendMessage}>
            <Flex p={2}>
                <Input
                    placeholder="Type your message..."
                    value={message}
                    onChange={(e) => setMessage(e.target.value)}
                    mr={2}
                />
                <Button type={"submit"}>
                    Send
                </Button>
            </Flex>
        </Form>
    );
}

export default MessageInput;
