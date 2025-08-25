import { Button, Card, Form, Input, type FormProps } from "antd";
import { useNavigate, useSearchParams } from "react-router";

type FieldType = {
    name? : string
    phone? : string
    email? : string
}

type KeyOfForm = keyof FieldType

export default function UsingQueryParams() {
    const [searchParams] = useSearchParams()
    const navigate = useNavigate()

    const onFinished : FormProps<FieldType>['onFinish'] = (values) => {
        const query = (Object.keys(values) as KeyOfForm[])
            .filter(key => values[key])
            .map(key => `${key}=${encodeURI(values[key] || '')}`)
            .join("&")
        
        navigate(`/group/query-param?${query}`)
    }
  
    return (
        <>
            <h1 className="text-2xl mb-4">Using Query Params</h1>

            <section className="flex gap-8">

                <Card title="Enter Query Params" className="flex-1">
                    <Form onFinish={onFinished} layout="vertical" >
                        <Form.Item<FieldType> label="Name" name={"name"}>
                            <Input placeholder="Enter Name" />
                        </Form.Item>
                        <Form.Item<FieldType> label="Phone" name={"phone"}>
                            <Input placeholder="Enter Name" />
                        </Form.Item>
                        <Form.Item<FieldType> label="Email" name={"email"}>
                            <Input placeholder="Enter Name" />
                        </Form.Item>

                        <Form.Item>
                            <Button htmlType="submit">Send</Button>
                        </Form.Item>
                    </Form>
                </Card>

                <Card title="Param Values" className="flex-1">
                    {searchParams.size == 0 && 
                        <div>There is no params</div>
                    }

                    {Array.from(searchParams.entries()).map(entry => 
                        <div key={entry[0]} className="flex justify-between">
                            <span>{entry[0]}</span>
                            <span>{entry[1]}</span>
                        </div>
                    )}
                </Card>

            </section>
        </>
    )
}