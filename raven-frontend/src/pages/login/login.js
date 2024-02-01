import React, { useState } from 'react';
import {Box, Heading, Input, Button, Flex} from '@chakra-ui/react';

function Login() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleLogin = () => {
        // Add your login logic here
        console.log('Logging in:', { username, password });
    };

    return (
        <Flex align="center" justify="center" h="100vh">
            <Box p={8} maxW="400px" borderWidth={1} borderRadius={8} boxShadow="lg">
                <Heading mb={4}>Login</Heading>
                <Input placeholder="Username" mb={3} value={username} onChange={(e) => setUsername(e.target.value)} />
                <Input
                    type="password"
                    placeholder="Password"
                    mb={3}
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <Button onClick={handleLogin}>
                    Login
                </Button>
            </Box>
        </Flex>
    );
}

export default Login;
