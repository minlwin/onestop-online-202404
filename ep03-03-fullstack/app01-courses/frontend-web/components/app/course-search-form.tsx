'use client'

import { CourseSearch } from "@/lib/types"
import { useForm } from "react-hook-form"
import { Form } from "../ui/form"
import { useRouter, useSearchParams } from "next/navigation"
import { useEffect } from "react"
import { LELVEL_OPTIONS, queryString, STATUS_OPTIONS } from "@/lib/utils"
import FormsSelect from "../forms/forms-select"
import { Plus, Search } from "lucide-react"
import FormsInput from "../forms/forms-input"
import { Button } from "../ui/button"
import Link from "next/link"

export default function CourseSearchForm() {

    const form = useForm<CourseSearch>({
        defaultValues: {
            deleted: "-1",
            level: "-1",
            keyword: ""
        }
    })
    const searchParam = useSearchParams()
    const router = useRouter()

    useEffect(() => {
        const level = searchParam.get("level")
        const deleted = searchParam.get("deleted")
        const keyword = searchParam.get("keyword")

        form.reset({
            deleted: deleted || "-1",
            level: level || "-1",
            keyword: keyword || ""
        })
    }, [form, searchParam])

    function search(form: CourseSearch) {

        if(form.deleted === "-1") {
            delete form.deleted
        }

        if(form.level === '-1') {
            delete form.level
        }

        router.push(`/courses?${queryString(form)}`)
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(search)} className="flex gap-4 items-end">
                <FormsSelect control={form.control} path="deleted" label="Status" options={[
                    {key : "-1", value : "Select All"},
                    ...STATUS_OPTIONS
                ]} className="w-[180px]" />

                <FormsSelect control={form.control} path="level" label="Level" options={[
                    {key : "-1", value : "Select All"},
                    ...LELVEL_OPTIONS
                ]} className="w-[180px]" />

                <FormsInput control={form.control} path="keyword" label="Keyword" placeholder="Search Keyword" />

                <div className="space-x-2">
                    <Button type="submit">
                        <Search /> Search
                    </Button>

                    <Button type="button" variant={'destructive'} asChild>
                        <Link href={'/courses/edit'}>
                            <Plus /> Create Course
                        </Link>
                    </Button>
                </div>

            </form>
        </Form>
    )
}