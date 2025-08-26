import { type RouteConfig, index, layout, route } from "@react-router/dev/routes";

export default [
    index("routes/home.tsx"),

    layout("routes/anonymous/_layout.tsx", [
        route("/about", "routes/anonymous/about-us.tsx"),
        route("/contact", "routes/anonymous/contact.tsx"),
    ]),

    layout("routes/auth/_layout.tsx", [
        route("/signin", "routes/auth/signin.tsx"),
        route("/signup", "routes/auth/signup.tsx"),
    ]),


] satisfies RouteConfig;
