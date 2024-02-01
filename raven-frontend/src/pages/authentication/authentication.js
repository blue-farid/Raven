// AuthPage.js

import React from 'react';
import { Box, Flex } from '@chakra-ui/react';
import SignUp from '../../components/sign-up/sign-up';
import SignIn from '../../components/sign-in/sign-in';

function AuthPage() {
    return (
        <Flex align="center" justify="center" h="100vh">
            <Box p={8} maxW="400px" borderWidth={1} borderRadius={8} boxShadow="lg">
                <SignUp />
                <Box mt={4} mb={4} borderWidth={1} />
                <SignIn />
            </Box>
        </Flex>
    );
}

export default AuthPage;
