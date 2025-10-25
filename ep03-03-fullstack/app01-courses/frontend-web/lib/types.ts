import * as lucideIcons from 'lucide-react'

export type IconType = keyof typeof lucideIcons

import z from "zod";

export const CourseSchema = z.object({
    name : z.string().nonempty("Please enter course name."),
    level : z.string().nonempty("Please select course level."),
    description: z.string().nonempty("Please enter course descrption.")
})

export type CourseForm = z.infer<typeof CourseSchema>

export type CourseSearch = {
    level?: string
    deleted?: string
    keyword?: string
}

export type CourseListItem = {
    id : number
    name : string
    level : string
    description : string
    deleted : boolean
    createdAt : string
}

export type CourseDetails = CourseListItem & {
    classes: ClassListItem[]
    updatedAt: string
}

export class RestClientException {
    constructor(readonly message:string[]) {}
}

export const ScheduleSchema = z.object({
    day: z.string().nonempty("Please select schedule day."),
    start: z.string().nonempty("Please select schedule start time."),
    end : z.string().nonempty("Please select schedule end time.")
})

export const ClassesSchema = z.object({
    courseId: z.string().nonempty("Please select course."),
    startDate: z.string().nonempty("Please enter start date."),
    classType: z.string().nonempty("Please select class type."),
    months: z.string().nonempty("Please enter duration in months."),
    remark: z.string().optional(),
    schedules: z.array(ScheduleSchema).nonempty("Please enter schedule.")
})

export type ClassesForm = z.infer<typeof ClassesSchema>

export type Schedule = z.infer<typeof ScheduleSchema>

export type ClassListItem = {
    id : number
    courseId : number
    level : string
    courseName : string
    startDate : string
    classType : string
    months: string
    deleted : boolean
    createdAt : string
}

export type ClassesDetails = ClassListItem & {
    remark: string
    schedules: Schedule[]
    updatedAt: string
}

export type ClassesSearch = {
    level?: string
    type?: string
    deleted?: string
    keyword?: string
}

export type PageInfo = {
    page: number
    size: number
    totalCount: number
    totalPage: number
    links: number []
}

export type PageResult<T> = {
    list: T []
    pageInfo: PageInfo
}

export type OptionItem = {
    key: string
    value : string
}