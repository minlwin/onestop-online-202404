import { zodResolver } from "@hookform/resolvers/zod"
import { ArrowRight, Plus, Search } from "lucide-react"
import { FormProvider, useForm } from "react-hook-form"
import { Link } from "react-router"
import FormsInput from "~/components/custom/forms-input"
import { Button } from "~/components/ui/button"
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "~/components/ui/table"
import { SearchOrderSchema, type SearchOrderForm } from "~/lib/form-schema"

export default function List() {
    return (
        <section className="flex flex-col gap-4">
            <SearchForm />
            <SearchResult />
        </section>
    )
}

function SearchForm() {

    const form = useForm<SearchOrderForm>({
        resolver: zodResolver(SearchOrderSchema),
        defaultValues: {
            dateFrom: "",
            dateTo : '',
            keyword: ''
        }
    })

    const search = (form: SearchOrderForm) => {
        console.log(form)
    }

    return (
        <FormProvider {...form}>
            <form onSubmit={form.handleSubmit(search)} className="flex items-end gap-3">
                <FormsInput control={form.control} path="dateFrom" type="date" label="Date From" />
                <FormsInput control={form.control} path="dateTo" type="date" label="Date To" />
                <FormsInput control={form.control} path="keyword" label="Keyword" />

                <div>
                    <Button type="submit" className="me-2">
                        <Search /> Search
                    </Button>

                    <Button type="button" asChild>
                        <Link to={"edit"}>
                            <Plus /> Create Order
                        </Link>
                    </Button>
                </div>
            </form>
        </FormProvider>
    )
}

function SearchResult() {
    return (
        <Table>
            <TableHeader>
                <TableRow>
                    <TableHead>Order ID</TableHead>
                    <TableHead>Order Date</TableHead>
                    <TableHead>Title</TableHead>
                    <TableHead>Items Count</TableHead>
                    <TableHead>Total Amount</TableHead>
                    <TableHead></TableHead>
                </TableRow>
            </TableHeader>
            <TableBody>
                <TableRow>
                    <TableCell>OD202509030001</TableCell>
                    <TableCell>September 03, 2025</TableCell>
                    <TableCell>Some Title</TableCell>
                    <TableCell>120</TableCell>
                    <TableCell>3,500,000 MMK</TableCell>
                    <TableCell>
                        <Link to={'OD202509030001'}>
                            <ArrowRight size={18} />
                        </Link>
                    </TableCell>
                </TableRow>
            </TableBody>
        </Table>
    )
}