import { Menu, type MenuProps } from "antd";
import { useEffect, useState } from "react";
import { useLocation } from "react-router";
import { Outlet, useNavigate } from "react-router";

export default function NestedRouteLayout() {

    const location = useLocation()
    const fromSub = location.state?.sub || false

    const navigate = useNavigate()
    const [current, setCurrent] = useState("/nested/nested1")

    useEffect(() => {
        if(!fromSub) {
            setCurrent("/nested/nested1")
        }
    }, [fromSub, setCurrent])

    const onSubMenuClick:MenuProps['onClick'] = e => {
        setCurrent(e.key)
        navigate(e.key, {state : {sub : true}})
    }

    return (
        <section className="flex gap-8">
            {/* Sub Menu */}
            <nav className="w-1/4">
                <Menu items={MENU_ITEM} onClick={onSubMenuClick} selectedKeys={[current]} />
            </nav>

            {/* Sub Router Outlet */}
            <article>
                <Outlet />
            </article>
        </section>
    )
}

type MenuItem = Required<MenuProps>['items'][number]

const MENU_ITEM: MenuItem[] = [
    {key : "/nested/nested1", label: "Sub Menu 1"},
    {key : "/nested/nested2", label: "Sub Menu 2"},
    {key : "/nested/nested3", label: "Sub Menu 3"},
]