import { Calendar, CheckCircle, CheckSquare, ChevronDown, File, Files, Group, House, Image, ListCheck, PenBox, Settings, type LucideProps } from "lucide-react";
import { Sidebar, SidebarContent, SidebarGroup, SidebarGroupContent, SidebarGroupLabel, SidebarHeader, SidebarMenu, SidebarMenuButton, SidebarMenuItem, SidebarProvider, SidebarTrigger } from "./components/ui/sidebar";
import { Link, Outlet } from "react-router";
import { Collapsible, CollapsibleContent, CollapsibleTrigger } from "./components/ui/collapsible";
import { useState } from "react";

export default function App() {
  return (
    <SidebarProvider>
      <AppSideBar />
      <div>
        <SidebarTrigger></SidebarTrigger>

        <main>
          <Outlet />
        </main>
      </div>
    </SidebarProvider>
  )
}

type MenuItem = {
  title: string
  icon?: React.ForwardRefExoticComponent<Omit<LucideProps, "ref"> & React.RefAttributes<SVGSVGElement>>
  url: string
}

type MenuGroup = {
  label: string
  items: MenuItem []
}

const MENU:MenuGroup[] = [
  {
    label : "Form with UI Component" , 
    items : [
      {title : "Inputs", url: "", icon: PenBox},
      {title : "Check Box", url: "", icon: CheckSquare},
      {title : "Radio Group", url: "", icon: CheckCircle},
      {title : "Calendar", url: "", icon: Calendar},
      {title : "Selets", url: "", icon: ListCheck},
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

function AppSideBar() {

  const [selected, setSelected] = useState(0)

  return (
    <Sidebar>
      <SidebarHeader>
        <SidebarMenu>
          <SidebarMenuItem>
            <SidebarMenuButton asChild>
              <Link to={``}><House /> Using Forms</Link>
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
              
              <CollapsibleContent>
                <SidebarGroupContent>
                  <SidebarMenu>
                    {group.items.map((item, itemIndex) => 
                      <SidebarMenuItem key={`item-${groupIndex + 1}-${itemIndex + 1}`}>
                        <SidebarMenuButton asChild>
                          <Link to={item.url} >
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