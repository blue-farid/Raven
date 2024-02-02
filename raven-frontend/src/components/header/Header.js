import React from 'react';
import {Box, Flex, Heading} from '@chakra-ui/react';
import SearchBox from "../searchBox/searchBox";

function Header() {
    return (
        <Box bg="blue.500" p={4} height={75}>
            <Flex justifyContent={"space-between"}>
                <Heading color="white">Raven Messenger</Heading>
                <SearchBox />
            </Flex>
        </Box>
    );
}

export default Header;
