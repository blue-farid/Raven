import {
    extendTheme,
    theme as baseTheme,
    withDefaultColorScheme,
} from '@chakra-ui/react';

const config = {
    initialColorMode: 'light',
    useSystemColorMode: false,
};

const colors = {
    primary: baseTheme.colors.telegram,
};

export const theme = extendTheme(
    { config, colors },
    withDefaultColorScheme({ colorScheme: 'primary' }),
);