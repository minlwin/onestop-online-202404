import { BookOpen, CalendarCheck, Home } from "lucide-react";
import Link from "next/link";

export default function AppMenu() {
    return (
        <nav className="bg-white shadow">
            <div className="px-14 flex justify-between">
                <Link href={"/"} className="flex gap-2 items-center py-4 px-4">
                    <Home className="size-4" /> Home
                </Link>

                <div className="flex gap-4">
                    <Link href={"/courses"} className="flex gap-2 items-center py-4 px-4">
                        <BookOpen className="size-4" /> Courses
                    </Link>

                    <Link href={"/classes"} className="flex gap-2 items-center py-4 px-4">
                        <CalendarCheck className="size-4" /> Classes
                    </Link>
                </div>
            </div>
        </nav>
    )
}