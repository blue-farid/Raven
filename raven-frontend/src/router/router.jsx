import { createBrowserRouter } from 'react-router-dom';
import Signup from '../pages/signup/signup';
import Login from '../pages/login/login';
import Chatroom from "../pages/chatroom/chatroom";

export const router = createBrowserRouter([
    {
        path: '/',
        element: <Chatroom />,
    },
    {
        path: '/login',
        element: <Login />,
    },
    {
        path: '/signup',
        element: <Signup />,
    },
]);