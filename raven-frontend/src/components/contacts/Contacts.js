// Contacts.js

import React from 'react';
import {Box, List, ListItem, Text} from '@chakra-ui/react';

const contactsData = [
    { id: 1, name: 'John Doe' },
    { id: 2, name: 'Jane Doe' },
    { id: 3, name: 'Saman Joon' },
];

function Contacts() {
    return (
        <Box w="25%" bg="gray.100" p={4}>
            <Text fontSize="xl" fontWeight="bold">Contacts</Text>
            <List spacing={2} mt={4}>
                {contactsData.map(contact => (
                    <ListItem key={contact.id} cursor="pointer" _hover={{ bg: 'gray.200' }}>
                        {contact.name}
                    </ListItem>
                ))}
            </List>
        </Box>
    );
}

export default Contacts;
