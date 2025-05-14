import type React from "react"
import { useState, type ChangeEventHandler } from "react"

export default function SpreadStateObject() {

    const [user, setUser] = useState<User>({name : '', phone : '', email : ''})

    const changeName:ChangeEventHandler<HTMLInputElement> = (event) => {
        setUser({...user, name : event.target.value})
    }

    const changePhone:ChangeEventHandler<HTMLInputElement> = (event) => {
        setUser({...user, phone : event.target.value})
    }

    const changeEmail:ChangeEventHandler<HTMLInputElement> = (event) => {
        setUser({...user, email : event.target.value})
    }

    return (
        <section>
            <h3>Spread State Object</h3>

            <div className="row">
                <div className="col">
                    <form>
                        <FormGroup label="Name">
                            <input onChange={changeName} type="text" className="form-control" placeholder="Enter Name" />
                        </FormGroup>
                        <FormGroup label="Phone">
                            <input onChange={changePhone} type="tel" className="form-control" placeholder="Enter Phone Number" />
                        </FormGroup>
                        <FormGroup label="Email">
                            <input onChange={changeEmail} type="email" className="form-control" placeholder="Enter Email Address" />
                        </FormGroup>
                    </form>
                </div>
                <div className="col">
                    <div>
                        <FormGroup label="Name">
                            <span className="form-control">{user.name || 'No Name'}</span>
                        </FormGroup>
                        <FormGroup label="Phone">
                            <span className="form-control">{user.phone || 'No Phone'}</span>
                        </FormGroup>
                        <FormGroup label="Email">
                            <span className="form-control">{user.email || 'No Email'}</span>
                        </FormGroup>
                    </div>
                </div>
            </div>
        </section>
    )
}

type User = {
    name : string
    phone: string
    email : string
}

function FormGroup({label, children} : {label:string, children:React.ReactNode}) {
    return (
        <div className="mb-3">
            <label className="form-label">{label}</label>
            {children}
        </div>
    )
}