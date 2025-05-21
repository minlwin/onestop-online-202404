import { useState } from "react"
import { useImmer, type Updater } from "use-immer";

let nextId = 0;

export default function StateArray() {

    const [item, setItem] = useState<Item | undefined>(undefined)
    const [list, updateList]:[Item[], Updater<Item[]>] = useImmer<Item[]>([])

    const saveItem = () => {

        if(item) {
            if(!item.id) {
                // Add New
                updateList(draft => {
                    draft.push({...item, id : ++ nextId})
                })
            } else {
                // Update
                updateList(draft => {
                    const index = draft.findIndex(a => a.id == item.id)
                    if(index >= 0) {
                        draft[index] = item
                    }
                })
            }
            setItem(undefined)
        }
    }

    const onItemAction:ItemAction = (id, action) => {
        if(action === 'Edit') {
            setItem(list.find(a => a.id === id))
        } else if (action === 'Delete') {
            updateList(list.filter(a => a.id != id))
            setItem(undefined)
        }
    } 

    return (
        <>
            <h3>Array as State</h3>

            <div className="row mt-4">
                <div className="col-3">
                    <Card title={item ? 'Edit Item' : 'Add New Item'}>
                        <ItemForm item={item} setItem={setItem} saveItem={saveItem} />
                    </Card>
                </div>

                <div className="col">
                    <Card title="Item List">
                        <ItemList list={list} onAction={onItemAction} />
                    </Card>
                </div>
            </div>
        </>
    )
}

type Item = {
    id: number
    name: string
    category: string
    price: number
}

function Card({title, children} : {title: string, children : React.ReactNode}) {
    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">{title}</h5>
                <div className="mt-3">
                    {children}
                </div>
            </div>
        </div>
    )
}

function ItemForm({item, setItem, saveItem} : {
    item: Item | undefined, 
    setItem: (item:Item | undefined) => void,
    saveItem: () => void
}) {

    const isValid = () => {
        return item?.name && item?.category && item?.price
    }

    return (
        <form>
            <div className="mb-3">
                <label className="form-label">Item</label>
                <input onChange={e => setItem(item ? {...item, name: e.target.value} : {id: 0, name : e.target.value, category : '', price : 0})} type="text" value={item?.name || ''} className="form-control" placeholder="Enter Item Name" />
            </div>
            <div className="mb-3">
                <label className="form-label">Category</label>
                <input onChange={e => setItem(item ? {...item, category: e.target.value} : {id: 0, name : '', category : e.target.value, price : 0})} type="text" value={item?.category || ''} className="form-control" placeholder="Enter Category" />
            </div>
            <div className="mb-3">
                <label className="form-label">Price</label>
                <input onChange={e => setItem(item ? {...item, price: Number.parseInt(e.target.value)} : {id: 0, name : '', category : '', price :  Number.parseInt(e.target.value)})} type="number" value={item?.price || 0} className="form-control" placeholder="Enter Price" />
            </div>

            <button disabled={!isValid()} onClick={e => {
                e.preventDefault()
                saveItem()
            }} className="btn btn-primary">Save</button>
        </form>
    )
}

function ItemList({list, onAction} : {list: Item[], onAction?:ItemAction}) {

    if(list.length === 0) {
        return <span>There is no item</span>
    }

    return (
        <table className="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <td></td>
                </tr>
            </thead>
            <tbody>
                {list.map((item) => <ItemRow key={item.id} item={item} onAction={onAction}  />)}
            </tbody>
        </table>
    )
}

type ItemAction = (id:number, action : 'Edit' | 'Delete') => void

function ItemRow({item, onAction} : {item:Item, onAction?:ItemAction}) {
    return (
        <tr key={item.id}>
            <td>{item.id}</td>
            <td>{item.name}</td>
            <td>{item.category}</td>
            <td>{item.price}</td>
            <td>
                <a href="#" onClick={e => {
                    e.preventDefault()
                    if(onAction) {
                        onAction(item.id, 'Edit')
                    }
                }} className="inline-block me-4 btn-link">
                    <i className="bi-pencil"></i>
                </a>

                <a href="#" onClick={e => {
                    e.preventDefault()
                    if(onAction) {
                        onAction(item.id, 'Delete')
                    }
                }} className="btn-link">
                    <i className="bi-trash"></i>
                </a>
            </td>
        </tr>
    )
}