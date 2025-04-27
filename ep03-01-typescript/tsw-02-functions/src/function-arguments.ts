// Argument With Types
function showFullName(firstName:string, lastName:string) {
    return `${firstName} ${lastName}`
}

const fullName = showFullName("Zaw Min" , "Lwin")
console.log(fullName)

// Optional Arguments
function getFullName(firstName?:string, lastName?:string) {
    if(firstName && lastName) {
        return `${firstName} ${lastName}`
    }

    if(firstName && !lastName) {
        return firstName
    }

    if(!firstName && lastName) {
        return lastName
    }

    return "No Name"
}

const result1 = getFullName()
const result2 = getFullName("Min Lwin")
const result3 = getFullName("Zaw", "Min Lwin")
const result4 = getFullName(undefined, "Lwin")

console.log(`getFullName() is ${result1}`)
console.log(`getFullName("Min Lwin") is ${result2}`)
console.log(`getFullName("Zaw", "Min Lwin") is ${result3}`)
console.log(`getFullName(undefined, "Lwin") is ${result4}`)

// Default Arguments
function greet(user = "User", count = 1) {
    for(let i = 0; i < count; i ++) {
        console.log(`Hello ${user}`)
    }
}

greet()
greet("Aung Aung")
greet("Thidar", 3)
greet(undefined, 5)