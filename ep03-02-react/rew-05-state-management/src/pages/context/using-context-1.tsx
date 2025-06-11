import type React from "react"
import { LevelContext } from "./level-context"
import { useContext } from "react"

export default function UsingContext1() {
    return (
        <>
            <h3>Using Context Sample 1</h3>

            <Section level={1}>
                <Header />
                <Section level={2}>
                    <Header/>
                    <Section level={3}>
                        <Headers count={3} />
                    </Section>
                </Section>
            </Section>
        </>
    )
}

function Section({children, level} : {children:React.ReactNode, level:number}) {
    return (
        <LevelContext value={level}>
            <div className="card">
                <div className="card-body">
                    {children}
                </div>
            </div>
        </LevelContext>
    )
}

function Header() {
    const level = useContext(LevelContext)
    switch(level) {
    case 1:
        return <h1>Header {level}</h1>
    case 2:
        return <h2>Header {level}</h2>
    case 3:
        return <h3>Header {level}</h3>
    default:
        return <h6>Header</h6>
    }
}

function Headers({count} : {count:number}) {
    return Array.from({length: count}).map((_, index) => <Header key={index} />)
}