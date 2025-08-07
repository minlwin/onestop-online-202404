import { Save, Trash2 } from "lucide-react";
import { Button } from "../ui/button";

export default function FormActions({clear} : {clear : VoidFunction}) {
    return (
        <div>
            <Button type="button" onClick={clear} variant={'outline'}>
                <Trash2 /> Clear
            </Button>

            <Button type="submit" className="ms-2">
                <Save /> Save
            </Button>
        </div>
    )
}