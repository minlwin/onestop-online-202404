import { Outlet } from "react-router";

export const handle  = {
    title : "Invoices"
}

export default function Layout() {
    return (
        <Outlet />
    )
}