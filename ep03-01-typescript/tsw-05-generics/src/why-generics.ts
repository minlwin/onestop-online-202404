class Container<T> {
    private storage:T[] = []

    add(item:T) {
        this.storage.push(item)
    }

    get(index:number) {
        return this.storage[index]
    }
}

const container = new Container<number>
container.add(1000)

let firstElement = container.get(0)

const stringContainer = new Container<string>