import type { Route } from "./+types/home";

export const handle = {
    title : "Home"
}

export function headers() {
  return {
     "X-Stretchy-Pants": "its for fun",
  }
}

export function meta({}: Route.MetaArgs) {
  return [
    { title: "New React Router App" },
    { name: "description", content: "Welcome to React Router!" },
  ];
}

export default function Home() {
  return (
    <>Hello Ant Design And React Router</>
  );
}
