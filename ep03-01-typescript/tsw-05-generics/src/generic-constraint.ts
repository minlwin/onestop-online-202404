// Type as Constraint
function showLength<T extends LengthEnable>(obj:T) {
    console.log(`Length of ${obj} is ${obj.length}`)
}

type LengthEnable = {
    length:number
}

showLength([1, 2, 3])
showLength({name : "Thidar", length: 10})

// Type Parameter as Constraint Type
function show<T, K extends keyof T>(object:T, key:K) {
    console.log(`${key.toString()} is ${object[key]}`)
}

type User = {
    name : string
    age : number
    job : "Student" | "Employee"
}

show({name : "Thidar", age : 20, job: "Student"}, "age")
show({id: 1, name: "IceCream"}, "name")