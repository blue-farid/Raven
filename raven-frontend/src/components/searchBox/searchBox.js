import React, { useState } from 'react';
import { Input, Box } from '@chakra-ui/react';

function SearchBox() {
    const [searchQuery, setSearchQuery] = useState('');

    const handleSearch = () => {
        // Pass the search query to the parent component
        // onSearch(searchQuery);
        console.log(searchQuery);
    };

    return (
        <Box>
            <Input
                placeholder="Search..."
                backgroundColor={"white"}
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
                onKeyDown={(e) => e.key === 'Enter' && handleSearch()}
            />
        </Box>
    );
}

export default SearchBox;
