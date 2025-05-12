import { NavLink, Route, Routes } from "react-router"
import Home from "./pages/home"
import MultipleState from "./pages/multiple-state"

export default function App() {
  return (
    <>
      <NavBar />

      <main className="container mt-4">
        <Routes>
          <Route index element={<Home />} />
          <Route path="/multiple" element={<MultipleState />} />
        </Routes>
      </main>
    </>
  )
}

function NavBar() {
  return (
    <nav className="navbar navbar-expand bg-light shadow">

      <div className="container">
        <a className="navbar-brand">
          Component State
        </a>

        <ul className="navbar-nav">
          <li className="nav-item">
            <NavLink className={'nav-link'} to={'/multiple'}>Multiple State</NavLink>
          </li>
        </ul>
      </div>
    </nav>
  )
}