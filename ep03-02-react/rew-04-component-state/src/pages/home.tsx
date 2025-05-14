import { useState } from "react";
import { sculptureList } from "../model/data";

export default function Home() {
    return (
        <section>
            <h3>First Component State</h3>

            <div className="row mt-4">
                <div className="col">
                    <WithoutState />
                </div>

                <div className="col">
                    <WithState />
                </div>
            </div>
        </section>
    )
}

function WithoutState() {

    let index = 0
    let sculpture = sculptureList[index]

    const handleNext = () => {
        index ++;
        if(index >= sculptureList.length) {
            index = 0
        }

        sculpture = sculptureList[index]
    }


    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title d-flex justify-content-between align-items-center">
                    Without Using State
                    <button onClick={handleNext} className="btn btn-outline-primary">
                        Next
                    </button>
                </h5>
                <div>

                    <h5>{sculpture.name} by {sculpture.artist}</h5>
                    <p>({`${index} of ${sculptureList.length}`})</p>

                    <img src={sculpture.url} alt={sculpture.alt} />

                    <p className="mt-4">{sculpture.description}</p>
                </div>
            </div>
        </div>
    )
}

function WithState() {
    const [index, setState]:[number, React.Dispatch<React.SetStateAction<number>>] = useState<number>(0)

    const handleNext = () => {
        setState(index + 1);
        if(index == sculptureList.length - 1) {
            setState(0)
        }
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

                    <p className="mt-4">{sculptureList[index].description}</p>
                </div>
            </div>
        </div>
    )
}
