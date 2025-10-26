import { Check, X } from "lucide-react";

export default function DeleteStatus({deleted, className} : {deleted : boolean, className?: string}) {
    return deleted ? <X className={className || 'size-4'} /> : <Check className={className || "size-4"} />
}