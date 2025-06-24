import axios from "axios";
import type { Region, State } from "./model";

const client = axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 1000
})

export async function getRegions() {
    return (await client.get<Region[]>('/regions')).data
}

export async function getStates(regionId?:number) {

    if(regionId) {
        return (await client.get<State[]>('/states', {params: {
            regionId : regionId
        }})).data
    }

    return (await client.get<State[]>('/states')).data
}