import { Outlet } from "react-router";

export default function Layout() {
    return (
        <div className="flex w-full h-full">
            <div className="flex-1"></div>
            <main className="flex-1">
                <Outlet />
            </main>
        </div>
    )
}