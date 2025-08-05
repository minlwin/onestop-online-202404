import { SidebarProvider } from "@/components/ui/sidebar";
import { Outlet } from "react-router";
import AppSideBar from "./components/app/app-sidebar";
import AppTitle from "./components/app/app-title";
import { useState } from "react";
import { AppTitleContext } from "./lib/context/app-title-context";
import AppFormResult from "./components/app/app-form-result";
import { FormResultContext } from "./lib/context/form-result-context";

export default function App() {

  const [title, setTitle] = useState("Learning Form")
  const [formResult, setFormResult] = useState<string>()

  return (
    <AppTitleContext.Provider value={{title : title, setTitle : setTitle}}>
      <SidebarProvider>
        <AppSideBar />
        <div className="py-2 pe-2 w-full">
          <main className="border w-full h-full shadow rounded-md">
            <AppTitle />
            <FormResultContext.Provider value={{result : formResult, setResult : setFormResult}}>
              <div className="flex px-6 gap-8">
                <div className="flex-1">
                  <h3 className="text-lg mb-3">Form</h3>
                  <Outlet />
                </div>
                <div className="flex-1">
                  <AppFormResult />
                </div>
              </div>
            </FormResultContext.Provider>

          </main>
        </div>
      </SidebarProvider>
    </AppTitleContext.Provider>
  )
}