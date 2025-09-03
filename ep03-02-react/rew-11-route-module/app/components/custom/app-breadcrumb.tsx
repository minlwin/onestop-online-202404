import { Link, useMatches } from "react-router";
import { Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList, BreadcrumbSeparator } from "../ui/breadcrumb";
import { Fragment } from "react/jsx-runtime";

type BreadcrumbData = {
    title : string,
    path : string
}

export default function AppBreadcrumb() {

    const matches = useMatches()

    const items:BreadcrumbData[] = matches
        .filter(match => match.handle)
        .map(match => {
            const handle = match.handle as {title : string}
            return {
                title : handle.title,
                path: match.pathname
            }
        })

    return (
        <Breadcrumb>
            <BreadcrumbList>
                {items.map((item, index) => 
                    <Fragment key={index}>
                        {index > 0 && <BreadcrumbSeparator />}
                        <BreadcrumbItem>
                            <BreadcrumbLink asChild>
                                <Link to={item.path}>{item.title}</Link>
                            </BreadcrumbLink>
                        </BreadcrumbItem>
                    </Fragment>
                )}
            </BreadcrumbList>
        </Breadcrumb>
    )
}