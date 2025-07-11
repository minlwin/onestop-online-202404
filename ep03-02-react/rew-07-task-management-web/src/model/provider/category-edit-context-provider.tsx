import { useState } from "react";
import { EditContegoryContext, type EditCategory } from "../context/edit-category-context";

export default function CategoryEditContextProvider({ children } : {children: React.ReactNode}) {
    const [editCategory, setEditCategory] = useState<EditCategory | undefined>(undefined);

    return (
        <EditContegoryContext.Provider value={[editCategory, setEditCategory]}>
            {children}
        </EditContegoryContext.Provider>
    );
}