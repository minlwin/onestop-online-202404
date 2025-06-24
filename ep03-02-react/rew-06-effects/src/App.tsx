import { useEffect, useState } from "react"
import { type Region, type State } from "./model/model"
import { getRegions, getStates } from "./model/client"

export default function App() {

  const [regions, setRegions] = useState<Region[]>([])
  const [states, setStates] = useState<State[]>([])
  const [regionId, setRegionId] = useState<number | undefined>()

  useEffect(() => {

    async function load() {
      const regionResult = await getRegions()
      setRegions(regionResult)

      const stateResult = await getStates()
      setStates(stateResult)
    }

    load()
  }, [])

  async function loadState(regionId?:number) {
      const stateResult = await getStates(regionId)
      setStates(stateResult)
      setRegionId(regionId)
  }

  return (
    <>
      <nav className="navbar navbar-expand navbar-dark bg-black">
        <div className="container">
          <a href="#" onClick={(e) => {
            e.preventDefault()
            loadState()
          }} className="navbar-brand">Locations</a>

          <ul className="navbar-nav">
            {regions.map(item => 
              <li key={item.id} className="nav-item">
                <a href="#" onClick={e => {
                  e.preventDefault()
                  loadState(item.id)
                }} className={`nav-link ${regionId === item.id ? 'active' : ''}`}>{item.name}</a>
              </li>
            )}
          </ul>
        </div>
      </nav>

      <main className="mt-4 container">
        <Locations value={states} />
      </main>
    </>
  )
}

function Locations({value} : {value : State[]}) {
  return (
    <>
      <section className="row row-cols-4 g-4">
        {value.map(item => 
          <div key={item.id} className="col"><Location value={item} /></div>
        )}
      </section>
    </>
  )
}

function Location({value} : {value : State}) {
  return (
    <div className="card">
      <div className="card-body">
        <h5 className="card-title">{value.name}</h5>
        <span>{value.capital}</span>
      </div>
    </div>
  )
}