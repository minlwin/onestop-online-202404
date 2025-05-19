import { NavLink, Route, Routes } from "react-router"
import Home from "./pages/home"
import MultipleState from "./pages/multiple-state"
import StateObject from "./pages/state-object"
import SpreadStateObject from "./pages/state-spread"
import StateNestedObject from "./pages/state-nested"
import StateArray from "./pages/state-array"

export default function App() {
  return (
    <>
      <NavBar />

      <main className="container mt-4">
        <Routes>
          <Route index element={<Home />} />
          <Route path="/multiple" element={<MultipleState />} />
          <Route path="/object" element={<StateObject />} />
          <Route path="/spread" element={<SpreadStateObject />} />
          <Route path="/nested" element={<StateNestedObject />} />
          <Route path="/array" element={<StateArray />} />
        </Routes>
      </main>
    </>
  )
}

function NavBar() {
  return (
    <nav className="navbar navbar-expand bg-light shadow">

      <div className="container">
        <NavLink to={'/'} className="navbar-brand">
          Component State
        </NavLink>

        <ul className="navbar-nav">
          <li className="nav-item">
            <NavLink className={'nav-link'} to={'/multiple'}>Multiple State</NavLink>
          </li>
          <li className="nav-item dropdown">
            <a className="nav-link dropdown-toggle" data-bs-toggle="dropdown">
              State Object
            </a>
            <ul className="dropdown-menu">
              <li><NavLink className={'dropdown-item'} to={'/object'}>Object as a State</NavLink></li>
              <li><NavLink className={'dropdown-item'} to={'/spread'}>Spread State Object</NavLink></li>
              <li><NavLink className={'dropdown-item'} to={'/nested'}>Nested State Object</NavLink></li>
            </ul>
          </li>
          <li className="nav-item">
            <NavLink className={'nav-link'} to={'/array'}>Array As State</NavLink>
          </li>
        </ul>
      </div>
    </nav>
  )
}