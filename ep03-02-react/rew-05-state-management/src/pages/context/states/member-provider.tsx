import type React from "react";
import MemberListProvider from "./member-list-provider";
import EditMemberProvider from "./edit-member-provider";
import MemberIdProvider from "./member-id-provider";

export default function MemberProvider({children} : {children : React.ReactNode}) {
    return (
        <MemberListProvider>
            <EditMemberProvider>
                <MemberIdProvider>
                    {children}
                </MemberIdProvider>
            </EditMemberProvider>
        </MemberListProvider>
    )
}