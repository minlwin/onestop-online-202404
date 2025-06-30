import type { PageSearch } from "./_common"

export type ProjectSearch = {
    staus? : string
    startFrom? : string
    startTo? : string
    keyword? : string
} & PageSearch