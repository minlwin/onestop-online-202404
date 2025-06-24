import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { BrowserRouter, Route, Routes } from 'react-router'
import Home from './pages/home.tsx'
import ProjectList from './pages/project/project-list.tsx'
import MemberList from './pages/member/member-list.tsx'
import TaskList from './pages/task/task-list.tsx'
import MemberEdit from './pages/member/member-edit.tsx'
import MemberDetails from './pages/member/member-details.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />} >
          <Route index element={<Home />} />
          <Route path='project' element={<ProjectList />} />
          <Route path='member' element={<MemberList />} />
          <Route path='member/edit' element={<MemberEdit />} />
          <Route path='member/details/:id' element={<MemberDetails />} />
          <Route path='task' element={<TaskList />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
