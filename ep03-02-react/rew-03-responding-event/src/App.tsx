import { NavLink, Route, Routes } from 'react-router'
import './App.css'
import Home from './pages/home'
import HandlingEvent from './pages/handling-event'
import ReadingProperties from './pages/reading-props'
import PassingHandler from './pages/passing-handler'
import NamingEventHandler from './pages/naming-handler'

export default function App() {
  return (
    <>
      <NavBar />

      <main className='mt-4 container'>
        <Routes>
          <Route index element={<Home />} />
          <Route path='/handling' element={<HandlingEvent />} />
          <Route path='/reading-props' element={<ReadingProperties />} />
          <Route path='/passing-props' element={<PassingHandler />} />
          <Route path='/naming' element={<NamingEventHandler />} />
        </Routes>
      </main>
    </>
  )
}

function NavBar() {
  return (
    <nav className='navbar navbar-expand navbar-dark bg-primary'>
      <div className="container">
        <NavLink className={'navbar-brand'} to={'/'}>Responding Event</NavLink>

        <ul className="navbar-nav">
          <NavItem path='/handling' name='Handling' />
          <NavItem path='/reading-props' name='Reading Properties' />
          <NavItem path='/passing-props' name='Passing Handler' />
          <NavItem path='/naming' name='Naming Handler' />
        </ul>
      </div>
    </nav>
  )
}

function NavItem({path, name} : {path:string, name:string}) {
  return (
    <li className="nav-item">
      <NavLink className="nav-link" to={path}>{name}</NavLink>
    </li>
  )
}