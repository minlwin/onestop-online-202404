import { Layout } from "antd";
import { Outlet } from "react-router";
import TopMenu from "../ui/top-menu";
const {Header, Content, Sider} = Layout


export default function BaseLayout() {
    return (
        <Layout className="flex h-full">
            <Sider width={280} className="bg-blue-100 h-full" >
                Hello Sider
            </Sider>
            <Layout className="flex-1">
                <Header className="bg-blue-200 px-8 py-4 shadow">
                    <TopMenu />
                </Header>
                <Content className="px-8 py-4">
                    <Outlet />
                </Content>
            </Layout>
        </Layout>
    )
}