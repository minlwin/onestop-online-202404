import SignOutButton from "@/components/app/signout-button";
import { User } from "lucide-react";
import React from "react";

export default function MemberLayout({children} : {children : React.ReactNode}) {
    return (
        <div className="h-screen">
            <nav className="bg-white shadow px-12 py-4 flex justify-between items-center">
                <h1 className="flex gap-2 items-center">
                    <User /> 
                    <span className="text-xl font-semibold">Member Home</span>
                </h1>

                <SignOutButton />
            </nav>

            <main className="px-12 py-4">
                {children}
            </main>
        </div>
    )
}