import { Atom, LogIn } from "lucide-react";
import PageTitle from "../components/PageTitle";

export default function ComponentAsArgs() {
    return (
        <section>
            <PageTitle title="Component As Argument" icon={<Atom />} />

            <section className="mt-4 w-50">
                <Card title="Login Form">
                    <div className="mb-3 mt-4">
                        <label className="form-label">Login ID</label>
                        <input type="text" placeholder="Enter Login ID" className="form-control" />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Password</label>
                        <input type="password" placeholder="Enter Password" className="form-control" />
                    </div>

                    <button className="btn btn-outline-primary">
                        <LogIn /> Login
                    </button>
                </Card>
            </section>
        </section>
    )
}

function Card({title, children} : {title:string, children: React.ReactNode}) {
    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                {children}
            </div>
        </div>
    )
}