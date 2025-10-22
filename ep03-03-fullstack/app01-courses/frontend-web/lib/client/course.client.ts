'use server'

import { request } from "../base-client";
import { CourseDetails, CourseForm, CourseListItem, CourseSearch } from "../types";
import { POST_CONFIG, PUT_CONFIG, queryString } from "../utils";

const ENDPOINT = "courses"

export async function search(form:CourseSearch):Promise<CourseListItem[]> {
    const response = await request(`${ENDPOINT}?${queryString(form)}`)
    return await response.json()
}

export async function findById(id: number | string):Promise<CourseDetails> {
    const response = await request(`${ENDPOINT}/${id}`)
    return await response.json()
}

export async function create(form: CourseForm):Promise<{id : number}> {
    const response = await request(ENDPOINT, {
        ...POST_CONFIG,
        body: JSON.stringify(form)
    })

    return await response.json()
}

export async function update(id: number | string,  form: CourseForm):Promise<{id : number}> {
    const response = await request(`${ENDPOINT}/${id}`, {
        ...PUT_CONFIG,
        body: JSON.stringify(form)
    })

    return await response.json()
}