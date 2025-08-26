import { Home } from "lucide-react"
import { Link, NavLink, Outlet } from "react-router"

export default function Layout() {
    return (
        <div>
            <Navbar />

            <main>
                <Outlet />
            </main>
        </div>
    )
}

function Navbar() {
    return (
        <nav className="flex px-8 py-4 justify-between">
            <Link to="/"><Home/> Home</Link>

            <ul>
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