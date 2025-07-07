import { NavLink, Outlet } from "react-router";
import Page from "../../../ui/page";

export default function ProjectDetails() {
    return (
        <Page icon="bi-rocket" title="Project Details">
            <Navigation />
            <section className="mt-3">
                <Outlet />
            </section>
        </Page>
    )
}

function Navigation() {
    return (
        <ul className="nav nav-underline">
            <li className="nav-item">
                <NavLink to="overview" className="nav-link">Overview</NavLink>
            </li>
            <li className="nav-item">
                <NavLink to="task" className="nav-link">Tasks</NavLink>
            </li>
            <li className="nav-item">
                <NavLink to="member" className="nav-link">Members</NavLink>
            </li>
            <li className="nav-item">
                <NavLink to="category" className="nav-link">Categories</NavLink>
            </li>
        </ul>
    )
}