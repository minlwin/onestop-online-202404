import { Home, ShoppingCart, User } from "lucide-react";
import { Sidebar, SidebarContent, SidebarGroup, SidebarGroupContent, SidebarHeader, SidebarMenu, SidebarMenuButton, SidebarMenuItem } from "../ui/sidebar";
import type { IconType } from "~/lib";
import { NavLink } from "react-router";

export default function AppSidebar({menus} : {menus : MenuItem[]}) {
    return (
        <Sidebar>
            <SidebarHeader>
                <div className="flex items-center gap-4">
                    <ShoppingCart size={60} /> 
                    <div className="flex flex-col">
                        <span className="text-2xl">MY SHOP</span>
                        <span>Customer</span>
                    </div>
                </div>
            </SidebarHeader>

            <SidebarContent className="mt-6">
                <SidebarGroup>
                    <SidebarGroupContent>
                        <SidebarMenu>
                            {menus.map((item, index) => 
                                <SidebarMenuItem key={index}>
                                    <SidebarMenuButton asChild>
                                        <NavLink to={item.url}>
                                            <item.icon />
                                            <span>{item.title}</span>
                                        </NavLink>
                                    </SidebarMenuButton>
                                </SidebarMenuItem>
                            )}
                        </SidebarMenu>
                    </SidebarGroupContent>
                </SidebarGroup>
            </SidebarContent>
        </Sidebar>
    )
}

export type MenuItem = {
    title : string
    icon : IconType
    url : string
}

