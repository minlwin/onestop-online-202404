'use server'

export async function getAll() {
    const response = await fetch("http://localhost:8080/divisions")
    return await response.json()
}