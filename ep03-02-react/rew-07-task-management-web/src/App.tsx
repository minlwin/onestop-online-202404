import { Link, NavLink, Outlet } from "react-router"

export default function App() {
  return (
    <>
      <NavBar />

      <main className="container mt-4">
        <Outlet />
      </main>
    </>
  )
}

function NavBar() {
  return (
    <nav className="navbar navbar-dark bg-black navbar-expand">
      <div className="container">
        <Link className="navbar-brand" to="/">
          <i className="bi-house"></i> Task Manager
        </Link>

        <ul className="navbar-nav">
          <li className="nav-item">
            <NavLink to="/project" className="nav-link">
              <i className="bi-rocket-takeoff"></i> Projects
            </NavLink>
          </li>
          <li className="nav-item">
            <NavLink to="/member" className="nav-link">
              <i className="bi-people"></i> Members
            </NavLink>
          </li>
        </ul>
      </div>
    </nav>
  )
}