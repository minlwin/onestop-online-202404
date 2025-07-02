import { Link } from "react-router";
import { FormGroup } from "../../ui/form-group";
import { useForm } from "react-hook-form";
import type { ProjectSearch } from "../../model/input/project-search";
import type { ProjectListItem, ProjectSearchResult } from "../../model/output/project-list-item";
import { searchProject } from "../../model/client/project-client";
import NoData from "../../ui/no-data";
import { useSearchResultList, useSearcResultSetter } from "../../model/context/search-result-context";
import SearchPage from "../../ui/search-page";
import ShowDetails from "../../ui/show-details";

export default function ProjectListComponent() {
    return (
        <SearchPage title="Project Management" icon="bi-rocket" searchForm={<SearchForm />}>
            <ProjectSearchResult />
        </SearchPage>
    )
}

function SearchForm() {

    const setResult = useSearcResultSetter()
    const {register, handleSubmit} = useForm<ProjectSearch>()

    async function search(form:ProjectSearch) {
        const response = await searchProject(form)
        setResult(response)
    }

    return (
        <form onSubmit={handleSubmit(search)} className="row">
            <FormGroup className="col-auto" label="Status">
                <select className="form-select" {...register('staus')}>
                    <option value="">All Status</option>
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
                <button type="submit" className="btn btn-dark me-2">
                    <i className="bi-search"></i> Search
                </button>
                <Link to='/project/edit' className="btn btn-outline-dark">
                    <i className="bi-plus-lg"></i> Create Project
                </Link>
            </div>
        </form>        
    )
}

function ProjectSearchResult() {
    
    const list = useSearchResultList<ProjectListItem>()

    if(!list.length) {
        return <NoData dataName="project" />
    }

    return (
        <>
            <table className="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Create At</th>
                        <th>Start At</th>
                        <th>Mile Stone</th>
                        <th>Status</th>
                        <th className="text-end">Members</th>
                        <th className="text-end">Tasks</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                {list.map(item => 
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.createAt}</td>
                        <td>{item.startAt}</td>
                        <td>{item.mileStone}</td>
                        <td>{item.status}</td>
                        <td className="text-end">{item.members}</td>
                        <td className="text-end">{item.tasks}</td>
                        <td className="text-center">
                            <ShowDetails to={`/project/details/${item.id}`} />
                        </td>
                    </tr>
                )}
                </tbody>
            </table>
        </>
    )
}