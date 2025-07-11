import { createContext, useContext } from "react"

type EditCategory = {id: unknown, name: string}
type EditContegoryContextType = [
    EditCategory | undefined, 
    (data : EditCategory | undefined) => void
]

const EditContegoryContext = createContext<EditContegoryContextType | undefined>(undefined)

const useEditCategory = () => {
    const context = useContext(EditContegoryContext)

    if(!context) {
        throw new Error("Invalid usage of Edit Category Context")
    }

    return context
}

export {
    EditContegoryContext,
    useEditCategory,
}

export type {
    EditCategory
}
