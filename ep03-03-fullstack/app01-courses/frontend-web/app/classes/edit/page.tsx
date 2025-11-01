'use client'

import PageTitle from "@/components/app/page-title"
import FormsInput from "@/components/forms/forms-input"
import FormsSelect from "@/components/forms/forms-select"
import FormsTextarea from "@/components/forms/forms-textarea"
import { Form } from "@/components/ui/form"
import { ClassesSchema, CourseListItem } from "@/lib/types"
import { TYPE_OPTIONS } from "@/lib/utils"
import { zodResolver } from "@hookform/resolvers/zod"
import { useEffect, useState } from "react"
import { useForm } from "react-hook-form"

import * as courseClient from '@/lib/client/course.client'

export default function ClassEditPage() {

    const [courses, setCourses] = useState<CourseListItem[]>([])

    const form = useForm({
        resolver: zodResolver(ClassesSchema),
        defaultValues: {
            courseId: "",
            classType: "",
            startDate: "",
            months: "",
            remark: "",
            schedules: [
                {day: "", start: "", end: ""}
            ]
        }
    })

    useEffect(() => {
        async function load() {
            const result = await courseClient.search({deleted : "false"})
            setCourses(result)
        }

        load()
    }, [setCourses])
    
    async function save() {

    }

    return (
        <div className="space-y-4">
            <PageTitle icon="Pencil" title="Create Course" />

            <Form {...form}>
                <form onSubmit={form.handleSubmit(save)} className="grid grid-cols-4 gap-4">
                    <FormsSelect control={form.control} path="courseId" label="Course" options={courses.map(a => ({key: String(a.id), value: a.name}))} />
                    <FormsSelect control={form.control} path="classType" label="Class Type" options={TYPE_OPTIONS} />
                    <FormsInput control={form.control} path="startDate" label="Start Date" type="date" className="col-start-1" />
                    <FormsInput control={form.control} path="months" label="Duration in Months" type="number" />
                    <FormsTextarea control={form.control} path="remark" label="Remark" className="col-span-3" />
                </form>
            </Form>
        </div>
    )
}