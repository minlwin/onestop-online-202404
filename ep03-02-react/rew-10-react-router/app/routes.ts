import { type RouteConfig, index, prefix, route } from "@react-router/dev/routes";

export default [
    index("routes/home.tsx"),
    route("props/:first?/:second?", "routes/component-props.tsx"),
    
    ...prefix('group', [
        route('path-variable', 'routes/group/using_path_variable.tsx', [
            index("routes/group/using_path_variable_index.tsx"),
            route(":id", "routes/group/using_path_variable_result.tsx")
        ]),
        route('query-param', 'routes/group/using_query_params.tsx'),
    ]),

    route("nested", "routes/nested/_layout.tsx", [
        route("nested1", "routes/nested/nested-1.tsx"),        
        route("nested2", "routes/nested/nested-2.tsx"),        
        route("nested3", "routes/nested/nested-3.tsx"),        
    ]),

] satisfies RouteConfig;
