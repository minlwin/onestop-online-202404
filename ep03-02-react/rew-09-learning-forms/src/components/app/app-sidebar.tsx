import { useState } from "react"
import { Sidebar, SidebarContent, SidebarGroup, SidebarGroupContent, SidebarGroupLabel, SidebarHeader, SidebarMenu, SidebarMenuButton, SidebarMenuItem } from "../ui/sidebar"
import { House, ChevronDown, Group, Settings, Files, Calendar, CheckCircle, CheckSquare, ListCheck, PenBox, File, Image, Flag } from "lucide-react"
import { Collapsible, CollapsibleContent, CollapsibleTrigger } from "../ui/collapsible"
import type { MenuGroup } from "@/lib/types"
import { Link } from "react-router"
import { useAppTitle } from "@/lib/context/app-title-context"

export default function AppSideBar() {

  const [selected, setSelected] = useState(0)
  const {setTitle} = useAppTitle()

  return (
    <Sidebar variant="floating">
      <SidebarHeader>
        <SidebarMenu>
          <SidebarMenuItem>
            <SidebarMenuButton asChild>
              <Link to={`/`}><House /> Learning Forms</Link>
            </SidebarMenuButton>
          </SidebarMenuItem>
        </SidebarMenu>
      </SidebarHeader>

      <SidebarContent>
        {MENU.map((group, groupIndex) => 
          <Collapsible key={`group-${groupIndex + 1}`} open={selected == groupIndex} className="group/collapsible">
            <SidebarGroup >
              
              <SidebarGroupLabel onClick={() => setSelected(groupIndex)} asChild>
                <CollapsibleTrigger>
                  {group.label}
                  <ChevronDown className="ml-auto transition-transform group-data-[state=open]/collapsible:rotate-180" />
                </CollapsibleTrigger>
              </SidebarGroupLabel>
              
              <CollapsibleContent className="side-menu-group">
                <SidebarGroupContent>
                  <SidebarMenu>
                    {group.items.map((item, itemIndex) => 
                      <SidebarMenuItem key={`item-${groupIndex + 1}-${itemIndex + 1}`}>
                        <SidebarMenuButton asChild>
                          <Link onClick={() => setTitle(`Learning ${item.title}`)} to={item.url} >
                            {item.icon && <item.icon />}
                            <span>{item.title}</span>
                          </Link>
                        </SidebarMenuButton>
                      </SidebarMenuItem>
                    )}
                  </SidebarMenu>
                </SidebarGroupContent>
              </CollapsibleContent>

            </SidebarGroup>
          </Collapsible>
        )}
      </SidebarContent>
    </Sidebar>
  )
}

const MENU:MenuGroup[] = [
  {
    label : "Form with UI Component" , 
    items : [
      {title : "Inputs", url: "/basic/inputs", icon: PenBox},
      {title : "Check Box", url: "/basic/checks", icon: CheckSquare},
      {title : "Radio Group", url: "/basic/radio", icon: CheckCircle},
      {title : "Calendar", url: "/basic/date-picker", icon: Calendar},
      {title : "Selets", url: "/basic/select", icon: ListCheck},
      {title : "Using All", url: "/basic/all", icon: Flag}
    ]
  },
  {
    label: "Using Files",
    items : [
      {title: "Text File", url: "", icon: File},
      {title: "Single Image File", url: "", icon: Image},
      {title: "Multiple Image Files", url: "", icon: Files},
    ]
  },
  {
    label: "Nested Forms",
    items : [
      {title: "Form With Items", url: "", icon: Group},
      {title: "Dynamic Form Group", url: "", icon: Settings},
    ]
  }

]
