import { Button } from "@/components/ui/button"
import { Input } from "@/components/ui/input"
import { Search } from "lucide-react"

export default async function SearchForm({keyword} : {keyword : string | string [] | undefined}) {

    return (
        <form className="mt-4 flex gap-2">
            <Input name="keyword" placeholder="Search Keyword" defaultValue={keyword} className="w-1/4" />
            <Button type="submit">
                <Search /> Search
            </Button>
        </form>
    )
}