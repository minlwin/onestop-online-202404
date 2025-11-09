'use client'

import PageTitle from "@/components/app/page-title"
import FormsInput from "@/components/forms/forms-input"
import FormsSelect from "@/components/forms/forms-select"
import FormsTextarea from "@/components/forms/forms-textarea"
import { Form } from "@/components/ui/form"
import { ClassesForm, ClassesSchema, CourseListItem } from "@/lib/types"
import { DAYS_OF_WEEK, TYPE_OPTIONS } from "@/lib/utils"
import { zodResolver } from "@hookform/resolvers/zod"
import { useEffect, useState } from "react"
import { useFieldArray, useForm } from "react-hook-form"

import { Button } from "@/components/ui/button"
import { Plus, Save, Trash } from "lucide-react"

import * as courseClient from '@/lib/client/course.client'
import * as classClient from '@/lib/client/classes.client'
import { useRouter, useSearchParams } from "next/navigation"

export default function ClassEditPage() {

    const router = useRouter()
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

    const {fields, append, remove} = useFieldArray({
        control: form.control,
        name: 'schedules'
    })

    useEffect(() => {
        async function load() {
            const result = await courseClient.search({deleted : "false"})
            setCourses(result)
        }

        load()
    }, [setCourses])

    const params = useSearchParams()
    const id = params.get("id")

    useEffect(() => {
        async function load() {
            if(id) {
                const details = await classClient.findById(id)
                form.setValue("courseId", String(details.courseId))
                form.setValue("classType", details.classType)
                form.setValue("startDate", details.startDate)
                form.setValue("months", String(details.months))
                form.setValue("remark", details.remark)              
                form.setValue('schedules', details.schedules)
            }
        }

        load()
    }, [id, form])
    
    async function save(form: ClassesForm) {
        const result = await classClient.create(form)
        router.push(`/classes/${result.id}`)
    }

    function addSchedule() {
        append({day : "", start: "", end : ""})
    }

    function removeSchedule(index : number) {
        remove(index)
        const schedules = form.watch('schedules')
        if(schedules.length == 0) {
            addSchedule()
        }
    }

    return (
        <div className="space-y-4">
            <PageTitle icon="Pencil" title={`${id ? 'Edit' : 'Create'} Course`} />

            <Form {...form}>
                <form onSubmit={form.handleSubmit(save)} className="grid grid-cols-4 gap-4">
                    <FormsSelect control={form.control} path="courseId" label="Course" options={courses.map(a => ({key: String(a.id), value: a.name}))} />
                    <FormsSelect control={form.control} path="classType" label="Class Type" options={TYPE_OPTIONS} />
                    
                    <FormsInput control={form.control} path="startDate" label="Start Date" type="date" 
                        className="col-start-1" />
                    <FormsInput control={form.control} path="months" label="Duration in Months" type="number" />
                    
                    <FormsTextarea control={form.control} path="remark" label="Remark" className="col-span-3" />

                    <div className="col-span-3">
                        <h3 className="text-lg mb-4">Schedules</h3>

                        <div className="space-y-2">
                        {fields.map((field, index) => 
                            <div key={field.id} className="flex items-start gap-4">
                                <FormsSelect control={form.control} path={`schedules.${index}.day`} 
                                    label={index == 0 ? "Day" : undefined} options={DAYS_OF_WEEK} className="w-[200px]" />
                                <FormsInput control={form.control} path={`schedules.${index}.start`}
                                     label={index == 0 ? "Start Time" : undefined} type="time" className="w-[160px]" />
                                <FormsInput control={form.control} path={`schedules.${index}.end`}
                                     label={index == 0 ? "End Time" : undefined} type="time" className="w-[160px]" />

                                <div className={index == 0 ? 'pt-[1.3rem]' : undefined}>
                                    <Button type="button" onClick={() => removeSchedule(index)}  disabled={!form.formState.isValid}>
                                        <Trash />
                                    </Button>
                                </div>
                            </div>
                        )}    
                        </div>
                    </div>

                    <div className="col-start-1 col-span-2 space-x-2">
                        <Button type="button" onClick={addSchedule} disabled={!form.formState.isValid}>
                            <Plus /> Add Schedule
                        </Button>

                        <Button type="submit" disabled={!form.formState.isValid}>
                            <Save /> Save Course
                        </Button>
                    </div>
                </form>
            </Form>
        </div>
    )
}