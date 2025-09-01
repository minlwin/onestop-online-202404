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

    route("/customer", "routes/customer/_layout.tsx", [
        index("routes/customer/home.tsx"),
        route("invoice", "routes/customer/invoices/_layout.tsx", [
            index("routes/customer/invoices/list.tsx"),
            route(":id", "routes/customer/invoices/details.tsx")
        ]),
        route("order", "routes/customer/orders/_layout.tsx", [
            index("routes/customer/orders/list.tsx"),
            route("edit", "routes/customer/orders/edit.tsx"),
            route(":id", "routes/customer/orders/details.tsx")
        ])
    ])
] satisfies RouteConfig;
