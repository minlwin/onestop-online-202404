import PageTitle from "../ui/page-title";

export default function NamingEventHandler() {
    return (
        <>
            <PageTitle title="Naming Event Handler" />

            <ToolsBar 
                downloadHandler={() => alert('Downloading Movie')} 
                playHandler={() => alert('Playing Movie')}/>
        </>
    )
}

function ToolsBar({playHandler, downloadHandler} : {playHandler : VoidFunction, downloadHandler : VoidFunction}) {
    return (
        <div className="card" onClick={() => alert('Clicking Tools Bar')}>
            <div className="card-body">
                <Button name="Play Movie" className="me-2" onClick={playHandler} />
                <Button name="Download Movie" className="me-2" onClick={downloadHandler} />
            </div>
        </div>
    )
}

function Button({name, onClick, className} : {name : string, onClick: VoidFunction, className?:string}) {
    return (
        <button onClick={(event) => {
            event.stopPropagation()
            onClick()
        }} className={`btn btn-outline-primary ${className}`}>
            {name}
        </button>
    )
}