import { useParams } from "react-router";
import Page from "../../ui/page";
import { useEffect } from "react";

export default function MemberDetails() {

    const params = useParams()

    useEffect(() => {
        console.log(`Member ID : ${params.id}`)
    }, [params])

    return (
        <Page title="Member Details" icon="bi-person">
            <div></div>
        </Page>
    )
}