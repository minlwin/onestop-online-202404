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
          <li className="nav-item dropdown">
            <a href="#" className="nav-link dropdown-toggle" data-bs-toggle="dropdown">
              State Structure
            </a>
            <ul className="dropdown-menu">
              <li>
                <NavLink to="/structure/deeply-nested" className="dropdown-item">
                  <i className="bi-bezier2"></i> Nested State
                </NavLink>
              </li>
              <li>
                <NavLink to="/structure/flat" className="dropdown-item">
                  <i className="bi-bezier"></i> Flat State
                </NavLink>
              </li>
            </ul>
          </li>
          <li className="nav-item dropdown">
            <a href="#" className="nav-link dropdown-toggle" data-bs-toggle="dropdown">
              Reducer
            </a>
            <ul className="dropdown-menu">
              <li>
                <NavLink to="/reducer/without" className="dropdown-item">Without Reducer</NavLink>
              </li>
              <li>
                <NavLink to="/reducer/with" className="dropdown-item">With Reducer</NavLink>
              </li>
              <li>
                <NavLink to="/reducer/immer" className="dropdown-item">Immer with Reducer</NavLink>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  )
}
