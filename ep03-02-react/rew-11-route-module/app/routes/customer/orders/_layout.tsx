import { Outlet } from "react-router";

export const handle  = {
    title : "Orders"
}



export default function Layout() {
    return (
        <Outlet />
    )
}