import { useState, type PointerEventHandler } from "react"

export default function StateObject() {
    return (
        <section>
            <h3>Updating Object In State</h3>

            <div className="row">
                <div className="col">
                    <h5>Mutable Object</h5>
                    <MutableObject />
                </div>

                <div className="col">
                    <h5>Immutable Object</h5>
                    <ImmutableObject />
                </div>
            </div>
        </section>
    )
}

function MutableObject() {

    const [position, setPosition] = useState<{x: number, y: number}>({x: 0, y: 0})

    const onPointerMove:PointerEventHandler  = (event) => {
        position.x = event.clientX
        position.y = event.clientY
        setPosition(position)
    }

    return (
        <div className="card mt-3" style={{height: 360}} onPointerMove={onPointerMove}>
            <div className="card-body" style={{position : 'relative'}}>
                <div style={{
                    position: "absolute",
                    backgroundColor: 'red',
                    borderRadius: '50%',
                    width: 20,
                    height: 20,
                    top: 0,
                    left: 0,
                    transform : `translate(${position.x}px, ${position.y}px)`
                }}></div>
            </div>
        </div>
    )
}

function ImmutableObject() {
    const [position, setPosition] = useState<{readonly x: number, readonly y: number}>({x: 0, y: 0})

    const onPointerMove:PointerEventHandler  = (event) => {
        setPosition({x : event.clientX - 760, y : event.clientY - 180})
    }

    return (
        <div className="card mt-3" style={{height: 360}} onPointerMove={onPointerMove}>
            <div className="card-body" style={{position : 'relative'}}>
                <div style={{
                    position: "absolute",
                    backgroundColor: 'red',
                    borderRadius: '50%',
                    width: 20,
                    height: 20,
                    top: 0,
                    left: 0,
                    transform : `translate(${position.x}px, ${position.y}px)`
                }}></div>
            </div>
        </div>
    )}
