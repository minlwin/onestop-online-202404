import DeleteStatus from '@/components/app/delete-status'
import PageTitle from '@/components/app/page-title'
import { Table, TableBody, TableCell, TableHead, TableHeader, TableRow } from '@/components/ui/table'
import * as courseClient from '@/lib/client/course.client'
import { ArrowRight } from 'lucide-react'
import Link from 'next/link'

export default async function CourseDetails(props : PageProps<'/courses/[id]'>) {
    
    const { id } = await props.params
    const details = await courseClient.findById(id)
    
    return (
        <section className='space-y-6'>
            <PageTitle icon='BookOpen' 
                title={details.name} 
                subTitle={[details.level, details.deleted ? "Deleted" : "Active", `Created At - ${details.createdAt}`]}
                description={details.description} editUrl={`/courses/edit?id=${id}`} />

            <div>
                <h4 className='text-xl'>Classes</h4>

                <Table>
                    <TableHeader>
                        <TableRow>
                            <TableHead>ID</TableHead>
                            <TableHead>Type</TableHead>
                            <TableHead>Start Date</TableHead>
                            <TableHead>Months</TableHead>
                            <TableHead>Status</TableHead>
                            <TableHead>Created At</TableHead>
                            <TableHead></TableHead>
                        </TableRow>
                    </TableHeader>

                    <TableBody>
                    {details.classes.map((item, index) => 
                        <TableRow key={index}>
                            <TableCell>{item.id}</TableCell>
                            <TableCell>{item.classType}</TableCell>
                            <TableCell>{item.startDate}</TableCell>
                            <TableCell>{item.months}</TableCell>
                            <TableCell>
                                <DeleteStatus deleted={item.deleted} />
                            </TableCell>
                            <TableCell>{item.createdAt}</TableCell>
                            <TableCell>
                                <Link href={`/classes/${item.id}`}>
                                    <ArrowRight className='size-4' />
                                </Link>
                            </TableCell>
                        </TableRow>
                    )}
                    </TableBody>
                </Table>
            </div>
        </section>
    )
}