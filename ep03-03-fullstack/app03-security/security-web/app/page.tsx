import { Button } from "@/components/ui/button";
import { LogIn, Shield, UserPlus } from "lucide-react";
import Link from "next/link";

export default function WelcomePage() {
  return (
    <div className="h-screen flex flex-col items-center justify-center gap-8">
      
      <header className="flex flex-col items-center justify-center gap-4">
        <Shield className="size-48" />
        <h1 className="uppercase text-3xl font-semibold">Security Demo</h1>
      </header>

      <nav className="space-x-1">
        <Button asChild>
          <Link href={'#'}>
            <LogIn /> Sign In
          </Link>
        </Button>

        <Button asChild>
          <Link href={'#'}>
            <UserPlus /> Sign Up
          </Link>
        </Button>
      </nav>

    </div>
  )
}