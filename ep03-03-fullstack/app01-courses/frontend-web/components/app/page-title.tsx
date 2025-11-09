import { IconType } from "@/lib/types";
import IconComponent from "./icon-component";
import { Badge } from "../ui/badge";
import { Button } from "../ui/button";
import Link from "next/link";
import { Pencil } from "lucide-react";

export default function PageTitle({
    icon, 
    title, 
    subTitle, 
    description, 
    editUrl} : {
        icon : IconType, 
        title : string, 
        subTitle? : string[], 
        description?: string, 
        editUrl? : string}) {
    
    if(subTitle) {
        return (
            <header className="flex gap-2">
                <div className="pt-1">
                    <IconComponent icon={icon} className="size-6" />
                </div>
                <div>
                    <div className="text-xl">{title}</div>
                    <div className="flex gap-2">
                    {subTitle.map((item, index) => 
                        <Badge key={index}>{item}</Badge>
                    )}
                    </div>
                    {description && <div className="text-muted-foreground">{description}</div>}
                </div>

                {editUrl &&
                    <div className="ml-auto mt-1">
                        <Button asChild>
                            <Link href={editUrl}>
                                <Pencil /> Edit
                            </Link>
                        </Button>
                    </div>
                }
            </header>
        )
    }
    
    return (
        <header className="flex items-start gap-2">
            <div className="pt-1">
                <IconComponent icon={icon} className="size-6" />
            </div>
            <div className="text-xl">
                <div className="text-xl">{title}</div>
                {description && <div className="text-muted-foreground">{description}</div>}
            </div>
            {editUrl &&
                <Button asChild>
                    <Link href={editUrl}>
                        <Pencil /> Edit
                    </Link>
                </Button>
            }
        </header>
    )
}