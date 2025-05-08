import { ArrowRight } from "lucide-react";
import PageTitle from "../components/PageTitle";
import { useState } from "react";

export default function PassingHandler() {

    const [color, setColor] = useState<'blue' | 'red' | 'black'>('black')
    
    const setBackBlue = () => setColor('blue')
    const setBackRed = () => setColor('red')

    return (
        <>
            <PageTitle title="Passing Handler" icon={<ArrowRight />} />
        
            <section className="mt-4">

                <div style={{width: 400, height: 150, backgroundColor : color}} className="mb-4"></div>

                <Button name="Blue" btnClass="btn-primary me-2" onClick={setBackBlue} />
                <Button name="Red" btnClass="btn-danger" onClick={setBackRed} />

            </section>
        </>
    )
}

function Button({btnClass, name, onClick} : {btnClass:string, name:string, onClick:VoidFunction}) {
    return (
        <button onClick={onClick} className={`btn ${btnClass}`}>{name}</button>
    )
}
