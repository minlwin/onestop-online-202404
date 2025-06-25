import type { PageSearch } from "./_common"

export type MemberSearch = {
    position? : string
    name? : string
    entryFrom? : string
    entryTo? : string
} & PageSearch