// Header.js

import React from 'react';
import {Box, Flex, Heading} from '@chakra-ui/react';

function Header() {
    return (
        <Box bg="blue.500" p={4} height={75}>
            <Flex>
                <Heading color="white">Raven Messenger</Heading>
            </Flex>
        </Box>
    );
}

export default Header;
