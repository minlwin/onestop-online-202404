import {
  isRouteErrorResponse,
  Link,
  Links,
  Meta,
  Outlet,
  Scripts,
  ScrollRestoration,
  useNavigate,
} from "react-router";

import type { Route } from "./+types/root";
import "./app.css";
import { Menu, type MenuProps } from "antd";
import { useState } from "react";

export const links: Route.LinksFunction = () => [
  { rel: "preconnect", href: "https://fonts.googleapis.com" },
  {
    rel: "preconnect",
    href: "https://fonts.gstatic.com",
    crossOrigin: "anonymous",
  },
  {
    rel: "stylesheet",
    href: "https://fonts.googleapis.com/css2?family=Inter:ital,opsz,wght@0,14..32,100..900;1,14..32,100..900&display=swap",
  },
];

export function Layout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="en">
      <head>
        <meta charSet="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <Meta />
        <Links />
      </head>
      <body>
        {children}
        <ScrollRestoration />
        <Scripts />
      </body>
    </html>
  );
}

export default function App() {

  const navigate = useNavigate()

  const [selected, setSelected] = useState('/')
  const onMenuSelect:MenuProps['onClick'] = e => {
    setSelected(e.key)
    navigate(e.key)
  }

  return (
    <>
      <nav className="shadow">
        <Menu items={APP_MENU_DATA} selectedKeys={[selected]} mode="horizontal"
          className="!px-8" onClick={onMenuSelect} />
      </nav>

      <main className="px-12 py-8">
        <Outlet />
      </main>
    </>
  );
}

export function ErrorBoundary({ error }: Route.ErrorBoundaryProps) {
  let message = "Oops!";
  let details = "An unexpected error occurred.";
  let stack: string | undefined;

  if (isRouteErrorResponse(error)) {
    message = error.status === 404 ? "404" : "Error";
    details =
      error.status === 404
        ? "The requested page could not be found."
        : error.statusText || details;
  } else if (import.meta.env.DEV && error && error instanceof Error) {
    details = error.message;
    stack = error.stack;
  }

  return (
    <main className="pt-16 p-4 container mx-auto">
      <h1>{message}</h1>
      <p>{details}</p>
      {stack && (
        <pre className="w-full p-4 overflow-x-auto">
          <code>{stack}</code>
        </pre>
      )}
    </main>
  );
}

type MenuItem = Required<MenuProps>['items'][number]

const APP_MENU_DATA: MenuItem[] = [
    {key : "/", label: "Single Menu"},
    {key : "/nested/nested1", label : "Sub Routing"},
    {key : "menu-3", label : "Using Parameter", children: [
        {type : 'item', label : 'Path Parameter', key : '/group/path-variable'},
        {type : 'item', label : 'Query Parameter', key : '/group/query-param'},
    ]},
    {key : "menu-4", label : "Actions"},
    {key : "menu-5", label : "Data Loading"},
]
