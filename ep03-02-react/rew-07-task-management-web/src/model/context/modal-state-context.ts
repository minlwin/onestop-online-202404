import { createContext, useContext } from "react";

type ModalStateContextType = [boolean, (state:boolean) => void]

const ModalStateContext = createContext<ModalStateContextType | undefined>(undefined)

const useModalStateContext = () => {
    const context = useContext(ModalStateContext)

    if(!context) {
        throw new Error("Invalid usage of Modal State Context")
    }

    return context
}

export {
    ModalStateContext,
    useModalStateContext
}