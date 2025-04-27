function sayHello(name:string) {
    return (time:number) => {
        for(let i = 0; i < time; i ++) {
            console.log(`Hello ${name}`)
        }
    }
}

const helloWorker = sayHello("TypeScript")

helloWorker(3)

helloWorker(1)