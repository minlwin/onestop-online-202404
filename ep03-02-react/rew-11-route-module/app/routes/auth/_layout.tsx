import { Flashlight, Home, ShoppingCart } from "lucide-react";
import { Link, Outlet } from "react-router";
import { Button } from "~/components/ui/button";

export default function Layout() {
    return (
        <div className="flex w-full h-full">
            <div className="flex-1 bg-gray-500 text-white flex flex-col justify-center items-center gap-2">
                <ShoppingCart size={180} className="animate-bounce" />
                <h1 className="text-5xl">MY SHOP</h1>
                <Button asChild className="bg-gray-200 text-gray-800 hover:text-white">
                    <Link to="/">
                        <Home /> Home
                    </Link>
                </Button>
            </div>
            <main className="flex-1 flex items-center justify-center">
                <div className="w-3/5">
                    <article className="flex flex-col gap-4">
                        <Outlet />
                    </article>
                </div>
            </main>
        </div>
    )
}