interface Item {
    readonly id: number
    readonly name: string
}

function showItem(item: Item) {
    console.log(`${item.id} : ${item.name}`)
}

class Product {
    constructor(
        readonly id:number, 
        readonly name: string, 
        public price:number
    ) {}
}

class SaleItem implements Item {
    constructor(public id:number, public name:string) {}
}

showItem(new SaleItem(1, "Pepsi"))
showItem(new Product(2, "T Shirt", 15000))
showItem({id: 10, name: "Truck"})

function defineShape(arg: {name:string, value?: number, [name:string]:any}) {
    console.log(arg.name)
    console.log(arg.value)
}

defineShape({name: "Test"})
defineShape({name: "Test", value: 10})
defineShape({name: "Test", value: 10, order: "Desc", others: true})

type ApiResponse = {
    success:boolean
    message:string
}