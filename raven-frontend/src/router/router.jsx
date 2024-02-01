import { Outlet, createBrowserRouter } from 'react-router-dom';
import Signup from '../pages/signup';
import Login from '../pages/login';
import Home from '../pages/home';
import { TokenGuard } from './guards/token-guard';
import Authentication from "../pages/authentication/authentication";

export const router = createBrowserRouter([
    // unauthorized paths
    {
        path: '/login',
        element: <Login />,
    },
    {
        path: '/signup',
        element: <Signup />,
    },
    {
        path: '/auth',
        element: <Authentication />,
    },
]);