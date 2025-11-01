import { clsx, type ClassValue } from "clsx"
import { twMerge } from "tailwind-merge"
import { object } from "zod"
import { OptionItem } from "./types"

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

export const LELVEL_OPTIONS:OptionItem[] = [
  {key : "Basic", value : "Basic"},
  {key : "Intermediate", value : "Intermediate"},
  {key : "Advance", value : "Advance"},
  {key : "AllInOne", value : "All In One"},
]

export const STATUS_OPTIONS:OptionItem[] = [
  {key : "false", value : "Active"},
  {key : "true", value : "Deleted"},
]

export const TYPE_OPTIONS:OptionItem[] = [
  {key : "Zoom", value : "Zoom"},
  {key : "Video", value : "Video"},
  {key : "Weekend", value : "Week End"},
  {key : "Weekday", value : "Week Days"},
]