import { useForm } from "react-hook-form";
import { FormGroup } from "../../ui/form-group";
import SearchPage from "../../ui/search-page";
import type { TaskSearch } from "../../model/input/task-search";
import { useSearchResultList, useSearcResultSetter } from "../../model/context/search-result-context";
import { searchTask } from "../../model/client/task-client";
import type { TaskListItem } from "../../model/output/task-list-item";
import NoData from "../../ui/no-data";

export default function TaskListComponent() {
    return (
        <SearchPage title="Task Management" icon="bi-stack" searchForm={<SearchForm />}>
            <SearchResult />
        </SearchPage>
    )
}

function SearchForm() {

    const {register, handleSubmit} = useForm<TaskSearch>()
    const setResult = useSearcResultSetter()

    async function search(form:TaskSearch) {
        const result = await searchTask(form)
        setResult(result)
    }

    return (
        <form onSubmit={handleSubmit(search)} className="row">
            <FormGroup className="col-auto" label="Status">
                <select className="form-select" {...register('status')}>
                    <option value="">All Staus</option>
                </select>
            </FormGroup>

            <FormGroup className="col-auto" label="Start From">
                <input type="date" className="form-control" {...register('startFrom')} />
            </FormGroup>

            <FormGroup className="col-auto" label="Start To">
                <input type="date" className="form-control" {...register('startTo')} />
            </FormGroup>

            <FormGroup className="col-auto" label="Keyword">
                <input type="text" placeholder="Search Keyword" className="form-control" {...register('keyword')} />
            </FormGroup>

            <div className="col btn-wrapper">
                <button type="submit" className="btn btn-dark">
                    <i className="bi-search"></i> Search
                </button>
            </div>
        </form>        
    )
}

function SearchResult() {

    const list = useSearchResultList<TaskListItem>()

    if(!list.length) {
        return <NoData dataName="task" />
    }

    return (
        <table className="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Project</th>
                    <th>Category</th>
                    <th>Task Name</th>
                    <th>Member</th>
                    <th>Start At</th>
                    <th>Mile Stone</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
            {list.map(item => 
                <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.projectName}</td>
                    <td>{item.categoryName}</td>
                    <td>{item.taskName}</td>
                    <td>{item.memberName}</td>
                    <td>{item.startAt}</td>
                    <td>{item.mileStone}</td>
                    <td>{item.status}</td>
                </tr>
            )}
            </tbody>
        </table>
    )
}