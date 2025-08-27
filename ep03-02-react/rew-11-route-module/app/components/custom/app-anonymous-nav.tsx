import { Home } from "lucide-react";
import { Link, NavLink } from "react-router";

export default function AppAnonymousNav() {
    return (
        <nav className="flex px-8 py-4 justify-between">
            <Link to="/" className="flex items-center gap-2">
                <Home size={24}/> 
                <span className="text-xl">Home</span>
            </Link>

            <ul className="flex gap-4">
                <li>
                    <NavLink to="/about">About Us</NavLink>
                </li>
                <li>
                    <NavLink to="/contact">Contact</NavLink>
                </li>
                <li>
                    <NavLink to="/signin">Sign In</NavLink>
                </li>
            </ul>
        </nav>
    )
}