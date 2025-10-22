'use client'

import PageTitle from "@/components/app/page-title";
import { Table } from "@/components/ui/table";

export default function ClassManagement() {
    return (
        <section>

            <PageTitle icon="CalendarCheck" title="Class Management" />

        </section>
    )
}

function SearchForm() {
    return (
        <></>
    )
}

function SearchResult() {
    return (
        <Table></Table>
    )
}