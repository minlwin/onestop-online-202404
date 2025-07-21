import { Link, Outlet } from "react-router"

export default function App() {
  return (
    <>
      <NavigationBar />

      <main className="my-4 mx-16">
        <Outlet />
      </main>
    </>
  )
}

function NavigationBar() {
  return (
    <nav className="px-16 flex justify-between items-center w-full bg-teal-700 text-white">
      <div>
        <Link to={'/'}>Task Management</Link>
      </div>

      <div>
        <Link className="inline-block px-4 py-4 hover:bg-teal-400" to="/project">Projects</Link>
        <Link className="inline-block px-4 py-4 hover:bg-teal-400" to="/task">Tasks</Link>
      </div>
    </nav>
  )
} 