import { Link, useParams } from "react-router";
import { FormGroup } from "../../../ui/form-group";
import { useForm } from "react-hook-form";
import type { TaskSearch } from "../../../model/input/task-search";
import { searchTask } from "../../../model/client/task-client";
import { useEffect, useState } from "react";
import type { TaskListItem } from "../../../model/output/task-list-item";
import type { Pager } from "../../../model/output/_common";
import NoData from "../../../ui/no-data";
import Pagination from "../../../ui/pagination";

export default function ProjectTaskList() {

    const {handleSubmit, reset, register} = useForm<TaskSearch>()
    const [list, setList] = useState<TaskListItem[]>([])
    const [pager, setPager] = useState<Pager>()

    const params = useParams()
    const projectId = params.id

    useEffect(() => {
        if(projectId) {
            reset({projectId : projectId})
        }
    }, [projectId, reset])

    async function search(params:TaskSearch) {
        const {list, pager} = await searchTask(params)
        setList(list)
        setPager(pager)
    }

    return (
        <>
            <form onSubmit={handleSubmit(search)} className="row">
                <FormGroup className="col-auto" label="Status">
                    <select {...register('status')} className="form-select">
                        <option value="">All Status</option>
                    </select>
                </FormGroup>

                <FormGroup label="Start From" className="col-auto">
                    <input {...register('startFrom')} type="date" className="form-control" />
                </FormGroup>

                <FormGroup label="Start To" className="col-auto">
                    <input {...register('startTo')} type="date" className="form-control" />
                </FormGroup>

                <FormGroup label="Keyword" className="col-auto">
                    <input {...register('keyword')} placeholder="Search Keyword" className="form-control" />
                </FormGroup>

                <div className="col btn-wrapper">
                    <button type="submit" className="btn btn-dark">
                        <i className="bi-search"></i> Search
                    </button>

                    <Link to="edit" className="btn btn-outline-dark ms-2">
                        <i className="bi-plus"></i> New Task
                    </Link>
                </div>
            </form>

            <section className="my-3">
                {list.length == 0 ? 
                    <NoData dataName="Task" /> :
                    <table className="table table-bordered table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Category</th>
                                <th>Member</th>
                                <th>Start At</th>
                                <th>Mile Stone</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                        {list.map(item => 
                            <tr key={item.id}>
                                <td>{item.id}</td>
                                <td>{item.taskName}</td>
                                <td>{item.categoryName}</td>
                                <td>{item.memberName}</td>
                                <td>{item.startAt}</td>
                                <td>{item.mileStone}</td>
                                <td>{item.status}</td>
                                <td className="text-center">
                                    <Link to={`${item.id}`} className="icon-link">
                                        <i className="bi-arrow-right"></i>
                                    </Link>
                                </td>
                            </tr>
                        )}
                        </tbody>
                    </table>
                }
            </section>
            
            <Pagination pager={pager} />
        </>
    )
}