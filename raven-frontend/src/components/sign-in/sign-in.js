// SignIn.js

import React, { useState } from 'react';
import { Box, Heading, Input, Button } from '@chakra-ui/react';

function SignIn() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleSignIn = () => {
        // Add your sign-in logic here
        console.log('Signing in:', { email, password });
    };

    return (
        <Box>
            <Heading mb={4}>Sign In</Heading>
            <Input placeholder="Email" mb={3} value={email} onChange={(e) => setEmail(e.target.value)} />
            <Input
                type="password"
                placeholder="Password"
                mb={3}
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            />
            <Button colorScheme="teal" onClick={handleSignIn}>
                Sign In
            </Button>
        </Box>
    );
}

export default SignIn;
