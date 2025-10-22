'use server'

import { request } from "../base-client";
import { ClassesDetails, ClassesForm, ClassesSearch, ClassListItem, PageResult } from "../types";
import { POST_CONFIG, PUT_CONFIG, queryString } from "../utils";

const ENDPOINT = "classes"

export async function search(form: ClassesSearch):Promise<PageResult<ClassListItem>> {
    const url = `${ENDPOINT}?${queryString(form)}`
    const response = await request(url)
    return await response.json()
}

export async function findById(id: number | string):Promise<ClassesDetails> {
    const response = await request(`${ENDPOINT}/${id}`)
    return await response.json()
}

export async function create(form : ClassesForm):Promise<{id: number}> {
    const response = await request(ENDPOINT, {
        ...POST_CONFIG,
        body: JSON.stringify(form)
    })
    return await response.json()
}

export async function update(id : number | string, form : ClassesForm):Promise<{id: number}> {
    const response = await request(`${ENDPOINT}/${id}`, {
        ...PUT_CONFIG,
        body: JSON.stringify(form)
    })
    return await response.json()
}