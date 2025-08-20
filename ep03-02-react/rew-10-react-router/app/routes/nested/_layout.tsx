import { Menu, type MenuProps } from "antd";
import { useState } from "react";
import { Outlet, useNavigate } from "react-router";

export default function NestedRouteLayout() {

    const navigate = useNavigate()
    const [current, setCurrent] = useState("/nested/nested1")

    const onSubMenuClick:MenuProps['onClick'] = e => {
        setCurrent(e.key)
        navigate(e.key)
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