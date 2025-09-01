import { Outlet } from "react-router"
import AppAnonymousNav from "~/components/custom/app-anonymous-nav"

export default function Layout() {
    return (
        <div>
            <div className="shadow-md">
                <AppAnonymousNav />
            </div>

            <main className="px-8 py-4 ">
                <Outlet />
            </main>
        </div>
    )
}

