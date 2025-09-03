import { Home, MessageSquare, ShoppingCart } from "lucide-react";
import { Outlet } from "react-router";
import AppPageHeader from "~/components/custom/app-page-header";
import AppSidebar, { type MenuItem } from "~/components/custom/app-sidebar";
import { SidebarProvider } from "~/components/ui/sidebar";

export const handle = {
    title : "Customer"
}

export default function Layout() {

    return (
        <SidebarProvider>
            <AppSidebar menus={MENUS} />

            <div className="px-8 w-full">
                <AppPageHeader />
                <main>
                    <Outlet />
                </main>
            </div>
        </SidebarProvider>
    )
}

const MENUS:MenuItem[] = [
    {title : "Home", icon: Home, url : '/customer'},
    {title : "Invoices", icon: MessageSquare, url: "/customer/invoice"},
    {title : "Orders", icon: ShoppingCart, url: "/customer/order"},
]