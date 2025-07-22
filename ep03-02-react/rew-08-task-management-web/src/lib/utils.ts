import axios from "axios"
import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"

export function cn(...inputs: ClassValue[]) {
  return twMerge(clsx(inputs))
}

export function restClient() {
  return axios.create({
    baseURL: 'http://localhost:8080',
    timeout: 1000
  })
}