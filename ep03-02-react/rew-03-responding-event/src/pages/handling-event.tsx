import PageTitle from "../ui/page-title";

export default function HandlingEvent() {
    return (
        <>
            <PageTitle title="Handling Event" />

            <section className="row">
                <div className="col-auto">
                    <Button name="Button 1" />
                </div>
                <div className="col-auto">
                    <Button name="Button 2" />
                </div>
            </section>
        </>
    )
}

function Button({name} : {name:string}) {

    const clickButton = () => alert('Clicking Button')

    return (
        <button onClick={clickButton} className="btn btn-outline-primary">{name}</button>
    )
}