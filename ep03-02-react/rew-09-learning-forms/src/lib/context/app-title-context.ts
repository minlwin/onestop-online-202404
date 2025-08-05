import { createContext, useContext } from "react"

type AppTitleContextType = {
    title: string
    setTitle: (title : string) => void
}

const AppTitleContext = createContext<AppTitleContextType | undefined>(undefined)

const useAppTitle = () => {
    const context = useContext(AppTitleContext)

    if(!context) {
        throw new Error("Invalid context usage of App Title")
    }

    return context
}

export {
    AppTitleContext,
    useAppTitle
}