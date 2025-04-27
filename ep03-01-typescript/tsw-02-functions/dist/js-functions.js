function useArgument() {
    for(let i = 0; i < arguments.length; i ++) {
        console.log(arguments[i])
    }
}

useArgument(1, 2, 3, 4)

function showFullName(firstName, lastName) {
    console.log(`${firstName} ${lastName}`)
}

showFullName()