import { useForm } from "react-hook-form";
import { FormGroup } from "../../../ui/form-group";
import type { CategorySearch } from "../../../model/input/category-search";
import { useParams } from "react-router";
import { useEffect, useRef, useState } from "react";
import type { CategoryListItem } from "../../../model/output/category-list-item";
import NoData from "../../../ui/no-data";
import { createCategory, searchCategory, updateCategory } from "../../../model/client/category-client";
import ModalDialog from "../../../ui/modal-dialog";
import ModalStateContextProvider from "../../../model/provider/modal-state-context-provider";
import { useModalStateContext } from "../../../model/context/modal-state-context";
import type { CategoryForm } from "../../../model/input/category-form";
import ErrorMessage from "../../../ui/error-message";
import CategoryEditContextProvider from "../../../model/provider/category-edit-context-provider";
import { useEditCategory, type EditCategory } from "../../../model/context/edit-category-context";

export default function ProjectCategoryList() {
    return (
        <ModalStateContextProvider>
            <CategoryEditContextProvider>
                <CategoryList />
                <CategoryEditDialog />
            </CategoryEditContextProvider>    
        </ModalStateContextProvider>
    )
}

function CategoryList() {
    const params = useParams()
    const projectId = params.id

    const {register, reset, handleSubmit} = useForm<CategorySearch>()
    const [list, setList] = useState<CategoryListItem[]>([])

    const [_1, setShowDialog] = useModalStateContext()
    const [_2, setEditCategory] = useEditCategory()

    useEffect(() => {
        if(projectId) {
            reset({projectId: projectId})
        }
    }, [projectId, reset])

    async function search(form:CategorySearch) {
        const response = await searchCategory(form)
        setList(response)
    }

    function addNew() {
        setEditCategory(undefined)
        setShowDialog(true)
    }

    function edit(item: EditCategory) {
        setEditCategory(item)
        setShowDialog(true)
    }
    
    return (
        <>
            <form onSubmit={handleSubmit(search)} className="row">
                <FormGroup label="Name" className="col-auto">
                    <input {...register('name')} type="text" className="form-control" placeholder="Search Name" />
                </FormGroup>

                <div className="col btn-wrapper">
                    <button type="submit" className="btn btn-dark">
                        <i className="bi-search"></i> Search
                    </button>

                    <button type="button" onClick={addNew} className="btn btn-outline-dark ms-2">
                        <i className="bi-plus"></i> Add New
                    </button>
                </div>
            </form>
        
            <section className="my-4">
            {list.length ? 
                <table className="table table-striped table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th className="text-end">Pending</th>
                            <th className="text-end">Progress</th>
                            <th className="text-end">Behind</th>
                            <th className="text-end">Paused</th>
                            <th className="text-end">Finished</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    {list.map(item => 
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td className="text-end">{item.pending}</td>
                            <td className="text-end">{item.progress}</td>
                            <td className="text-end">{item.behind}</td>
                            <td className="text-end">{item.paused}</td>
                            <td className="text-end">{item.finished}</td>
                            <td className="text-center">
                                <a type="button" className="icon-btn" 
                                    onClick={() => edit({id: item.id, name: item.name})}>
                                    <i className="bi-pencil"></i>
                                </a>
                            </td>
                        </tr>
                    )}    
                    </tbody>
                </table> : 
                <NoData dataName="Category" />
            }
            </section>

        </>
    )    
}

function CategoryEditDialog() {

    const formRef = useRef<HTMLFormElement | null>(null)
    const {register, handleSubmit, reset,formState : {errors}} = useForm<CategoryForm>()
    const [showDialog, setShowDialog] = useModalStateContext()
    const [editCategory, setEditCategory] = useEditCategory()

    useEffect(() => {
        if (editCategory) {
            reset({name: editCategory.name})
        } else {
            reset({name: ''})
        }
    }, [editCategory, reset])

    async function onSave(form: CategoryForm) {
        if (editCategory) {
            await updateCategory(editCategory.id, form)
            setEditCategory(undefined)
        } else {
            await createCategory(form)
        }
        setShowDialog(false)
    }

    return (
        <ModalDialog title={editCategory ? "Edit Category" : "Add New Category"} show={showDialog}  
            onHide={() => setShowDialog(false)} 
            onSave={() => formRef.current?.requestSubmit()}>
            
            <form ref={formRef} onSubmit={handleSubmit(onSave)} className="row">
                <FormGroup label="Name">
                    <input {...register('name', {required : true})} type="text" className="form-control" placeholder="Enter Category Name" />
                    {errors.name && <ErrorMessage message="Please enter category name." />}
                </FormGroup>
            </form>

        </ModalDialog>
    )
}