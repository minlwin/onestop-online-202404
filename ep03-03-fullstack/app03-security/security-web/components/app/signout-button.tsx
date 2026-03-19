'use client'

import { LogOut } from "lucide-react";
import { useRouter } from "next/navigation";

export default function SignOutButton() {

    const router = useRouter()

    const onSignOut = () => {
        router.replace("/signin")
    }

    return (
        <button onClick={onSignOut} type="button" className="flex items-center gap-2 cursor-pointer">
            <LogOut className="size-4" /> Sign Out
        </button>
    )
}