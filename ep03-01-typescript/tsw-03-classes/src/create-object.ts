// Create an Object without Class
const user1 = {
    name: "Aung Aung",
    phone: "0918171671",
    email: "aung@gmail.com"
}

class User {
    constructor(
        public name:string,
        public phone:string,
        public email:string
    ) {}
}

const user2 = new User("Aung Aung", "0918117111", "aung@gmail.com")
