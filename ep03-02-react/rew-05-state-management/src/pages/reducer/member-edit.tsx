import { useForm } from "react-hook-form";
import type { Member } from "./member-domain";
import FormGroup from "../../ui/form/form-group";

export default function MemberEditForm({member, saveMember, clearForm} : {member?:Member, saveMember:(member:Member) => void, clearForm : VoidFunction}) {
    
    const {
        register, 
        handleSubmit,
        formState : {errors}
    } = useForm<Member>({values : {
        id : member?.id || 0,
        name : member?.name || "",
        email : member?.email || "",
        phone : member?.phone || ""
    }})


    return (
        <section>
            <h4>{member ? "Edit" : "Add New"} Member</h4>

            <form onSubmit={handleSubmit(saveMember)}>
                <FormGroup label="Name">
                    <input className="form-control" placeholder="Enter name" {...register('name', {required : true})} />
                    {errors.name && <span className="text-secondary">Please Enter Name</span>}
                </FormGroup>

                <FormGroup label="Phone">
                    <input className="form-control" placeholder="Enter Phone" {...register('phone', {required : true})} />
                    {errors.phone && <span className="text-secondary">Please Enter Phone Number</span> }
                </FormGroup>

                <FormGroup label="Email">
                    <input className="form-control" placeholder="Enter Email" {...register('email', {required : true})} />
                    {errors.phone && <span className="text-secondary">Please Enter Email Address</span> }
                </FormGroup>

                <div>
                    <button className="btn btn-primary me-2">Save Member</button>
                    <button type="button" className="btn btn-info" onClick={clearForm}>Clear Form</button>
                </div>
            </form>
        </section>
    )
}