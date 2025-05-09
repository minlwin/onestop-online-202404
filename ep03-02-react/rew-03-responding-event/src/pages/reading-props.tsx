import PageTitle from "../ui/page-title";

export default function ReadingProperties() {
    return (
        <>
            <PageTitle title="Reading Properties from Event Handler" />

            <Button name="Button 1" message="This is Message from Parent" />
            <Button name="Button 2" message="This is Other Message" className="ms-2" />
     </>
    )
}

function Button({message, name, className} : {message:string, name:string, className?:string}) {

    const btnAction = () => alert(message)

    return (
        <button onClick={btnAction} className={`btn btn-outline-primary ${className}`}>{name}</button>
    )
}