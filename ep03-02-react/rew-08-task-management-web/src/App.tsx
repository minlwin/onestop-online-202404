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
    <nav className="px-16 py-4 flex justify-between items-center w-full bg-teal-700 text-white">
      <div>
        <Link to={'/'}>Task Management</Link>
      </div>

    </nav>
  )
} 