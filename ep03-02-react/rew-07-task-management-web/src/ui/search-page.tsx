import type React from "react"
import Page from "./page"
import Pagination from "./pagination"
import { useState } from "react"
import type { PageResult } from "../model/output/_common"
import { SearchResultContext, useSearchResultPager } from "../model/context/search-result-context"

export default function SearchPage({icon, title, searchForm, children} : SearchPageProperties) {

    const [result, setResult] = useState<PageResult<unknown>>({list: []})

    return (
        <SearchResultContext.Provider value={[result, setResult]}>
            <Page title={title} icon={icon}>
                <section>
                    {searchForm}
                </section>

                <section className="mt-3">
                    {children}
                </section>

                <section>
                    <SearchPagePagination />
                </section>
            </Page>
        </SearchResultContext.Provider>
    )
}

function SearchPagePagination() {

    const pager = useSearchResultPager()

    return (
        <Pagination pager={pager} />
    )
}

type SearchPageProperties = {
    title: string
    icon?: string
    searchForm?: React.ReactNode
    children?: React.ReactNode
}