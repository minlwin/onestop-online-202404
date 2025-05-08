import { Check, SwitchCamera, X } from "lucide-react";
import PageTitle from "../components/PageTitle";
import { useState } from "react";
import Card from "../components/Card";

export default function ConditionalRendering() {

    const [state, setState] = useState<boolean>(false)

    const toggle = () => setState(!state)

    return (
        <>
            <PageTitle title="Conditional Rendering" icon={
                <SwitchCamera />
            } />

            <div className="section row row-cols-3">
                <div className="col">
                    <Card title="AND Condition">
                        {state && <Check />}
                        <div>state && Check</div>
                    </Card>
                </div>  
                <div className="col">
                    <Card title="OR Condition">
                        {state || <X />}
                        <div>state || X</div>
                    </Card>
                </div>  
                <div className="col">
                    <Card title="Ternary Condition">
                        {state ? <Check /> : <X />}
                        <div>state ? Check : X</div>
                    </Card>
                </div>  
            </div>

            <button onClick={toggle} className="btn btn-outline-primary mt-3">
                <SwitchCamera /> Toggle
            </button>
        </>    
    )
}