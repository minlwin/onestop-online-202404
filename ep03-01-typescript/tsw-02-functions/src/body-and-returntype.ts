function sumBySide(array:number[], isEven?:boolean):number {
    let result = 0

    for(let i = 0; i < array.length; i++) {
        if(isEven === undefined) {
            result += array[i]
        } else if(isEven && i % 2 === 0) {
            result += array[i]
        } else if(!isEven && i % 2 !== 0) {
            result += array[i]
        }
    }
    return result
}

const ARRAY = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

console.log(`sumBySide(ARRAY) is ${sumBySide(ARRAY)}`)
console.log(`sumBySide(ARRAY, true) is ${sumBySide(ARRAY, true)}`)
console.log(`sumBySide(ARRAY, false) is ${sumBySide(ARRAY, false)}`)