import PageTitle from '@/components/app/page-title'
import { Item, ItemContent, ItemDescription, ItemMedia, ItemTitle } from '@/components/ui/item'
import * as classClient from '@/lib/client/classes.client'
import { BookOpen, Calendar, Clock, Hourglass } from 'lucide-react'

export default async function ClassDetailsPage(props : PageProps<'/classes/[id]'>) {
    
    const { id } = await props.params
    const details = await classClient.findById(id)
    
    return (
        <section className='space-y-6'>
            <PageTitle icon='CalendarCheck' 
                title={`${details.courseName} ${details.classType}`}
                subTitle={[
                    details.level, 
                    details.deleted ? "Deleted" : "Active",
                    `Created At : ${details.createdAt}`
                ]}
                description={details.remark}
                editUrl={`/classes/edit?id=${id}`} />

            <section>
                <h1 className='text-xl'>Class Information</h1>
                <div className='grid grid-cols-3 gap-4 mt-4'>

                    <Item variant={'outline'}>
                        <ItemMedia>
                            <BookOpen />
                        </ItemMedia>
                        <ItemContent>
                            <ItemTitle>Course</ItemTitle>
                            <ItemDescription>{details.courseName}</ItemDescription>
                        </ItemContent>
                    </Item>

                    <Item variant={'outline'}>
                        <ItemMedia>
                            <Calendar />
                        </ItemMedia>
                        <ItemContent>
                            <ItemTitle>Start Date</ItemTitle>
                            <ItemDescription>{details.startDate}</ItemDescription>
                        </ItemContent>
                    </Item>

                    <Item variant={'outline'}>
                        <ItemMedia>
                            <Hourglass />
                        </ItemMedia>
                        <ItemContent>
                            <ItemTitle>Duration</ItemTitle>
                            <ItemDescription>{details.months} Month</ItemDescription>
                        </ItemContent>
                    </Item>
                </div>
            </section>

            <section>
                <h1 className='text-xl'>Shedule</h1>
                <div className='grid grid-cols-3 gap-4 mt-4'>
                    {details.schedules.map((item, index) => 
                        <Item key={index} variant={'outline'}>
                            <ItemMedia>
                                <Clock />
                            </ItemMedia>
                            <ItemContent>
                                <ItemTitle>{item.day}</ItemTitle>
                                <ItemDescription>{`${item.start} to ${item.end}`}</ItemDescription>
                            </ItemContent>
                        </Item>
                    )}
                </div>
            </section>

        </section>
    )
}