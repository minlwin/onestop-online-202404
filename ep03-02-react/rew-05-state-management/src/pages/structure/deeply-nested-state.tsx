import { useState } from "react";
import { travelPlan, type Place } from "./deeply-nested";

export default function DeeplyNestedState() {

    const [planList] = useState<Place[]>(travelPlan)

    return (
        <>
            <h3>Nested State</h3>

            <section className="accordion">
                {planList.map(plan => <PlaceComponent key={plan.id} place={plan} />)}
            </section>
        </>
    )
}

function PlaceComponent({place} : {place: Place}) {

    if(!place.childPlaces || place.childPlaces.length == 0) {
        return (
            <div className="card mb-2">
                <div className="card-body">
                    {place.title}
                </div>
            </div>
        )
    }

    return (
        <div className="accordion-item">
            <h5 className="accordion-header">
                <button className={`accordion-button ${place.id == 1 ? '' : 'collapsed'}`} data-bs-toggle="collapse" data-bs-target={`#collapse-${place.id}`}>{place.title}</button>
            </h5>

            <div id={`collapse-${place.id}`} className={`accordion-collapse collapse ${place.id == 1 ? 'show' : ''}`}>
                <div className="accordion-body">
                    {place.childPlaces && place.childPlaces.map(child => <PlaceComponent key={child.id} place={child} />)}
                </div>
            </div>
        </div>
    )
}