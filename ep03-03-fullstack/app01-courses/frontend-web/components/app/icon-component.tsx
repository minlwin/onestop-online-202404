import { IconType } from "@/lib/types";
import * as lucideIcons from 'lucide-react'

export default function IconComponent({icon, className} : {icon : IconType, className?: string}) {
    const Icon = lucideIcons[icon] as lucideIcons.LucideIcon

    return (
        <Icon className={className || 'size-4'} />
    )
}