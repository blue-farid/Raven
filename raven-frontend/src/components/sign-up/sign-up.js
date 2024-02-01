// SignUp.js

import React, { useState } from 'react';
import { Box, Heading, Input, Button } from '@chakra-ui/react';

function SignUp() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSignUp = () => {
        // Add your sign-up logic here
        console.log('Signing up:', { email, password });
    };

    return (
        <Box>
            <Heading mb={4}>Sign Up</Heading>
            <Input placeholder="Email" mb={3} value={email} onChange={(e) => setEmail(e.target.value)} />
            <Input
                type="password"
                placeholder="Password"
                mb={3}
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <Button colorScheme="teal" onClick={handleSignUp}>
                Sign Up
            </Button>
        </Box>
    );
}

export default SignUp;
