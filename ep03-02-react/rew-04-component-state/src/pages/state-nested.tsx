import { type ChangeEventHandler } from "react"
import { useImmer } from "use-immer"

export default function StateNestedObject() {

    const [user, updateUser] = useImmer<User>({
        name : {
            firstName: '',
            lastName : ''
        },
        phone : '',
        email : ''
    })

    const changeFirstName:ChangeEventHandler<HTMLInputElement> = (event) => {
        updateUser(draft => {
            draft.name.firstName = event.target.value
        })
    }

    const changeLastName:ChangeEventHandler<HTMLInputElement> = (event) => {
        updateUser(draft => {
            draft.name.lastName = event.target.value
        })
    }

    const changePhone:ChangeEventHandler<HTMLInputElement> = (event) => {
        updateUser(draft => {
            draft.phone = event.target.value
        })
    }

    const changeEmail:ChangeEventHandler<HTMLInputElement> = (event) => {
        updateUser(draft => {
            draft.email = event.target.value
        })
    }

    return (
        <section>
            <h3>Update Nested Object State</h3>
            <div className="row">
                <div className="col">
                    <form>
                        <div className="row">
                            <div className="col">
                                <FormGroup label="First Name">
                                    <input onChange={changeFirstName} type="tel" className="form-control" placeholder="Enter First Name" />
                                </FormGroup>
                            </div>
                            <div className="col">
                                <FormGroup label="Last Name">
                                    <input onChange={changeLastName} type="tel" className="form-control" placeholder="Enter Last Name" />
                                </FormGroup>
                            </div>
                        </div>
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
                        <div className="row">
                            <div className="col">
                                <FormGroup label="First Name">
                                    <span className="form-control">{user.name.firstName || 'No First Name'}</span>
                                </FormGroup>
                            </div>
                            <div className="col">
                                <FormGroup label="Last Name">
                                    <span className="form-control">{user.name.lastName || 'No Last Name'}</span>
                                </FormGroup>
                            </div>
                        </div>
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

function FormGroup({label, children} : {label:string, children:React.ReactNode}) {
    return (
        <div className="mb-3">
            <label className="form-label">{label}</label>
            {children}
        </div>
    )
}

type User = {
    name : {
        firstName: string
        lastName: string
    }
    phone: string
    email : string
}
