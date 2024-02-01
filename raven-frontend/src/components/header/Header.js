// Header.js

import React from 'react';
import {Box, Flex, Heading} from '@chakra-ui/react';

function Header() {
    return (
        <Box bg="blue.500" p={4}>
            <Flex>
                <Heading color="white">Messenger App</Heading>
            </Flex>
        </Box>
    );
}

export default Header;
