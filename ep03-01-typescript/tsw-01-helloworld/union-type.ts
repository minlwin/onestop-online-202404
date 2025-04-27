type ValidationResult = {
    value: boolean
    message: string
} | string | undefined

function validate(input:string): ValidationResult {

    if(!input) {
        return {value : false, message: "Please enter input"}
    }

    return undefined
} 

type CourseForm = {
    name: string
    level: string
    duration: number
}

type Course = {
    id: number
} & CourseForm

const tsCourse:Course = {
    id: 10,
    name: "Type Script",
    duration: 15,
    level : "Basic"
} 