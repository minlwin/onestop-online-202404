import { useState } from "react"
import { sculptureList } from "../model/data"

export default function MultipleState() {

    return (
        <section>
            <h3>Multiple State of a Component</h3>

            <div className="row mt-3">
                <div className="col">
                    <Gallary />
                </div>
                <div className="col">
                    <Gallary />
                </div>
            </div>
        </section>
    )
}

function Gallary() {
    const [index, setIndex] = useState(0)
    const [showContent, setShowContent] = useState(false)

    const handleNext = () => {
        setIndex(index + 1)

        if(index >= sculptureList.length - 1) {
            setIndex(0)
        }
    }

    const toggleContent = () => {
        setShowContent(!showContent)
    }

    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title d-flex justify-content-between align-items-center">
                    Using State
                    <button onClick={handleNext} className="btn btn-outline-primary">
                        Next
                    </button>
                </h5>
                <div>

                    <h5>{sculptureList[index].name} by {sculptureList[index].artist}</h5>
                    <p>({`${index + 1} of ${sculptureList.length}`})</p>

                    <img src={sculptureList[index].url} alt={sculptureList[index].alt} />
                    
                    <div className="mt-3">
                        <button onClick={toggleContent} className="btn btn-outline-primary">
                            Show Description
                        </button>
                    </div>

                    {showContent && 
                        <p className="mt-4">{sculptureList[index].description}</p>
                    }

                </div>
            </div>
        </div>
    ) 
}