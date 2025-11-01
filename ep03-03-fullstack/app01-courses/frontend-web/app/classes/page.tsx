'use client'

import PageTitle from "@/components/app/page-title";
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";
import { ClassesSearch, ClassListItem, PageResult } from "@/lib/types";
import { useEffect, useState } from "react";

import * as classApi from "@/lib/client/classes.client"
import { useForm } from "react-hook-form";
import { Form } from "@/components/ui/form";
import Loading from "@/components/app/app-loading";
import DeleteStatus from "@/components/app/delete-status";
import FormsSelect from "@/components/forms/forms-select";
import { LELVEL_OPTIONS, STATUS_OPTIONS, TYPE_OPTIONS } from "@/lib/utils";
import FormsInput from "@/components/forms/forms-input";
import { Button } from "@/components/ui/button";
import { Plus, Search } from "lucide-react";
import Link from "next/link";

export default function ClassManagement() {

    const [page, setPage] = useState<PageResult<ClassListItem>>()

    async function search(form:ClassesSearch) {

        if(form.level === "-1") {
            delete form.level
        }

        if(form.deleted === "-1") {
            delete form.deleted
        }

        if(form.type === "-1") {
            delete form.type
        }

        const result = await classApi.search(form)
        setPage(result)
    }

    useEffect(() => {
        search({page: 0})
    }, [setPage])

    return (
        <section className="space-y-4">
            <PageTitle icon="CalendarCheck" title="Class Management" />
            <SearchForm onSearch={search} />
            <SearchResult page={page} />
        </section>
    )
}

function SearchForm({onSearch} : {onSearch : (form : ClassesSearch) => void}) {

    const form = useForm<ClassesSearch>({
        defaultValues: {
            level: "-1",
            type: "-1",
            deleted: "-1",
            keyword: "",
            page: 0
        }
    })

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSearch)} className="flex items-end gap-4">
                <FormsSelect control={form.control} path="type" options={[
                    {key: "-1", value: "Search All"},
                    ...TYPE_OPTIONS
                ]} label="Class Type" className="w-[180px]" />
                <FormsSelect control={form.control} path="level" options={[
                    {key: "-1", value: "Search All"},
                    ...LELVEL_OPTIONS
                ]} label="Level" className="w-[180px]" />
                <FormsSelect control={form.control} path="deleted" options={[
                    {key: "-1", value: "Search All"},
                    ...STATUS_OPTIONS
                ]} label="Status" className="w-[180px]" />
                <FormsInput control={form.control} path="keyword" label="Keyword" placeholder="Search Keyword" />

                <div className="space-x-2">
                    <Button type="submit">
                        <Search/> Search
                    </Button>

                    <Button type="button" asChild>
                        <Link href={"/classes/edit"}>
                            <Plus /> Add New
                        </Link>
                    </Button>
                </div>
            </form>
        </Form>
    )
}

function SearchResult({page} : {page?: PageResult<ClassListItem>}) {

    if(!page) {
        return (
            <Loading data="Class data" />
        ) 
    }

    const { list, pageInfo } = page

    return (
        <Table>
            <TableHeader>
                <TableRow>
                    <TableHead>ID</TableHead>
                    <TableHead>Course</TableHead>
                    <TableHead>Level</TableHead>
                    <TableHead>Type</TableHead>
                    <TableHead>Start At</TableHead>
                    <TableHead>Month</TableHead>
                    <TableHead>Status</TableHead>
                    <TableHead>Created At</TableHead>
                    <TableHead></TableHead>
                </TableRow>
            </TableHeader>

            <TableBody>
            {list.map((item, index) => 
                <TableRow key={index}>
                    <TableCell>{item.id}</TableCell>
                    <TableCell>{item.courseName}</TableCell>
                    <TableCell>{item.level}</TableCell>
                    <TableCell>{item.classType}</TableCell>
                    <TableCell>{item.startDate}</TableCell>
                    <TableCell>{item.months}</TableCell>
                    <TableCell>
                        <DeleteStatus deleted={item.deleted} />
                    </TableCell>
                    <TableCell>{item.createdAt}</TableCell>
                    <TableCell></TableCell>
                </TableRow>
            )}
            </TableBody>
        </Table>
    )
}