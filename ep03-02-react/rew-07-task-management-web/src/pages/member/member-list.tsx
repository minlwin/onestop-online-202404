import { useForm } from "react-hook-form";
import type { MemberSearch } from "../../model/input/member-search";
import { FormGroup } from "../../ui/form-group";
import Page from "../../ui/page";
import Pagination from "../../ui/pagination";
import { Link, useNavigate } from "react-router";

export default function MemberList() {

    const {register, handleSubmit} = useForm<MemberSearch>()

    function search(form:MemberSearch) {
        console.log(form)
    }

    return (
        <Page title="Member Management" icon="bi-people">
            <form onSubmit={handleSubmit(search)} className="row">
                <FormGroup label="Position" className="col-auto">
                    <select className="form-select" {...register('position')}>
                        <option>All Position</option>
                    </select>
                </FormGroup>

                <FormGroup label="Name" className="col-auto">
                    <input type="text" className="form-control" placeholder="Search Name" 
                        {...register('name')} />
                </FormGroup>

                <FormGroup label="Entry From" className="col-auto">
                    <input type="date" className="form-control" placeholder="Search Project Name"
                        {...register('entryFrom')} />
                </FormGroup>

                <FormGroup label="Entry To" className="col-auto">
                    <input type="date" className="form-control" placeholder="Search Project Name"
                        {...register('entryTo')} />
                </FormGroup>

                <div className="col btn-wrapper">
                    <button type="submit" className="btn btn-dark me-2">
                        <i className="bi-search"></i> Search
                    </button>

                    <Link to="/member/edit" type="button" className="btn btn-outline-dark">
                        <i className="bi-plus"></i> Add New Member
                    </Link>
                </div>
            </form>

            <table className="table table-bordered table-striped table-hover mt-3">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Position</th>
                        <th>Entry At</th>
                        <th className="text-end">Projects</th>
                        <th className="text-end">Tasks</th>
                        <th></th>
                    </tr>
                </thead>

                <tbody>
                    <MemberRow />
                </tbody>
            </table>

            <Pagination />
        </Page>
    )
}

function MemberRow() {

    const navigate = useNavigate()

    function showDetails(id: number) {
        navigate(`/member/details/${id}`)
    }

    return (
        <tr>
            <td>1</td>
            <td>Aung Aung</td>
            <td>PM</td>
            <td>2025-04-01</td>
            <td className="text-end">3</td>
            <td className="text-end">20</td>
            <td className="text-center">
                <a href="#" onClick={e => {
                    e.preventDefault()
                    showDetails(1)
                }} className="icon-link">
                    <i className="bi-send"></i>
                </a>
            </td>
        </tr>
    )
}