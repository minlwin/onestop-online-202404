import { useState } from "react"
import {FlatPlan, flatTravelPlan} from './flat-structure'

export default function FlatStructure() {

    const [flatPlan] = useState<Record<number, FlatPlan>>(flatTravelPlan)

    return (
        <>
            <h3>Flat State</h3>

            <section className="accordion">

            </section>
        </>
    )
}

function PlaceComponent({plan} : {plan : FlatPlan}) {
    return (
        <></>
    )
}