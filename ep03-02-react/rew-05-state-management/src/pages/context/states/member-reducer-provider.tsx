import { MemberReducerContext } from "./member-reducer-context";
import type { MemberAction } from "../../reducer/member-reducer";
import type { Member } from "../../reducer/member-domain";
import { memberReducer } from "../../reducer/member-reducer-immer";
import { useImmerReducer } from "use-immer";
import EditMemberProvider from "./edit-member-provider";
import MemberIdProvider from "./member-id-provider";

export function MemberReducerProvider({children} : {children :React.ReactNode}) {
    const context = useImmerReducer<Member[], MemberAction>(memberReducer, [])
    return (
        <MemberReducerContext value={context}>
            <EditMemberProvider>
                <MemberIdProvider>
                    {children}
                </MemberIdProvider>
            </EditMemberProvider>
        </MemberReducerContext>
    )
}