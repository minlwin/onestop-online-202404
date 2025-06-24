export interface Region {
    id: number
    name: string
}

export interface State {
    id: number
    name: string
    region: Region
    capital: string
}