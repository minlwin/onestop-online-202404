import { StrictMode } from 'react'
import { BrowserRouter, Route, Routes } from 'react-router'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import UiInputs from './components/page/basic/ui-inputs.tsx'
import UiChecks from './components/page/basic/ui-checks.tsx'
import UiRadios from './components/page/basic/ui-radios.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />}>
          <Route path='basic/inputs' element={<UiInputs />} />    
          <Route path='basic/checks' element={<UiChecks />} />    
          <Route path='basic/radio' element={<UiRadios />} />    
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
