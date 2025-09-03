import { Link } from "react-router";
import { Button } from "../ui/button";
import AppBreadcrumb from "./app-breadcrumb";
import { LogOut } from "lucide-react";

export default function AppPageHeader() {
    return (
        <header className="py-4 flex justify-between items-center">
            <AppBreadcrumb />     
            <Button asChild variant={"ghost"}>
                <Link to={'/signin'}>
                    <LogOut /> Sign Out
                </Link>
            </Button>
        </header>
    )
}