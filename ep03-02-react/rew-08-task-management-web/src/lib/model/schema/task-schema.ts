import * as z from "zod"

export const TaskSearchSchema = z.object({
    projectId: z.string(),
    startFrom: z.string(),
    startTo: z.string(),
    keyword: z.string()
})

export type TaskSearch = z.infer<typeof TaskSearchSchema>

export const TaskEditSchema = z.object({
    projectId: z.string().nonempty(),
    name: z.string().nonempty(),
    assignee: z.string().nonempty(),
    dueDate: z.string().nonempty(),
    startDate: z.string(),
    endDate: z.string(),
    description: z.string()
})

export type TaskEdit = z.infer<typeof TaskEditSchema>