import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.tsx'
import { BrowserRouter, Route, Routes } from 'react-router'
import DeeplyNestedState from './pages/structure/deeply-nested-state.tsx'
import Home from './pages/home.tsx'
import FlatStructure from './pages/structure/flat-structure-state.tsx'
import ReducerHome from './pages/reducer/reducer-home.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route element={<App />} >
          <Route index element={<Home />} />
          <Route path="/structure/deeply-nested" element={<DeeplyNestedState />} />
          <Route path="/structure/flat" element={<FlatStructure />} />
          <Route path="/reducer" element={<ReducerHome />} />
        </Route>
      </Routes>
    </BrowserRouter>    
  </StrictMode>,
)
