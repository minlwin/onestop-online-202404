import { Link } from "react-router";
import { Breadcrumb, BreadcrumbItem, BreadcrumbLink, BreadcrumbList, BreadcrumbSeparator } from "../ui/breadcrumb";
import { Fragment } from "react/jsx-runtime";

type BreadcrumbData = {
    title : string,
    path : string
}

export default function AppBreadcrumb({items} : {items : BreadcrumbData[]}) {
    return (
        <Breadcrumb>
            <BreadcrumbList>
                <BreadcrumbItem>
                    <BreadcrumbLink asChild>
                        <Link to={'/'}>Home</Link>
                    </BreadcrumbLink>
                </BreadcrumbItem>

                {items.map((item, index) => 
                    <Fragment key={index}>
                        <BreadcrumbSeparator />
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