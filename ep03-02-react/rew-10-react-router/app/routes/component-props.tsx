import { Button, Card, Input } from "antd";
import type { Route } from "./+types/component-props";
import { Form, useMatch, useMatches, type ActionFunctionArgs, type LoaderFunctionArgs } from "react-router";

export const handle = {
    title : "Component Props"
}

export async function loader({params} : LoaderFunctionArgs) {
    return Object.keys(params).length == 0 ? {message : "This is message from Loader"}
        : params
}

export default function ComponentProps({
    matches,
    params,
    loaderData,
    actionData
}:Route.ComponentProps) {

    return (
        <div>
            
            <section className="flex gap-4">

                <Card title="Matches" className="!flex-1">
                    <pre>{JSON.stringify(matches, null, 2)}</pre>
                </Card>

                <div className="flex-1 flex flex-col gap-4">
                    <Card title="Params">
                        <pre>{JSON.stringify(params, null, 2)}</pre>
                    </Card>

                    <Card title="Loader Data">
                        <pre>{JSON.stringify(loaderData, null, 2)}</pre>
                    </Card>

                    <Card title="Action Form">
                        <Form method="post" action="/props">
                            <div className="mb-3">
                                <label className="block mb-2">Message</label>
                                <Input placeholder="Message" name="message" />
                            </div>
                            <Button htmlType="submit">Send</Button>
                        </Form>
                    </Card>

                    <Card title="Action Data">
                        <pre>{JSON.stringify(actionData, null, 2)}</pre>
                    </Card>
                </div>

            </section>            
        </div>

    )
}

export async function action({request} : ActionFunctionArgs) {
    const data = await request.formData()
    console.log(data)
    return {message : data.get('message')}
}