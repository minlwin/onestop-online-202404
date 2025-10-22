import type { Metadata } from "next";
import "./globals.css";
import AppMenu from "@/components/app/top-menu";

export const metadata: Metadata = {
  title: "Fetch Demo",
  description: "Learning about Rest Client via fetch",
};

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body>

        <AppMenu />

        <main className="px-16 py-4">
          {children}
        </main>
      </body>
    </html>
  );
}
