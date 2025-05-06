import { NavLink, Route, Routes } from 'react-router'
import './App.css'
import ProductList from './pages/product-list'
import ComponentAsArgs from './pages/component-as-args'

export default function App() {

  return (
    <>
      <NavBar />

      <div className="container mt-4">
        <Routes>
          <Route index element={<ProductList />} />
          <Route path='/as-arg' element={<ComponentAsArgs />} />
        </Routes>
      </div>
    </>
  )
}

function NavBar() {
  return (
    <nav className='navbar navbar-expand bg-light shadow'>
      <div className="container">
        <span className="navbar-brand">Learning Component</span>

        <ul className="navbar-nav">
          <NavItem path='/' name='Product List' />
          <NavItem path='/as-arg' name='As Argument' />
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