import { NavLink, Outlet } from "react-router"

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
    <nav className="navbar navbar-expand navbar-dark bg-primary">
      <div className="container">
        <NavLink className="navbar-brand" to="/">
          <i className="bi-house"></i> State Management
        </NavLink>

        <ul className="navbar-nav">
          <li className="nav-item">
            <NavLink to="/structure/deeply-nested" className="nav-link">
              <i className="bi-bezier2"></i> Nested State
            </NavLink>
          </li>
        </ul>
      </div>
    </nav>
  )
}
