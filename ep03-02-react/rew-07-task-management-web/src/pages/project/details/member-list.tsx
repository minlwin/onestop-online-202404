import { useEffect, useState } from "react"
import Card from "../../../ui/card"
import InputGroup from "../../../ui/input-group"

export default function ProjectMemberList() {
    return (
        <div className="row">
            <div className="col-9">
                <MembersInProject />
            </div>
            <div className="col">
                <MemberSearch />
            </div>
        </div>
    )
}

function MembersInProject() {

    const [list, setList] = useState<{id: number}[]>([])

    useEffect(() => {
        const result = Array.from({length : 7}, (_, i) => ({id : i + 1}))
        setList(result)
    }, [setList])

    return (
        <Card title="Members in Project">
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Position</th>
                        <th className="text-end">Pending</th>
                        <th className="text-end">Proceed</th>
                        <th className="text-end">Behind</th>
                        <th className="text-end">Finished</th>
                        <th className="text-end">Total</th>
                    </tr>
                </thead>

                <tbody>
                {list.map(item => 
                    <tr key={item.id}>
                        <td>Member Name</td>
                        <td>Programmer</td>
                        <td className="text-end">5</td>
                        <td className="text-end">4</td>
                        <td className="text-end">0</td>
                        <td className="text-end">0</td>
                        <td className="text-end">9</td>
                    </tr>
                )}
                </tbody>
            </table>
        </Card>
    )
}

function MemberSearch() {

    const [list, setList] = useState<{id: number}[]>([])

    useEffect(() => {
        const result = Array.from({length : 5}).map((_, index) => ({id : index + 1}))
        setList(result)
    }, [setList])

    return (
        <Card title="Search Member">
            <form className="mb-3">
                <InputGroup icon="bi-search">
                    <input type="text" placeholder="Search Member" className="form-control" />
                </InputGroup>
            </form>

            <div className="list-group">
            {list.map(item => 
                <div key={item.id} className="list-group-item d-flex justify-content-between">
                    <span>Member Name</span>
                    <a href="#" className="icon-link">
                        <i className="bi-plus-lg"></i>
                    </a>
                </div>
            )}
            </div>

            <div className="mt-3 d-flex justify-content-between">
                <button type="button" className="btn btn-outline-dark">
                    <i className="bi-arrow-left"></i>
                </button>
                <button type="button" className="btn btn-outline-dark">
                    <i className="bi-arrow-right"></i>
                </button>
            </div>
        </Card>
    )
}

