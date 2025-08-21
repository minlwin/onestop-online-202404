import { Card } from "antd";
import type { Route } from "./+types/using_path_variable_result";

export default function ResultView({params} : Route.ComponentProps) {
    return (
        <Card title="Path Variable Result">
            <p>Value of ID is : {params.id}</p>
        </Card>
    )
}