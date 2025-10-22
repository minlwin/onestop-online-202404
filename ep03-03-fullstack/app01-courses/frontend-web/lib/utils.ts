import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"
import { object } from "zod"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export function queryString(form: {[key:string] : any}) {
  const searchParam = new URLSearchParams
  
  Object.keys(form).forEach(key => {
    searchParam.append(key, form[key])
  })

  return searchParam.toString()
}

export const POST_CONFIG:RequestInit = {
  method: "POST",
  headers: {
    "Content-Type" : "application/json"
  }
}

export const PUT_CONFIG:RequestInit = {
  method: "PUT",
  headers: {
    "Content-Type" : "application/json"
  }
}