type User = {
    id: number
    name: string
    loginId: string
    password: string
}

function showUser(user:any) {
    console.log(`User ID  : ${user.id}`)
    console.log(`Name     : ${user.name}`)
    console.log(`Login ID : ${user.loginId}`)
    console.log(`Password : ${user.password}`)

    user.showUser();
}

showUser({id: 1, name: "Aung Aung", loginId: "aung", password: "aung"})

let one:1

one = 1

let yes:true

yes = true

type response = 'Success' | 'Warning' | 'Error'