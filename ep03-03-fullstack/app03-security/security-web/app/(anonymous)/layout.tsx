import { Button } from "@/components/ui/button";
import { Home, Shield } from "lucide-react";
import Link from "next/link";
import React from "react";

export default function AnonymousLayout({children} : {children : React.ReactNode}) {
    return (
        <div className="h-screen flex">
            <header className="flex-1 bg-gray-700 text-white flex flex-col items-center justify-center gap-4">
                <Shield className="size-48" />
                <h1 className="text-4xl font-bold uppercase">Security Demo</h1>
                <Button asChild variant={'secondary'}>
                    <Link href={'/'}>
                        <Home /> Home
                    </Link>
                </Button>
            </header>

            <main className="flex-1 flex items-center justify-center">
                <section className="w-1/2">
                    {children}
                </section>
            </main>
        </div>
    )
}