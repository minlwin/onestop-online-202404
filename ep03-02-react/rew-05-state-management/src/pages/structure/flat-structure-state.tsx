import { useState } from "react"
import {type FlatPlan, flatTravelPlan} from './flat-structure'

export default function FlatStructure() {

    const [flatPlan, setFlatPlan] = useState<Record<number, FlatPlan>>(flatTravelPlan)
    const basePlan = flatPlan[0]
    const [selectedPlan, setSelectedPlan] = useState<number>(1)

    const handleOnVisit = (placeId:number, parentId:number) => {
        const parent = flatPlan[parentId]
        const nextParent:FlatPlan = {...parent, childIds: parent.childIds.filter(id => id != placeId) }
        flatPlan[parentId] = nextParent
        setFlatPlan({...flatPlan})
    }

    return (
        <>
            <h3>Flat State</h3>

            <section className="accordion">
                {basePlan.childIds.map(childId => <PlaceComponent 
                    key={childId} 
                    planId={childId} 
                    parentId={0} 
                    planRecord={flatPlan} 
                    selectedId={selectedPlan}
                    onVisit={handleOnVisit} 
                    onClick={setSelectedPlan} />)}
            </section>
        </>
    )
}

function PlaceComponent({planId, parentId, planRecord, selectedId, onVisit, onClick} 
    : {
        planId : number, 
        parentId : number,
        planRecord : Record<number, FlatPlan>,
        selectedId: number,
        onVisit: (placeId:number, parentId:number) => void,
        onClick: (placeId:number) => void,
    }) {
    
    const plan = planRecord[planId]
    const show = (planId === selectedId || hasChildForShow(planRecord, planId, selectedId))
 
    if(plan.childIds.length == 0) {
        return (
            <div className="card mb-2">
                <div className="card-body d-flex justify-content-between align-items-center">
                    <span>{plan.title}</span>
                    <button onClick={() => onVisit(planId, parentId)} type="button" className="btn btn-outline-primary">
                        <i className="bi-check"></i> Visited
                    </button>
                </div>
            </div>
        )
    }
    
    return (
        <div className="accordion-item">
            <h5 className="accordion-header" onClick={() => onClick(planId)}>
                <button className={`accordion-button ${show ? '' : 'collapsed'}`} data-bs-toggle="collapse" data-bs-target={`#collapse-${planId}`}>{plan.title}</button>
            </h5>

            <div id={`collapse-${plan.id}`} className={`accordion-collapse collapse ${show ? 'show' : ''}`}>
                <div className="accordion-body">
                    {plan.childIds.map(childId => <PlaceComponent 
                        key={childId} 
                        planId={childId} 
                        parentId={planId} 
                        planRecord={planRecord} 
                        selectedId={selectedId}
                        onVisit={onVisit}
                        onClick={onClick} />)}
                </div>
            </div>
        </div>
    )
}

function hasChildForShow(planRecord : Record<number, FlatPlan>, planId:number, selectedId:number) {
    
    const plan = planRecord[planId]

    if(plan.childIds.length > 0) {
        for(const childId of plan.childIds) {
            if(childId === selectedId) {
                return true
            }

            const result = hasChildForShow(planRecord, childId, selectedId)

            if(result) {
                return true
            }
        }
    }
    
    return false
}