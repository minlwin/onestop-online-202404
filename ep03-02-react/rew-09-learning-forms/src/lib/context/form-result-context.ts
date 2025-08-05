import { createContext, useContext } from "react"

type FormResultContextType = {
    result? : string
    setResult : (result? : string) => void
}

const FormResultContext = createContext<FormResultContextType | undefined>(undefined)

const useFormResult = () => {
    const context = useContext(FormResultContext)

    if(!context) {
        throw Error("Invalid context usage of Form Result.")
    }

    return context
}

export {
    FormResultContext,
    useFormResult
}