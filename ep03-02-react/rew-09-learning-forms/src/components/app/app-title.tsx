import { useAppTitle } from "@/lib/context/app-title-context"

export default function AppTitle() {
    const {title} = useAppTitle()
    return (
        <div className="py-4 px-6">
            <h3 className="text-xl">{title}</h3>
        </div>
    )
}