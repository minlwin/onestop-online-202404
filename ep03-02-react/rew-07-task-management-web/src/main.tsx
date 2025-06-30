import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'
import { BrowserRouter, Route, Routes } from 'react-router'
import MemberListComponent from './pages/member/member-list.tsx'
import MemberEditComponent from './pages/member/member-edit.tsx'
import MemberDetailsComponent from './pages/member/member-details.tsx'
import ProjectListComponent from './pages/project/project-list.tsx'
import HomeComponent from './pages/home.tsx'
import TaskListComponent from './pages/task/task-list.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />} >
          <Route index element={<HomeComponent />} />
          <Route path='project' element={<ProjectListComponent />} />
          <Route path='member' element={<MemberListComponent />} />
          <Route path='member/edit' element={<MemberEditComponent />} />
          <Route path='member/details/:id' element={<MemberDetailsComponent />} />
          <Route path='task' element={<TaskListComponent />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
