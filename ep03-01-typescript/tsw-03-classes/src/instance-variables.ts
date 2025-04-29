class Person {
    
    constructor(
        readonly firstName:string, 
        readonly lastName:string
    ) {}

    get fullName() {
        return `${this.firstName} ${this.lastName}`
    }
}