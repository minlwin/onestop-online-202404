import { createContext, useContext } from "react";
import type { PageResult } from "../output/_common";

type SearchResultContextType<T> = [result:PageResult<T>, setResult:(result:PageResult<T>) => void]

const SearchResultContext = createContext<SearchResultContextType<unknown> | undefined>(undefined)

function useSearchResultContext<T>() {

    const context = useContext(SearchResultContext) 

    if(!context) {
        throw new Error("Invalid usage of Search Result Context")
    }

    return context as SearchResultContextType<T>
}

function useSearchResult() {
    return useSearchResultContext()[0]
}

function useSearchResultList<T>():T[] {
    return useSearchResult().list as T[]
}

function useSearchResultPager() {
    return useSearchResult().pager
}


function useSearcResultSetter() {
    return useSearchResultContext()[1]
}

export {
    SearchResultContext,
    useSearchResultList,
    useSearchResultPager,
    useSearcResultSetter
}