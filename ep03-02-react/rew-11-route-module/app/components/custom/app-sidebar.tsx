import { Home } from "lucide-react";
import { Sidebar, SidebarContent, SidebarHeader } from "../ui/sidebar";
import type { IconType } from "~/lib";

export default function AppSidebar() {
    return (
        <Sidebar>
            <SidebarHeader>
                <Home />
            </SidebarHeader>

            <SidebarContent>

            </SidebarContent>
        </Sidebar>
    )
}

type MenuBase = {
    title : string
    icon? : IconType
}

type MenuItemLink = MenuBase & {
    url : string
}

type MenuItemGroup = MenuBase & {
    children : MenuItemLink[]
}

type MenuItem = MenuItemLink | MenuItemGroup

type MenuGroup = MenuBase & {
    children : MenuItem[]
}

const MENU_DATA : MenuGroup[] = [
    {title: "Route Module", children : [

    ]},
]