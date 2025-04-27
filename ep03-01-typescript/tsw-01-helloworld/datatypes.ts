class Hello {
    id:number
    name:string
    phone:string
    deleted:boolean
}

const hello = new Hello
hello.id = 1
hello.phone = "09181817171"
hello.name = "Aung Aung"

let course = {
    id: 1,
    name: "Type Script"
}

const helloArray:Hello[] = []

function showWithTurple(input: [String, number]) {
    for(let i = 0; i < input[1]; i++) {
        console.log(input[0])
    }
}

const arg1:[String, number] = ["Hello Turple", 3]

let poped = arg1.pop()
console.log(poped)

console.log(arg1)

showWithTurple(arg1)