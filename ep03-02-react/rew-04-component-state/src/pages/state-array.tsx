import { useState } from "react"

export default function StateArray() {

    const [list, setList] = useState<Item[]>([])
    const [item, setItem] = useState<Item | undefined>(undefined)

    const addItem = (item:Item) => {
        setList([...list, item])
    }

    const deleteItem = (id: number) => {
        setList(list.filter(item => item.id !== id))
    }

    const saveItem = () => {
        if(item && item.id == 0) {
            addItem(item)
            setItem(undefined)
        }
    }

    return (
        <>
            <h3>Array as State</h3>

            <div className="row mt-4">
                <div className="col-3">
                    <Card title="Edit Item">
                        <ItemForm item={item} setItem={setItem} saveItem={saveItem} />
                    </Card>
                </div>

                <div className="col">
                    <Card title="Item List">
                        <ItemList list={list} />
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

            <button onClick={e => {
                e.preventDefault()
                saveItem()
            }} className="btn btn-primary">Save</button>
        </form>
    )
}

function ItemList({list} : {list: Item[]}) {

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
                </tr>
            </thead>
            <tbody>
                {list.map((item, index) => 
                    <tr key={index}>
                        <td>{item.id}</td>
                        <td>{item.name}</td>
                        <td>{item.category}</td>
                        <td>{item.price}</td>
                    </tr>
                )}
            </tbody>
        </table>
    )
}