import { NavLink, Outlet } from "react-router"
import type { DropdownMenuModel } from "./ui/menu/dropdown-menu"
import DropdownMenu from "./ui/menu/dropdown-menu"

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
          <DropdownMenu model={STATE_STRUCTURE_MENU} />
          <DropdownMenu model={REDUCER_MENU} />
          <DropdownMenu model={CONTEXT_MENU} />
        </ul>

      </div>
    </nav>
  )
}

const STATE_STRUCTURE_MENU:DropdownMenuModel = {
  title: "State Structure",
  items: [
    {name : "Nested Structure", link : "/structure/deeply-nested"},
    {name : "Flat Structure", link : "/structure/flat"},
  ]
}

const REDUCER_MENU :DropdownMenuModel = {
  title: "Reducer",
  items: [
    {name : "Without Reducer", link : "/reducer/without"},
    {name : "Using Reducer", link : "/reducer/with"},
    {name : "Reducer with Immer", link : "/reducer/immer"},
  ]
}

const CONTEXT_MENU :DropdownMenuModel = {
  title: "Context",
  items: [
    {name : "Sample 1", link : "/context/sample1"},
    {name : "Sample 2", link : "/context/sample2"},
  ]
}