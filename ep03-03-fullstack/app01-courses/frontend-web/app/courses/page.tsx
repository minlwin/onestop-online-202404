import CourseSearchForm from "@/components/app/course-search-form";
import PageTitle from "@/components/app/page-title";
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from "@/components/ui/table";

import * as courseClient from "@/lib/client/course.client"
import { CourseListItem } from "@/lib/types";
import { ArrowRight, Check, X } from "lucide-react";
import Link from "next/link";

export default async function CourseManagement(props : PageProps<'/courses'>) {

    const searchParams = await props.searchParams
    const result = await courseClient.search(searchParams)

    return (
        <section className="space-y-4"> 

            <PageTitle icon="BookOpen" title="Course Management" />

            <CourseSearchForm />

            <SearchResult list={result} />

        </section>
    )
}

function SearchResult({list} : {list : CourseListItem[]}) {
    return (
        <Table>
            <TableHeader>
                <TableRow>
                    <TableHead>ID</TableHead>
                    <TableHead>Name</TableHead>
                    <TableHead>Level</TableHead>
                    <TableHead>Status</TableHead>
                    <TableHead>Created At</TableHead>
                    <TableHead></TableHead>
                </TableRow>
            </TableHeader>

            <TableBody>
            {list.map((item, index) => 
                <TableRow key={index}>
                    <TableCell>{item.id}</TableCell>
                    <TableCell>{item.name}</TableCell>
                    <TableCell>{item.level}</TableCell>
                    <TableCell>{item.deleted ? <X className="size-4" /> : <Check className="size-4" />}</TableCell>
                    <TableCell>{item.createdAt}</TableCell>
                    <TableCell>
                        <Link href={`/courses/${item.id}`}>
                            <ArrowRight />
                        </Link>
                    </TableCell>
                </TableRow>
            )}
            </TableBody>
        </Table>
    )
}