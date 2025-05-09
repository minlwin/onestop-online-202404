import PageTitle from "../ui/page-title";

export default function PassingHandler() {

    const changeBack = (color: 'blue' | 'red') => {
        document.getElementById('targetDiv')!.style.backgroundColor = color
    }

    const changeBackBlue = () => changeBack('blue')
    const changeBackRed = () => changeBack('red')

    return (
        <>
            <PageTitle title="Passing Handler as Properties" />

            <div id="targetDiv" style={{width : 400, height: 150, backgroundColor : 'black', marginBottom : 16}}></div>

            <Button name="Button 1" className="me-2" onClick={() => alert('Pressing Button 1')} />
            <Button name="Button 2" className="me-2" onClick={changeBackBlue} />
            <Button name="Button 3" className="me-2" onClick={changeBackRed} />
        </>
    )
}

function Button({name, onClick, className} : {name : string, onClick: VoidFunction, className?:string}) {
    return (
        <button onClick={onClick} className={`btn btn-outline-primary ${className}`}>
            {name}
        </button>
    )
}