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
import ProjectEdit from './pages/project/project-edit.tsx'
import TaskEdit from './pages/task/task-edit.tsx'
import TaskDetails from './pages/task/task-details.tsx'
import ProjectDetails from './pages/project/details/_layout.tsx'
import ProjectTaskList from './pages/project/details/task-list.tsx'
import ProjectCategoryList from './pages/project/details/category-list.tsx'
import ProjectMemberList from './pages/project/details/member-list.tsx'
import ProjectTaskEdit from './pages/project/details/task-edit.tsx'
import ProjectOverview from './pages/project/details/project-overview.tsx'

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<App />} >
          <Route index element={<HomeComponent />} />
          <Route path='project' element={<ProjectListComponent />} />
          <Route path='project/edit' element={<ProjectEdit />} />
          <Route path='project/details/:id' element={<ProjectDetails />}>
            <Route path='overview' element={<ProjectOverview />} />
            <Route path='category' element={<ProjectCategoryList />} />
            <Route path='member' element={<ProjectMemberList />} />
            <Route path='task' element={<ProjectTaskList />} />
            <Route path='task/edit' element={<ProjectTaskEdit />} />
          </Route>
          <Route path='member' element={<MemberListComponent />} />
          <Route path='member/edit' element={<MemberEditComponent />} />
          <Route path='member/details/:id' element={<MemberDetailsComponent />} />
          <Route path='task' element={<TaskListComponent />} />
          <Route path='task/edit' element={<TaskEdit />} />
          <Route path='task/details/:id' element={<TaskDetails />} />
        </Route>
      </Routes>
    </BrowserRouter>
  </StrictMode>,
)
