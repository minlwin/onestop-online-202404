import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import { BrowserRouter, Route, Routes } from 'react-router'
import App from './App'
import ProjectList from './components/pages/projects/project-list.tsx'
import ProjectEdit from './components/pages/projects/project-edit.tsx'
import ProjectDetails from './components/pages/projects/project-details.tsx'
import TaskList from './components/pages/tasks/task-list.tsx'
import TaskEdit from './components/pages/tasks/task-edit.tsx'
import TaskDetails from './components/pages/tasks/task-details.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />}>
          <Route index element={<ProjectList />} />
          <Route path='project' element={<ProjectList />} />
          <Route path='project/edit' element={<ProjectEdit />} />
          <Route path='project/:id' element={<ProjectDetails />} />
          <Route path='task' element={<TaskList />} />
          <Route path='task/edit' element={<TaskEdit />} />
          <Route path='task/:id' element={<TaskDetails />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
