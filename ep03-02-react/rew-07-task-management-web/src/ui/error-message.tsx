export default function ErrorMessage({message} : {message? : string}) {
    return (
        <span className="text-danger">{message}</span>
    )
}