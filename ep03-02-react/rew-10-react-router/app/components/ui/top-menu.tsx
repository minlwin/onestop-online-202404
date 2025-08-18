import { Menu, type MenuProps } from "antd";
import { MenuOutlined } from "@ant-design/icons"

type MenuItem = Required<MenuProps>['items'][number]

const items: MenuItem[] = [
    {label : "Menu 1", key : "menu1", icon : <MenuOutlined />},
    {label : "Menu 2", key : "menu2", icon : <MenuOutlined />},
    {label : "Menu 3", key : "menu3", icon : <MenuOutlined />},
]

export default function TopMenu() {
    return (
        <Menu mode="horizontal" items={items}  />
    )
}