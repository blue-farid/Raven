import React, {useState} from 'react';
import {Box, Heading, Input, Button, Flex, FormLabel} from '@chakra-ui/react';

function Signup() {
    const [firstname, setFirstname] = useState('');
    const [lastname, setLastname] = useState('');
    const [phone, setPhone] = useState('');
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [image, setImage] = useState('');
    const [bio, setBio] = useState('');


    const handleSignUp = () => {
        // Add your signup logic here
        console.log('Signing up:', {username, password});
    };

    return (
        <Flex align="center" justify="center" h="100vh">
            <Box p={8} maxW="400px" borderWidth={1} borderRadius={8} boxShadow="lg">
                <Heading mb={4}>Sign Up</Heading>
                <Input placeholder="First Name" mb={3} value={firstname}
                       onChange={(e) => setFirstname(e.target.value)}/>
                <Input placeholder="Last Name" mb={3} value={lastname} onChange={(e) => setLastname(e.target.value)}/>
                <Input placeholder="Phone Number" mb={3} value={phone} onChange={(e) => setPhone(e.target.value)}/>
                <Input placeholder="Username" mb={3} value={username} onChange={(e) => setUsername(e.target.value)}/>
                <Input
                    type="password"
                    placeholder="Password"
                    mb={3}
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <Input placeholder="Bio" mb={3} value={bio} onChange={(e) => setBio(e.target.value)}/>
                <Flex>
                    <FormLabel>image:</FormLabel>
                    <Input placeholder="Image" type="file" pt={1} mb={3} value={image}
                           onChange={(e) => setImage(e.target.value)}/>
                </Flex>

                <Button onClick={handleSignUp}>
                    Sign Up
                </Button>
            </Box>
        </Flex>
    );
}

export default Signup;
