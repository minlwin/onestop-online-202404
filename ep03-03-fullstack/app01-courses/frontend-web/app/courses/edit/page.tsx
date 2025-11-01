'use client'

import { CourseForm, CourseSchema } from "@/lib/types"
import { zodResolver } from "@hookform/resolvers/zod"
import { useRouter, useSearchParams } from "next/navigation"
import { useEffect } from "react"
import { useForm } from "react-hook-form"

import * as courseClient from "@/lib/client/course.client"
import { Form } from "@/components/ui/form"
import FormsSelect from "@/components/forms/forms-select"
import { LELVEL_OPTIONS } from "@/lib/utils"
import PageTitle from "@/components/app/page-title"
import FormsInput from "@/components/forms/forms-input"
import FormsTextarea from "@/components/forms/forms-textarea"
import { Button } from "@/components/ui/button"
import { Save } from "lucide-react"
import { handle } from "@/lib/client-utils"

export default function CourseEditPage() {

    const router = useRouter()

    const form = useForm({
        resolver: zodResolver(CourseSchema),
        defaultValues: {
            level: undefined,
            name: "",
            description: ""
        }
    })

    const searchParams = useSearchParams()
    const id = searchParams.get("id")

    useEffect(() => {

        async function load() {
            if(id) {
                const result = await courseClient.findById(id)
                form.reset({
                    level: result.level,
                    name: result.name,
                    description: result.description
                })
            }
        }

        load()

    }, [id, form])

    function save(form:CourseForm) {
        handle(async () => {
            const result = await (id ? courseClient.update(id, form) : courseClient.create(form))
            router.push(`/courses/${result.id}`)
        })
    }

    return (

        <section className="space-y-4">
            <PageTitle icon="Pencil" title={id ? "Edit Course" : "Add New Course"} />
            <Form {...form}>

                <form onSubmit={form.handleSubmit(save)}>
                    <div className="grid grid-cols-4 gap-4 items-start">
                        <FormsSelect control={form.control} path="level" label="Course Level" options={LELVEL_OPTIONS} />
                        <FormsInput control={form.control} path="name" label="Course Name" className="col-span-2" />
                        <div></div>
                        <FormsTextarea control={form.control} path="description" label="Description" className="col-span-4" />

                        <div>
                            <Button type="submit">
                                <Save /> Save Course
                            </Button>
                        </div>
                    </div>
                </form>
            </Form>
        </section>
    )
}