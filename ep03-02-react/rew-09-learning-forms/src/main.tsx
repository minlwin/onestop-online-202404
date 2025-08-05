import { StrictMode } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import UiInputs from './components/page/basic/ui-inputs.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />}>
          <Route path='basic/inputs' element={<UiInputs />} />        
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
