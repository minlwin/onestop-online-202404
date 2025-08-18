import { type RouteConfig, index, layout } from "@react-router/dev/routes";

export default [
    layout('./components/layout/base-layout.tsx', [
        index("routes/home.tsx")
    ])
] satisfies RouteConfig;
