import FormGroup from "@/components/custom/form-group";
import Page from "@/components/custom/page";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Folder, Plus, Search } from "lucide-react";
import { Link } from "react-router";

export default function ProjectList() {
    return (
        <Page title="Project List" icon={<Folder />}>

            <form className="flex gap-2">
                <FormGroup label="Start From">
                    <Input type="date" />
                </FormGroup>
                <FormGroup label="Start To">
                    <Input type="date" />
                </FormGroup>
                <FormGroup className="w-1/4" label="Keyword">
                    <Input type="text" placeholder="Search Keyword" />
                </FormGroup>

                <div style={{paddingTop : 22.5}}>
                    <Button type="submit">
                        <Search /> Search
                    </Button>

                    <Button asChild variant={"outline"} className="ms-1">
                        <Link to="">
                            <Plus /> Add New
                        </Link>
                    </Button>
                </div>
            </form>
        </Page>
    )
}