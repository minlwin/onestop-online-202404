// Named Function
function sumAll(array : number[]):number {
    let sum = 0
    for(let i = 0; i < array.length; i ++) {
        sum += array[i]
    }
    return sum
}

let array = [1, 2, 3, 4, 5]
let result = sumAll(array)

console.log(`Sum of ${array} is ${result}`)

// Anonymous Function
const isEven = function (input:number) {
    return input % 2 === 0
}

for(let element of array) {
    console.log(`${element} is ${isEven(element) ? 'Even Number' : 'Odd Number'}`)
}

// Arrow Function
const findIndex = (array : number[], element : number) => {
    let index = -1

    for(let i = 0; i < array.length; i ++) {
        if(array[i] === element) {
            return i
        }
    }
    return index
}

console.log(`Index of 3 is ${findIndex(array, 3)}`)
console.log(`Index of 6 is ${findIndex(array, 6)}`)
