export type Pager = {
    page: number
    size: number
    totalPage: number
    totalSize: number
    links: number[]
}

export const DUMMY_PAGE:Pager = {
    page: 2,
    size: 10,
    totalPage: 3,
    totalSize: 26,
    links: [0, 1, 2]
}