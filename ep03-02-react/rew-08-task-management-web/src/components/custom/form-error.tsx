export default function FormError({message} : {message : string}) {
    return (
        <span className="text-sm text-red-500">{message}</span>
    )
}